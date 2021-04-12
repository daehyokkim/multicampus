package mc.sn.day8;

import java.util.ArrayList;

public class Studio {

	private LottoMachine machine;
	
	public Studio() {}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Studio st = new Studio();
		try {
			st.onAir();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onAir() throws InterruptedException{
		//����غ��ϰ� ��Ʈ�ϰ� �̱� �ð�
		System.out.println("�ζ� ��÷ ����� �غ��մϴ�.");
		Thread.sleep(50);
		this.readyAir();
		System.out.println("�ζ� ��÷ ����� �����մϴ�.");
		Thread.sleep(50);
		machine.startMachineV2(6);
		Thread.sleep(30);
		System.out.println("�ζ� ��÷�� ���� �մϴ�.");
	}
	
	public void readyAir() {
		//���� �缭 �ζ� �ӽſ� �����ϴ� ����
		ArrayList<LottoBall> list = this.makeBalls(45);
		machine = new LottoMachine(list);
		
	}
	
	public ArrayList<LottoBall> makeBalls(int number){
		ArrayList<LottoBall> list = null;
		list = new ArrayList<LottoBall>();
		for(int i =0 ; i<number;i++) {
			list.add(i, new LottoBall(i+1));
		}
		
		return list;
	}

}
