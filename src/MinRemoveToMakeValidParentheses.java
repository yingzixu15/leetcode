import java.util.*;
import java.util.stream.Collectors;

public class MinRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> left = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(') {
                left.push(i);
            } else if (chars[i] == ')') {
                if (left.isEmpty()) {
                    chars[i] = '!';
                } else {
                    left.pop();
                }
            }
        }
        for (int i: left) {
            chars[i] = '!';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: chars) {
            if (c != '!')
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
