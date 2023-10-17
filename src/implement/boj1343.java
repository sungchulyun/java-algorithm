package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1343 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        st = st.replaceAll("XXXX", "AAAA");
        st = st.replaceAll("XX", "BB");
        if(st.contains("X"))
            System.out.println(-1);
        else
            System.out.println(st);
    }
}
