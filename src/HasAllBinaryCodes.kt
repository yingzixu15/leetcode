import kotlin.math.pow

class HasAllBinaryCodes {
    fun hasAllCodes(s: String, k: Int): Boolean {
        val substringSet = mutableSetOf<String>()
        for (i in 0..s.length - k) {
            substringSet.add(s.substring(i,i+k))
        }
        print(substringSet)
        val target = 2.0.pow(k).toInt()
        return substringSet.size == target
    }
}