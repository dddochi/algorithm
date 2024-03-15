import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }    
    public static int solution(String str){
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        //각 item을 stack에 넣어준다
        for(char x : str.toCharArray()){
            if(x >= '0' && x <= '9'){
                numStack.push(x - '0');
            }else{
                opStack.push(x);
            }    
        }
        while(!opStack.isEmpty()){
            char op = opStack.pop();
            int item1 = numStack.pop();
            int item2 = numStack.pop();
            int result = 0;
            switch (op) {
                case '+':
                    result = item1 + item2;
                    numStack.push(result);
                    break;
                case '-':
                    result = item1 - item2;
                    numStack.push(result);
                    break;
                case '*':
                    result = item1 * item2;
                    numStack.push(result);
                    break;
                case '/':
                    result = item1 / item2;
                    numStack.push(result);
                    break;
            }
        }
        return numStack.pop();
    }
}
