package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj10026 {

    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static char[][] arr;

    static boolean[][] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String st = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = st.charAt(j);
            }
        }

        visited = new boolean[n][n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        sb.append(cnt).append(" ");
        rg();
        cnt = 0;
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);

    }
    public static void bfs(int x, int y){
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    if(!visited[nx][ny] && arr[nx][ny] == arr[s.x][s.y]){
                        q.add(new Spot(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void rg(){
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                if(arr[i][j] == 'R'){
                    arr[i][j] = 'G';
                }
            }
        }
    }
}
