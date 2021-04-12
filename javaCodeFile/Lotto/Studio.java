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
		//방송준비하고 멘트하고 뽑기 시간
		System.out.println("로또 추첨 방송을 준비합니다.");
		Thread.sleep(50);
		this.readyAir();
		System.out.println("로또 추첨 방송을 시작합니다.");
		Thread.sleep(50);
		machine.startMachineV2(6);
		Thread.sleep(30);
		System.out.println("로또 추첨을 종료 합니다.");
	}
	
	public void readyAir() {
		//볼을 사서 로또 머신에 셋팅하는 역할
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
