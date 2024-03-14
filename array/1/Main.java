import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    scanner.nextLine();
    int[] numList = new int[size];
    for (int i = 0; i < size; i++) {
      numList[i] = scanner.nextInt();
    }
    List<Integer> resultList = solution(numList);

    for (Integer num : resultList) {
      System.out.print(num + " ");
    }
  }

  public static List<Integer> solution(int[] numList) {

    List<Integer> resultList = new ArrayList<>();
    resultList.add(numList[0]);
    for (int i = 1; i < numList.length; i++) {
      if (numList[i - 1] < numList[i]) {
        resultList.add(numList[i]);
      }
    }
    return resultList;
  }

  public static List<Integer> solution2(int n, int[] numList){
    List<Integer> answer = new ArrayList<>();
    answer.add(numList[0]);
    for(int i = 1; i < n; i++){
      if(numList[i] > numList[i-1]) answer.add(numList[i]);
      
      
    }
    return answer;
  }

}
