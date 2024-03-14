import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(solution(str));
    }
    //내가 직접 해본 것
    public static String solution(String str){
        char[] s = str.toCharArray();
        String answer = "";
        for(int i = 0; i <s.length; i++){
            Boolean isDuplicated = false;
            for(int j = 0; j<i; j++){
                if(s[i] == s[j]){
                    isDuplicated = true;
                     break;
                }
                
               
            }
            if (isDuplicated == false) {
                answer += s[i];
            }
            
        }
        return answer;
    }
    //강의 - indexOf 활용
    //indexOf - 해당 charactor의 가장 첫 Index를 return해준다
    public static String solution2(String str){
        String answer = "";
        for(int i = 0; i < str.length(); i++){
            //System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }
}
