package mc.sn.day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GisaTest {
   private ArrayList<StudentDTO> list;
   public GisaTest() {
      list = new ArrayList<StudentDTO>();
   }

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      GisaTest gt = new GisaTest();
     gt.makeGisaData();
     gt.quiz2();
     gt.quiz3();
     int answer = gt.quiz4();
     gt.printAnswer(4, answer);
       
   }
   
   public int quiz4() {
      //국어점수 + 점수포인트 합이 50 이상인 자료 건수를 출력하시오.
      //지역코드 A-5/B-10/C-15
      int val = 50;
      int i=0;
      for(StudentDTO temp : list) {
         if(temp.getAccPoint().equals("A")||temp.getAccPoint().equals("B")) {
            int score = 0;
            if(temp.getLocalCode().equals("A")) {
               score = 5;
            }else if(temp.getLocalCode().equals("B")) {
               score = 10;
            }else if(temp.getLocalCode().equals("C")) {
               score = 15;
            }
            if((score+temp.getKor()) >= 50) {
               i++;
            }
         }
      }
      System.out.println(i);
      return i;
   }
   
   public void quiz3() {
      //영어+수학 점수가 120점 이상인 학생의 총점과 
      //담임코드에 따른 점수데이터의 총합을 더하세요.(담임코드 A-5/B-15/C-20)
      int val = 120;
      int sum = 0;
      
      for(StudentDTO temp : list) {
         int em = (temp.getEng()+temp.getMath());
         if(em>=120) {
            int score = 0;
            if(temp.getMagrCode().equals("A")) {
               score = 5+temp.getTotal();
            }else if(temp.getMagrCode().equals("B")) {
               score = 15+temp.getTotal();
            }else if(temp.getMagrCode().equals("C")) {
               score = 20+temp.getTotal();
            }
            sum = sum + score;
            
         }
//         else if(val == (temp.getEng()+temp.getMath())) {
//            System.out.println(temp.getStdNo());
//         }//120에 딱 걸치는 학생이 있는지 확인 해봄.
      }
      System.out.println(sum);
   }
   
   public void quiz2() {
      System.out.println(list.size());
      //지역변수가 B이고 국어+영어점수가 최고인 점수를 출력하시오.
//      int max = 0;
//      for(StudentDTO temp : list) {
//         if(temp.getLocalCode().equals("B")) {
//            if(max < (temp.getKor()+temp.getEng())) {
//               max = (temp.getKor()+temp.getEng());
//            }
//         }
//      }//내가 짠 코드
      StudentDTO tempDTO = list.get(0);
      int max = tempDTO.getKor()+tempDTO.getEng();
      for(StudentDTO dto : list) {
         if(dto.getLocalCode().equals("B")) {
            int score = dto.getEng()+dto.getKor();
            if(max<score) {
               max = score;
            }
         }
      }//강사님이 짠 코드
      
      System.out.println("answer is"+max);
      
   }
   
   public void printAnswer(int number,int answer) throws IOException{
	   String fileName = "Ans"+number+".txt";
	   File file = new File(fileName);
	   FileWriter fw = new FileWriter(file);
	   PrintWriter pw = new PrintWriter(fw);
	   pw.println(answer);
	   pw.close();
	   fw.close();
   }
   
   
   public void makeGisaData() throws NumberFormatException, IOException {
      //파일에 접속해서 해당 라인 읽어와서 아래와 같이 분리해서 리스트 저장
      //제너릭
      File file = new File("data\\Abc1115.csv");
      
      if(file.exists()) {
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr); 
         String line = null;
         while((line = br.readLine()) != null) {
            String temp = line;//"990001,addx, 17,29,16,49,43,154,C,A,C";
            String[] data = temp.split(",");
            StudentDTO dto = new StudentDTO();
            int i = Integer.parseInt(data[0]);
            dto.setStdNo(i);
            dto.setEmail(data[1]);
            i = Integer.parseInt(data[2].trim());//띄어쓰기를 자동으로 처리.
            dto.setKor(i);
            dto.setEng(Integer.parseInt(data[3].trim()));
            dto.setMath(Integer.parseInt(data[4].trim()));
            dto.setSci(Integer.parseInt(data[5].trim()));
            dto.setHist(Integer.parseInt(data[6].trim()));
            dto.setTotal(Integer.parseInt(data[7].trim()));
            dto.setMagrCode(data[8]);
            dto.setAccPoint(data[9]);
            dto.setLocalCode(data[10]);
            //System.out.println(dto);
            list.add(dto);
            System.out.println(line);
         }
         br.close();
         fr.close();
      }
   }

}