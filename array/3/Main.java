import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i ++){
            a[i] = scanner.nextInt(); 
        }
        for(int i = 0 ; i < n; i++){
            b[i] = scanner.nextInt();
        }
        solution(n, a, b);
    }
    public static void solution(int n, int[] a, int[] b){
        //1 - 가위, 2 - 바위, 3 - 보
        for(int i = 0; i < n; i++){
            // a < b -> B (1<2, 2<3)
            //b = 1, a = 3 -> B
            if(a[i]+1 == b[i]) System.err.println("B");
            else if(a[i] == 3 && b[i] == 1) System.out.println("B");
            else if(a[i] == b[i]) System.out.println("D");
            else System.out.println("A");
        }
    }
    public static String solution2(int n, int[] a, int[] b){
        String answer = "";
        for(int i = 0; i < n; i++){
            if(a[i] == b[i]) answer += "D";
            else if(a[i] == 1 && b[i] == 3) answer += "A";
            else if(a[i] == 2 && b[i] == 1) answer += "A";
            else if(a[i] == 3 && b[i] == 2) answer += "A";
            else answer += "B";
        }
        return answer;
    }    
}
