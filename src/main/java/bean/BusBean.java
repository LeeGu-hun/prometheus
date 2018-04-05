package bean;

public class BusBean {
	String buslinenum,bustype,companyid,endpoint,endtime,firsttime,headway,headwayHoli,headwayNorm,headwayPeak,lineId,startpoint;
	
	

	public BusBean(String buslinenum, String bustype, String companyid, String endpoint, String endtime,
			String firsttime, String headway, String headwayHoli, String headwayNorm, String headwayPeak, String lineId,
			String startpoint) {
		super();
		this.buslinenum = buslinenum;
		this.bustype = bustype;
		this.companyid = companyid;
		this.endpoint = endpoint;
		this.endtime = endtime;
		this.firsttime = firsttime;
		this.headway = headway;
		this.headwayHoli = headwayHoli;
		this.headwayNorm = headwayNorm;
		this.headwayPeak = headwayPeak;
		this.lineId = lineId;
		this.startpoint = startpoint;
	}
	

	public BusBean() {}


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

	public String getHeadway() {
		return headway;
	}

	public void setHeadway(String headway) {
		this.headway = headway;
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
