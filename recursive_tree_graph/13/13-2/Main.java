//강사님 코드
//+ main에다가 'ch[1] = 1;'' 추가 (DFS(1)호출전)
//ArrayList<ArrayList<Integer>> graph

import java.util.ArrayList;

public class Main {
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void DFS(){
        if(v == n) answer++;
        else{
            for (int nv : graph.get(v)) {
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();    
        //List<List<Integer>> arr = new ArrayList<>();
        for(int i = 1; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for(int i = 0; i < m ; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map.get(a).add(b);
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }  
   
}
