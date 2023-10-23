package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206 {
    static class Spot{
        int x;
        int y;
        int cnt;
        boolean isCrashed;
        Spot(int x, int y, int cnt, boolean isCrashed){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isCrashed = isCrashed;
                }
    }
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][][] visited;
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
    }
    public static void bfs(){
        Queue<Spot> queue = new LinkedList<>();
        visited = new boolean[n][m][2];
        queue.add(new Spot(0, 0, 1, false));

        while(!queue.isEmpty()){
            Spot s = queue.poll();

            if(s.x == n-1 && s.y == m-1){
                System.out.println(s.cnt);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if(arr[nx][ny] == 0){
                    if(!s.isCrashed && !visited[nx][ny][0]){
                        queue.add(new Spot(nx, ny, s.cnt + 1, false));
                        visited[nx][ny][0] = true;
                    } else if(s.isCrashed && !visited[nx][ny][1]){
                        queue.add(new Spot(nx, ny, s.cnt+1, true));
                        visited[nx][ny][1] = true;
                    }
                } else {
                    if(!s.isCrashed){
                        queue.add(new Spot(nx, ny, s.cnt+1, true));
                        visited[nx][ny][1] = true;
                    }

                }
            }
        }
        System.out.println(-1);
    }
}
