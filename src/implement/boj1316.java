package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1316 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String st = arr[i];
            if(check(st))
                answer++;
        }
        System.out.println(answer);
    }

    public static boolean check(String st) {
        boolean[] check = new boolean[26];
        char prev = '0';

        for (int j = 0; j < st.length(); j++) {
            char c = st.charAt(j);

            if (prev != c) {
                if (!check[c - 'a']) {
                    check[c - 'a'] = true;
                    prev = c;
                } else {
                    return false;
                }
            } else {
                continue;
            }
        }
        return true;
    }
}