import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solution(n, str));

    }
    //혼자 해본 코드
    // public static char solution(int n, String str){
    //     int [] score = new int[5];
    //     for(int i = 0; i < n; i++){ //A - 65 E - 69
    //         score[str.charAt(i) - 65]++; //0 ~ 4
    //     }
    //     int max = 0;
    //     int index = 0;
    //     for(int i = 0; i < 5; i++){
    //         if(max < score[i]){
    //             max = score[i];
    //             index = i;
    //         }
    //     }
        
    //     return (char)(index + 65);
    // }
    //강의 설명 듣고 스스로 해본 코드
    public static char solution(int n, String str){
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('A', 0);
        hashMap.put('B', 0);
        hashMap.put('C', 0);
        hashMap.put('D', 0);
        hashMap.put('E', 0);
        for(int i = 0; i < n; i++){
            hashMap.put(str.charAt(i), hashMap.get(str.charAt(i)) + 1);
        }
        int max = 0;
        char maxKey = 'A';
        for(char key : hashMap.keySet()){
            if(hashMap.get(key) > max){
                max = hashMap.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }
    //강사님 코드
    public static char solution2(int n, String str){
        HashMap<Character, Integer> map = new HashMap<>();
        char answer = ' ';
        for(char x : str.toCharArray()){
            map.getOrDefault(map.get(x), 0);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}
