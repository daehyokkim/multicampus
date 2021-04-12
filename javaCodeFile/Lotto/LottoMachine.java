package mc.sn.day8;

import java.util.ArrayList;
import java.util.Random;

public class LottoMachine {
	private ArrayList<LottoBall> list;
	
	public LottoMachine(ArrayList<LottoBall> list) {
		this.list = list;
	}
	
	public LottoBall getBall() {
		LottoBall ball = null;
		Random random = new Random();
		int index = random.nextInt(45);
		ball = list.get(index);
		return ball;
	}
	
	public void startMachine(int num) {
		
		LottoBall ball = null;
		for(int i=0;i<num;i++) {
			ball = this.getBall();
			if(ball.getIsSelected()) {
				i--;
				continue;
			}
			else {
				ball.setIsSelected(true);
			}
			System.out.println(ball.getNumber()+ " ¹ø!!!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public LottoBall getBallV2() {
		LottoBall ball = null;
		Random random = new Random();
		int index = random.nextInt(list.size());
		ball = list.remove(index);
		return ball;
	}

	public void startMachineV2(int num) {
		
		LottoBall ball = null;
		for(int i=0;i<num;i++) {
			ball = this.getBallV2();
			System.out.println(ball+ " ¹ø!!!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
