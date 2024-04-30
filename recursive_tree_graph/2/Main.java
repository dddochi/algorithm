import java.util.*;

public class Main {
    //입력된 10진수 n -> 2진수로 바꿔서 출력
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solution(n);
    }   
    public static void solution(int n ){
        if(n == 1 || n == 0){
            System.out.print(n  + " ");
            return;
        }
        else{
            solution(n / 2);
            System.out.print(n % 2  + " ");
        }
        
    } 
    //설명듣고 코드 조금 수정
    // 1 나누기 2 : 목 - 0, 나머지 - 0
    public static void solution2(int n ){
        if( n == 0){
            return;
        }
        else{
            solution2(n / 2);
            System.out.print(n % 2  + " ");
        }
        
    } 
}
