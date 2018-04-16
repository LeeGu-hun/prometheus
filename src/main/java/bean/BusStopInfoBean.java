package bean;

public class BusStopInfoBean {

	String arsNo;		// 정류소 번호
	String bstopId;		// 정류소 ID
	String nodeNm;		// 정류소명
	String gpsX;		// 정류소GPS좌표 X
	String gpsY;		// 정류소GPS좌표 Y
	String bustype;		// 버스종류(일반/마을)
	String lineNo;		// 버스번호
	String lineid;		// 노선ID
	String bstopIdx;	// 노선 정류소 순번
	String carNo1;		// 첫번쨰 차량번호
	String carNo2;		// 두번째 차량번호
	String min1;		// 첫번째 차량 남은 도착시간
	String min2;		// 두번째 차량 남은 도착시간
	String station1;	// 첫번째 차량 남은 정류소 수
	String station2;	// 두번째 차량 남은 도착시간
	String lowplate1;	// 첫번째 차량 저상버스구분 (0:일반 1:저상)
	String lowplate2;	// 두번째 차량 저상버스구분 (0:일반 1:저상)
	String crowded1;	// 첫번째 차량 혼잡도
	String crowded2;	//두번째 차량 혼잡도

	public BusStopInfoBean() {
	}

	public BusStopInfoBean(String arsNo, String bstopId, String bstopIdx, String bustype, String carNo1, String carNo2,
			String gpsX, String gpsY, String lineNo, String lineid, String lowplate1, String lowplate2, String min1,
			String min2, String nodeNm, String station1, String station2, String crowded1, String crowded2) {
		super();
		this.arsNo = arsNo;
		this.bstopId = bstopId;
		this.bstopIdx = bstopIdx;
		this.bustype = bustype;
		this.carNo1 = carNo1;
		this.carNo2 = carNo2;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
		this.lineNo = lineNo;
		this.lineid = lineid;
		this.lowplate1 = lowplate1;
		this.lowplate2 = lowplate2;
		this.min1 = min1;
		this.min2 = min2;
		this.nodeNm = nodeNm;
		this.station1 = station1;
		this.station2 = station2;
		this.crowded1 = crowded1;
		this.crowded2 = crowded2;
	}

	public BusStopInfoBean(String bstopId, String bstopIdx, String bustype, String carNo1, String carNo2, String gpsX,
			String gpsY, String lineNo, String lineid, String lowplate1, String lowplate2, String min1, String min2,
			String nodeNm, String station1, String station2, String crowded1, String crowded2) {
		super();
		this.bstopId = bstopId;
		this.bstopIdx = bstopIdx;
		this.bustype = bustype;
		this.carNo1 = carNo1;
		this.carNo2 = carNo2;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
		this.lineNo = lineNo;
		this.lineid = lineid;
		this.lowplate1 = lowplate1;
		this.lowplate2 = lowplate2;
		this.min1 = min1;
		this.min2 = min2;
		this.nodeNm = nodeNm;
		this.station1 = station1;
		this.station2 = station2;
		this.crowded1 = crowded1;
		this.crowded2 = crowded2;
	}

	public BusStopInfoBean(String arsNo, String bstopId, String bstopIdx, String bustype, String carNo1, String gpsX,
			String gpsY, String lineNo, String lineid, String lowplate1, String min1, String nodeNm, String station1,
			String crowded1) {
		super();
		this.arsNo = arsNo;
		this.bstopId = bstopId;
		this.bstopIdx = bstopIdx;
		this.bustype = bustype;
		this.carNo1 = carNo1;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
		this.lineNo = lineNo;
		this.lineid = lineid;
		this.lowplate1 = lowplate1;
		this.min1 = min1;
		this.nodeNm = nodeNm;
		this.station1 = station1;
		this.crowded1 = crowded1;
	}

	public BusStopInfoBean(String bstopId, String bstopIdx, String bustype, String carNo1, String gpsX, String gpsY,
			String lineNo, String lineid, String lowplate1, String min1, String nodeNm, String station1,
			String crowded1) {
		super();
		this.bstopId = bstopId;
		this.bstopIdx = bstopIdx;
		this.bustype = bustype;
		this.carNo1 = carNo1;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
		this.lineNo = lineNo;
		this.lineid = lineid;
		this.lowplate1 = lowplate1;
		this.min1 = min1;
		this.nodeNm = nodeNm;
		this.station1 = station1;
		this.crowded1 = crowded1;
	}

	public BusStopInfoBean(String arsNo, String bstopId, String bstopIdx, String bustype, String gpsX, String gpsY,
			String lineNo, String lineid, String nodeNm) {
		super();
		this.arsNo = arsNo;
		this.bstopId = bstopId;
		this.bstopIdx = bstopIdx;
		this.bustype = bustype;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
		this.lineNo = lineNo;
		this.lineid = lineid;
		this.nodeNm = nodeNm;
	}

	public BusStopInfoBean(String gpsX, String gpsY, String nodeNm) {
		super();
		this.gpsX = gpsX;
		this.gpsY = gpsY;
		this.nodeNm = nodeNm;
	}

	public String getArsNo() {
		return arsNo;
	}

	public void setArsNo(String arsNo) {
		this.arsNo = arsNo;
	}

	public String getBstopId() {
		return bstopId;
	}

	public void setBstopId(String bstopId) {
		this.bstopId = bstopId;
	}

	public String getBstopIdx() {
		return bstopIdx;
	}

	public void setBstopIdx(String bstopIdx) {
		this.bstopIdx = bstopIdx;
	}

	public String getBustype() {
		return bustype;
	}

	public void setBustype(String bustype) {
		this.bustype = bustype;
	}

	public String getCarNo1() {
		return carNo1;
	}

	public void setCarNo1(String carNo1) {
		this.carNo1 = carNo1;
	}

	public String getCarNo2() {
		return carNo2;
	}

	public void setCarNo2(String carNo2) {
		this.carNo2 = carNo2;
	}

	public String getGpsX() {
		return gpsX;
	}

	public void setGpsX(String gpsX) {
		this.gpsX = gpsX;
	}

	public String getGpsY() {
		return gpsY;
	}

	public void setGpsY(String gpsY) {
		this.gpsY = gpsY;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public String getLineid() {
		return lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid;
	}

	public String getLowplate1() {
		return lowplate1;
	}

	public void setLowplate1(String lowplate1) {
		this.lowplate1 = lowplate1;
	}

	public String getLowplate2() {
		return lowplate2;
	}

	public void setLowplate2(String lowplate2) {
		this.lowplate2 = lowplate2;
	}

	public String getMin1() {
		return min1;
	}

	public void setMin1(String min1) {
		this.min1 = min1;
	}

	public String getMin2() {
		return min2;
	}

	public void setMin2(String min2) {
		this.min2 = min2;
	}

	public String getNodeNm() {
		return nodeNm;
	}

	public void setNodeNm(String nodeNm) {
		this.nodeNm = nodeNm;
	}

	public String getStation1() {
		return station1;
	}

	public void setStation1(String station1) {
		this.station1 = station1;
	}

	public String getStation2() {
		return station2;
	}

	public void setStation2(String station2) {
		this.station2 = station2;
	}

	public String getCrowded1() {
		return crowded1;
	}

	public String getCrowded2() {
		return crowded2;
	}

	public void setCrowded1(String crowded1) {
		this.crowded1 = crowded1;
	}

	public void setCrowded2(String crowded2) {
		this.crowded2 = crowded2;
	}

}
