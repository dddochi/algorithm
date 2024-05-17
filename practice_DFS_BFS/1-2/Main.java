//설명 듣고 풀어본 코드 - 정답!
//부분집합 -> 상태 트리 문제

import java.util.Scanner;

public class Main {
    static int n;
    static int[] items;
    static int[] ch;
    static int goal;
    static String answer = "NO";
    public static void DFS(int L, int sum){
        if(sum == goal){
            int otherSum = 0;
            for(int i = 0; i < n; i++ ){
              if(ch[i] == 0){
                  otherSum += items[i];
              }
            }
            if(sum == otherSum) answer = "YES";
            return;          
      }
        if(L == n) return;
        else{
            
            ch[L] = 1;
            DFS(L + 1, sum += items[L]);
            ch[L] = 0;
            sum -= items[L];
            DFS(L + 1, sum);
        }
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        items = new int[n]; //0 ~ n-1
        goal = 0;
        for(int i = 0; i < n; i++){
            items[i] = scanner.nextInt();
            goal += items[i];
        }
        goal = goal / 2;
        ch = new int[n];
        DFS(0, 0);
        System.out.println(answer);
    }
    
}
