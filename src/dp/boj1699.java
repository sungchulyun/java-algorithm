package dp;

import java.io.*;

public class boj1699 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int i = 1; i <= N; i++){
            dp[i] = N+1;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j*j <= i; j++){
                if(i- j * j >= 0){
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
