import java.util.*;

public class Main {
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int n = scanner.nextInt();
    //     Set<Integer> a = new HashSet<>();
    //     for(int i = 0; i < n; i++){
    //         a.add(scanner.nextInt());
    //     }
    //     int m = scanner.nextInt();
    //     Set<Integer> b = new HashSet<>();
    //     for(int j = 0; j < m; j++){
    //         b.add(scanner.nextInt());
    //     }
    //     for(int x : solution(n, a, m, b)){
    //         System.out.print(x + " ");
    //     }
    // } 
    //<스스로 해본 코드> two pointer algorithm 이용 
    // public static Set<Integer> solution(int n, Set<Integer> aSet, int m, Set<Integer> bSet){
    //     List<Integer> a = new ArrayList<>(aSet);
    //     List<Integer> b = new ArrayList<>(bSet);
    //     Set<Integer> answer = new HashSet<>();
    //     int p1 = 0, p2 = 0;

    //     while (p1 < a.size()) {
    //         p2 = 0;
    //         while (p2 < b.size()) {
    //             if(a.get(p1) == b.get(p2)){
    //                 answer.add(a.get(p1));
    //                 break;
    //             }
    //             p2++;
    //         }
    //         p1++;
    //     }
    //     return answer;
    // } 
    //강의 설명 듣고, 스스로 구현해본 코드
    //Timeout exceeded 뜬다
    // public static List<Integer> solution(int n, Set<Integer> aSet, int m, Set<Integer> bSet){
    //     List<Integer> a = new ArrayList<>(aSet);
    //     List<Integer> b = new ArrayList<>(bSet);
    //     List<Integer> answer = new ArrayList<>();
    //     int p1 = 0, p2 = 0;
    //     while (p1 <n && p2 <m) {
    //         if(a.get(p1) == b.get(p2)){
    //             answer.add(a.get(p1));
    //             p1++;
    //             p2++;
    //         }
    //         if(a.get(p1) < b.get(p2)) p1++;
    //         if(a.get(p1) > b.get(p2)) p2++;
            
    //     }
    //     return answer;
    // }
    
    //강사님 코드
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = scanner.nextInt();
        }
        for(int x : solution(n, a, m, b)){
            System.out.print(x + " ");
        }
    } 
    public static List<Integer> solution(int n, int[] a, int m, int[] b){
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0, p2 = 0;
        while (p1 > n && p2 > m) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            }
            else if(a[p1] < b[p2]) p1++;
            else p2++;
            
        }
        return answer;
    }
}
