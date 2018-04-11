package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
	public String search(@RequestParam(value ="busStop",defaultValue="false")String station, Model model, HttpServletRequest request) throws Exception {
		API api = new API();
		List<BusStopBean> bstop  = new ArrayList();
		bstop	=	api.busStation(station);
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
	public String searchNum(@RequestParam(value = "busNum", defaultValue = "false") String busnum, Model model,HttpServletRequest request)
			throws Exception {
		ApiBusNum bNum = new ApiBusNum();
		System.out.println("들어옴?");
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
	
		model.addAttribute("BusLine", BusLine);
		mav.addObject("BusInfo", BusInfo);
		mav.setViewName("search/bus_search_info");
		
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
//		System.out.println(bNodeId);
		List<BusStopInfoBean> BusStopInfo = stopNodeInfo.busStopInfo(bNodeId);
		String x = BusStopInfo.get(0).getGpsX();
		String y = BusStopInfo.get(0).getGpsY();
		String failedResult = "서비스를 지원하지 않는 정류장 입니다.";
		String node = BusStopInfo.get(0).getNodeNm();
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(node);
		
		ModelAndView mav = new ModelAndView();
//		if(x.equals(null)) {
//			mav.addObject("failedResult",failedResult);
//			mav.setViewName("include/bus_node_map_view");
//			
//			return mav;
//		}
		String buf = "<script>panTo('"+x+"','"+y+"','"+node+"');</script>";
		mav.addObject("pantoResult", buf);
		mav.setViewName("include/bus_node_map_view");
		
		
		return mav;
	}
}
