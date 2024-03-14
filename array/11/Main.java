import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int [][] arr = new int[n+1][6];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < 6; j++){
                arr[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        System.out.println(solution(n, arr));
    }
    //강사님 코드
    public static int solution(int n, int[][] arr){
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 0; j <= n; j++){
                for(int k = 1; k <=5; k++){
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(max < cnt){
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }
    //설명 들은 후 만들어본 코드 - Runtime error   
    // public static int solution(int n, int[][] arr){
    //     int prev_count = 0;
    //     int count;
    //     int tot_student = 0;
    //     for(int i = 1; i < n+1; i++){
    //         count = 0;
    //         for(int j = 1; j < n+1; j++){
    //             for(int k = 1; k < 6; k++){
    //                 if(arr[i][k] == arr[j][k]){
    //                     count++;
    //                     break;
    //                 }
    //             }
    //         }
            
    //        // = Math.max(count, prev_count);
    //         if(count > prev_count){
    //             tot_student = i;
    //         }
    //         prev_count = count;
    //     }
    //     return tot_student;
    // }
    
    //설명 듣기 전에 만든 코드 - 엉망
    // public static int solution(int n, int[][] arr){
    //     int[] cnt = new int[n];
    //     for(int k = 0; k<5; k++){
    //         for(int i = 0; i < n; i++){
    //             for(int j = i+1; j < n; j++){
    //                 if(arr[k][i] == arr[k][j]){
    //                     cnt[i]++;
    //                     cnt[j]++;
    //                 }
    //             }
    //         }
    //     }
    //     int max = 0;
    //     for(int i = 0; i < n; i++){
    //         if(cnt[i] > max){
    //             max = cnt[i];
    //         }
    //     }
    //     return max;
        
    // } 
}
