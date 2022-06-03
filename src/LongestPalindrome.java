public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Boolean[] evenFrequency = new Boolean[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index;
            if (c >= 'a' && c <= 'z') {
                index = c - 'a';
            } else {
                index = 26 + c - 'A';
            }
            if (evenFrequency[index] == null)
                evenFrequency[index] = false;
            else evenFrequency[index] = !evenFrequency[index];
        }
        int oddCount = 0;
        for (Boolean b: evenFrequency) {
            if (b != null && !b)
                oddCount++;
        }
        if (oddCount == 0)
            return s.length();
        else return s.length() - oddCount + 1;
    }
}
