import java.util.List;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int bestStart = -1;
        int bestEnd = -1;
        int bestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] oddPalindromeInterval = extendFromCentre(s, i, i);
            int oddLength = oddPalindromeInterval[1] - oddPalindromeInterval[0] + 1;
            int[] evenPalindromeInterval = extendFromCentre(s, i, i+1);
            int evenLength = evenPalindromeInterval[1] - evenPalindromeInterval[0] + 1;
            if (oddLength > bestLength) {
                bestStart = oddPalindromeInterval[0];
                bestEnd = oddPalindromeInterval[1];
                bestLength = oddLength;
            }
            if (evenLength > bestLength) {
                bestStart = evenPalindromeInterval[0];
                bestEnd = evenPalindromeInterval[1];
                bestLength = evenLength;
            }
        }
        return s.substring(bestStart, bestEnd + 1);
    }

    private int[] extendFromCentre(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        start++;
        end--;
        return new int[]{start, end};
    }
}
