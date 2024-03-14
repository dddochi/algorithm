import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] num = new int[n+2][n+2];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                num[i+1][j+1] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        System.out.println(solution(n, num));
    }
    public static int solution(int n, int[][] num){
        //상 - [0][1]
        //자신 -[1][1] -> [1][2] -> ..
        //하 - [2][1]   
        //우 - [1][2]
        //좌 - [1][0] 
        int count = 0; 
        int main, up, down, left, right;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                up = num[i][j+1]; //상
                main = num[i+1][j+1]; //자신
                down = num[i+2][j+1]; //하
                left = num[i+1][j]; //좌
                right = num[i+1][j+2]; //우
                if(main > up && main > down && main > left && main > right) count++;
            }
        }
        return count;
    }    
}
