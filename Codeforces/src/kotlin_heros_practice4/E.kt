package kotlin_heros_practice4

import java.io.*
import java.util.*

fun main(args: Array<String>) {
    Thread(null, Runnable { E().solve() }, "1", 1 shl 26).start()
}

class E {
    internal class Task {
        fun solve(testNumber: Int, input: InputReader, out: PrintWriter) {
            var t = input.nextInt()
            while ((t--) > 0) {
                var n = input.nextInt()
                if (n <= 3) {
                    out.println(-1)
                    continue
                }

                val list = LinkedList<Int>()
                list.offer(3)
                list.offer(1)
                list.offer(4)
                list.offer(2)

                var cur = 4
                while (cur < n) {
                    cur++
                    if (cur % 2 == 1) {
                        list.addLast(cur)
                    } else{
                        list.addFirst(cur)
                    }
                }

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


