import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012 {
    public static int[][] cabbages;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int bugs;
    public static int N, M, K;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbages = new int[M][N];
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                cabbages[a][b] = 1;
            }

            bugs = 0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && cabbages[i][j] == 1){
                        dfs(i, j);
                        bugs++;
                    }
                }
            }
            sb.append(bugs).append("\n");
        }
       System.out.print(sb);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N){
                if(!visited[nx][ny] && cabbages[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }
}
