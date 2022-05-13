
fun countVowelStrings(n: Int): Int {
    val table = mutableListOf<List<Int>>(listOf(1,1,1,1,1))
    for (k in 1 until n) {
        val prevRow = table[k-1]
        val curRow = prevRow.mapIndexed { index, _ -> prevRow.slice(0..index).sum() }
        table.add(curRow)
    }
    return table[n-1].sum()
}
