import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(solution(str));
    }

    //내가 해본 것
    public static String solution(String str){
        Boolean isDifferent = false;
        str = str.toLowerCase();
        char[] s = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            if(s[lt] != s[rt]){
                 isDifferent = true;
                 break;
            }
            lt++;
            rt--;
        }
        if (isDifferent == false) {
            return "YES";
        }else{
            return "NO";
        }
    }
    //강의
    public static String solution2(String str){
        String answer="YES";
        str = str.toUpperCase();
        int len = str.length();
        for(int i = 0; i<len/2; i++){
            if(str.charAt(i)!= str.charAt(len-i-1)) return "NO";
        }
        return answer;
    }
    //string builder 사용 
    public static String solution3(String str){
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer = "YES";
        return answer;
    }
}
