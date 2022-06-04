

fun main(args: Array<String>) {
    val p: (String?) -> Unit = {
        println(it)
    }
//    val name: Any? = "hello"
//    val nothing: Nothing
//    val res = println("hello world")
//    println(res)
//    println(res)
    p("hello")
}