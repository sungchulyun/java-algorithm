package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9095 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];

            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;
            for(int i = 3; i <= N; i++){
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
            sb.append(dp[N-1]).append("\n");
        }
        System.out.println(sb);
    }
}
