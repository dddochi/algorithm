import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    } 
    //혼자 풀어본 코드 - 오답
    //후위식 연산에 대한 불완전한 이해
    // public static int solution(String str){
    //     Stack<Integer> numStack = new Stack<>();
    //     Stack<Character> opStack = new Stack<>();

    //     //각 item을 stack에 넣어준다
    //     for(char x : str.toCharArray()){
    //         if(x >= '0' && x <= '9'){
    //             numStack.push(x - '0');
    //         }else{
    //             opStack.push(x);
    //         }    
    //     }
    //     while(!opStack.isEmpty()){

    //         char op = opStack.pop();
    //         int item1 = numStack.pop();
    //         int item2 = numStack.pop();
    //         int result = 0;
    //         switch (op) {
    //             case '+':
    //                 result = item1 + item2;
    //                 numStack.push(result);
    //                 break;
    //             case '-':
    //                 result = item1 - item2;
    //                 numStack.push(result);
    //                 break;
    //             case '*':
    //                 result = item1 * item2;
    //                 numStack.push(result);
    //                 break;
    //             case '/':
    //                 result = item1 / item2;
    //                 numStack.push(result);
    //                 break;
    //         }
    //     }
    //     return numStack.pop();
    // }
    public static int solution(String str){
        Stack<Integer> stack = new Stack<>();
        int result;
        for(char x : str.toCharArray()){
            
            if(x >= '0' && x <= '9'){
                stack.push(Character.getNumericValue(x));
                
            }
            else{
                int rt = stack.pop();
                int lt = stack.pop();
                
                switch (x) {
                    case '+':
                        result = lt + rt;
                        stack.push(result);
                        break;
                    case '-':
                        result = lt - rt;
                        stack.push(result);
                        break;
                    case '*':
                        result = lt * rt;
                        stack.push(result);
                        break;
                    case '/':
                        result = lt / rt;
                        stack.push(result);
                        break;
                }
            }
        }
        return stack.get(0);
    }
    public static int solution2(String str){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()){
            if(Character.isDigit(x)) stack.push(x - 48);
            else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') stack.push(lt + rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);
        return answer;
    }
}
