import java.awt.Cursor

/**
 * @author Mis Wang
 * @describe 第四天课程 Edit Page控制流：if、when、for、while
 */


/**
 * If表达式
 */
//在 Kotlin 中，if是一个表达式，即它会返回一个值。 因此就不需要三元运算符（条件 ? 然后 : 否则），
// 因为普通的 if 就能胜任这个角色。

// 传统用法
// val a = 4
//val b = 3
//var min = b
//var max = a
//if (a < b) max = b

// With else
//var max: Int
//if (a > b) {
//    max = a
//} else {
//    max = b
//}

// 作为表达式
//val max = if (a > b) a else b

//if的分支可以是代码块，最后的表达式作为该块的值：
//val max = if (a > b) {
//print("Choose a")
//a
//} else {
//    print("Choose b")
//    b
//}
/**
 * When 表达式
 */
//when取代了类C语言的switch操作符。如下:
//when (x) {
//    1 -> print("x == 1")
//    2 -> print("x == 2")
//    else -> { // 注意这个块
//        print("x is neither 1 nor 2")
//    }
//}
//when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。 when 既可以被当做表达式使用也可以被当做语句使用。
// 如果它被当做表达式， 符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。（像 if 一样，
// 每一个分支可以是一个代码块，它的值是块中最后的表达式的值。）

//如果其他分支都不满足条件将会求值 else 分支。 如果 when 作为一个表达式使用，则必须有 else 分支， 除非编译器能够检测出所有的可能情况都已经覆盖了。

//如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：

//when (x) {
//    0, 1 -> print("x == 0 or x == 1")
//    else -> print("otherwise")
//}
//我们可以用任意表达式（而不只是常量）作为分支条件
//
//when (x) {
//    parseInt(s) -> print("s encodes x")
//    else -> print("s does not encode x")
//}
//我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
//
//when (x) {
//    in 1..10 -> print("x is in the range")
//    in validNumbers -> print("x is valid")
//    !in 10..20 -> print("x is outside the range")
//    else -> print("none of the above")
//}
//另一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值。注意： 由于智能转换，你可以访问该类型的方法和属性而无需任何额外的检测。

//fun hasPrefix(x: Any) = when(x) {
//    is String -> x.startsWith("prefix")
//    else -> false
//}
//when 也可以用来取代 if-else if链。 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支：

//when {
//    x.isOdd() -> print("x is odd")
//    x.isEven() -> print("x is even")
//    else -> print("x is funny")
//}

/**
 * for 循环
 */
//for 循环可以对任何提供迭代器（iterator）的对象进行遍历，这相当于像 C# 这样的语言中的 foreach 循环。语法如下：
//
//for (item in collection) print(item)
//循环体可以是一个代码块。
//
//for (item: Int in ints) {
//    // ……
//}
//如上所述，for 可以循环遍历任何提供了迭代器的对象。即：
//
//有一个成员函数或者扩展函数 iterator()，它的返回类型
//有一个成员函数或者扩展函数 next()，并且
//有一个成员函数或者扩展函数 hasNext() 返回 Boolean。
//这三个函数都需要标记为 operator。
//
//如需在数字区间上迭代，请使用区间表达式:

// for (i in 6 downTo 0 step 2)  downTo 倒序 6,5,4,3,2,1,0
// step 取俩个数值相差的值是不是相差2,如果step的值大于6还是取6

//for (i in 1..3) {
//    println(i)
//}
//for (i in 6 downTo 0 step 2) {
//    println(i)
//}
//
//对区间或者数组的 for 循环会被编译为并不创建迭代器的基于索引的循环。
//
//如果你想要通过索引遍历一个数组或者一个 list，你可以这么做：
//
//
//1
//fun main(args: Array<String>) {
//    2
//    val array = arrayOf("a", "b", "c")
//    3
//    for (i in array.indices) {
//        4
//        println(array[i])
//        5
//    }
//    6
//}
//
//或者你可以用库函数 withIndex：
//
//fun main(args: Array<String>) {
//    2
//    val array = arrayOf("a", "b", "c")
//    3
//    for ((index, value) in array.withIndex()) {
//        4
//        println("the element at $index is $value")
//        5
//    }
//    6
//}
/**
 * While 循环
 */
//while 和 do..while 照常使用

//while (x > 0) {
//    x--
//}

//do {
//    val y = retrieveData()
//} while (y != null) // y 在此处可见


fun main(args: Array<String>) {
    val a = 3
    val b = 4
    var max = b
    var min = a
    if (a < b) max = b


    when (b) {
        3, 5 -> println("是对的")
        else -> println("是错的")
    }
    when {
        a < b -> println("是对的")
        else -> println("是错的")
    }
    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println(array[i])
    }

    for ((index, values) in array.withIndex()) {
        println("the element at $index is $values")
    }
    for (i in 5 downTo 0 step 3) {
        println(i)
    }
}

