import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] num = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                num[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        System.out.println(solution(n, num));
    }
    public static int solution(int n, int[][] num){
        // 각 열의 합, 각 행의합, 두 대각선의 합 중 가장 큰 값
        List<Integer> sumList = new ArrayList<>();
        int sum;

        //행의 합
        for(int i = 0; i < n; i++){
            sum = 0;
            for(int j = 0; j < n; j++){
                sum += num[i][j];
            }
            sumList.add(sum);
        }
        //열의 합
        for(int i = 0; i < n; i++){
            sum = 0;
            for(int j = 0; j < n; j++){
                sum += num[j][i];
            }
            sumList.add(sum);
        }
        //대각선의 합
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += num[i][i];
        }
        sumList.add(sum);
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += num[n-i-1][i];
        }
        sumList.add(sum);

        //최대값 구하기
        int max = sumList.get(0);
        for(int k = 0; k < sumList.size(); k++){
            if(max < sumList.get(k)) max = sumList.get(k);
        }
        return max;
    }

    public static int soultion2(int n, int[][] arr){
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i = 0; i < n; i++){
            sum1 = sum2 = 0;
            for(int j = 0; j <n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for(int i = 0; i <n; i ++){
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }


}
