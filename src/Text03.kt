import java.util.*

/**
 * @author Mis Wang
 * @describe 第二天课程 kotlin代码风格
 */


/**
 * <h1>命名风格</h1>
 * <p>--使用骆驼命名法(在命名中避免下划线)</p>

 *<p>--类型名称首字母大写</p>

 *<p>--方法和属性首字母小写</p>

 *<p>--缩进用四个空格</p>

 *<p>--public 方法要写说明文档，这样它就可以出现在 Kotllin Doc 中</p>
 */


/**
 * 冒号
 * 在冒号区分类型和父类型中要有空格，在实例和类型之间是没有空格的
 */

interface Foo<out T : Any> : Bar {
    fun foo(a: Int): T
}

interface Bar {
    fun ff(b: String)
}

/**
 * Lambdas
 * 在Lambdas 表达式中，大括号与表达式间要有空格，箭头与参数和函数体间要有空格。
 * 尽可能得把Lambdas放在括号外面传入
 */
val list: MutableList<Int>? = Arrays.asList(40, 50, 60)

fun filter(): List<Int> {
    return list!!.filter { it > 40 }.map { element -> element * 2 }
}

/**
 * 类声明格式
 */
//1.参数比较少的类可以用一行表示
open class Person(id: Int, name: String)
//2.具有较多的参数的类应该格式化成每个构造函数的参数都位于与缩进的单独行中。
// 此外，结束括号应该在新行上。如果我们使用继承，那么超类构造函数调用或实现的接口列表应该位于与括号相同的行中

open class Persons(
        id: Int,
        name: String,
        surname: String
) : Person(id, name) {
    // ...
}

//3.对于多个接口，应该首先定位超类构造函数调用，然后每个接口应该位于不同的行中
//构造函数参数可以使用常规缩进或连续缩进（双倍正常缩进）
interface KotlinMaker {
    //...
}

class Personss(
        id: Int,
        name: String,
        surname: String
) : Person(id, name),
        KotlinMaker {
    // ...
}

/**
 * Unit 如果函数返回Unit，返回类型应该省略
 */
fun foo() { // ": Unit"被省略了
}

/**
 * 函数VS属性
 *
 * 在某些情况下，没有参数的函数可以与只读属性互换。尽管语义是相似的，但是有一些风格上的约定在什么时候更偏向于另一个。

 * 在下面的情况下，更偏向于属性而不是一个函数:

 * -- 不需要抛出异常 -- 拥有O(1)复杂度 -- 低消耗的计算(或首次运行结果会被缓存) -- 返回与调用相同的结果
 */


fun main(args: Array<String>) {
    println(filter().toString())
}