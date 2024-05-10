//부분집합 구하기
//상태 트리
import java.util.*;

public class Main {
    static int n;
    static int[] ch;
    public static void DFS(int L){
        if(L == n+1){ //끝남
            String tmp = "";
            for(int i = 1; i <= n; i++){
                if(ch[i] == 1) tmp += i;
               
            }
            if(tmp.length() > 0) System.out.println(tmp);
        }
        else{
            ch[L] = 1; //'L'레벨 사용
            DFS(L+1);
            ch[L] = 0; //'L'레벌 사용 x
            DFS(L+1);
        }
    }
    public static void main(String[] args) {
        n = 3;
        ch = new int[n+1]; // check 배열
        DFS(1);
    }  
    
}
