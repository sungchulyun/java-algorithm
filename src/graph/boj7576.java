package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] arr;
    static Queue<Spot> q;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.add(new Spot(i, j));
                }
            }
        }

        System.out.println(bfs());
    }
    public static int bfs(){

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n)
                    continue;

                if(arr[nx][ny] == 0){
                    arr[nx][ny] = arr[s.x][s.y] + 1;
                    q.add(new Spot(nx, ny));
                }

            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    return -1;
                }
                if(arr[i][j] > max){
                    max = arr[i][j];
                }
            }
        }
        if(max == 1)
            return 0;
        else
            return max-1;
    }
}
