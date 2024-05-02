//fibonacci
import java.util.*;
public class Main {
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int n = scanner.nextInt();
    //     for(int i = 0; i < n; i++){
    //         System.out.print(fibo(i) + " ");
    //     }
        
    // }
    // public static int fibo(int n){
    //     int answer;
    //     if( n == 0 || n == 1 ) {
    //        answer = 1;
    //     }
    //     else {
    //         answer =  fibo(n-1) + fibo(n-2); 
    //     }
    //     return answer;
    // }

    //Advanced code
    static int[] fibo;
    public static int DFS(int n ){
        if(n==1) return fibo[n] = 1;
        if(n==2) return fibo[n] = 2;
        else return fibo[n] = DFS(n-1) + DFS(n-2);
    }
    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n+1];
        DFS(n);
        for(int i = 0; i < n; i++) System.out.print(fibo[i] + " ");
    }

     //Advanced code
     static int[] fibo;
     public static int DFS(int n ){
         if(fibo[n] > 0) //이미 값을 구했음
            return fibo[n];
         if(n==1) return fibo[n] = 1;
         if(n==2) return fibo[n] = 2;
         else return fibo[n] = DFS(n-1) + DFS(n-2);
     }
     public static void main(String[] args) {
         int n = 45;
         fibo = new int[n+1];
         DFS(n);
         for(int i = 0; i < n; i++) System.out.print(fibo[i] + " ");
     }



}
