import java.io.*
import java.util.*

fun main(args: Array<String>) {
    Thread(null, Runnable { solve() }, "1", 1 shl 26).start()
}

internal class Task {
    fun solve(testNumber: Int, input: InputReader, out: PrintWriter) {
        // TODO
    }
}

fun solve() {
    val inputStream = System.`in`
    val outputStream: OutputStream = System.out
    val `in` = InputReader(inputStream)
    val out = PrintWriter(outputStream)
    val task = Task()
    task.solve(1, `in`, out)
    out.close()
}

internal class InputReader(stream: InputStream?) {
    private val reader by lazy {
        BufferedReader(InputStreamReader(stream), 32768)
    }

    private var tokenizer: StringTokenizer? = null

    operator fun next(): String {
        while (tokenizer == null || !tokenizer!!.hasMoreTokens()) {
            tokenizer = try {
                StringTokenizer(reader.readLine())
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
        return tokenizer!!.nextToken()
    }

    fun nextInt(): Int = next().toInt()
    fun nextLong(): Long = next().toLong()
    fun nextDouble(): Double = next().toDouble()
}


