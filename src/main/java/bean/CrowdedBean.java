package bean;

public class CrowdedBean {
	String carNo;		// 차량번호
	int crowded;		// 혼잡도		
	
	
	public CrowdedBean() {
		super();
	}
	public CrowdedBean(String carNo, int crowded) {
		super();
		this.carNo = carNo;
		this.crowded = crowded;
	}
	public String getCarNo() {
		return carNo;
	}
	public int getCrowded() {
		return crowded;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public void setCrowded(int crowded) {
		this.crowded = crowded;
	}
	
	

}
