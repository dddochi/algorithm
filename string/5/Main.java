import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(T.solution(str));
    }

    //내가 풀어본 방식
    public static String solution(String str){
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() -1;

        while (lt < rt) {
            if(((s[lt]>= 65 && s[lt] <=90) ||(s[lt]>=97 && s[lt] <=122)) && ((s[rt]>= 65 && s[rt] <=90) ||(s[rt]>=97 && s[rt] <=122)) ){ //영어문자
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }

            if (!((s[lt]>= 65 && s[lt] <=90) ||(s[lt]>=97 && s[lt] <=122))) { //lt가 특수문자
                lt++;    
            }
            if (!((s[rt]>= 65 && s[rt] <=90) ||(s[rt]>=97 && s[rt] <=122))) { //rt가 특수문자
                rt--;    
            }
       
        }
        return String.valueOf(s);
    }

    //강의
    public String solution2(String str){
        String answer = "";
        char[] s = str.toCharArray();
        int lt=0, rt=str.length() -1;
        while (lt<rt) {
            if (!Character.isAlphabetic(s[lt])) lt++;
            else if(!Character.isAlphabetic(s[rt])) rt--;
            else{
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            answer = String.valueOf(s);
        }
        return answer;
    }
   
    
}
