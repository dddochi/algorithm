import java.util.Scanner;

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
    //버블 정렬
    //강사님 코드와 동일
    public static int[] solution(int n, int[] arr){
        for(int i = 0; i < n - 1; i++){
            boolean isChanged = false;
            for(int j = 0; j < n - i -1; j++){
                if(arr[j] > arr[j+1]){
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
}

