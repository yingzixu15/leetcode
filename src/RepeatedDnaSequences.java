import java.util.*;

public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10)
            return Collections.emptyList();
        Set<String> allSubstring = new HashSet<>();
        Set<String> repeatedSubstring = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String slice = s.substring(i,i + 10);
            if (allSubstring.contains(slice)) {
                repeatedSubstring.add(slice);
            } else
                allSubstring.add(slice);
        }
        return new ArrayList<>(repeatedSubstring);
    }
}
