fun longestValidParentheses(s: String): Int {
    if (s.isEmpty())
        return 0
    var dp = IntArray(s.length)
    dp.fill(0)
    for (i in 1 until s.length) {
        if (s[i] == ')') {
            if (i-1 >= 0 && s[i-1] == '(') {
                if (i-2 >= 0)
                    dp[i] = dp[i-2] + 2
                else
                    dp[i] = 2
            } else if (i - dp[i-1] - 1 >= 0 && s[i - dp[i-1] - 1] == '(') {
                if (i - dp[i-1] - 2 >= 0)
                    dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
                else
                    dp[i] = dp[i-1] + 2
            }
        }
    }
    return dp.maxOf {it}
}