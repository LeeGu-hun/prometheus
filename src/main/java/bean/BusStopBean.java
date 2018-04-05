package bean;

public class BusStopBean {
	String bstopId;
	String bstopName;
	String bstopGpsX;
	String bstopGpsY;
	String bstopType;
	
	
	public BusStopBean() {}
	public BusStopBean(String bstopId, String bstopName, String bstopGpsX, String bstopGpsY, String bstopType) {
		super();
		this.bstopId = bstopId;
		this.bstopName = bstopName;
		this.bstopGpsX = bstopGpsX;
		this.bstopGpsY = bstopGpsY;
		this.bstopType = bstopType;
	}
	public String getBstopId() {
		return bstopId;
	}
	public String getBstopName() {
		return bstopName;
	}
	public String getBstopGpsX() {
		return bstopGpsX;
	}
	public String getBstopGpsY() {
		return bstopGpsY;
	}
	public String getBstopType() {
		return bstopType;
	}
	public void setBstopId(String bstopId) {
		this.bstopId = bstopId;
	}
	public void setBstopName(String bstopName) {
		this.bstopName = bstopName;
	}
	public void setBstopGpsX(String bstopGpsX) {
		this.bstopGpsX = bstopGpsX;
	}
	public void setBstopGpsY(String bstopGpsY) {
		this.bstopGpsY = bstopGpsY;
	}
	public void setBstopType(String bstopType) {
		this.bstopType = bstopType;
	}
	
	
	
}
