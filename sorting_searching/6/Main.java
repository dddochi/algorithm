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
    //혼자 풀어본 코드
    //결과 출력은 잘 되지만, 오답 뜬다..!  
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
    //설명 듣고 풀어본 코드
    public static List<Integer> solution2(int n, int[] arr){
        int[] tmp = new int[n];
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tmp[i] = arr[i];
        }
        Arrays.sort(tmp);

        //비교
        for(int i = 0; i < n; i++){
            if(tmp[i] != arr[i]){
                answer.add(i+1);
            }
        }

        return answer;
    }
    //강사님 코드
    public static List<Integer> solution3(int n, int[] arr){
        List<Integer> answer = new ArrayList<>();
        int [] tmp = arr.clone(); //깊은 복사
        Arrays.sort(tmp);
        for(int i = 0; i < n; i++){
            if(tmp[i] != arr[i]) answer.add(i+1);
        }
        return answer;
    }
}
