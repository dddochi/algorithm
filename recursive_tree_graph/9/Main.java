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
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        DFS(root, 0);
        System.out.println(answer);
    } 
    static int answer = 10000;   
    public static void DFS(Node node, int L){

        if(node == null){
            if(answer > L -1 ) {
                answer = L -1;
            }
        }
        else{
            DFS(node.lt, L+1);
            DFS(node.rt, L+1);
        }
        
    }
    //강사님 코드
    public static  int DFS_(int L, Node root){
        if(node.lt == null && node.rt == null){ //말단 노드인지 check
            return L;
        }
        else{
            return Math.min(DFS_(L+1, root.lt), DFS_(L+1, root.rt));
        }
    }
}
