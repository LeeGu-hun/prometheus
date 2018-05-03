package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.CrowdedBean;
import service.BusService;

@Controller
public class BusNumController {
	private BusService busService;

	public void setBusService(BusService busService) {
		this.busService = busService;
	}

	@RequestMapping(value = "/jsontest", method = RequestMethod.GET)
	public String busCrowded(HttpServletRequest request, Model model) {
		int oneValue = 0;
		String carNo = "";
		if (request.getParameter("carno") != null) {
			carNo = request.getParameter("carno");
			//확인 작업 
			if (busService.busCarNo(carNo)) {
				System.out.println("있다");
			} else {
				System.out.println("없다");
				try {
					busService.busInsert(carNo, oneValue);
				} catch (Exception e1) {
					System.out.println("insert가 실패했다.");
					e1.printStackTrace();
				}
			}
			oneValue = busService.busGetCrowded(carNo);
			System.out.println("더하기전 값 oneValue: " + oneValue);
		} else {
			System.out.println("carno 가 널이다");
		}
		if (request.getParameter("onevalue") != null) {
			oneValue += Integer.parseInt(request.getParameter("onevalue"));
			System.out.println("더하고 나서  oneValue: " + oneValue);
		} else {
			System.out.println("onevlaue 가 널이다");
		}

		CrowdedBean bean = new CrowdedBean(carNo, oneValue);

		// 버스 인원 추가
		try {
			busService.busCrowdedUpdate(bean);
		} catch (Exception e1) {
			System.out.println("update에 문제가 있다");
			e1.printStackTrace();
		}

		List<CrowdedBean> list = null;
		try {
			list = busService.busGetAll(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("busCrowded", list);
		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = requestURI.substring(ctxPath.length());
		System.out.println(cmd);
		request.setAttribute("cmd", cmd);
		return "./include/jsontest";
	}

	/* 안드로이드 통신관련 */
	@RequestMapping(value = "/andtest", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> androidTestWithRequestAndResponse(HttpServletRequest request) {
		System.out.println("안드로이드에서 요청이 들어왔다  carNo : " + request.getParameter("carno"));

		Map<String, Integer> result = new HashMap<String, Integer>();
		int oneValue = 0;
		String carNo = request.getParameter("carno");
		oneValue = busService.busGetCrowded(carNo);

		result.put("crowded", oneValue);
		System.out.println("DB는 문제없이 돌아간다");
		return result;
	}

}
