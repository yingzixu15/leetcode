import kotlin.math.max

fun totalFruit(fruits: IntArray): Int {
    var b1 = 0
    var b2 = 0
    var b1type = -1
    var b2type = -1
    var maxFruits = 0
    var prevType = -1
    var fruitsInARow = 0
    for (fruit in fruits) {
        if (fruit == b1type)
            b1++
        else if (fruit == b2type)
            b2++
        else if (b1type == -1) {
            b1 = 1
            b1type = fruit
        } else if (b2type == -1) {
            b2 = 1
            b2type = fruit
        } else {
            maxFruits = max(maxFruits, b1 + b2)
            b1 = fruitsInARow
            b1type = prevType
            b2 = 1
            b2type = fruit
        }
        if (fruit == prevType)
            fruitsInARow++
        else
            fruitsInARow = 1
        prevType = fruit
    }
    maxFruits = max(maxFruits, b1 + b2)
    return maxFruits
}