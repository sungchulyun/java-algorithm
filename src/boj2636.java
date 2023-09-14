import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2636 {

    static class Spot{
        int x;
        int y;
        Spot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1 , 1};

    static boolean[][] visited;

    static int cheese;

    static int[][] map;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cheese++;
            }
        }
        int cheeseCount = 0;
        int time = 0;

        while(cheese != 0){
            cheeseCount = cheese;
            time++;
            visited = new boolean[N][M];
            bfs();
        }
        System.out.println(time);
        System.out.println(cheeseCount);


    }

    public static void bfs(){
        Queue<Spot> q = new LinkedList<>();
        q.add(new Spot(0,0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Spot s = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(map[nx][ny] == 0){
                        q.add(new Spot(nx, ny));
                    } else {
                        cheese--;
                        map[nx][ny] = 0;
                    }
                }
            }
        }

    }
}
