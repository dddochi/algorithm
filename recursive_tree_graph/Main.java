import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solution(n);
    }
    //혼자 풀어본 코드
    public static void solution(int n){
        List<Integer> answer = new ArrayList<>();
        if (n > 1) {
            solution(n-1);
        }
        System.out.println(n + " ");
    }
    //강사님 코드
    public static void DFS(int n ){
        if(n==0) return ; //return; - 함수 종료의 의미
        else{
            DFS(n-1);
            System.out.println(n + " ");
        }
    }
}
