/**
 * @author Mis Wang
 * @describe 第四天课程 基本类型
 */
//在 Kotlin 中，所有变量的成员方法和属性都是一个对象。一些类型是内建的，
// 它们的实现是优化过的，但对用户来说它们就像普通的类一样。
// 在这节中，我们将会讲到大多数的类型：数值，字符，布尔，以及数组。
/**
 * 数值
 * Kotlin 处理数值的方法和 java 很相似，但不是完全一样。
 * 比如，不存在隐式转换数值的精度，并且在字面上有一些小小的不同。
 *
 * Kotlin 提供了如下内建数值类型(和 java 很相似)：
 * 类型	    字宽
 * Double	 64
 * Float	 32
 * Long	     64
 * Int	     32
 * Short	 16
 * Byte	     8
 */

/**
 * 字面值常量
 * 主要是以下几种字面值常量:
 * --数型:123 --长整型要加大写L:123L --16进制:0x0f --二进制:0b00001011
 * 注意不支持八进制
 * Kotlin 也支持传统的浮点数表示:
 * -- 默认 Doubles : 123.5 , 123.5e10 -- Floats 要添加 f 或 F ：123.5f
 */

/**
 * 表示
 * 在 java 平台上，数值被 JVM 虚拟机以字节码的方式物理存储的，
 * 除非我们需要做可空标识(比如说 Int?) 或者涉及泛型。在后者中数值是装箱的。
 * 注意装箱过的数值是不保留特征的：
 */
//val a: Int = 10000
//print (a === a ) //打印 'true'
//val boxedA: Int? = a
//val anotherBoxedA: Int? = a
//print (boxedA === anotherBoxedA ) //注意这里打印的是 'false'
/**
 * 另一方面，它们是值相等的：
 */
//val a: Int = 10000
//print(a == a) // Prints 'true'
//val boxedA: Int? = a
//val anotherBoxedA: Int? = a
//print(boxedA == anotherBoxedA) // Prints 'true'

/**
 * 显示转换
 * 由于不同的表示，短类型不是长类型的字类型。
 */
//这是些伪代码，不能编译的
//val a: Int? =1 //一个装箱过的 Int (java.lang.Integer)
//val b: Long? = a // 一个隐式装箱的 Long (java.lang.Long)
//print( a == b )// 很惊讶吧　这次打印出的是 'false' 这是由于 Long 类型的 equals() 只有和 Long 比较才会相同
//因此不止是恒等，有时候连等于都会悄悄丢失。

//所以，短类型是不会隐式转换为长类型的。这意味着我们必须显式转换才能把 Byte 赋值给 Int

//val b: Byte = 1 // OK, literals are checked statically
//val i: Int = b //ERROR
//我们可以通过显式转换把数值类型提升

//val i: Int = b.toInt() // 显式转换
//每个数值类型都支持下面的转换：

//toByte(): Byte

//toShort(): Short

//toInt(): Int

//toLong(): Long

//toFloat(): Float

//toDouble(): Double

//toChar(): Char

//隐式转换一般情况下是不容易被发觉的，因为我们可以使用上下文推断出类型，并且算术运算会为合适的转换进行重载，比如

//val l = 1.toLong + 1 //Long  + Int => Long

/**
 * 运算符
 */
//Kotlin支持标准的算术运算表达式，这些运算符被声明为相应类的成员。参看运算符重载。

//至于位运算，Kotlin 并没有提供特殊的操作符，只是提供了可以叫中缀形式的方法，比如：

//val x = (1 shl 2) and 0x000FF000

//下面是全部的位运算操作符(只可以用在 Int 和 Long 类型)：

//--shl(bits) – 有符号左移 (Java 的 <<)
//--shr(bits) – 有符号右移 (Java 的 >>)
//--ushr(bits) – 无符号右移 (Java 的 >>>)
//--and(bits) – 位与
//--or(bits) – 位或
//--xor(bits) – 位异或
//--inv() – 位非

//浮点数比较
//相等性检测：a == b 与 a != b
//比较操作符：a < b、 a > b、 a <= b、 a >= b
//区间实例以及区间检测：a..b、 x in a..b、 x !in a..b
//当其中的操作数 a 与 b 都是静态已知的 Float 或 Double 或者它们对应的可空类型（声明为该类型，或者推断为该类型，
// 或者智能类型转换的结果是该类型），两数字所形成的操作或者区间遵循 IEEE 754 浮点运算标准。
//然而，为了支持泛型场景并提供全序支持，当这些操作符并非静态类型为浮点数（例如是 Any、 Comparable<……>、 类型参数）时，
// 这些操作使用为 Float 与 Double 实现的不符合标准的 equals 与 compareTo，这会出现：
//认为 NaN 与其自身相等
//认为 NaN 比包括正无穷大（POSITIVE_INFINITY）在内的任何其他元素都大
//认为 -0.0 小于 0.0
/**
 * 字符
 */
//字符用 Char 类型表示。它们不能直接当作数字
//
//fun check(c: Char) {
//    if (c == 1) { // 错误：类型不兼容
//        // ……
//    }
//}
//字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和
// \$。 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。

//我们可以显式把字符转换为 Int 数字：

//fun decimalDigitValue(c: Char): Int {
//    if (c !in '0'..'9')
//        throw IllegalArgumentException("Out of range")
//    return c.toInt() - '0'.toInt() // 显式转换为数字
//}
//当需要可空引用时，像数字、字符会被装箱。装箱操作不会保留同一性。
/**
 * 布尔
 */
//布尔用 Boolean 类型表示，它有两个值：true 和 false。
//若需要可空引用布尔会被装箱。
//内置的布尔运算有：
//--|| – 短路逻辑或
//--&& – 短路逻辑与
//--! - 逻辑非
/**
 * 数组
 */
//数组在 Kotlin 中使用 Array 类来表示，它定义了 get 和 set 函数（按照运算符重载约定这会转变为 []）和 size 属性，以及一些其他有用的成员函数：

//class Array<T> private constructor() {
//    val size: Int
//    operator fun get(index: Int): T
//    operator fun set(index: Int, value: T): Unit

//    operator fun iterator(): Iterator<T>
//    // ……
//}
//我们可以使用库函数 arrayOf() 来创建一个数组并传递元素值给它，这样 arrayOf(1, 2, 3) 创建了
// array [1, 2, 3]。 或者，库函数 arrayOfNulls() 可以用于创建一个指定大小的、所有元素都为空的数组。

//另一个选项是用接受数组大小和一个函数参数的 Array 构造函数，用作参数的函数能够返回给定索引的每个元素初始值：

//// 创建一个 Array<String> 初始化为 ["0", "1", "4", "9", "16"]
//val asc = Array(5, { i -> (i * i).toString() })
//如上所述，[] 运算符代表调用成员函数 get() 和 set()。

//注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。这意味着 Kotlin 不让我们把 Array<String>
// 赋值给 Array<Any>，以防止可能的运行时失败（但是你可以使用 Array<out Any>, 参见类型投影）。

//Kotlin 也有无装箱开销的专门的类来表示原生类型数组: ByteArray、 ShortArray、IntArray 等等。这些类和 Array
// 并没有继承关系，但是它们有同样的方法属性集。它们也都有相应的工厂方法:

//val x: IntArray = intArrayOf(1, 2, 3)
//x[0] = x[1] + x[2]

/**
 * 字符串
 */
//字符串用 String 类型表示。字符串是不可变的。 字符串的元素——字符可以使用索引运算符访问: s[i]。 可以用 for 循环迭代字符串:


//for (c in str) {
//    println(c)
//}
//Target platform: JVMRunning on kotlin v. 1.2.41
//可以用 + 操作符连接字符串。这也适用于连接字符串与其他类型的值， 只要表达式中的第一个元素是字符串：


//val s = "abc" + 1
//println(s + "def")
//Target platform: JVMRunning on kotlin v. 1.2.41
//请注意，在大多数情况下，优先使用字符串模板或原始字符串而不是字符串连接。

//字符串字面值
//Kotlin 有两种类型的字符串字面值: 转义字符串可以有转义字符，以及原始字符串可以包含换行和任意文本。转义字符串很像 Java 字符串:

//val s = "Hello, world!\n"
//转义采用传统的反斜杠方式。参见上面的 字符 查看支持的转义序列。

//原始字符串 使用三个引号（"""）分界符括起来，内部没有转义并且可以包含换行和任何其他字符:

//val text = """
//for (c in "foo")
//print(c)
//"""
//你可以通过 trimMargin() 函数去除前导空格：

//val text = """
//|Tell me and I forget.
//|Teach me and I remember.
//|Involve me and I learn.
//|(Benjamin Franklin)
//""".trimMargin()
//默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。

//字符串模板
//字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。 模板表达式以美元符（$）开头，由一个简单的名字构成:


//val i = 10
//println("i = $i") // 输出“i = 10”
//Target platform: JVMRunning on kotlin v. 1.2.41
//或者用花括号括起来的任意表达式:


//val s = "abc"
//println("$s.length is ${s.length}") // 输出“abc.length is 3”
//Target platform: JVMRunning on kotlin v. 1.2.41
//原始字符串和转义字符串内部都支持模板。 如果你需要在原始字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：

//val price = """
//${'$'}9.99
//"""
fun main(args: Array<String>) {
    val x = (1 shl 2) and 0x000FF000
    val loo = 3L + 4
    println(loo)

    val asc: Array<Int> = arrayOf(1, 2, 4)
    val kl: Array<String?> = arrayOfNulls(5)
    println(kl[0])

    val xs: IntArray = intArrayOf(1, 2, 3)
    xs[0] = xs[1] + xs[2]
    specialty("苹果", "橘子", "西瓜", addr = "address")
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
     """.trimMargin()
    println(text)
}

/**
 * @param vararg 表示不定数量的参数
 */
fun specialty(vararg fruits: String, addr: String) {
    for (fruit in fruits) {
        println("fruit:$fruit, addr: $addr")
    }
}
