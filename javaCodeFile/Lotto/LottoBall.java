package mc.sn.day8;

public class LottoBall {
	private Integer number;
	private boolean isSelected;
	
	//number를 셋팅하는 생성자 만들고
	public LottoBall() {}
	public LottoBall(Integer number) {
		this.number = number;
		this.isSelected= false;
	}
	
	//각 필드의 get/set을 만드시오
	public Integer getNumber() {
		return this.number;
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNumber().toString();
	}
	
}
