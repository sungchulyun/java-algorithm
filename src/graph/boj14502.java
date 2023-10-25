package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502 {
    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[][] arr;
    static int[][] copyarr;
    static Queue<Spot> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int max = Integer.MIN_VALUE;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }
    public static void dfs(int wall){

        if(wall == 3){
            max = Math.max(max, bfs());
            return;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }

    }
    public static int bfs(){

        q = new LinkedList<>();
        copyarr = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyarr[i][j] = arr[i][j];
                if(arr[i][j] == 2){
                    q.add(new Spot(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    if(copyarr[nx][ny] == 0){
                        copyarr[nx][ny] = 2;
                        q.add(new Spot(nx, ny));
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copyarr[i][j] == 0){
                    sum++;
                }
            }
        }
        return sum;
    }
}
