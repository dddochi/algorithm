import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.nextLine();
    int[] numbers = new int[n];
    for(int i = 0; i < n; i++){
        numbers[i] = scanner.nextInt();
    }
    
    for(int x : solution(n, numbers)){
        System.out.print(x + " ");
    }
  }

  public static List<Integer> solution(int n, int[] numbers){
    List<Integer> answer = new ArrayList<>();
    int res;
    int tmp = 0;
    int t;
    for (int i = 0; i < n; i++) {
        res = 0;
        tmp = numbers[i];
        while (tmp > 0) {
            t = tmp % 10;
            res = 10 * res + t;
            tmp = tmp / 10;
        }
        
        if(isPrime(res)) answer.add(res);
    }
    return answer;
  }

  public static Boolean isPrime(int num){
    if(num == 1) return false;
    for(int i = 2; i < num; i++){
        if(num % i == 0) return false;     
    }
    return true;
  }
  
}
