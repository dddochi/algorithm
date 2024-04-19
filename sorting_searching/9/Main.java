import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
    //설명 듣고 풀어본 코드
    //출력 잘되는데, 오답..
    public static int solution(int n, int m, int[] arr){
        Arrays.sort(arr);
        int answer = 0;
        int lt = arr[n-1]; //최솟값 - 아이템 중 가장 큰 값
        int rt = 0; //최댓값 - 모든 아이템의 합
        for(int i = 0; i < n; i++){
            rt += arr[i];
        }
        int mid = 0;
        while (lt < rt) {
          mid = (lt + rt)/2;  
          if(isOk(mid, m, arr)){
            answer = mid;
            rt = mid -1;
          }
          else{
            lt = mid + 1;
          }
        }
        return answer;
    }  
   
    public static boolean isOk(int mid, int m, int[] arr){
        int count = 1;
        int tot = mid;
        for(int i = 0; i < arr.length; i++){
            if(tot - arr[i] < 0 ){
                count++;
                tot = mid;
            }
            tot -= arr[i];
        }
     
        if(count <= m) return true;
        return false;
    }
}
