import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, c, arr));
    }
    public static int solution(int n, int c, int[] arr){
        int lt = 1;
        int rt = arr[n-1];
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int ep = arr[0];
            if(count(arr, mid) == c){ //ok 
                lt = mid + 1;
                answer = mid;
            }
            else if(count(arr, mid) > c){ 
                lt = mid + 1;
            }
            else{//거리가 줄어야함
                rt = mid -1;
            }
            
        }  
        return answer;  
    }
    public static int count(int[] arr, int mid){
        int count = 1;
        int ep = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - ep >= mid){
                ep = arr[i];
                count++;
            }
        }
        return count;
    }
}
