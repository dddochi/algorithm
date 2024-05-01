//fibonacci
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            System.out.print(fibo(i) + " ");
        }
        
    }
    public static int fibo(int n){
        int answer;
        if( n == 0 || n == 1 ) {
           answer = 1;
        }
        else {
            answer =  fibo(n-1) + fibo(n-2); 
        }
        return answer;
    }
}
