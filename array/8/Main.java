import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] scores = new int[n];
    scanner.nextLine();
    for(int i = 0; i < n; i++){
        scores[i] = scanner.nextInt();
    }
    
    for(int x : solution(n, scores)){
        System.out.print(x + " ");
    }
 } 
 public static int[] solution(int n, int[] scores){
    int[] ranking = new int[n];
    int cnt;
    for(int i = 0; i <n; i++){
        cnt = 1;
        for(int j = 0; j < n; j++){
            if(scores[j] > scores[i]){
                cnt++;
            }
        }
        ranking[i] = cnt;
    }
    return ranking;
 }   
}
