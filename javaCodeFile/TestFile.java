package mc.sn.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TestFile tf = new TestFile();
		tf.connectFile();
	}
	
	public void connectFile() throws IOException {
		File f = new File("C:\\dev\\data\\Abc1115.csv");
		if(f.exists()) {
			System.out.println(f.getName()+ "�� �����մϴ�."); 
			//FileReader �ν��Ͻ��� ����ÿ�.
			FileReader fr = new FileReader(f); 
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			//������ �����ִ� �ϵ��ũ�� �Ҿ����� �� ���� ��� --> IOException
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
			br.close();
			fr.close();
		}
		else {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
	}

}
