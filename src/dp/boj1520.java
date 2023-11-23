package dp;

import java.io.*;
import java.util.StringTokenizer;

public class boj1520 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] dp;
    static int[][] arr;

    static int N, M;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        dp= new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        bw.write(dfs(1,1) + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
    public static int dfs(int x, int y){

        if(x == N && y == M){
            return 1;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 1 || ny < 1 || nx > N || ny > M){
                continue;
            }
            if(arr[nx][ny] < arr[x][y]){
                dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}
