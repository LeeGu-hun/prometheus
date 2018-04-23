package assembler;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import bean.BusStopBean;

public class API {

	public Map<String, Object> busStation(String station, String page) throws Exception {
		ArrayList<BusStopBean> list = new ArrayList();
		Map<String, Object> result = new HashMap<String, Object>();
		String URLSTRING = URLEncoder.encode(station, "UTF-8");
		String url = "http://61.43.246.153/openapi-data/service/busanBIMS2/busStop?serviceKey=qtoPVWzzOaHE2p0loY9qiyWjAqQ%2FHPfkE3dZmm41%2FLOt9EBf3wB613JruaP8d27Jm0cJlwJE851k7v5UTG4hQQ%3D%3D&numOfRows=20&pageNo="+page+"&bstopnm="+URLSTRING+" ";
		
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.getResponseCode();
		String inputLine;
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//파싱 끝
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();

		FileOutputStream output = new FileOutputStream("./BUSTEST");
		output.write(response.toString().getBytes());
		output.close();

		Document doc = builder.parse("./BUSTEST");
		doc.getDocumentElement().normalize();
		
		//페이지처리용 total
		String totalCount = doc.getElementsByTagName("totalCount").item(0).getChildNodes().item(0).getNodeValue();
		
		int itemsize = doc.getElementsByTagName("item").getLength();
		
		if (itemsize > 0) {
			for (int i = 0; i < itemsize; i++) {
				list.add(new BusStopBean(
						doc.getElementsByTagName("bstopId").item(i).getChildNodes().item(0).getNodeValue(),
						doc.getElementsByTagName("bstopNm").item(i).getChildNodes().item(0).getNodeValue(),
						doc.getElementsByTagName("gpsX").item(i).getChildNodes().item(0).getNodeValue(),
						doc.getElementsByTagName("gpsY").item(i).getChildNodes().item(0).getNodeValue(),
						doc.getElementsByTagName("stoptype").item(i).getChildNodes().item(0).getNodeValue()));
			}
		}else {
			list.add(new BusStopBean(null,null,"129.059362360916","35.15332040526",null));
		}
		
		result.put("totalCount", totalCount); // item 수
		result.put("bstopCount", itemsize); // 해당 page의 item 수
		result.put("bstop", list); //item List
		// 파싱 데이터 받아오기 끝
		return result;
	}
}
