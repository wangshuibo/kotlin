import java.util.*
import javax.print.DocFlavor

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

fun fiter(): MutableList<Int> {
    list!!.filter { it > 10 }.map { element -> element * 2 }
}


fun main(args: Array<String>) {

}