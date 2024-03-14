import java.util.Scanner;

public class ChangeCase {
    public static String solution(String str){
        
        String answer = "";
        for(char x : str.toCharArray()){
            //ascii 사용
            if (x >= 65 && x <= 90) { //대문자
                answer += (char)(x + 32); //형변환 해주기
               
            }
            else if(x >= 97 && x <= 122){ //소문자
                answer += (char)(x - 32);
            }
            // if (Character.isLowerCase(x)) {
            //     answer += Character.toUpperCase(x);
            // }else{
            //     answer += Character.toLowerCase(x);
            // }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a string : ");
        String str = scanner.nextLine();   
        

        String newStr = solution(str);
        System.out.println(newStr);
    }

    //ascii 문자 활용
    //대문자 : 65 ~ 90
    //소문자 : 97 ~ 122
    //대문자 = 소문자 - 32 //차이 32
    
}
