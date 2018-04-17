package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.tag.common.xml.ForEachTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import assembler.API;
import assembler.ApiBusInfo;
import assembler.ApiBusLine;
import assembler.ApiBusNum;
import assembler.ApiBusStopInfo;
import bean.BusBean;
import bean.BusInfoBean;
import bean.BusStopBean;
import bean.BusStopInfoBean;

@Controller
public class LeftMenuController {

	@RequestMapping(value = "/busNumSearch", method = RequestMethod.GET)
	public String busNumSearch(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = requestURI.substring(ctxPath.length());
		System.out.println(cmd);
		request.setAttribute("cmd", cmd);
		return "./main";
	}

	@RequestMapping(value = "/busStopSearch", method = RequestMethod.GET)
	public String busStopSearch(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = requestURI.substring(ctxPath.length());
		System.out.println(cmd);
		request.setAttribute("cmd", cmd);
		return "./main";
	}

	@RequestMapping("/searchbStop")
	public String search(@RequestParam(value = "busStop", defaultValue = "false") String station, Model model,
			HttpServletRequest request) throws Exception {
		API api = new API();
		List<BusStopBean> bstop = new ArrayList();
		bstop = api.busStation(station);
		int count = bstop.size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bstop", bstop);
		map.put("bstopCount", count);
		model.addAttribute("map", map);

		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = requestURI.substring(ctxPath.length());
		System.out.println(cmd);
		request.setAttribute("cmd", cmd);

		return "./main";
	}

	@RequestMapping("/searchbnum")
	public String searchNum(@RequestParam(value = "busNum", defaultValue = "false") String busnum, Model model,
			HttpServletRequest request) throws Exception {
		ApiBusNum bNum = new ApiBusNum();
		List<BusBean> BusNumInfo = new ArrayList();
		BusNumInfo = bNum.getBusNum(busnum);
		// System.out.println(BusNumInfo.get(0).getLineId());

		// ApiBusLine bLine = new ApiBusLine();
		// List<BusInfoBean> BusLine = new ArrayList();
		// BusLine = bLine.getBusLine(BusNumInfo.get(0).getLineId());

		model.addAttribute("BusNumInfo", BusNumInfo);

		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = requestURI.substring(ctxPath.length());
		System.out.println(cmd);
		request.setAttribute("cmd", cmd);

		return "main";
	}

	@RequestMapping(value = "/searchBInfo", method = RequestMethod.GET)
	public ModelAndView searchBusInfo(HttpServletRequest request, Model model) throws Exception {
		String bId = request.getParameter("buslineId");

		System.out.println(bId);
		ModelAndView mav = new ModelAndView();
		ApiBusInfo bInfo = new ApiBusInfo();
		List<BusBean> BusInfo = new ArrayList();
		BusInfo = bInfo.getBusNum(bId);

		ApiBusLine bLine = new ApiBusLine();
		List<BusInfoBean> BusLine = new ArrayList();

		BusLine = bLine.getBusLine(bId);

		mav.addObject("BusLine", BusLine);
		mav.addObject("BusInfo", BusInfo);
		mav.setViewName("include/bus_node_search_view");

		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String cmd = requestURI.substring(ctxPath.length());
		System.out.println(cmd);
		request.setAttribute("cmd", cmd);

		return mav;
	}

	@RequestMapping(value = "/searchBGps", method = RequestMethod.GET)
	public ModelAndView searchBusNodeGps(HttpServletRequest request) throws Exception {
		String bNodeId = request.getParameter("busNodeId");
		ApiBusStopInfo stopNodeInfo = new ApiBusStopInfo();
		// System.out.println(bNodeId);
		List<BusStopInfoBean> BusStopInfo = stopNodeInfo.busStopInfo(bNodeId);
		String x = BusStopInfo.get(0).getGpsX();
		String y = BusStopInfo.get(0).getGpsY();
		String node = BusStopInfo.get(0).getNodeNm();
		// System.out.println(x);
		// System.out.println(y);
		// System.out.println(node);

		ModelAndView mav = new ModelAndView();
		// if(x.equals(null)) {
		// mav.addObject("failedResult",failedResult);
		// mav.setViewName("include/bus_node_map_view");
		//
		// return mav;
		// }
		String buf = "<script>panTo('" + x + "','" + y + "','" + node + "');</script>";
		mav.addObject("pantoResult", buf);
		mav.setViewName("include/bus_node_map_view");

		return mav;
	}

	@RequestMapping(value = "/searchbStopInfo", method = RequestMethod.GET)
	public ModelAndView searchBusStopInfo(HttpServletRequest request, Model model) throws Exception {
		String bstopId = request.getParameter("bStopId");
		String gpsX = request.getParameter("bstopGpsX");
		String gpsY = request.getParameter("bstopGpsY");
		String name = request.getParameter("bstopName");

		ModelAndView mav = new ModelAndView();
		ApiBusStopInfo bstopInfo = new ApiBusStopInfo();
		List<BusStopInfoBean> busStopInfo = new ArrayList();
		busStopInfo = bstopInfo.busStopInfo(bstopId);

		// map에 버스 정보
		StringBuffer conOverLay = new StringBuffer();

		conOverLay.append("<div class=\"wrap\">"); //wrap
		conOverLay.append("<div class=\"info\">"); //2
		conOverLay.append("<div class=\"title\">"); 
		conOverLay.append(name + "[" + busStopInfo.get(0).getArsNo()
				+ "] <div class=\"close\" onclick=\"closeOverlay()\" title=\"닫기\"></div></div>"); //title
		conOverLay.append("<div class=\"body\">");//3
		conOverLay.append("<div class=\"desc\">");//4
		for (int i = 0; i < busStopInfo.size(); i++) {
			conOverLay.append("<div class=\"mapBusTable\">");//5
			conOverLay.append("<div class=\"busNumGps\" align= left>");//7
			conOverLay.append("<div class=\"ellipsis\">" + busStopInfo.get(i).getLineNo() + "번 버스");
			if (busStopInfo.get(i).getCarNo1() == null) {
				conOverLay.append("<span class=\"jibun\"> [정보없음]</span></div>");//ellipsis
				conOverLay.append("</div>"); //busNumGps
				conOverLay.append("<div class=\"busImg\" align= left ></div>");//busImg
			}else if(busStopInfo.get(i).getCarNo2() == null) {
				conOverLay.append("</div>");//ellipsis
				conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo1() + "] "
						+ busStopInfo.get(i).getStation1() + "정거장 전  " + busStopInfo.get(i).getMin1()
						+ "분 후 도착  </div>"); //jibun ellipsis
				conOverLay.append("</div>");//busNumGps
				conOverLay.append("<div class=\"busImg\" align= left>");
				conOverLay.append(busStopInfo.get(i).getCrowded1());
				conOverLay.append("</div>");//busImg
			}else {
				conOverLay.append("</div>");//ellipsis
				conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo1() + "] "
						+ busStopInfo.get(i).getStation1() + "정거장 전  " + busStopInfo.get(i).getMin1()
						+ "분 후 도착  </div>");//jibun ellipsis
				conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo2() + "] "
						+ busStopInfo.get(i).getStation2() + "정거장 전  " + busStopInfo.get(i).getMin2()
						+ "분 후 도착  </div>");//jibun ellipsis
				conOverLay.append("</div>");//busNumGps
				conOverLay.append("<div class=\"busImg\" align= left>");
				conOverLay.append("<img class=\"crowdedImg\" src=\"http://postfiles8.naver.net/MjAxODA0MTZfOTcg/MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png?type=w3\">");
				conOverLay.append("<img class=\"crowdedImg\" src=\"http://postfiles13.naver.net/MjAxODA0MTZfNDEg/MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png?type=w3\">");
				conOverLay.append("</div>");//busImg
			}
			conOverLay.append("</div>");//busInfo
		}
		conOverLay.append("</div>" + "</div>" + "</div>" + "</div>");// /desc/body/info/wrap

		String buf = "<script>overlay('" + conOverLay + "','" + gpsX + "','" + gpsY + "','" + name + "');</script>";
		mav.addObject("bSIResult", buf); // busStopInfo
		mav.setViewName("include/bus_node_bstop_view");

		return mav;
	}
}
