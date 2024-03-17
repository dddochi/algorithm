import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }   
    //혼자 시도 : 문제 solution 눈으로는 로직 파악 but 코드 구현 실패
    //문제 설명 듣고 풀어본 코드
    //solution :
    //여는 괄호 - 무조건 push
    //닫는 괄호 - 1.레이저 - pop & stack size를 answer에 더해줌
    //닫는 괄호 - 2.쇠막대기 - pop & answer에 1을 더해줌
    public static int solution(String str){
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < str.length(); i++){
            //여는 괄호 '('일 때
            if(stack.isEmpty() || str.charAt(i) == '(') stack.push(str.charAt(i));
            //닫는 괄호 ')'일 떄
            else if(stack.peek() == '(' && stack.peek() == str.charAt(i-1) && str.charAt(i)==')'){ //레이저
                stack.pop();
                answer += stack.size();
            }
            else if(stack.peek() == '(' && stack.peek() != str.charAt(i-1) && str.charAt(i) == ')'){ //쇠막대기
                stack.pop();
                answer += 1;
            }
        }
        return answer;
    } 
    //강사님 코드
    public static int solution2(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') stack.push('(');
            else{
                stack.pop();
                if(str.charAt(i-1) == '(') answer += stack.size();
                else answer ++;
            }
        }
        return answer;
    }
}
