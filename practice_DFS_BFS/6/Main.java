import java.util.Scanner;

//10 이하의 n개의 자연수가 주어지면 이중 m개를 뽑아 일렬로 나열하는 법 모두 출력
//순열 1째 자리에서 뽑힌 숫자는 2째 자리에서 뽑힐 수 없다.
public class Main{
    static int[] p;
    static int[] ch;
    static int n, m;
    public static void DFS(int L, int[] arr){
        if(L == m){
            for(int i = 0; i < m; i++){
                System.out.print( p[i] + " ");
            }
            System.out.println();
            return;
        }
        else{
            for(int i = 0; i < n; i++){
                if(ch[i] == 1) continue;
                p[L] = arr[i];
                ch[i] = 1;
                DFS(L+1, arr);
                ch[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int [] arr = new int[n];
        ch = new int[n];
        for(int i = 0; i <n; i++){
            arr[i] = scanner.nextInt();
        }

        p = new int[m];

        DFS(0, arr);
    }

    //강사님 코드
    //내 코드와 거의 똑같음
    public static void DFS_(int L, int[] arr){
        if(L == m){
            for(int x : p) System.out.print( x + " ");
            System.out.println();
            return;
        }
        else{
            for(int i = 0; i < n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    p[L] = arr[i];
                    DFS_(L+1, arr);
                    ch[i] = 0;
                }
            }
        }
    }
    

}