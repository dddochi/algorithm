import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //강의
    public static String solution2(String str){
        String answer="";
        int m=Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){
            int len=x.length();
            if(len>m){
                m=len;
                answer = x;
            }
        
        }
        return answer;

    }
    //강의 
    //indexOf 사용
    public static String solution3(String str){
        String answer="";
        int m=Integer.MIN_VALUE, pos;
        while ((pos=str.indexOf(' '))!=-1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len>m) {
                m=len;
                answer=tmp;
            }
            str = str.substring(pos+1);
        }
        
        return answer;

    }
    //내가 직접해본 것
    public static String solution(String str){
        String maxLengthStr = "";

        String[] words = str.split("\\s+");
        for(int i=0; i < words.length; i++){
           if(maxLengthStr.length() < words[i].length() ){
            maxLengthStr = words[i];
          
           }
        }
      
        return maxLengthStr;
    }
    public static void main(String[] args) {
        //한개의 문장이 주어지면 그 문장 속 가장 긴 단어 출력하기
        //각 단어는 공백으로 구분됨

        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter a sentence:");
        String str = scanner.nextLine();
        Main T = new Main();

        System.out.println(T.solution(str));
    }

    
}
