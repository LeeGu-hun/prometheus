package bean;

public class BusBean {
	String buslinenum;	//버스번호
	String lineId;		//노선ID
	String bustype;		//버스 종류
	String companyid;	//버스회사명
	String startpoint;	//기점명(버스출발지)
	String endpoint;	//종점명(버스도착지)
	String firsttime;	//첫차시간
	String endtime;		//막차시간
	String headwayNorm;	//배차간격(분)(일반)
	String headwayPeak;	//배차간격(분)(출퇴근)
	String headwayHoli;	//배차간격(분)(휴일)

	public BusBean() {
	}

	public BusBean(String buslinenum, String lineId) {
		super();
		this.buslinenum = buslinenum;
		this.lineId = lineId;
	}

	public BusBean(String buslinenum, String bustype, String companyid, String endpoint, String endtime,
			String firsttime, String headwayHoli, String headwayNorm, String headwayPeak, String lineId,
			String startpoint) {
		super();
		this.buslinenum = buslinenum;
		this.bustype = bustype;
		this.companyid = companyid;
		this.endpoint = endpoint;
		this.endtime = endtime;
		this.firsttime = firsttime;
		this.headwayHoli = headwayHoli;
		this.headwayNorm = headwayNorm;
		this.headwayPeak = headwayPeak;
		this.lineId = lineId;
		this.startpoint = startpoint;
	}

	public BusBean(String buslinenum, String bustype, String companyid, String endpoint, String endtime,
			String firsttime, String lineId, String startpoint) {
		super();
		this.buslinenum = buslinenum;
		this.bustype = bustype;
		this.companyid = companyid;
		this.endpoint = endpoint;
		this.endtime = endtime;
		this.firsttime = firsttime;
		this.lineId = lineId;
		this.startpoint = startpoint;
	}

	public BusBean(String buslinenum, String bustype, String endpoint, String endtime, String firsttime, String lineId,
			String startpoint) {
		super();
		this.buslinenum = buslinenum;
		this.bustype = bustype;
		this.endpoint = endpoint;
		this.endtime = endtime;
		this.firsttime = firsttime;
		this.lineId = lineId;
		this.startpoint = startpoint;
	}

	public String getBuslinenum() {
		return buslinenum;
	}

	public void setBuslinenum(String buslinenum) {
		this.buslinenum = buslinenum;
	}

	public String getBustype() {
		return bustype;
	}

	public void setBustype(String bustype) {
		this.bustype = bustype;
	}

	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getFirsttime() {
		return firsttime;
	}

	public void setFirsttime(String firsttime) {
		this.firsttime = firsttime;
	}

	public String getHeadwayHoli() {
		return headwayHoli;
	}

	public void setHeadwayHoli(String headwayHoli) {
		this.headwayHoli = headwayHoli;
	}

	public String getHeadwayNorm() {
		return headwayNorm;
	}

	public void setHeadwayNorm(String headwayNorm) {
		this.headwayNorm = headwayNorm;
	}

	public String getHeadwayPeak() {
		return headwayPeak;
	}

	public void setHeadwayPeak(String headwayPeak) {
		this.headwayPeak = headwayPeak;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getStartpoint() {
		return startpoint;
	}

	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}

}