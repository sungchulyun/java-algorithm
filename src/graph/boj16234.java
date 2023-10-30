package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16234 {
    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n,l,r;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Queue<Integer> populations;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bfs(i,j);
                int moveAble = populations.size();
                if(moveAble > 1){
                    movements();
                    cnt++;
                }

            }
        }
        System.out.println(cnt);
    }
    public static void bfs(int x, int y){
        populations = new LinkedList<>();
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(x, y));
        populations.add(arr[x][y]);
        visited = new boolean[n][n];
        visited[x][y] = true;

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    int diff = Math.abs(arr[nx][ny] - arr[s.x][s.y]);
                    if(l <= diff && diff <= r && !visited[nx][ny]){
                        q.add(new Spot(nx, ny));
                        populations.add(arr[nx][ny]);
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
    public static void movements(){
        int size = populations.size();
        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += populations.poll();
        }
        int avg = sum / size;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j])
                    arr[i][j] = avg;
            }
        }
    }
}
