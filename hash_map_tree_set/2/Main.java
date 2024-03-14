import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(solution(str1, str2));
    }
    public static String solution(String str1, String str2){
        //알파벳 -> hashmap으로 작성
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
       
        for(char x : str1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }
        for(char x : str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }
        for(char x : map1.keySet()){
            if(!map2.containsKey(x)){
               // answer = "NO";
               //break;
                return "NO";
            } 
            else{
                if(map1.get(x) != map2.get(x)) return "NO";
            }
        }
        return "YES";
    }
    //강사님 설명 듣고 작성해본 코드
    public static String solution2(String str1, String str2){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : str1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(char x : str2.toCharArray()){
            //같은 알파벳(키)가 없는 경우
            if(map.containsKey(x) == false) return "NO";
            else{ 
                if(map.get(x) == 0) return "NO"; //개수가 0보다 작아질때
                map.put(x, map.get(x) - 1);
            }
        }
        // 모두 0이 아니면 NO -> 0112 같은 상황 check
        for(char x : map.keySet()){
            if(map.get(x) != 0) return "NO";
        }
        return "YES";
    }   
    //강사님 코드 
    public static String solution3(String s1, String s2){
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x: s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(char x : s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0) return "NO";
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }
}
