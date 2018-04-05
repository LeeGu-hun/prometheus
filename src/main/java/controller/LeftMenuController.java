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
import org.w3c.dom.Element;

import assembler.API;
import bean.BusStopBean;


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

	@RequestMapping("/search")
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
	
}
