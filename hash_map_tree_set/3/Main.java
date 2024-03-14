import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }
        for(int x : solution2(n, k, arr)){
            System.out.print(x + " ");
        }
    } 
    //스스로해본 코드 - 출력 O - RuntimeError
    public static List<Integer> solution(int n, int k, int[] arr){
        List<Integer> windows = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        //initialize sliding window
        for(int i = 0; i < k ; i++){
            windows.add(arr[i]);
            
        }
        //first hash 
        for(int x : windows){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        answer.add(map.size());
        map.clear();

        for(int i = k; i < n; i++){
            windows.remove(i - k);
            windows.add(arr[i]);

            for(int x : windows){
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            answer.add(map.size());
            map.clear();
        }
        return answer;
    }   
    //설명 듣고 혼자 작성한 코드 - 출력 O - TimeLimitExceeded
    public static List<Integer> solution2(int n, int k, int arr[]){
        List<Integer> answer = new ArrayList<>();
       
        //초기화된 window의 값 hashmap에 넣어주기
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());
        //window 밀기
        int lt = 0;
        for(int rt = k; rt <n; rt++){
            map.put(arr[lt], map.getOrDefault(arr[lt], 0) - 1);
            lt++;
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            
            if(map.containsValue(0)){
                Integer removeKey = 0;
                for(Integer x : map.keySet()){
                    if(map.get(x) == 0) {
                        removeKey = x;
                        break;
                    }
                }
                map.remove(removeKey);
            }
           
        
            answer.add(map.size());
        }
        return answer;
    }
    //강사님 코드 
    public static List<Integer> solution3(int n, int k , int[] arr){
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
        for(int i = 0; i < k - 1; i++){
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for(int rt = 0; rt < n; rt++){
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt]) -1);
            if(HM.get(arr[lt]) == 0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
}
