package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visited;
    static int[][] arr;
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));

    }
    public static int bfs(int x, int y){
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Spot s = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + s.x;
                int ny = dy[i] + s.y;

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(!visited[nx][ny] && arr[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.add(new Spot(nx, ny));
                        arr[nx][ny] = arr[s.x][s.y] + 1;
                    }
                }
            }
        }
        return arr[N-1][M-1];
    }
}
