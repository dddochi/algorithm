import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int [] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = scanner.nextInt();
        }
        System.out.println(solution(n, num));  

    } 
    public static int solution(int n, int[] num){
        int count = 0;
        int[] score = new int[n];
        int totScore = 0;
        for(int i = 0; i < n; i++){
            if(num[i] == 0){
                score[i] = 0;
                count = 0;
            }
            else{
                count++;
                score[i] = count;
                totScore += score[i];
            }
        }
        return totScore;
    }
    //<각 점수를 저장하지 않고, 곧장 total score 구하는 코드>
    // public static int solution(int n, int[] num){
    //     int count = 0;
    //     int totScore = 0;
    //     for(int i = 0; i < n; i++){
    //         if(num[i] == 0){
             
    //             count = 0;
    //         }
    //         else{
    //             count++;
         
    //             totScore += count;
    //         }
    //     }
    //     return totScore;
    // }   
}
