//문자열과 특정 문자 하나를 입력받아 -> 문자열에서 특정 문자가 몇번 나오는지 카운트
//ex) Computercooler, c -> 2
import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string and character
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter a character: ");
        char targetChar = scanner.next().charAt(0);

        // Call the countOccurrences method and print the result
        int count = countOccurrences(inputString, targetChar);
        System.out.println("The character '" + targetChar + "' appears " + count + " times in the string.");
    }

    // Method to count occurrences of a character in a string
    public static int countOccurrences(String str, char target) {
        str = str.toLowerCase();
        target = Character.toLowerCase(target);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        // for(char x : str.toCharArray()){
        //     if(x == target){
        //         count++;
        //     }
        // }
        return count;
    }
}
