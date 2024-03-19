import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, arr));
    } 
    //혼자 풀어본 코드 - 정답
    public static int solution(int n, int m, int[] arr){
        Queue<Integer> Q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            Q.offer(i);
        }
   

        while (Q.contains(m)) {
            int target_index = Q.poll();
            int target = arr[target_index];
            boolean isBiggerElement = false;
            for(int x : Q){
                if(arr[x]> target){
                    isBiggerElement = true;
                    break;
                }
            }
            if(isBiggerElement) Q.offer(target_index);
            else count++;

        }
        return count;
    }   
    //설명 듣고 풀어본 코드 - 정답
    //class를 만들어서 id, priority를 instance 변수로 선언한다.
    // public static int solution2(int n, int m, int[] arr){
    //     int count = 0;
    //     Queue<Person> Q = new LinkedList<>();
    //     for(int i = 0; i < arr.length; i++){
    //         Q.offer(new Person(i, arr[i]));
    //     }
    //     while (true) {
    //         Person target = Q.poll();
    //         boolean isBiggerElement = false;
    //         for(Person p : Q){
    //             if(p.priority > target.priority){
    //                 isBiggerElement = true;
    //                 break;
    //             }
    //         }
    //         if(isBiggerElement) Q.offer(target);
    //         else {
    //             count++;
    //             if(target.id == m) break;
    //         }
    //     }
    //     return count;
    // }
    // static class Person{
    //     int id;
    //     int priority;
    //     Person(int id, int priority){
    //         this.id = id;
    //         this.priority = priority;
    //     }
    // }
    //강사님 코드
    static class Person{
        int id;
        int priority;
        public Person(int id, int priority){
            this.id = id;
            this.priority = priority;
        }
    }
    public static int solution3(int n, int m, int[] arr){
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            Q.offer(new Person(i, arr[i]));
        }
        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for(Person x : Q){
                if(x.priority > tmp.priority){
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }
}
