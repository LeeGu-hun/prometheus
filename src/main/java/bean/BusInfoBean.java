package bean;

public class BusInfoBean {
	String arsNo,avgtm,bstopIdx,bstopnm,carNo,direction,gpsTm,lat,lineNo,lon,lowplate,nodeId,nodeKn,rpoint;
	
	
	

	public BusInfoBean(String arsNo, String avgtm, String bstopIdx, String bstopnm, String carNo, String direction,
			String gpsTm, String lat, String lineNo, String lon, String lowplate, String nodeId, String nodeKn,
			String rpoint) {
	
		this.arsNo = arsNo;
		this.avgtm = avgtm;
		this.bstopIdx = bstopIdx;
		this.bstopnm = bstopnm;
		this.carNo = carNo;
		this.direction = direction;
		this.gpsTm = gpsTm;
		this.lat = lat;
		this.lineNo = lineNo;
		this.lon = lon;
		this.lowplate = lowplate;
		this.nodeId = nodeId;
		this.nodeKn = nodeKn;
		this.rpoint = rpoint;
	}
	
	

	public BusInfoBean(String avgtm, String bstopIdx, String bstopnm, String carNo, String direction, String gpsTm,
			String lat, String lineNo, String lon, String lowplate, String nodeId, String nodeKn, String rpoint) {
		super();
		this.avgtm = avgtm;
		this.bstopIdx = bstopIdx;
		this.bstopnm = bstopnm;
		this.carNo = carNo;
		this.direction = direction;
		this.gpsTm = gpsTm;
		this.lat = lat;
		this.lineNo = lineNo;
		this.lon = lon;
		this.lowplate = lowplate;
		this.nodeId = nodeId;
		this.nodeKn = nodeKn;
		this.rpoint = rpoint;
	}



	public BusInfoBean(String arsNo, String avgtm, String bstopIdx, String bstopnm, String lineNo, String nodeId,
			String rpoint) {
	
		this.arsNo = arsNo;
		this.avgtm = avgtm;
		this.bstopIdx = bstopIdx;
		this.bstopnm = bstopnm;
		this.lineNo = lineNo;
		this.nodeId = nodeId;
		this.rpoint = rpoint;
	}



	public BusInfoBean(String avgtm, String bstopIdx, String bstopnm, String lineNo, String nodeId, String rpoint) {
		super();
		this.avgtm = avgtm;
		this.bstopIdx = bstopIdx;
		this.bstopnm = bstopnm;
		this.lineNo = lineNo;
		this.nodeId = nodeId;
		this.rpoint = rpoint;
	}



	public BusInfoBean(String bstopIdx, String bstopnm, String lineNo, String nodeId) {
		super();
		this.bstopIdx = bstopIdx;
		this.bstopnm = bstopnm;
		this.lineNo = lineNo;
		this.nodeId = nodeId;
	}



	public BusInfoBean() { }

	public String getArsNo() {
		return arsNo;
	}

	public void setArsNo(String arsNo) {
		this.arsNo = arsNo;
	}

	public String getAvgtm() {
		return avgtm;
	}

	public void setAvgtm(String avgtm) {
		this.avgtm = avgtm;
	}

	public String getBstopIdx() {
		return bstopIdx;
	}

	public void setBstopIdx(String bstopIdx) {
		this.bstopIdx = bstopIdx;
	}

	public String getBstopnm() {
		return bstopnm;
	}

	public void setBstopnm(String bstopnm) {
		this.bstopnm = bstopnm;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getGpsTm() {
		return gpsTm;
	}

	public void setGpsTm(String gpsTm) {
		this.gpsTm = gpsTm;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLowplate() {
		return lowplate;
	}

	public void setLowplate(String lowplate) {
		this.lowplate = lowplate;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeKn() {
		return nodeKn;
	}

	public void setNodeKn(String nodeKn) {
		this.nodeKn = nodeKn;
	}

	public String getRpoint() {
		return rpoint;
	}

	public void setRpoint(String rpoint) {
		this.rpoint = rpoint;
	}
	
	
}
