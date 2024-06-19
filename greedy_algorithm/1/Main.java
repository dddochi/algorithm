import java.util.*;
public class Main {
    public static class Info{
        int height;
        int weight;
        public Info(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //rule -> 최대 몇명 선발 가능?
        Info[] infoList = new Info[n];
        for(int i = 0; i < n; i++){
            int weight = scanner.nextInt();
            int height = scanner.nextInt();
            infoList[i] = new Info(height, weight);
        }
        //A지원자 -> 키, 몸무게 둘다 A보다 큰 지원자 있으면 -> 탈락
        //output - 최대 몇명?
        //혼란스러운 점 -> 탈락을 하면 -> 탈락하고 남은 인원끼리 비교를 하는 것인가? 아니면 처음부터 다 비교를 하고 out?
        int count = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(infoList[i].height < infoList[j].height && infoList[i].weight < infoList[j].weight){
                    count--;    
                }
            }
        }
        System.out.println(count);
    }    
}
