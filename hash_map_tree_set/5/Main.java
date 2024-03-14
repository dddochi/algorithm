import java.util.*;

//TreeSet 문제
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, arr));
        

    }   
    //혼자 시도해본 코드 - 미완성 -> Treeset에 대해 알지 못함
    // public static int solution(int n, int k, int[] arr){
    //     //arr에 있는 모든 수 중 3개를 합해 만들 수 있는 수 모두 기록 - 3중포문..?
    //     //이중에서 k번째 출력하라

    //     //k개의 합을 찾고 - map에 등수 등록
    //    // List<Integer> sumArr = new ArrayList<>();
    //     Set<Integer> sumSet = new HashSet<>();
    //     int length = arr.length;
    //     int sum = 0;
    //     for(int i = 0; i < length; i++){
    //         for(int j = i + 1; j < length; j++){
    //             for(int s = j + 1; s < length; s++){
    //                 sum = arr[i] + arr[j] + arr[s];
                   
    //                 sumSet.add(sum);
    //                 sum = 0;
    //             }
                
    //         }
    //     }
        
    //     List<Integer> sumArr =  new ArrayList<>(sumSet);
        
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int[] max = new int[k];

    //     //initialize window
    //     // for(int i = 0; i <k - 1; i++){
    //     //     map.put(sumArr.get(i), i );
    //     // }
    
    //     max[0] = sumArr.get(0);
    //     int lt = 0;
    //     for(int rt = 1; rt < sumArr.size(); rt++){
    //         int newItem = sumArr.get(rt);
    //         if(newItem < max[0]){
    //             int tmp1= max[1];
    //             max[1] = newItem;
    //             int tmp2 = max[2];
    //             max[2] = tmp1;
    //             for(int i = 0; i < k; i++){
    //                 int tmp;
    //             }
    //         }
    //     }
    //     return 0;
    // } 
    public static int solution(int n, int k, int[] arr){
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());

        //3번 뽑은 숫자의 합 - 모든 경우의 수 구하기
        //내림차순 정렬
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int l = j; l < n; l++){
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        
        //k번째 큰 수 출력
        int cnt = 0;
        for(int x : Tset){
            cnt++;
            if(cnt == k) return x;
        }
        return answer;
    }
}
