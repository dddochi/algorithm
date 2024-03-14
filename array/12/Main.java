import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //학생 수 
        int m = scanner.nextInt(); //시험 수
        scanner.nextLine();
        int [][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        
        System.out.println(solution(n, m, arr));
    }   
    public static int solution(int n, int m, int[][] arr){
        // int[][] mentoList = new int [n][n-1];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         for(int k = j+1; k < n; j++ ){
        //             mentoList[j][k] = arr[j][k];
        //         }
        //     }
        // }
        //int[][] memtiList = new int [n][n-1];
        int pi = 0;
        int pj = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int cnt = 0;
                for(int k = 0; k < m; k++){ //Test 수
                    for(int s = 0; s < n; s++){//등수
                        if (arr[k][s] == i) {
                            pi = i;
                        }
                        if(arr[k][s] == j){
                            pj = j;
                        }
                        if(pi > pj){
                            cnt++;
                        }
                    }
                    if(cnt == m){answer++;}
                }
            }
        }
        return answer;
        
    } 
}
