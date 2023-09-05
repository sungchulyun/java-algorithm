import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj10026 {
    static int N;
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {-1, 0, 1, 0};
    static char[][] arr;
    static boolean[][] visited;

    public static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    cnt++;
                    bfs(i,j);
                }
            }
        }
        sb.append(cnt).append(" ");
        int normal = cnt;
        cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == 'R')
                    arr[i][j] = 'G';
            }
        }

        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(normal + " " + cnt);
        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + mx[i];
                int ny = s.y + my[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if(arr[nx][ny] != arr[x][y] || visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                q.add(new Spot(nx, ny));
            }
        }
    }
}
