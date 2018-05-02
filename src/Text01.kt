import java.util.*


/**
 * @author Mis Wang
 * @describe 第一天课程 Kotlin基本语法
 */

/**
 * @param a Int参数
 * @param b Int参数
 * @return Int整型
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * @describe sum函数写法也可以等价于 sum==sum1
 */
fun sum1(a: Int, b: Int) = a + b

/**
 *@describe 返回一个没有意义的值 Unit 返回类型可以省略
 */
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

/**
 * @describe 使用条件表达式
 */
fun maxOf(a: Int, b: Int): Int {
    if (a > b)
        return a
    else
        return b
}

/**
 * @describe  if (a > b)return a else return b可以等价于
 *
 */
fun maxOf1(a: Int, b: Int): Int {
    return when {
        a > b -> a
        else -> b
    }

}

/**
 * @describe 使用可空变量以及空值检查
 */
fun parseInt(str: String?): String? {

    return str
}

/**
 * 程序主入口
 */
fun main(args: Array<String>) {
    print("sum 3 of and 5 is ")
    println(sum(3, 5))
    println("sum 19 of and 23 is ${sum1(19, 23)}")
    printSum(-1, 8)

    /**
     *  定义局部变量
     */
    //1.声明常量
    val a: Int = 1  //立即初始化
    val b = 2      //推导出Int型
    val c: Int     //当没有初始化值时必须声明类型
    c = 3          //赋值
    //2.声明变量
    var x = 5//推导出Int型
    x += 1
    println("x = $x")
    //使用字符串模板
    var aa = 1
    //使用变量名作物模板
    val s1 = " aa is $a"
    aa = 2
    //使用表达式作为模板
    val s2 = "${s1.replace("is", "was")}, but now is $aa"
    println(s2)
    //使用条件表达式
    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("max of 0 and 42 is ${maxOf1(0, 42)}")

    var lists = Arrays.asList("a", "b", "c", "d")
    //item:String指明类型
    for (item: String in lists) {
        println(item)
    }
    //item变量名
    for (item in lists) {
        println(item)
    }

    //当 str 中不包含整数时返回空: 说明str: String?变量带有?可以传null
    println(parseInt(null))

}


