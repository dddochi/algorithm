
//팩토리얼 구하기 ex) n = 5 -> 5 * 4 * 3 * 2 * 1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }   
    public static int solution(int n ){
        if(n == 1) return 1;
        return n * solution(n-1);
    } 
}
