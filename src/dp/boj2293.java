package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2293 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[M+1];
        dp[0] = 1;
        for(int coin : arr){
            for(int j = coin; j <= M; j++){
                if(j - coin >= 0){
                    dp[j] += dp[j-coin];
                }
            }
        }
        System.out.println(dp[10]);
    }
}
