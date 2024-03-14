import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int n = scanner.nextInt(); 
  
        int [][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <n; j++){
                board[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        
        int m = scanner.nextInt();
        int[] moves = new int[m];
        for(int k = 0; k < m; k++){
            moves[k] = scanner.nextInt();
        }

        System.out.println(solution(n, board, m, moves));
    }   
    public static int solution(int n, int[][] board, int m, int[] moves){
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        //i -> moves에서 가져오면 됨 -> j는 0이 없는 첫번쨰 요소 get
        for(int i = 0; i < m; i++){
            int item = 0;
            //인형 집기
            for(int j = 0; j < n; j++){
                if(board[moves[i]-1][j]!= 0){
                    item = board[moves[i]-1][j]; //인형 아이템 get
                    board[moves[i]-1][j] = 0; //인형 뽑인 곳은 0으로 처리
                }
            }
            //바구니에 인형 넣기
            
            if(!stack.isEmpty() &&stack.lastElement() == item){ //같은 인형 2번 연속 -> 제거
                stack.pop();
                count = count + 2;

            }
            else{
                stack.push(item);
            }
        }
        return count;
    } 
    
}
