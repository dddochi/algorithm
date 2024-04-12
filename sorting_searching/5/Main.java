import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution2(n, arr));
    }
    public static char solution(int n, int[] arr){
        //정렬
        //insertion
        for(int i = 0; i < n; i++){
            int idx = i;
            for(int j = i+1; j < n; j++){
                if(arr[idx] > arr[j]){
                    idx = j;
                }
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        //중복 숫자가 있는지 check!
        for(int i = 0; i < n-1; i++){
            if(arr[i] == arr[i+1]) return 'D';
        }
        return 'U';
    }
    //설명 듣고 풀어본 코드 - HashMap 사용법- 시간 복잡도 : O(n)
    public static char solution2(int n, int[] arr){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int x : arr){
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        for(int x :hashMap.keySet()){
            if(hashMap.get(x) > 1) return 'D';
        }
        return 'U';
    }
    //강사님 코드
    public static char solution3(int n, int[] arr){
        char answer = 'U';
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(arr[i] == arr[i+1]) return 'D';
        }
        return answer;
    }
}
