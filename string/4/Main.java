import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //강의 - StringBuilder 활용
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = scanner.next();
        }
        for(String x : T.solution(n, str)){
            System.out.println(x);
        }

    }
    //StringBuilder 활용
    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }
    //특정 문자만 뒤집는 법
    //직접 뒤집기
    public ArrayList<String> solution2(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length()-1;
            while (lt<rt) { //lt와 rt 같아지면 멈추기 ex) study
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
                
            }
            String tmp = String.valueOf(s); //valueOf : s를 string화해줌
            answer.add(tmp);
        }
        return answer;
    }

    //내가 직접해본 방식
    // public static void main(String[] args) {
    //     //N개의 단어가 주어지면 -> 각 단어를 거꾸로 출력
    //     // 3<=N<=20
    //     Scanner scanner = new Scanner(System.in);
    //     int n = scanner.nextInt();

    //     scanner.nextLine(); // Consume the newline character

    //     String [] words = new String[n];
    //     for(int i = 0; i <n; i++){
    //         words[i] = scanner.nextLine();
    //     }
    //     Main T = new Main();

    //     for(int i=0; i<n; i++){
    //         System.out.println(T.solution(words[i]));;
    //     }
    // }
    // public static String solution(String word){
    //     String answer = "";
    //     char[] word_arr = word.toCharArray();
    //     for(int i = word.length()-1; i >= 0; i--){
    //         answer += word_arr[i];
    //     }
    //     return answer;
    // }
}
