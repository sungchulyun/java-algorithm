package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14501 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] t = new int[N+1];
        int[] p = new int[N+1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            t[i] = day;
            p[i] = pay;
        }

        int[] dp = new int[N+1];
        for(int i = 1; i < N; i++){
            if(t[i] + i <= N){
                dp[i+t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}
