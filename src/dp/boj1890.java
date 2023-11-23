package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1890 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        int[][] dp= new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(dp[i][j] > 0 && arr[i][j] > 0){
                    int jump = arr[i][j];

                    if(jump + j <= N){
                        dp[i][j+jump] += dp[i][j];
                    }
                    if(jump + i <= N){
                        dp[i+jump][j] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[N][N]);
    }
}
