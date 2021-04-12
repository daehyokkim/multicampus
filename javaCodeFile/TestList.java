package mc.sn.day8;

import java.util.ArrayList;


public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestList tl = new TestList();
		tl.test1();
	}
	// Ŭ���� A,B �� ��Ӱ��踦 ������ �ְ� A�� ����Ŭ�����̸�
	// ������ ���� ������ �ڵ尡 �����ϴ�.
	// A a = new B();//promotion
	// B b =(B)a; //casting
	
	public void test1() {
		//ArrayList�� �н� �մϴ�. CRUD ũ��
		//ArrayList �ν��Ͻ��� ���弼��.
		//Ȯ�� --> promotion --> ū������ Ȯ��
		//������ --> testing --> �������� 
		ArrayList list = new ArrayList();
		list.add(new Integer(1)); //Create ����
		list.add(new Integer(2)); //Create ����
		list.set(1,new Integer(20)); //set(index,value),U
		list.set(1,"20"); //set(index,value),U
//		�ٸ� Ÿ���� ������ �� runtime�� �߰� �� �� �ִ�.
		printList(list);
		list.remove(1); // remove(index), D
		int size = list.size(); 
		printList(list);
	}
	
	//��ʸ� ���� ���� ����  : ����Ʈ�� ���� �� �ִ� Object�� �����Ͽ� ������ �����ϱ� ����?
	public void test2() {
		//ArrayList�� �н� �մϴ�. CRUD ũ��
		//ArrayList �ν��Ͻ��� ���弼��.
		//Ȯ�� --> promotion --> ū������ Ȯ��
		//������ --> testing --> �������� 
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1)); //Create ����
		list.add(new Integer(2)); //Create ����
		list.set(1,new Integer(20)); //set(index,value),U
//		list.set(1,"20"); //set(index,value),U
//		�ٸ� Ÿ���� ������ �� runtime�� �߰� �� �� �ִ�.
		printList(list);
		list.remove(1); // remove(index), D
		int size = list.size(); 
		printList(list);
	}

	public void test3() {
		//ArrayList�� �н� �մϴ�. CRUD ũ��
		//ArrayList �ν��Ͻ��� ���弼��.
		//Ȯ�� --> promotion --> ū������ Ȯ��
		//������ --> testing --> �������� 
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); //Create ���� //���������� �ɽ����ϴ� �� (�ڽ�)
		list.add(2); //Create ����
		list.set(1,20); //set(index,value),U
//		list.set(1,"20"); //set(index,value),U
//		�ٸ� Ÿ���� ������ �� runtime�� �߰� �� �� �ִ�.
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
			int temp = list.get(i); //unboxing �ڵ����� �ش� ��ü ���� 	
		}
		
	}

}
