import java.util.Scanner; // Import the Scanner class

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    System.out.println(solution(str));
  }

  public static String solution(String str) {
    String answer = "";
    int count = 1;
    for (int i = 0; i < str.length(); i++) {
      if (i == str.length() - 1) {
        if (str.charAt(i - 1) == str.charAt(i)) {

          answer += str.charAt(i);
          answer += count;
        } else {
          answer += str.charAt(i);
        }
      } else if (str.charAt(i) != str.charAt(i + 1)) {
        answer += str.charAt(i);
        if (count != 1) {
          answer += count;
        }
        count = 1;
      } else {
        count++;
      }
    }
    return answer;
  }
}

//강사님 코드
class Main {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    System.out.println(solution(str));
  }
  
  public String solution(String s){
    String answer = "";
    s=s+" ";
    int cnt = 1;
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) == s.charAt(i+1)){
        cnt++;
      }
      else{
        answer += s.charAt(i);
        if(cnt > 1) answer += String.valueOf(cnt);
        cnt = 1;
      }
    }
  }
}
