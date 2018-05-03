/**
 * @author Mis Wang
 * @describe 基本类型
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

//shl(bits) – 带符号左移 (相当于 Java’s <<) shr(bits) – 带符号右移 (相当于 Java’s >>) ushr(bits)
// – 无符号右移 (相当于 Java’s >>>) and(bits) – 按位与 or(bits) – 按位或 xor(bits) – 按位异或 inv(bits) – 按位翻转

fun main(args: Array<String>) {
    val x = (1 shl 2) and 0x000FF000
    println(x)
}