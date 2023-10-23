package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7569 {
    static class Spot{
        int x;
        int y;
        int z;
        Spot(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }
    static int n, m, h;
    static int[][][] arr;
    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, -1, 1, 0, 0};

    static Queue<Spot> q;

    static int max = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[m][n][h];
        q = new LinkedList<>();

        for(int k = 0; k < h; k++){
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1){
                        q.add(new Spot(i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 6; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];
                int nz = s.z + dz[i];

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h){
                    if(arr[nx][ny][nz] == 0){
                        arr[nx][ny][nz] = arr[s.x][s.y][s.z] + 1;
                        q.add(new Spot(nx, ny, nz));
                    }
                }
            }
        }
        for(int k = 0; k < h; k++){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j][k] == 0)
                        return -1;
                    if(arr[i][j][k] > max){
                        max = arr[i][j][k];
                    }
                }
            }
        }
        if(max == 1)
            return 0;
        else
            return max - 1;
    }
}
