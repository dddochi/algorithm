import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        int [] heights = new int[num];
        for(int i = 0 ; i < num; i++){
            heights[i] = scanner.nextInt();
        }
        System.out.println(solution(num, heights));
    }

    public static int solution(int num, int[] heights){
        int max = heights[0];
        int count = 1;
        for(int i = 1; i < num; i++){
            if(heights[i] > max){
                max = heights[i];
                count++;
            }
        }
        return count;
    }
    
}
