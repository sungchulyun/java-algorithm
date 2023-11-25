package dp;

import java.io.*;
import java.util.StringTokenizer;

public class boj2294 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[K+1];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= K; i++){
            dp[i] = K+1;
        }

        dp[0] = 0;
        for(int coin : arr){
            for(int i = 1; i <= K; i++){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        int ans = dp[K];
        if(ans == K+1)
            bw.write(-1 + "\n");
        else
            bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
