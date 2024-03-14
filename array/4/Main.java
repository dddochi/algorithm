import java.util.Scanner;

public class Main {
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int num = scanner.nextInt();
    //     for(int i = 0; i < num; i++){
    //         System.out.print(fibo(i) + " ");
    //     }
    // }

    // public static int fibo(int num){
    //         if(num == 0 || num == 1){
    //             return 1;
    //         }
    //         return fibo(num-1) + fibo(num -2);   
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] fibo = generateFibo(num);
        System.out.println(fibo);
    }

    public static int[] generateFibo(int num){
        int[] fibo = new int[num];
        for(int i = 0; i < num; i++){
            if(i == 0 || i == 1){
                fibo[i] = 1;
            }
            else{
                fibo[i] = fibo[i-1] + fibo[i-2];
            }
        }
        return fibo;
      }

    //강사님 코드
    public static int[] solution2(int n){
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < n; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }
        return answer;
    }
}
