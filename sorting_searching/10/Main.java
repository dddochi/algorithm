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
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n-1];
        int answer = 0;
        int mid = 0;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            if(count(arr, mid) >= c){
                //범위에 들어오는 값
                lt = mid + 1; 
                answer = mid;
            }
            else{
                //범위에 들어오지 x -> 배치하는 말의 개수가 c보다 작음
                rt = mid - 1;
            }
        }
        return answer;
    }
    public static int count(int[] arr, int mid){
        int count = 1; //말의 개수
        int ep = arr[0]; //말을 놓는 위치 -> 계속 갱신
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - ep >= mid){
                count++;
                ep = arr[i];
            }
        }
        return count;
    }
    
}
