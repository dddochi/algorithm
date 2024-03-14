import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        //s.length() >= t.length
        System.out.println(solution2(s, t));

    }   
    //스스로 해본 코드
    public static int solution(String s, String t){
        int tSize = t.length();
        int sSize = s.length();
        int cnt= 0;
        HashMap<Character, Integer> windows = new HashMap<>();
        
        //initialize window hashmap
        for(int i = 0; i < tSize -1; i++){
            windows.put(s.charAt(i), windows.getOrDefault(s.charAt(i), 0)+1);
        }
       
        int lt = 0;
        for(int rt = tSize -1; rt < sSize; rt++){
            windows.put(s.charAt(rt), windows.getOrDefault(s.charAt(rt), 0)+1);
        
            if(checkAnagram(windows, t)) cnt++;
       
        
            windows.put(s.charAt(lt), windows.get(s.charAt(lt))-1);
            if(windows.get(s.charAt(lt)) == 0) windows.remove(s.charAt(lt));
            lt++;
        }
        return cnt;
    } 

    public static boolean checkAnagram(HashMap<Character, Integer> originalWindow, String t){
        HashMap<Character, Integer> windows = new HashMap<>(originalWindow);
        Boolean isSame = true;
            for(char x : t.toCharArray()){
                if(!windows.containsKey(x)) {
                    isSame = false;
                    break;
                }
                else if(windows.get(x) == 0){
                    isSame = false;
                    break;
                }
                else windows.put(x, windows.get(x) - 1);
            }
        return isSame;
    }
    //강의 듣고 스스로 풀어본 코드
    public static int solution2(String s, String t){
        int tSize = t.length();
        int sSize = s.length();
        int cnt= 0;
        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        //initialize t map
        for(int i = 0; i < tSize; i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) +1);
        }
        //initialize window hashmap
        for(int i = 0; i < tSize -1; i++){
            windows.put(s.charAt(i), windows.getOrDefault(s.charAt(i), 0)+1);
        }
       
        int lt = 0;
        for(int rt = tSize -1; rt < sSize; rt++){
            windows.put(s.charAt(rt), windows.getOrDefault(s.charAt(rt), 0)+1);
        
            if(windows.equals(tMap)) cnt++;
       
        
            windows.put(s.charAt(lt), windows.get(s.charAt(lt))-1);
            if(windows.get(s.charAt(lt)) == 0) windows.remove(s.charAt(lt));
            lt++;
        }
        return cnt;
    } 

//강사님 코드
public static int solution3(String a, String b){
    int answer = 0;
    HashMap<Character, Integer> am = new HashMap<>();
    HashMap<Character, Integer> bm = new HashMap<>();
    for(char x : b.toCharArray())bm.put(x, bm.getOrDefault(x, 0) + 1);
    int L = b.length() - 1;
    for(int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
    int lt = 0;
    for(int rt = L; rt < a.length(); rt++){
        am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
        if(am.equals(bm)) answer++;
        am.put(a.charAt(lt), am.get(a.charAt(rt))-1);
        if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
        lt++;
    }
    return answer;
}

    
}

