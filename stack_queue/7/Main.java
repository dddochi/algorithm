//plan curriculum
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String eClass = scanner.nextLine();
        String totClass = scanner.nextLine();
        System.out.println(solution(eClass, totClass));
    }
    public static String solution(String eClass, String totClass){
        String result = "";
        Queue<Character> totQ = new LinkedList<>();
        Queue<Character> eQ = new LinkedList<>();
    
        for(int i = 0; i < totClass.length(); i++){
            totQ.offer(totClass.charAt(i));
        }
        for(int j = 0; j < eClass.length(); j++){
            eQ.offer(eClass.charAt(j));
        }

        while (!totQ.isEmpty()) {
            if(totQ.poll() == eQ.peek()) eQ.poll();
            if(eQ.isEmpty()) return "YES";
        }
        return "NO";
    }
    //설명 듣고 작성한 코드
    //contains() 사용
    public static String solution2(String eClass, String totClass){
        String result = "";
        Queue<Character> eQ = new LinkedList<>();
    
        for(int i = 0; i < eClass.length(); i++){
            eQ.offer(eClass.charAt(i));
        }
        for(Character x : totClass.toCharArray()){
            if(eQ.contains(x)){
                if(eQ.peek() != x) return "NO";
                else eQ.poll(); 
            }
        }
        if(eQ.isEmpty()) return "YES";
        return "NO";
    }

    //강사님 코드
    public static String solution3(String need, String plan){
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x : need.toCharArray()) Q.offer(x);
        for(char x : plan.toCharArray()){
            if(Q.contains(x)){ //x가 필수 과목!
                if(x != Q.poll()) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO";
        return answer;
    }
}
