package dp;

import java.io.*;
import java.util.StringTokenizer;

public class boj11052 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) {
                if (j - i >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - i] + arr[i]);
                }
            }
        }
        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
