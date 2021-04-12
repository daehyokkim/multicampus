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
			System.out.println(f.getName()+ "이 존재합니다."); 
			//FileReader 인스턴스를 만드시오.
			FileReader fr = new FileReader(f); 
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			//파일이 쓰여있는 하드디스크가 불안정할 시 에러 출력 --> IOException
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
			br.close();
			fr.close();
		}
		else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

}
