//설명듣고 코드를 좀더 효율적으로 작성해봄
import java.util.*;
public class Main {
    static int n, f;
    static int[] ch;
    static boolean flag = false;
    static int[] arr;
    static int[] com;

    public static void DFS(int data, int L){
        if(flag == true) return;
        if(L == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (com[i] * arr[i]); //문제는 조합 ㅎ 
            }
            if(sum == f){
                for(int i = 0; i < n; i++){
                    System.out.print(arr[i]  + " ");
                }
                flag = true;
                return;
            }
        }
        for(int i = 0; i <n; i++){
            if(ch[i] == 1) continue; 
            ch[i] = 1;
            arr[L] = i + 1;
            DFS(i + 1, L + 1);
            ch[i] = 0;
            arr[L] = 0;
        }
    }
    public static int generateCom(int n, int r){
        int a = 1;
        for(int i = 0; i < r; i++){
            a *= (n - i);
        }
        int b = 1;
        for(int i = 1; i <= r; i++){
            b  *= i;
        }

        return a/b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        f = scanner.nextInt();
        arr = new int[n];
        com = new int[n];
        ch = new int[n+1];
        for(int i = 0; i < n; i++){
            com[i] = generateCom(n-1, i);
        }
        DFS(0, 0);        
    }
}

//저번 시간에 배운 '조합구하기' 사용

//설명듣고 코드를 좀더 효율적으로 작성해봄
import java.util.*;
public class Main {
    static int n, f;
    static int[] ch;
    static boolean flag = false;
    static int[] arr;
    static int[] com;

    public static void DFS(int data, int L){
        if(flag == true) return;
        if(L == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (com[i] * arr[i]);
            }
            if(sum == f){
                for(int i = 0; i < n; i++){
                    System.out.print(arr[i]  + " ");
                }
                flag = true;
                return;
            }
        }
        for(int i = 0; i <n; i++){
            if(ch[i] == 1) continue; 
            ch[i] = 1;
            arr[L] = i + 1;
            DFS(i + 1, L + 1);
            ch[i] = 0;
            arr[L] = 0;
        }
    }
    static int[][] result;
    public static int generateCom(int n, int r){
        if(result[n][r] > 0) return result[n][r];
        if(r == 0 || r == n) return 1;
        else{
            return result[n][r] = (generateCom(n-1, r-1) + generateCom(n-1, r));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        f = scanner.nextInt();
        arr = new int[n];
        com = new int[n];
        ch = new int[n+1];
        result = new int[n+1][n+1];
        generateCom(n-1, n-1);
        for(int i = 0; i < n; i++){
          com[i] = generateCom(n-1, i);
        }
        
        DFS(0, 0);        
    }
}



