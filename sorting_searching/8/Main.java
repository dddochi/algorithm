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
    //혼자 풀어본 코드 - 정답
    //이진 검색 스스로 구현해봄
    public static int solution(int n, int m, int[] arr){
        int answer = -1;
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length -1; //마지막 인덱스
        int mid;
        while (true) {
            mid = (low + high) /2;
            if(m > arr[mid]){
                low = mid + 1;
            }
            else if(m < arr[mid]){
                high = mid -1;
            }
            else{ // m == arr[mid]
                answer = mid + 1; 
                break;
            }
        }
        return answer;
    }
    //강사님 코드
    public static int solution2(int n, int m, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        int lt = 0, rt = n-1;
        while (lt <= rt) {
            int mid = (lt + rt)/2;
            if(arr[mid] == m){
                answer = mid + 1;
                break;
            }
            else if(arr[mid] > m) rt = mid - 1;
            else lt = mid + 1;
        }
    }   
}
