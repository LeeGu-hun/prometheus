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
import bean.BusStopBean;
import bean.BusStopInfoBean;

public class ApiBusStopInfo {

	public List<BusStopInfoBean> busStopInfo(String station) throws Exception {
		ArrayList<BusStopInfoBean> result = new ArrayList();

		String URLSTRING = URLEncoder.encode(station, "UTF-8");

		String url = "http://61.43.246.153/openapi-data/service/busanBIMS2/stopArr?serviceKey=qtoPVWzzOaHE2p0loY9qiyWjAqQ%2FHPfkE3dZmm41%2FLOt9EBf3wB613JruaP8d27Jm0cJlwJE851k7v5UTG4hQQ%3D%3D&bstopid="
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

		FileOutputStream output = new FileOutputStream("./BUSNODEGPS");
		output.write(response.toString().getBytes());
		output.close();

		Document doc = builder.parse("./BUSNODEGPS");
		doc.getDocumentElement().normalize();

		Element item = (Element) doc.getElementsByTagName("item").item(0);

		int itemsize = doc.getElementsByTagName("item").getLength();

		for (int i = 0; i < itemsize; i++) {
			if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 17) {
				result.add(new BusStopInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("arsNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bustype").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo2").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsX").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsY").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineid").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate2").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("min1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("min2").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeNm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("station1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("station2").item(0).getChildNodes().item(0).getNodeValue()
						));
			} else if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 16) {
				result.add(new BusStopInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bustype").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo2").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsX").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsY").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineid").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate2").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("min1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("min2").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeNm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("station1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("station2").item(0).getChildNodes().item(0).getNodeValue()
						));
			}  else if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 13) {
				result.add(new BusStopInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("arsNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bustype").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsX").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsY").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineid").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("min1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeNm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("station1").item(0).getChildNodes().item(0).getNodeValue()
						));
			} else if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 12) {
				result.add(new BusStopInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bustype").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("carNo1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsX").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsY").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineid").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lowplate1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("min1").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeNm").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("station1").item(0).getChildNodes().item(0).getNodeValue()
						));
			}
			
			
			else if (doc.getElementsByTagName("item").item(i).getChildNodes().getLength() == 9) {
				result.add(new BusStopInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("arsNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopId").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bstopIdx").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("bustype").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsX").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsY").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineNo").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("lineid").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeNm").item(0).getChildNodes().item(0).getNodeValue()
						));
			} else {
				result.add(new BusStopInfoBean(
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsX").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("gpsY").item(0).getChildNodes().item(0).getNodeValue(),
						((Element) doc.getElementsByTagName("item").item(i)).getElementsByTagName("nodeNm").item(0).getChildNodes().item(0).getNodeValue()
						));
			}

		}
		return result;
	}
}