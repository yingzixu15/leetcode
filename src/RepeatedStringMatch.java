public class RepeatedStringMatch {
    public int repeatedStringMatch(String a, String b) {
        int baseNumRepeat = b.length() / a.length();
        for (int i = 0; i <= 3; i++) {
            if (a.repeat(baseNumRepeat + i).contains(b))
                return baseNumRepeat + i;
        }
        return -1;
    }
}
