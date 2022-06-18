import java.util.LinkedList;

public class FindWinnerCircularGame {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> players = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            players.add(i);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k - 1; j++)
                players.add(players.removeFirst());
            players.removeFirst();
        }
        return players.removeFirst();
    }
}
