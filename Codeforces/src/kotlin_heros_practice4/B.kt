package kotlin_heros_practice4

import java.io.*
import java.util.*
import kotlin.math.*

fun main(args: Array<String>) {
    Thread(null, Runnable { B().solve() }, "1", 1 shl 26).start()
}

class B {

    internal class Task {
        fun solve(testNumber: Int, input: InputReader, out: PrintWriter) {
            var t = input.nextInt()
            while ((t--) > 0) {
                var a1 = input.nextInt()
                var b1 = input.nextInt()
                var a2 = input.nextInt()
                var b2 = input.nextInt()

                var min1 = min(a1, b1)
                var max1 = max(a1, b1)
                var min2 = min(a2, b2)
                var max2 = max(a2, b2)

                if (max1 != max2 || min1 + min2 != max1) {
                    out.println("No")
                    continue
                }

                out.println("Yes")
            }
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


}



