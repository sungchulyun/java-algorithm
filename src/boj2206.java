import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206 {
    static class Spot {
        int x;
        int y;
        int cnt;
        boolean isCrashed;
        Spot(int x, int y, int cnt, boolean isCrashed){
            this.x = x;
            this.y = y;
            this.cnt  = cnt;
            this.isCrashed = isCrashed;
        }
    }
    static int N, M;
    static int[][] arr;
    static boolean[][][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1 ,0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

    }
    public static void bfs(){
        Queue<Spot> q = new LinkedList<>();
        visited = new boolean[N][M][2];
        q.add(new Spot(0, 0,1, false));

        while(!q.isEmpty()){
            Spot s = q.poll();

            if(s.x == N - 1 && s.y == M - 1){
                System.out.println(s.cnt);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];


                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if(arr[nx][ny] == 0){
                    if(!s.isCrashed && !visited[nx][nx][0]){
                        q.add(new Spot(nx, ny, s.cnt + 1, false));
                        visited[nx][ny][0] = true;
                    } else if(s.isCrashed &&!visited[nx][ny][1]){
                        q.add(new Spot(nx, ny, s.cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                } else {
                    if(!s.isCrashed) {
                        q.add(new Spot(nx, ny, s.cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
