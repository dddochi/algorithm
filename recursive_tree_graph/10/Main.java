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
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
       System.out.println( BFS(root));
    }    
    static Queue<Node> Q = new LinkedList<>();
    public static int BFS(Node root){
        Q.offer(root);
        int L = 0;
        
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++){
                Node cur = Q.poll();
                if(cur.lt== null && cur.rt== null){
                    return L;
                }
                else{
                    if(cur.lt != null)
                    Q.offer(cur.lt);
                    if(cur.rt != null)
                    Q.offer(cur.rt);
                }
               
            }
            L++;
        }
       return 0;
    }
}
