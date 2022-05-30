import java.util.LinkedList

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */

class MyHashMap {
    private val base: Int = 10000
    private val data = Array<LinkedList<MutableList<Int>>?>(base) { null }

    fun put(key: Int, value: Int) {
        val pos = key.hashCode() % base
        val list = data[pos]
        if (list == null) {
            data[pos] = LinkedList()
            data[pos]?.add(mutableListOf(key, value))
            return
        }
        var found = false
        run lit@ {
            list.forEach {
                if (it[0] == key) {
                    it[1] = value
                    found = true
                    return@lit
                }
            }
        }
        if (!found) {
            list.addLast(mutableListOf(key, value))
        }
    }

    fun get(key: Int): Int {
        val pos = key.hashCode() % base
        val list = data[pos] ?: return -1
        list.forEach {
            if (it[0] == key)
                return it[1]
        }
        return -1
    }

    fun remove(key: Int) {
        val pos = key.hashCode() % base
        val list = data[pos] ?: return
        list.forEach {
            if (it[0] == key) {
                list.remove(it)
                return
            }
        }
    }
}