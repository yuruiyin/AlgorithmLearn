package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Input
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class Input {

    private StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public int nextInt() throws IOException {
        in.nextToken();
        return (int)in.nval;
    }
    public long nextLong() throws IOException {
        in.nextToken();
        return (long)in.nval;
    }

}
