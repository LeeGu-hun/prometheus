package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.tag.common.xml.ForEachTag;
import org.springframework.aop.target.SimpleBeanTargetSource;
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
	public String search(@RequestParam(value = "busStop", defaultValue = "false") String station,
			@RequestParam(value = "page", defaultValue = "false") String page, Model model, HttpServletRequest request)
			throws Exception {
		API api = new API();
		Map<String, Object> map = new HashMap<String, Object>();
		map = api.busStation(station, page);

		// 페이지 처리 부분 class 로 따로 만들 필요가 있음 또는 bean을 만들어서 하는 방법
		int currentPage = Integer.parseInt(page); // 현재 페이지
		int sizeOfPage = 5; // 표시할 페이지 수
		int maxbStopCount = 20; // 한페이지에 표시할 정류소 수
		int total = Integer.parseInt(map.get("totalCount").toString()); // 정류소 총 수
		int totalPage = (total + maxbStopCount - 1) / maxbStopCount; // 총 페이지 수
		int startPage = ((currentPage - 1) / sizeOfPage) * sizeOfPage + 1; // 시작할 페이지
		int endPage = startPage + sizeOfPage - 1; // 마지막 페이지
		if (endPage >= totalPage)
			endPage = totalPage;

		/*
		 * System.out.println("현재 페이지 =" + page); System.out.println("현재 페이지 =" +
		 * currentPage); System.out.println("한 화면에 표시할 페이지 수 =" + sizeOfPage);
		 * System.out.println("한페이지에 표시할 정류소 수 =" + maxbStopCount);
		 * System.out.println("총 정류소 수 =" + total); System.out.println("총 페이지 수 =" +
		 * totalPage); System.out.println("한화면에 시작할 첫페이지 넘버 =" + startPage);
		 * System.out.println("한화면에 마지막 페이지 넘버 =" + endPage);
		 */

		map.put("station", station); // 검색어
		map.put("totalPage", totalPage); // page 수
		map.put("currentPage", currentPage); // 현재 페이지
		map.put("startPage", startPage); // 시작할 페이지
		map.put("endPage", endPage); // 마지막페이지

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
		List<BusBean> busNumInfo = new ArrayList();
		busNumInfo = bNum.getBusNum(busnum);
		Map<String, Object> map = new HashMap<String, Object>();
		int infoSize =  busNumInfo.size();
		System.out.println("infoSize"+ infoSize);
		map.put("BusNumInfo", busNumInfo);
		map.put("infoSize",infoSize);
		model.addAttribute("map", map);
		
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
		String bSize = request.getParameter("infoSize");
		
		ModelAndView mav = new ModelAndView();
		ApiBusInfo bInfo = new ApiBusInfo();
		List<BusBean> busInfo = new ArrayList();
		busInfo = bInfo.getBusNum(bId);

		ApiBusLine bLine = new ApiBusLine();
		List<BusInfoBean> busLine = new ArrayList();

		busLine = bLine.getBusLine(bId);
		mav.addObject("BusLine", busLine);
		mav.addObject("BusInfo", busInfo);
		mav.addObject("bSize",bSize);
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
		List<BusStopInfoBean> busStopInfo = stopNodeInfo.busStopInfo(bNodeId);
		String gpsX = busStopInfo.get(0).getGpsX();
		String gpsY = busStopInfo.get(0).getGpsY();
		String name = busStopInfo.get(0).getNodeNm();
		ModelAndView mav = new ModelAndView();

		// map에 버스 정보
		StringBuffer conOverLay = new StringBuffer();

		conOverLay.append("<div class=\"wrap\">"); // wrap
		conOverLay.append("<div class=\"info\">"); // 2
		conOverLay.append("<div class=\"title\">");
		conOverLay.append(name + "[" + busStopInfo.get(0).getArsNo()
				+ "] <div class=\"close\" onclick=\"closeOverlay()\" title=\"닫기\"></div></div>"); // title
		conOverLay.append("<div class=\"body\">");// 3
		conOverLay.append("<div class=\"desc\">");// 4
		for (int i = 0; i < busStopInfo.size(); i++) {
			conOverLay.append("<div class=\"mapBusTable\">");// 5
			conOverLay.append("<div class=\"busNumGps\" align= left>");// 7
			conOverLay.append("<div class=\"ellipsis\">" + busStopInfo.get(i).getLineNo() + "번 버스");
			if (busStopInfo.get(i).getCarNo1() == null) {
				conOverLay.append("<span class=\"jibun\"> [정보없음]</span></div>");// ellipsis
				conOverLay.append("</div>"); // busNumGps
				conOverLay.append("<div class=\"busImgs\" align= left ></div>");// busImg
			} else if (busStopInfo.get(i).getCarNo2() == null) {
				conOverLay.append("</div>");// ellipsis
				conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo1() + "] "
						+ busStopInfo.get(i).getStation1() + "정거장 전  " + busStopInfo.get(i).getMin1()
						+ "분 후 도착  </div>"); // jibun ellipsis
				conOverLay.append("</div>");// busNumGps
				conOverLay.append("<div class=\"busImgs\" align= left>");
				conOverLay.append("<div class=\"busimg\" align= center>");
				conOverLay.append("<p class=\"busNum\">[" + busStopInfo.get(i).getCarNo1() + "]</p>");
				if (busStopInfo.get(i).getCrowded1() <= 20) {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/"
							+ "MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_"
							+ "5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png\">");
				} else if (busStopInfo.get(i).getCrowded1() < 35) {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/"
							+ "MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_"
							+ "EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png\">");
				} else {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfMTQg/"
							+ "MDAxNTIzODY5MjU3NDgx.a8kS9vmgZcV8xZQ6LMjBbmzsEytJIEfENusu_i2H4qkg.xVRPaORFC6BEuTdY0su_"
							+ "5DtsQrro_1EOHl2xgKTf7E0g.PNG.aaz77/3.png\">");
				}
				conOverLay.append("</div>");// firstBus
				conOverLay.append("</div>");// busImg
			} else {
				conOverLay.append("</div>");// ellipsis
				conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo1() + "] "
						+ busStopInfo.get(i).getStation1() + "정거장 전  " + busStopInfo.get(i).getMin1()
						+ "분 후 도착  </div>");// jibun ellipsis
				conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo2() + "] "
						+ busStopInfo.get(i).getStation2() + "정거장 전  " + busStopInfo.get(i).getMin2()
						+ "분 후 도착  </div>");// jibun ellipsis
				conOverLay.append("</div>");// busNumGps
				conOverLay.append("<div class=\"busImgs\" align= left>");
				conOverLay.append("<div class=\"busimg\" align= center>");
				conOverLay.append("<p class=\"busNum\">[" + busStopInfo.get(i).getCarNo1() + "]</p>");
				if (busStopInfo.get(i).getCrowded1() <= 20) {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/"
							+ "MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_"
							+ "5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png\">");
				} else if (busStopInfo.get(i).getCrowded1() < 35) {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/"
							+ "MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_"
							+ "EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png\">");
				} else {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfMTQg/"
							+ "MDAxNTIzODY5MjU3NDgx.a8kS9vmgZcV8xZQ6LMjBbmzsEytJIEfENusu_i2H4qkg.xVRPaORFC6BEuTdY0su_"
							+ "5DtsQrro_1EOHl2xgKTf7E0g.PNG.aaz77/3.png\">");
				}
				conOverLay.append("</div>");// firstBus
				conOverLay.append("<div class=\"busimg\" align= center>");
				conOverLay.append("<p class=\"busNum\">[" + busStopInfo.get(i).getCarNo2() + "]</p>");
				if (busStopInfo.get(i).getCrowded2() <= 20) {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/"
							+ "MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_"
							+ "5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png\">");
				} else if (busStopInfo.get(i).getCrowded2() < 35) {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/"
							+ "MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_"
							+ "EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png\">");
				} else {
					conOverLay.append("<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfMTQg/"
							+ "MDAxNTIzODY5MjU3NDgx.a8kS9vmgZcV8xZQ6LMjBbmzsEytJIEfENusu_i2H4qkg.xVRPaORFC6BEuTdY0su_"
							+ "5DtsQrro_1EOHl2xgKTf7E0g.PNG.aaz77/3.png\">");
				}
				conOverLay.append("</div>");// secondBus
				conOverLay.append("</div>");// busImg
			}
			conOverLay.append("</div>");// busInfo
		}
		conOverLay.append("</div>" + "</div>" + "</div>" + "</div>");// /desc/body/info/wrap

		String buf = "<script>overlay('" + conOverLay + "','" + gpsX + "','" + gpsY + "','" + name + "');</script>";
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

		if (busStopInfo.size() == 0) {
			conOverLay.append("<div class=\"wrap\">"); // wrap
			conOverLay.append("<div class=\"info\">"); // 2
			conOverLay.append("<div class=\"title\">");
			conOverLay.append(name + "[ ] <div class=\"close\" onclick=\"closeOverlay()\" title=\"닫기\"></div></div>"); // title
			conOverLay.append("<div class=\"body\">");// 3
			conOverLay.append("<div class=\"desc\">");// 4
			conOverLay.append("<div class=\"ellipsis\"> 김해/양산 일부 지역은 확인할 수 없습니다.</div>");
			conOverLay.append("<span class=\"jibun\"> [정보없음]</span>");// ellipsis
			conOverLay.append("</div>" + "</div>" + "</div>" + "</div>");// /desc/body/info/wrap
		} else {
			conOverLay.append("<div class=\"wrap\">"); // wrap
			conOverLay.append("<div class=\"info\">"); // 2
			conOverLay.append("<div class=\"title\">");
			conOverLay.append(name + "[" + busStopInfo.get(0).getArsNo()
					+ "] <div class=\"close\" onclick=\"closeOverlay()\" title=\"닫기\"></div></div>"); // title
			conOverLay.append("<div class=\"body\">");// 3
			conOverLay.append("<div class=\"desc\">");// 4
			for (int i = 0; i < busStopInfo.size(); i++) {
				conOverLay.append("<div class=\"mapBusTable\">");// 5
				conOverLay.append("<div class=\"busNumGps\" align= left>");// 7
				conOverLay.append("<div class=\"ellipsis\">" + busStopInfo.get(i).getLineNo() + "번 버스");
				if (busStopInfo.get(i).getCarNo1() == null) {
					conOverLay.append("<span class=\"jibun\"> [정보없음]</span></div>");// ellipsis
					conOverLay.append("</div>"); // busNumGps
					conOverLay.append("<div class=\"busImgs\" align= left ></div>");// busImg
				} else if (busStopInfo.get(i).getCarNo2() == null) {
					conOverLay.append("</div>");// ellipsis
					conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo1() + "] "
							+ busStopInfo.get(i).getStation1() + "정거장 전  " + busStopInfo.get(i).getMin1()
							+ "분 후 도착  </div>"); // jibun ellipsis
					conOverLay.append("</div>");// busNumGps
					conOverLay.append("<div class=\"busImgs\" align= left>");
					conOverLay.append("<div class=\"busimg\" align= center>");
					conOverLay.append("<p class=\"busNum\">[" + busStopInfo.get(i).getCarNo1() + "]</p>");
					if (busStopInfo.get(i).getCrowded1() <= 20) {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/"
										+ "MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_"
										+ "5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png\">");
					} else if (busStopInfo.get(i).getCrowded1() < 35) {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/"
										+ "MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_"
										+ "EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png\">");
					} else {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfMTQg/"
										+ "MDAxNTIzODY5MjU3NDgx.a8kS9vmgZcV8xZQ6LMjBbmzsEytJIEfENusu_i2H4qkg.xVRPaORFC6BEuTdY0su_"
										+ "5DtsQrro_1EOHl2xgKTf7E0g.PNG.aaz77/3.png\">");
					}
					conOverLay.append("</div>");// firstBus
					conOverLay.append("</div>");// busImg
				} else {
					conOverLay.append("</div>");// ellipsis
					conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo1() + "] "
							+ busStopInfo.get(i).getStation1() + "정거장 전  " + busStopInfo.get(i).getMin1()
							+ "분 후 도착  </div>");// jibun ellipsis
					conOverLay.append("<div class=\"jibun ellipsis\"> [" + busStopInfo.get(i).getCarNo2() + "] "
							+ busStopInfo.get(i).getStation2() + "정거장 전  " + busStopInfo.get(i).getMin2()
							+ "분 후 도착  </div>");// jibun ellipsis
					conOverLay.append("</div>");// busNumGps
					conOverLay.append("<div class=\"busImgs\" align= left>");
					conOverLay.append("<div class=\"busimg\" align= center>");
					conOverLay.append("<p class=\"busNum\">[" + busStopInfo.get(i).getCarNo1() + "]</p>");
					if (busStopInfo.get(i).getCrowded1() <= 20) {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/"
										+ "MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_"
										+ "5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png\">");
					} else if (busStopInfo.get(i).getCrowded1() < 35) {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/"
										+ "MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_"
										+ "EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png\">");
					} else {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfMTQg/"
										+ "MDAxNTIzODY5MjU3NDgx.a8kS9vmgZcV8xZQ6LMjBbmzsEytJIEfENusu_i2H4qkg.xVRPaORFC6BEuTdY0su_"
										+ "5DtsQrro_1EOHl2xgKTf7E0g.PNG.aaz77/3.png\">");
					}
					conOverLay.append("</div>");// firstBus
					conOverLay.append("<div class=\"busimg\" align= center>");
					conOverLay.append("<p class=\"busNum\">[" + busStopInfo.get(i).getCarNo2() + "]</p>");
					if (busStopInfo.get(i).getCrowded2() <= 20) {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfOTcg/"
										+ "MDAxNTIzODY5MjU3Mjg1.LKPuNYZRGO4sGNcHasT0kBTOHDBVPAm3-TGhtGGOe9sg.WdrsC5klAh6zW_"
										+ "5qnZ2EGaBaHXloaSiiVMnpY0I4h2Eg.PNG.aaz77/1.png\">");
					} else if (busStopInfo.get(i).getCrowded2() < 35) {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfNDEg/"
										+ "MDAxNTIzODY5MjU3Mzg2.mlUYpom6PEMkhg1fphN-JYTgqi_4qGrSukGMfZY-aiQg.r0VJHRaRGldVrF_"
										+ "EZQYIJtRjtw-5emMK-ZhZRNjofGcg.PNG.aaz77/2.png\">");
					} else {
						conOverLay.append(
								"<img class=\"crowdedImg\" src=\"https://blogfiles.pstatic.net/MjAxODA0MTZfMTQg/"
										+ "MDAxNTIzODY5MjU3NDgx.a8kS9vmgZcV8xZQ6LMjBbmzsEytJIEfENusu_i2H4qkg.xVRPaORFC6BEuTdY0su_"
										+ "5DtsQrro_1EOHl2xgKTf7E0g.PNG.aaz77/3.png\">");
					}
					conOverLay.append("</div>");// secondBus
					conOverLay.append("</div>");// busImg
				}
				conOverLay.append("</div>");// busInfo
			}
			conOverLay.append("</div>" + "</div>" + "</div>" + "</div>");// /desc/body/info/wrap

		}

		String buf = "<script>overlay('" + conOverLay + "','" + gpsX + "','" + gpsY + "','" + name + "');</script>";
		mav.addObject("bSIResult", buf); // busStopInfo
		mav.setViewName("include/bus_node_bstop_view");

		return mav;
	}
}
