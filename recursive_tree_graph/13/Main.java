import java.util.*;
public class Main {
    static int n, m, answer;
    static int[] check;
    static HashMap<Integer, List<Integer>> map;
    //ArrayList
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new HashMap<>();    
        //List<List<Integer>> arr = new ArrayList<>();
        for(int i = 1; i < n+1; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < m ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map.get(a).add(b);
        }
        check = new int[n+1];
        DFS(1);
        System.out.println(answer);
    }  
    public static void DFS(int v){ //v - vertex
        if(v == n){
            answer++;
        }
        if(map.get(v).isEmpty()) return;
        else{
            for(int i = 0; i < map.get(v).size(); i++){
                int nv = map.get(v).get(i);
                if(check[nv] == 0){
                    check[nv] = 1;
                    DFS(nv);
                    check[nv] = 0;
                }
            }
        }
    }  
    
}
// 5 9 
// 1 2
// 1 3
// 1 4
// 2 1
// 2 3
// 2 5
// 3 4
// 4 2
// 4 5
