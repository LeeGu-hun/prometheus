package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.BindStatus;

import bean.BusInfoBean;
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
		System.out.println("들어오는값  carNo : "+ request.getParameter("carno"));
		System.out.println("들어오는값  crowded : "+ request.getParameter("onevalue"));
		
		if (request.getParameter("carno") != null) {
			carNo = request.getParameter("carno");
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
			System.out.println("더하기전 값 oneValue: "+ oneValue);
		}else {
			System.out.println("carno 가 널이다");
		}
		if(request.getParameter("onevalue") !=null) {
			oneValue += Integer.parseInt(request.getParameter("onevalue"));
			System.out.println("더하고 나서  oneValue: "+ oneValue);
		}else {
			System.out.println("onevlaue 가 널이다");
		}

		CrowdedBean bean = new CrowdedBean(carNo, oneValue);
		
		//버스 인원 추가 
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
			System.out.println("getall이 실패했다");
			e.printStackTrace();
		}
			System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1)+"번째 carNo "+list.get(i).getCarNo());
			System.out.println((i+1)+"번째 crowded "+list.get(i).getCrowded());
		}
		
		model.addAttribute("busCrowded", list);
		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = requestURI.substring(ctxPath.length());
		System.out.println(cmd);
		request.setAttribute("cmd", cmd);
		return "./include/jsontest";
	}

}
