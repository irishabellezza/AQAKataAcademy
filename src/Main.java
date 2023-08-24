import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение, для выхода введите \"end\":");
        Scanner in = new Scanner(System.in);
        String str = "";

        while(in.hasNextLine()){
            str = in.nextLine();
            if(str.equals("end")) {
                break;
            }
            else {
                try {
                    System.out.println(calc(str));
                } catch (Exception e) {
                    System.out.println("throws Exception");
                }
            }
        }
    }

    static boolean checkString(String str) throws Exception {
        String regex = "([1-9]|10)\\s*[\\+\\-\\*\\/]\\s*([1-9]|10)";

        if(Pattern.matches(regex, str)==true)
            return true;
        else
            throw new Exception();
    }

    public static String calc(String input) throws Exception{
        int value = 0;

        if(checkString(input)) {
            int a = Integer.parseInt(input.split("\\s*[\\+\\-\\*\\/]\\s*")[0]);
            int b = Integer.parseInt(input.split("\\s*[\\+\\-\\*\\/]\\s*")[1]);

            if(input.contains("+"))
                value = a + b;
            else if(input.contains("-"))
                value = a - b;
            else if(input.contains("*"))
                value = a * b;
            else if(input.contains("/"))
                value = a / b;
        }
        else
            throw new Exception();

        return String.valueOf(value);
    }
}
