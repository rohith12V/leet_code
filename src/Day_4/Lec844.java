package Day_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lec844 {
    public static boolean backspaceCompare(String s, String t) {
        final String preProcessA = preProcess(s);
        final String preProcessB = preProcess(t);
        return preProcessA.equals(preProcessB);
    }

    private static String preProcess(String input) {
        final int length = input.length();
        final List<String> result =  new ArrayList<>();
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) != '#') {
                result.add(String.valueOf(input.charAt(i)));
            }
            else if (input.charAt(i) == '#') {
                result.remove(result.size() - 1);
            }
        }
        return  String.join("", result);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
    }
}
