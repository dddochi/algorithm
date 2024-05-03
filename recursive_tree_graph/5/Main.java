import java.util.*;
class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
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
        DFS(root);
    }   
    //pre-order traversal 
    public static void DFS(Node node){
        if(node.data != 0){
            System.out.print(node.data + " ");
            node.data = 0;
        }
        if(node.lt != null){
         DFS(node.lt);
        }
        if(node.rt != null){
            DFS(node.rt);
        }
        else{
            return;
        }
    }
    
    //in-order traversal
    public static void DFS(Node node){
        if(node.lt != null){
            DFS(node.lt);
           }
        if(node.data != 0){
            System.out.print(node.data + " ");
            node.data = 0;
        }
        if(node.rt != null){
            DFS(node.rt);
        }
        else{
            return;
        }
    }

    //post-order traversal
    public static void DFS(Node node){
        if(node.lt != null){
            DFS(node.lt);
        }
        if(node.rt != null){
            DFS(node.rt);
        }
        if(node.data != 0){
            System.out.print(node.data + " ");
            node.data = 0;
        }
    }
    //강사님 코드
    public static void DFS(Node root){
        if(root == null){ //말단 노드라는 뜻
            return;
        }else{
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);
        }
    }
}
