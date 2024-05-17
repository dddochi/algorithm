//합이 같은 부분집합
//DFS (아마존 인터뷰)

//혼자 풀어본 코드 - 정답 나옴 :) 
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arrList;
    static int[] ch;
    static int n;
    static int[] items;
    static int sum = 0;
    static int goal;
    static int anotherGoal;
    static String answer = "NO";

    public static void DFS(int v, int index){
        sum += v;
        if(sum == goal){
            anotherGoal = 0;
            for(int i = 0; i < items.length; i++){
                if(ch[items[i]] == 0){
                    anotherGoal += items[i];
                }
                
            }
        }
        if(goal == anotherGoal){
        //    System.out.println("YES");
            answer = "YES";
           return;        
        }
        for(int i = 0; i <arrList.get(index).size(); i++){
            int nv = arrList.get(index).get(i);
            ch[nv] = 1;
            DFS(nv, index + 1);
            ch[nv] = 0;
            sum -= nv;
        }
    }
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        n = scanner.nextInt();
        items = new int[n];
        goal = 0;
        for(int i = 0; i < n; i++){
            items[i] = scanner.nextInt();
            goal += items[i];
        }
        goal = goal / 2;

        //arrList 초기화
        arrList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++){
            arrList.add(new ArrayList<Integer>());
        }

        //연결관계 arrayList로 나타내기
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                arrList.get(i).add(items[j]);
            }
        }

        //체크배열 초기화
        ch = new int[1001];
        ch[items[0]] = 1;
        DFS(items[0], 0);
        System.out.println(answer);
    }    
}
