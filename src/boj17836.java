import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17836 {
    static int N, M, T;
    static int[] mx = {0, 1, 0, -1};
    static int[] my = {1, 0, -1, 0};

    static int[][] maps;
    static boolean[][][] visited;

    static int cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0, 0);
        if(result == -1) System.out.println("Fail");
        else System.out.println(result);
    }

    public static class Spot {
        int x;
        int y;

        int count;

        boolean isGram;

        Spot(int x, int y, int count, boolean isGram) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isGram = isGram;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Spot> q = new LinkedList<>();
        visited[x][y][0] = true;
        q.add(new Spot(x, y, 0, false));

        while (!q.isEmpty()) {
            Spot s = q.poll();
            if(s.count > T) break;
            if(s.x == N - 1 && s.y == M - 1) return s.count;

            for (int i = 0; i < 4; i++) {
                int nx = s.x + mx[i];
                int ny = s.y + my[i];

                if(!s.isGram){  //검이 없을 때
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                        if(!visited[nx][ny][0] && maps[nx][ny] == 0){
                            q.add(new Spot(nx, ny, s.count + 1, false));
                            visited[nx][ny][0] = true;
                        } else if(!visited[nx][ny][0] && maps[nx][ny] == 2){
                            q.add(new Spot(nx, ny, s.count + 1, true));
                            visited[nx][ny][0] = true;
                        }
                    }
                } else {    //검이 있을 때
                    if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                        if(!visited[nx][ny][1]){
                            q.add(new Spot(nx, ny, s.count + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
