package Day_8_Arrays;

public class Lec_557_Reverse_Words {
    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (start == -1) {
                    start = i;
                }
                end++;
                continue;
            }
            reverseString(chars, start, end - 1);
            end++;
            start = -1;
        }
        if (start!=-1) {
            reverseString(chars, start, end - 1);
        }
        return String.valueOf(chars);
    }

    public void reverseString(char[] s, int low, int high) {
        while (low <= high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
