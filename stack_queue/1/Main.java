import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        System.out.println(solution(str));
    }
    //혼자 풀어본 코드 - 오답 
    //stack 사용 x, 단순히 닫는괄호, 여는괄호 짝의 개수만 check -> 순서를 놓침
    // public static String solution(String str){
    //     int left = 0;
    //     int right = 0;
    //     for(char x : str.toCharArray()){
    //         if(x == '(') left++;
    //         else right++; 
    //     }
    //     if(left == right) return "YES";
    //     return "NO";
    // } 

    //강의듣고 혼자 작성한 코드 - 정답
    public static String solution(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '('){
                stack.add(ch);
            }
            else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";
        return "YES";
    }
}
