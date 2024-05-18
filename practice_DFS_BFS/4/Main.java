// 1 ~ N 
//중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력
// 경우의 수 N * N ... * N 

import java.util.*;

public class Main {
    static int n, m;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        // stack에 넣기
        DFS(0, 0);
    }
    //혼자 풀어본 코드
    //stack활용
    // n = 3, m = 2
    // 0
    // 1 2 3 -> 1 ~ n
    // 1 2 3 : m Level까지
    public static void DFS(int L, int data) {
        if (L > m)
            return;
        if (L == m) {
            for (int x : stack) {
                System.out.print(x + " "); 
            }
            System.out.println();
            stack.pop();
            return;
        }
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            DFS(L + 1, i);
        }
        if(!stack.isEmpty()) 
        stack.pop();
        
        
    }
}
