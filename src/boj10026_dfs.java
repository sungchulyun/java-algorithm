import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026_dfs {
    public static int N;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};

    public static char[][] arr;
    public static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    count++;
                    dfs(i, j);
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 'R'){
                    arr[i][j] = 'G';
                }
            }
        }
        int normal = count;
        count = 0;
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    count++;
                    dfs(i, j);
                }
            }
        }

        System.out.print(normal + " " + count);


    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                if(!visited[nx][ny] && arr[nx][ny] == arr[x][y]){
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}
