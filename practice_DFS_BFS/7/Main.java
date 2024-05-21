//조합의 경우의 수

import java.util.Scanner;

public class Main {

    public static int DFS(int n, int r) {
        if (r == 1)
            return n;
        else if (r == n)
            return 1;
        else {
            return DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(DFS(n, r));
    }
}
