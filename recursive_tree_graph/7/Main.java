//BFS (넓이 우선 탐색) - 레벨 탐색

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node lt, rt;
    public Node(int data){
        this.data = data;
        this.lt = null;
        this.rt = null;
    }
}
public class Main {
   
    public static void main(String[] args) {
        Node root;
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);   
        BFS(root); 
    }  
    
    //혼자 작성한 코드
    public static void BFS(Node node){
        if(node.lt == null){ return;}
        else{
            if(node.data == 1) System.out.print(node.data + " ");
            System.out.print(node.lt.data + " ");
            System.out.print(node.rt.data + " ");
            BFS(node.lt);
            BFS(node.rt);
        }
    }
    //강사님 코드
    public static void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0; //level
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for(int i = 0; i < len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
            System.out.println();
        }

    }
    //강사님 코드 참고해서 연습
    public static void BFS_(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print("L " + L + " : ");
            for (int i = 0; i < len; i++) {
                Node item = Q.poll();
                System.out.print(item.data + " ");
                if(item.lt != null)
                Q.offer(item.lt);
                if(item.rt != null)
                Q.offer(item.rt);

            }
            System.out.println();
            L++;
        }
    }
}
