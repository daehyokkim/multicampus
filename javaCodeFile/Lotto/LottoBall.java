package mc.sn.day8;

public class LottoBall {
	private Integer number;
	private boolean isSelected;
	
	//number�� �����ϴ� ������ �����
	public LottoBall() {}
	public LottoBall(Integer number) {
		this.number = number;
		this.isSelected= false;
	}
	
	//�� �ʵ��� get/set�� ����ÿ�
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
