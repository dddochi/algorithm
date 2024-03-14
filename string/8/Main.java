import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //팰린드롬 -> 알파벳 외 특수문자, 숫자, 공백 등 무시
        Scanner scanner = new Scanner(System.in);
    
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    //내가 만든것
    public static String solution(String str){
        str = str.toUpperCase();
        String new_str = "";
       
        for(int i = 0; i <str.length(); i++){
            if(Character.isAlphabetic(str.charAt(i))) new_str += str.charAt(i);
        }

        
        for(int j = 0; j < new_str.length()/2; j++){
            if(new_str.charAt(j)!= new_str.charAt(new_str.length() - 1 - j))
                return "NO";
        }
        return "YES";
    }

    //강의 - replaceAll
     public static String solution2(String s){
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", ""); // A-Z가 아닌 것은 다 ""(빈문자)로 대체해라
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer = "YES";

        return answer;

    }
}
