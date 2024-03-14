import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str).toString());
    }
    //내가 푼 방식
    public static Integer solution(String str){
        String new_str = str.replaceAll("[^0-9]", "");
        Integer num = Integer.parseInt(new_str);
        return num;
    }
    //강의 
    //ascii : 숫자 0 ~ 9 -> 48 ~ 57
    public int solution2(String s){
        int answer = 0;
        for(char x : s.toCharArray()){
            if(x>=48 && x<=57) answer = answer*10 + (x - 48);
        }
        return answer;
    }
    //isDigit 사용
    public int solution3(String s){
        String answer = "";
        for(char x : s.toCharArray()){
            if(Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

}
