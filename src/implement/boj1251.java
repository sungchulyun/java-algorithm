package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj1251 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        List<String> list = new ArrayList<>();

        for(int i = 1; i < st.length(); i++){
            for(int j = i + 1;j < st.length(); j++) {
                StringBuilder a = new StringBuilder(st.substring(0, i));
                StringBuilder b = new StringBuilder(st.substring(i, j));
                StringBuilder c = new StringBuilder(st.substring(j));
                StringBuilder sb = new StringBuilder();
                sb.append(a.reverse()).append(b.reverse()).append(c.reverse());
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
