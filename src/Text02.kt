import java.util.*

/**
 * @author Mis Wang
 * @describe 第二天课程 kotlin习惯用语
 */

val lists: MutableList<Int>? = Arrays.asList(10, 99, 88, 60)
var map: MutableMap<Int, String>? = null
val mm = mapOf("a" to 1, "b" to 2, "c" to 3)
fun main(args: Array<String>) {
    val users1 = User("张三", 18)
    //复制函数---修改某些属性但想要其他部分不变
    val users2 = users1.copy(name = "王五")
    println(users1.name + "copy==age=" + users2.age)
    //获取过滤List
    val positives = lists?.filter {
        it > 60
    }
    //或者等于
    val positives2 = lists!!.filter { x -> x > 60 }
    println("获取过滤List=$positives")
    //创建Map集合
    map = mutableMapOf()
    for (name: Int in IntRange(0, 10)) {
        map!![name] = "张三"
    }

    for ((k, v) in map!!) {
        println("$k -> $v")
    }

    for ((k, v) in mm) {
        println("$k -> $v")
    }

    /**
     * 元组（Tuple），给多个变量同时赋值，分二元（Pair）和三元（Triple）
     */
    val (year, month, day) = Triple(2017, "6月", "14号")
    println("${year}年$month$day")
    val date = Triple(2017, "6月", "14号")
    println("${date.first}年${date.second}${date.third}")
    /**
     * 元组（Tuple），给多个变量同时赋值，分二元（Pair）和三元（Triple）
     */
    val (years, months) = Pair(2017, "6月")
    println("${years}年$months")
    val dates = Pair(2017, "6月")
    println("${dates.first}年${dates.second} ")
    println("lazy==$p")
}

//懒属性(延迟加载)
val p: String by lazy {
    return@lazy "张三"
}

/**
 * 一个只保存数据的类
 */
data class User(val name: String, val age: Int)

/**
 * 函数默认值
 */
fun foo(a: Int = 0, b: String = "") {

}