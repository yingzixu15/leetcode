import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, LinkedList<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            int key = (new String(chars)).hashCode();
            LinkedList<String> list = map.getOrDefault(key, null);
            if (list == null)
                map.put(key, new LinkedList<>(List.of(s)));
            else list.addLast(s);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}
