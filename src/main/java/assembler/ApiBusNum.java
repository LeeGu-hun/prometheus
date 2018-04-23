package assembler;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import bean.BusBean;

public class ApiBusNum {
	public List getBusNum(String busnum) throws Exception {
		List<BusBean> TEST = new ArrayList();
		String URLSTRING = URLEncoder.encode(busnum, "UTF-8");

		String url = "http://61.43.246.153/openapi-data/service/busanBIMS2/busInfo?serviceKey=qtoPVWzzOaHE2p0loY9qiyWjAqQ%2FHPfkE3dZmm41%2FLOt9EBf3wB613JruaP8d27Jm0cJlwJE851k7v5UTG4hQQ%3D%3D&lineno="
				+ URLSTRING + " ";

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
		// 파싱 끝
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();

		FileOutputStream output = new FileOutputStream("./BUSNUMTEST");
		output.write(response.toString().getBytes());
		output.close();

		Document doc = builder.parse("./BUSNUMTEST");
		doc.getDocumentElement().normalize();

		Element item = (Element) doc.getElementsByTagName("item").item(0);
		int itemsize = doc.getElementsByTagName("item").getLength();

		for (int i = 0; i < itemsize; i++) {
			if (((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("buslinenum").item(0)
					.getChildNodes().item(0).getNodeValue().equals("73(아침)")) {
				TEST.add(new BusBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("buslinenum").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bustype").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i))
								.getElementsByTagName("endpoint").item(0).getChildNodes().item(0).getNodeValue(),
						"10:00",
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("firsttime").item(0)
								.getChildNodes().item(0).getNodeValue(),
						"5200073000",
						((Element) doc.getElementsByTagName("item").item(i))
								.getElementsByTagName("startpoint").item(0).getChildNodes().item(0).getNodeValue()));
			} else {
				TEST.add(new BusBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("buslinenum").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bustype").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("endpoint").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("endtime").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("firsttime").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineId").item(0)
								.getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("startpoint").item(0)
								.getChildNodes().item(0).getNodeValue()));
			}
		}
		return TEST;
	}

}