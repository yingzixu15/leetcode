import java.math.BigInteger

class PascalsTriangle2 {
    fun getRow(rowIndex: Int): List<Int> {
        val listFactorials = factorial(rowIndex)
        val result = mutableListOf<Int>()
        for (i in 0..rowIndex) {
            val binomial = listFactorials[rowIndex] / (listFactorials[i] * listFactorials[rowIndex - i])
            result.add(binomial.toInt())
        }
        return result
    }

    // compute factorials x! for x = 0,1,...,n
    private fun factorial(n: Int): List<BigInteger> {
        val result = mutableListOf<BigInteger>()
        for (i in 0..n) {
            if (i == 0)
                result.add(BigInteger.ONE)
            else
                result.add(BigInteger(i.toString()) * result[i-1])
        }
        return result
    }
}