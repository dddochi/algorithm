import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solution(n, k));;
    }  
    //혼자 풀어본 코드 - 정답
    public static int solution(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        //초기화 : 1~n
        for(int i = 0; i < n; i++){
            queue.add(i+1);
        }
        int item;
        while (queue.size() > 1) {
            //k번째 아이템 지우기
            for(int i = 0; i < k-1; i++){ 
                item = queue.poll();
                queue.add(item);
            }
            queue.poll();
           
        }
       
        return queue.poll();
    } 
    //강사님 코드
    public static int solution2(int n, int k){
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <= n; i++) Q.offer(i);
        while (!Q.isEmpty()) {
            for(int i = 1; i < k; i++){
                Q.offer(Q.poll());
            }
            Q.poll();
            if(Q.size() == 1) answer = Q.poll();
        }
        return answer;
    }
}
