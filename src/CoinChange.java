import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        Map<Integer, Integer> recordMap = new HashMap<>();
        recordMap.put(0, 0);
        for (int target = 1; target <= amount; target++) {
            int minNumCoins = Integer.MAX_VALUE;
            boolean found = false;
            for (int i = 0; i < coins.length && coins[i] <= target; i++) {
                int coin = coins[i];
                if (recordMap.containsKey(target - coin)) {
                    found = true;
                    int numCoins = recordMap.get(target - coin) + 1;
                    if (minNumCoins > numCoins)
                        minNumCoins = numCoins;
                }
            }
            if (found)
                recordMap.put(target, minNumCoins);
        }

        if (recordMap.containsKey(amount))
            return recordMap.get(amount);
        else
            return -1;
    }
}
