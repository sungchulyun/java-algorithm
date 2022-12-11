package samsung01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bog1012 {
	static int[][] arr;
	static boolean[][] visited;
	static int[] moveX = {1, -1, 0, 0};
	static int[] moveY = {0, 0, 1, -1};
	static int N;
	static int M;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int []count = new int[T];
		int bugs = 0;
		for(int k = 0; k<T; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visited = new boolean[M][N];
			for(int i = 0; i<K; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(str.nextToken());
				int b = Integer.parseInt(str.nextToken());
				arr[a][b] = 1;
			}
			visited[0][0] = false;
			for(int i = 0; i<M; i++) {
				for(int j = 0; j<N; j++) {
					if(arr[i][j] == 1 && visited[i][j] == false) {
						bfs(i,j);
						count[k]++;
					}
				}
			}
			System.out.println(count[k]);
		}
	}
	public static void bfs(int x, int y) {
		Queue<spot> q = new LinkedList<>();
		q.add(new spot(x,y));
		
		while(!q.isEmpty()) {
			spot s = q.poll();
			for(int i = 0; i<4; i++) {
				int nowX = s.x + moveX[i];
				int nowY = s.y + moveY[i];
				
				if(nowX < 0 || nowY < 0 || nowX >= M || nowY >= N) {
					continue;
				}
				if(arr[nowX][nowY] == 0 || visited[nowX][nowY]) {
					continue;
				}
				visited[nowX][nowY] = true;
				q.add(new spot(nowX, nowY));
			}
		}
	}
}
class spot{
	int x;
	int y;
	spot(int x, int y){
		this.x = x;
		this.y= y;
	}
}
