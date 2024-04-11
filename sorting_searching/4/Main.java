import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt(); //s - 캐시 크기
        int n = scanner.nextInt(); //n - 작업의 개수
        int [] arr = new int [n]; 
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int x :  solution(s, n, arr)){
            System.out.print(x + " ");
        }
    }
    public static int[] solution(int s, int n, int [] arr){
        int[] cache = new int[s];
        for(int i = 0; i < n ; i++){
            
            //cache - miss  -> 새로운 아이템 캐시에 추가 ->
            if(!checkCache(cache, arr[i])){
                //기존 아이템 한칸 씩 싹 밀기 + s 이상이면 버리기
                int[] newCache = new int[s];
                for(int j = 0; j < s; j++){
                    
                    if(j+1 != s){
                        newCache[j+1] =cache[j];
                    }

                }
                newCache[0] = arr[i];
                cache = newCache;
            }
            else{ //cache - hit
               for(int j = 0; j < s; j++){
                  if(arr[i] == cache[j]){
                    for(int k = j; k > 0; k--){
                        int tmp = cache[k];
                        cache[k] = cache[k-1];
                        cache[k-1] = tmp;
                    }
                    break;
                  }

               } 
            }
            
        }
        return cache;


    }
    //cache가 arr[i] 가지고 있는지 check
    public static boolean checkCache(int[] cache, int x){
        for(int i = 0; i < cache.length; i++){
            if(cache[i] == x) return true;
        }
        return false;
    }
    //설명 듣고 풀어본 코드
    public static int[] solution2(int s, int n, int [] arr){
        int[] cache = new int[s];
        for(int i = 0; i < n ; i++){
            
            //cache - miss  -> 새로운 아이템 캐시에 추가 ->
            if(!checkCache(cache, arr[i])){
                //기존 아이템 한칸 씩 싹 밀기 + s 이상이면 버리기
                for(int j = s-1; j > 0; j--){
                    int tmp = cache[j];
                    cache[j]= cache[j-1];
                    cache[j-1] = tmp;
                }
                cache[0] = arr[i];
               
            }
            else{ //cache - hit
               for(int j = 0; j < s; j++){
                  if(arr[i] == cache[j]){
                    for(int k = j; k > 0; k--){
                        int tmp = cache[k];
                        cache[k] = cache[k-1];
                        cache[k-1] = tmp;
                    }
                    break;
                  }

               } 
            }
            
        }
        return cache;


    }
    //강사님 코드
    public static int[] solution3(int size, int  n, int [] arr){
        int[] cache = new int[size];
        for(int x : arr){
            int pos = -1;
            for(int i=0; i<size; i++){if(x == arr[i]) pos = i;}
            if(pos == -1){ //cache miss
                for(int i = size -1; i >= 1; i--){
                    cache[i] = cache[i-1];
                }
            }
            else{//cache hit
                for(int i = pos; i >=1; i--){
                    cache[i] = cache[i-1];
                }
               
            }
            cache[0] = x;
        }
    }
   


}
