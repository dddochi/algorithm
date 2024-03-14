import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //scanner.nextLine();
        int [] firstArr = new int[n]; 
        for(int i = 0; i < n; i++){
            firstArr[i] = scanner.nextInt();
        }
        //scanner.nextLine();

        int m = scanner.nextInt();
        //scanner.nextLine();
        int[] secondArr = new int[m];
        for(int j = 0; j < m; j++){
            secondArr[j] = scanner.nextInt();
        }
        //scanner.nextLine();
        
        for(int x : solution(n, firstArr, m, secondArr)){
            System.out.print(x + " ");
        }
    }
    //혼자 해본 코드
    // public static List<Integer> solution(int n, int[] firstArr, int m, int[] secondArr){
    //     List<Integer> result = new ArrayList<>();
    //     //n열이 m열에 끼워진다고 생각하기
    //     //n이 사이에 끼여있으면 넣기 - 0부터 시작해서 자기보다 큰 수 나오면 넣기
    //     for(int i = 0; i < n ; i ++){
    //         result.add(firstArr[i]);
    //     }
    //     for(int j = 0; j < m; j++){
    //         for(int k = 0; k < result.size()-1; k++){
    //             if(secondArr[j] > result.get(k) && secondArr[j] <= result.get(k+1)){
    //                 result.add(k+1, secondArr[j]);
    //             }
    //             //0번 index보다 작으면
    //             else if(secondArr[j] <result.get(0)){
    //                 result.add(0, secondArr[j]);
    //             }
        
    //         }
    //         //마지막 index보다 크면
    //         if(secondArr[j] > result.get(result.size()-1)){
    //             result.add(secondArr[j]);
    //         }
    //     }
    //     return result;

    // }
    // //강의 듣고 스스로 해본 코드 - two pointer algorithm
    // public static List<Integer> solution(int n, int[] a, int m, int[] b){
    //     List<Integer> answer = new ArrayList<>();
    //     int p1  = 0;
    //     int p2 = 0;
    //     while (p1 < n && p2 < m) {
    //         if(a[p1] > b[p2]){
    //             answer.add(b[p2]);
    //             p2++;
    //         }
    //         else{
    //             answer.add(a[p1]);
    //             p1++;
                
    //         }
    //     }
    //     //남은 배열의 아이템들 모두 넣어버리기
    //     if(n - m >0){// n, 즉 a 배열이 더 큰 상황
    //         for(int k = p1; k < n; k++){
    //             answer.add(a[k]);   
    //         }
    //     }else if( m - n > 0){ // m, 즉 b 배열이 더 큰 상황
    //         for(int s = p2; s < m; s++){
    //             answer.add(b[s]);
    //         }
            
    //     }
    //     return answer;
    // }
    //강사님 코드
    public static List<Integer> solution(int n, int[] a, int m, int[] b){
        int p1 = 0, p2 = 0;
        List<Integer> answer = new ArrayList<>();
        while(p1 < n && p2 < m){
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while (p1 < n) {
            answer.add(a[p1++]);
        }
        while (p2 < m) {
            answer.add(b[p2++]);
        }
        return answer;
    }
}
