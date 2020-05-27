package kotlin_heros_practice4

import java.io.*
import java.util.*

fun main(args: Array<String>) {
    Thread(null, Runnable { D().solve() }, "1", 1 shl 26).start()
}

class D {
    internal class Task {
        fun solve(testNumber: Int, input: InputReader, out: PrintWriter) {
            var t = input.nextInt()
            while ((t--) > 0) {
                var n = input.nextInt()
                var arr = IntArray(n)
                var totalSize = 0
                for (i in 0 until n) {
                    arr[i] = input.nextInt()
                    totalSize += arr[i]
                }

                // 模拟
                var left = 0
                var right = n - 1
                var stepCount = 0
                var leftSize = 0
                var isFromLeft = true
                var preSize = 0
                while (left <= right) {
                    stepCount++
                    if (isFromLeft) {
                        var sum = 0
                        var nextLeft = -1
                        for (i in left..right) {
                            sum += arr[i]
                            if (sum > preSize) {
                                nextLeft = i + 1
                                break
                            }
                        }

                        leftSize += sum
                        if (nextLeft == -1) {
                            break
                        }
                        left = nextLeft
                        preSize = sum
                    } else {
                        var sum = 0
                        var nextRight = -1
                        for (i in right downTo left) {
                            sum += arr[i]
                            if (sum > preSize) {
                                nextRight = i - 1
                                break
                            }
                        }

                        if (nextRight == -1) {
                            break
                        }

                        right = nextRight
                        preSize = sum
                    }
                    isFromLeft = !isFromLeft
                }

                out.println("$stepCount $leftSize ${totalSize - leftSize}")
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


