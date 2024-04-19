//강사님 코드
import java.util.*;

public class Main2 {
     
    public static int count(int [] arr, int capacity){
        int cnt = 1; //DVD 장수
        int sum = 0; //노래가 차지하는 용량
        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum = x; 
            }
            else sum += x;
            
        }
        return cnt;
    }
    public static int solution(int n, int m, int[] arr){
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= m){
                answer = mid;
                rt = mid - 1;
            }
            else lt = mid + 1;
        }
        return answer;
    }

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
      
   
}
