import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        //대문자로 이루어진 문자열을 받음
        //같은 문자 반복되면 -> 바로 오른쪽에 반복 횟수를 적어놓음
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter:");
        String str = scanner.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str){
        String answer = "";
        int count = 1;
        for(int i = 0; i < str.length()-1; i++){

            if(str.charAt(i) == str.charAt(i+1)){
                count++;
            }else{
                answer += str.charAt(i);
                answer += Integer.toString(count);
                count = 1;
            }
        }
        return answer;
    }
}