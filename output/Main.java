import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author yry
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task333 solver = new Task333();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task333 {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.readInt();
            out.println(n);
        }

    }

    static class InputReader extends InputStream {
        InputReader;

        int read();

        int readInt();

    }
}

