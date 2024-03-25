import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int x : solution(n, arr)){
            System.out.print(x + " ");
        }
    }   
    //혼자 풀어본 코드 
    //selectin sort
    //1번 인덱스부터 0번부터 i-1번까지 탐색
    //i-1번부터 탐색하면서, 나보다 큰수가 있으면 자리 바꾸기 / 나보다 작은 수가 있으면 멈추기 
    //정답
    public static int[] solution(int n, int[] arr){
        for(int i = 1; i < n; i++){
            int idx = i;
            for(int j = i-1; j >= 0; j--){
                if(arr[idx] < arr[j]){
                    int tmp = arr[idx];
                    arr[idx] = arr[j];
                    arr[j] = tmp;
                    idx--;
                }
                else break;
            }
        }
        return arr;
    }
    //설명듣고 작성한 코드
    public static int[] solution2(int n, int[] arr){
        for(int i = 0; i < n; i++){
            int tmp = arr[i];
            int last = 0;
            System.out.println("tmp = " + tmp);
            for(int j = i - 1; j >= 0; j--){
                
                if(tmp < arr[j]){
                    arr[j+1] = arr[j];
                    last = j; //마지막에 tmp 넣기 위해
                }
                else break;
            }
            arr[last] = tmp;
        }
        return arr;
    }
}
