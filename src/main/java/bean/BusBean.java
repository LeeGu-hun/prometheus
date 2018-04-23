package bean;

public class BusBean {
	String busLineNum;	//버스번호
	String lineId;		//노선ID
	String busType;		//버스 종류
	String companyId;	//버스회사명
	String startPoint;	//기점명(버스출발지)
	String endPoint;	//종점명(버스도착지)
	String firstTime;	//첫차시간
	String endTime;		//막차시간
	String headwayNorm;	//배차간격(분)(일반)
	String headwayPeak;	//배차간격(분)(출퇴근)
	String headwayHoli;	//배차간격(분)(휴일)

	public BusBean() {
	}

	public BusBean(String busLineNum, String busType, String companyId, String endPoint, String endTime,
			String firstTime, String headwayHoli, String headwayNorm, String headwayPeak, String lineId,
			String startPoint) {
		super();
		this.busLineNum = busLineNum;
		this.busType = busType;
		this.companyId = companyId;
		this.endPoint = endPoint;
		this.endTime = endTime;
		this.firstTime = firstTime;
		this.headwayHoli = headwayHoli;
		this.headwayNorm = headwayNorm;
		this.headwayPeak = headwayPeak;
		this.lineId = lineId;
		this.startPoint = startPoint;
	}

	public BusBean(String busLineNum, String busType, String companyId, String endPoint, String endTime,
			String firstPime, String lineId, String startPoint) {
		super();
		this.busLineNum = busLineNum;
		this.busType = busType;
		this.companyId = companyId;
		this.endPoint = endPoint;
		this.endTime = endTime;
		this.firstTime = firstTime;
		this.lineId = lineId;
		this.startPoint = startPoint;
	}

	public BusBean(String busLineNum, String busType, String endPoint, String endTime, String firstTime, String lineId,
			String startPoint) {
		super();
		this.busLineNum = busLineNum;
		this.busType = busType;
		this.endPoint = endPoint;
		this.endTime = endTime;
		this.firstTime = firstTime;
		this.lineId = lineId;
		this.startPoint = startPoint;
	}

	
	public String getBusLineNum() {
		return busLineNum;
	}

	public String getLineId() {
		return lineId;
	}

	public String getBusType() {
		return busType;
	}

	public String getCompanyId() {
		return companyId;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getHeadwayNorm() {
		return headwayNorm;
	}

	public String getHeadwayPeak() {
		return headwayPeak;
	}

	public String getHeadwayHoli() {
		return headwayHoli;
	}

	public void setBusLineNum(String busLineNum) {
		this.busLineNum = busLineNum;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setHeadwayNorm(String headwayNorm) {
		this.headwayNorm = headwayNorm;
	}

	public void setHeadwayPeak(String headwayPeak) {
		this.headwayPeak = headwayPeak;
	}

	public void setHeadwayHoli(String headwayHoli) {
		this.headwayHoli = headwayHoli;
	}
	
	
}