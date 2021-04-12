package mc.sn.day8;

import java.util.ArrayList;


public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestList tl = new TestList();
		tl.test1();
	}
	// 클래스 A,B 가 상속관계를 가지고 있고 A가 수퍼클래스이면
	// 다음과 같은 다형성 코드가 가능하다.
	// A a = new B();//promotion
	// B b =(B)a; //casting
	
	public void test1() {
		//ArrayList를 학습 합니다. CRUD 크기
		//ArrayList 인스턴스를 만드세요.
		//확장 --> promotion --> 큰값으로 확장
		//다형성 --> testing --> 작은값을 
		ArrayList list = new ArrayList();
		list.add(new Integer(1)); //Create 저장
		list.add(new Integer(2)); //Create 저장
		list.set(1,new Integer(20)); //set(index,value),U
		list.set(1,"20"); //set(index,value),U
//		다른 타입이 들어가있을 때 runtime떄 발견 할 수 있다.
		printList(list);
		list.remove(1); // remove(index), D
		int size = list.size(); 
		printList(list);
	}
	
	//재너릭 개념 도입 이유  : 리스트가 가질 수 있는 Object를 지정하여 에러를 제거하기 위해?
	public void test2() {
		//ArrayList를 학습 합니다. CRUD 크기
		//ArrayList 인스턴스를 만드세요.
		//확장 --> promotion --> 큰값으로 확장
		//다형성 --> testing --> 작은값을 
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1)); //Create 저장
		list.add(new Integer(2)); //Create 저장
		list.set(1,new Integer(20)); //set(index,value),U
//		list.set(1,"20"); //set(index,value),U
//		다른 타입이 들어가있을 때 runtime떄 발견 할 수 있다.
		printList(list);
		list.remove(1); // remove(index), D
		int size = list.size(); 
		printList(list);
	}

	public void test3() {
		//ArrayList를 학습 합니다. CRUD 크기
		//ArrayList 인스턴스를 만드세요.
		//확장 --> promotion --> 큰값으로 확장
		//다형성 --> testing --> 작은값을 
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); //Create 저장 //내부적으로 케스팅하는 것 (박싱)
		list.add(2); //Create 저장
		list.set(1,20); //set(index,value),U
//		list.set(1,"20"); //set(index,value),U
//		다른 타입이 들어가있을 때 runtime떄 발견 할 수 있다.
		printList(list);
		list.remove(1); // remove(index), D
		int size = list.size(); 
		printList(list);
	}

	//int -> Integer , char -> Character
	public void printList(ArrayList<Integer> list) {
		for(int i=0; i< list.size() ; i++) {
//			Integer integer = (Integer)list.get(i); //casting, R
//			int temp  = integer.intValue();
//			System.out.println(temp);
			int temp = list.get(i); //unboxing 자동으로 해당 객체 생성 	
		}
		
	}

}
