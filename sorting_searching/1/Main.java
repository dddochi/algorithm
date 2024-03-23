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
    //혼자 풀어본 코드 - 정답
    //bubble sort
    public static int[] solution(int n, int[] arr){
        for(int i = 0; i < n - 1; i++){
            boolean isChanged = false;
            for(int j = 0; j < n -i-1; j++){
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    isChanged = true;
                }
            }
            if(!isChanged) break;
        }
        return arr;
    }
    //문제 설명 듣고 풀어본 코드
    //선택 정렬 - selection sort
    //강사님 코드와 동일
    public static int[] solution2(int n, int[] arr){
        for(int i = 0; i < n - 1; i++){
            int idx = i;
            for(int j = i + 1; j < n; j++){
                if(arr[idx] > arr[j] ){
                    idx = j;
                }
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}
