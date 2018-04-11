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

import bean.BusInfoBean;

public class ApiBusLine {
	public List getBusLine(String bLine) throws Exception {

		List TEST = new ArrayList();
		String URLSTRING = URLEncoder.encode(bLine, "UTF-8");

		String url = "http://61.43.246.153/openapi-data/service/busanBIMS2/busInfoRoute?serviceKey=qtoPVWzzOaHE2p0loY9qiyWjAqQ%2FHPfkE3dZmm41%2FLOt9EBf3wB613JruaP8d27Jm0cJlwJE851k7v5UTG4hQQ%3D%3D&lineid="
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
		// System.out.println(response.toString());
		// 파싱 끝
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();

		FileOutputStream output = new FileOutputStream("./BUSLINETEST");
		output.write(response.toString().getBytes());
		output.close();

		Document doc = builder.parse("./BUSLINETEST");
		doc.getDocumentElement().normalize();

		Element item = (Element) doc.getElementsByTagName("item").item(0);
		Element item1 = (Element) doc.getElementsByTagName("item").item(1);
		int nodesize = item1.getChildNodes().getLength();

		int itemsize = doc.getElementsByTagName("item").getLength();
		List carnum = new ArrayList();
		
		for(int i = 0; i<itemsize;i++) {
			if(doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 14) {
			TEST.add(new BusInfoBean(
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("arsNo").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("avgtm").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopnm").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("direction").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsTm").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lat").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lon").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeId").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeKn").item(0).getChildNodes().item(0).getNodeValue(),
					((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("rpoint").item(0).getChildNodes().item(0).getNodeValue()
					));
			carnum.add(((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo").item(0).getChildNodes().item(0).getNodeValue()
					+ ((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopnm").item(0).getChildNodes().item(0).getNodeValue());
			} else if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 13){
				TEST.add(new BusInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("avgtm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopnm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("direction").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsTm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lat").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lon").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeKn").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("rpoint").item(0).getChildNodes().item(0).getNodeValue()
						));
			carnum.add(((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo").item(0).getChildNodes().item(0).getNodeValue()
					+ ((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopnm").item(0).getChildNodes().item(0).getNodeValue());
			} else if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 6){
				TEST.add(new BusInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("avgtm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopnm").item(0).getChildNodes().item(0).getNodeValue(),					
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),						
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("rpoint").item(0).getChildNodes().item(0).getNodeValue()
						));
			} else if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 7){
				TEST.add(new BusInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("arsNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("avgtm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopnm").item(0).getChildNodes().item(0).getNodeValue(),					
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),						
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("rpoint").item(0).getChildNodes().item(0).getNodeValue()
						));
			} else {
				TEST.add(new BusInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopnm").item(0).getChildNodes().item(0).getNodeValue(),					
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),						
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeId").item(0).getChildNodes().item(0).getNodeValue()
						));
			}
		}
//		for(int i = 0; i <carnum.size();i++) {
//		System.out.println(carnum.get(i));
//		}
		return TEST;
	}
}
