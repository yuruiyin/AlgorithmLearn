package kotlin_heros_practice4

import java.io.*
import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) {
    Thread(null, Runnable { C().solve() }, "1", 1 shl 26).start()
}

class C {
    internal class Task {
        fun solve(testNumber: Int, input: InputReader, out: PrintWriter) {
            var t = input.nextInt()
            while ((t--) > 0) {
                var n = input.nextInt()
                val list = mutableListOf<Int>()
                var idx = 0
                while (n > 0) {
                    val curDigit = n % 10
                    if (curDigit != 0) {
                        list.add((curDigit * 10.0.pow(idx)).toInt())
                    }
                    idx++;
                    n /= 10
                }

                out.println(list.size)
                list.forEach {
                    out.print("$it ")
                }
                out.println()
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


