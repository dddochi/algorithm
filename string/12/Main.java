import java.util.Scanner; // Import the Scanner class
import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    scanner.nextLine();
    String str = scanner.nextLine();

    System.out.println(solution(num, str));

  }

  public static String solution(int num, String str) {
    String answer = "";
    List<String> strList = new ArrayList<>();
    int number;
    for (int i = 0; i < num; i++) {
      String newStr = str.substring(i * 7, (i + 1) * 7);
      strList.add(newStr);
      String binary = "0";
      for (int j = 0; j < newStr.length(); j++) {
        if (newStr.charAt(j) == '#') {
          binary += 1;
        }
        if (newStr.charAt(j) == '*') {
          binary += 0;
        }

      }
      number = Integer.parseInt(binary, 2);
      answer += (char) number;
    }
    return answer;
  }
  //강사님 코드
  public static String solution2(int n, String s){
    String answer = "";
    for(int i = 0; i < n; i++){
      String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
      int num = Integer.parseInt(tmp, 2);
      answer += (char) num;
      s = s.substring(7);
    }
    return answer;
  }
}
