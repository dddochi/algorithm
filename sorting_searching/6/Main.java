import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int x : solution(n, arr)){
            System.out.print(x + " ");
        }
    }    
    public static List<Integer> solution(int n, int[] arr){
        List<Integer> answer = new ArrayList<>();
        boolean isChanged = false;
        for(int i = 0; i < n; i++){
            int idx = i;
            for(int j = i + 1; j < n; j++){
                if(arr[idx] > arr[j]){ //나보다 더 키 작은 애가 뒤에 나타남 -> 철수와 짝궁 case
                    idx = j;
                    isChanged = true;
                }
            }
            if(isChanged){
                answer.add(i + 1);
                answer.add(idx + 1);
                break;
            }
        }
        return answer;
    }
}
