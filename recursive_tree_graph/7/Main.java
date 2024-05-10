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
    public static void DFS(Node node){
        if(node.lt == null){ return;}
        else{
            if(node.data == 1) System.out.print(node.data + " ");
            System.out.print(node.lt.data + " ");
            System.out.print(node.rt.data + " ");
            DFS(node.lt);
            DFS(node.rt);
        }
    }
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
}
