import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < 2; j++){
                points[i][j] = scanner.nextInt();
            }
        }
        for(int[] arr : solution(n, points)){
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
        }

    }  
    //혼자 풀어본 코드
    //출력은 제대로 나오나 , 오답 뜸 
    public static int[][] solution(int n, int[][] points){
       //2차원 array -> 정렬
       //(2, 1) -> 
       for(int i = 0; i < n -1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(points[j][0] > points[j + 1][0]){
                    int [][] tmp = new int[1][2];
                    tmp[0][0] = points[j][0];
                    tmp[0][1] = points[j][1];
                    points[j][0] = points[j+1][0];
                    points[j][1] = points[j+1][1];
                    points[j+1][0] = tmp[0][0];
                    points[j+1][1] = tmp[0][1];
                }
                if(points[j][0] == points[j+1][0]){
                    if(points[j][1] > points[j+1][1]){
                        int [][] tmp = new int[1][2];
                        tmp[0][0] = points[j][0];
                        tmp[0][1] = points[j][1];
                        points[j][0] = points[j+1][0];
                        points[j][1] = points[j+1][1];
                        points[j+1][0] = tmp[0][0];
                        points[j+1][1] = tmp[0][1];
                    }
                }
            }
       }
       return points;
    } 
    
}
