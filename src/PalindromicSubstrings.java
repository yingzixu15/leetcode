public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            result++;
            // odd palindromes
            for (int j = 1; (i-j) >= 0 && (i+j) <= n-1 && s.charAt(i-j) == s.charAt(i+j); j++) {
                result++;
            }
            // even palindromes
            for (int k = 0; (i-k) >= 0 && (i+k+1) <= n-1 && s.charAt(i-k) == s.charAt(i+k+1); k++) {
                result++;
            }
        }
        return result;
    }
}
