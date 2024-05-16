import java.util.*;

class Node{
    int data;
    Node lt, rt;
    public Node(int data){
        this.data = data;
        this.lt = this.rt = null;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        solution2(s, e);
    }
    //혼자 풀어본 코드
    //TimeLimitExceeded  
    public static void solution(int s, int e){
        Queue<Node> Q = new LinkedList<>();
        Node root = new Node(s);
        int L = 0;
        Q.offer(root);
        while (!Q.isEmpty() ) { //수정
            int len = Q.size();
            for(int i = 0; i < len; i++){
                Node curNode = Q.poll();
                if(curNode.data == e){
                    System.out.println(L);
                    return;
                }
                Q.offer(new Node(curNode.data + 1));
                Q.offer(new Node(curNode.data - 1));
                Q.offer(new Node(curNode.data + 5));
            }    
            L++;
        }
    } 
    //다시 시도 
    //Node가 굳이 필요 없을 것 같아서 제거
    //또 TimeLimit,,,,,,,,
    public static void solution2(int s, int e){
        Queue<Integer> Q = new LinkedList<>();
        int root = s;
        int L = 0;
        Q.offer(root);
        while (!Q.isEmpty() ) { //수정
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int curLoc = Q.poll();
                if(curLoc == e){
                    System.out.println(L);
                    return;
                }
                Q.offer(curLoc + 1);
                Q.offer(curLoc - 1);
                Q.offer(curLoc + 5);
            }    
            L++;
        }
    }  
    //강사님 코드
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();
    public static int BFS(int s, int e){
        ch = new int[10001]; //좌표 범위 1 ~ 10000까지 
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                // if(x == e) return L;
                for(int j = 0; j <3; j++){
                    int nx = x + dis[j];
                    if(nx == e) return L + 1;
                    if(nx >=1 && nx <=10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
}
