import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //소수의 개수 출력
        // 소수 - 1과 자기자신만이 약수 / 2제외 짝수 x
        // 약수로 다 나누기 -> 약수 -> 최대 공약수의 약수 -> 엥 이건 근데 숫자 2개 비교해야함
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        // int count = 0;
        // for(int i = 0; i <num; i ++){
        //     if(solution(i) == true){
        //         System.out.print(i + " ");
        //         count++;
        //     }
        // }
        // System.out.println();
        // System.out.println(count);
        // System.out.println(solution2(num)); -> Runtime error

        //강사님 코드
        System.out.println(solution3(num));
    }
    public static Boolean solution(int n){
        if(n <= 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            } 
        }
        return true;
    }
    //강사님 코드 - 에라토스테네스 방식
    // 1. 2체크 - 소수 o => 2의 배수 모두 지우기 -> 1과 자기자신 말고도 2배수라는 약수 가지기 때문
    // 2. 3 체크 - 소수 o => 3을 약수로 갖는 모든 것 지우기 = 6,9,...
    //3. 5 체크 - 소수 o => 5배수 모두 지우기 => 10, 15 ...
    //요약하면 -> 0으로 채워진 배열만들고,
    // 0이 들어있는애는 소수로 check & 동시에 그 수의 배수 모두 지워버리기
    
    //<강사님 설명듣고 에라토스테네스 방식으로 만들어보기>
    public static int solution2(int n){
        int count = 0;
        int[] prime = new int[n];
        for(int i = 2; i < n; i++){
            if(prime[i] == 0){
                count++;
                prime[i] = 1;
                for(int j = i; i*j < n; j++){
                    prime[i * j] = 1;
                }
            }
        }
        return count;
    }

    public static int solution3(int n){
        int answer = 0;
        int[] ch = new int[n+1]; //n도 포함 해야하니 n+1까지 ex) 20이면 -> 20까지 check
        for(int i = 2; i < n; i++){
            if(ch[i] == 0){
                answer ++;
                for(int j = i; j < n; j = j+i){ //j가 i의 배수로 돌아야하니까 i만큼 증가해야함!
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }
}


