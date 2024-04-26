import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solution(n);
    }
    public static void solution(int n){
        List<Integer> answer = new ArrayList<>();
        if (n > 1) {
            solution(n-1);
        }
        System.out.println(n + " ");
    }
}
