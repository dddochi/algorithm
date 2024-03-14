import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }   
    public static String solution(String str){
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for(char ch : str.toCharArray()){
            if(ch == ')'){
                while(stack.lastElement() != '('){
                    stack.pop();
                }
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        for(char ch : stack){
            answer += ch;
        }
        return answer;
    } 
    //강사님 코드
    public static String solution2(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(x == ')'){
                while (stack.pop()!= '('); //stack.pop() -> 꺼내는 동시에 꺼낸값을 return 받음
            }
            else stack.push(x);
        }
        for(int i = 0; i < stack.size(); i++) answer += stack.get(i);
        return answer;
    }
}
