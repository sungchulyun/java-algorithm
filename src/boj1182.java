import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182 {
    static int N, S;
    static int[] arr;
    static int answer = 0;

    static boolean[] visit;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0 ,0);
        System.out.print(answer);
    }
    public static void dfs(int i, int cnt){
       if(i == N)
           return;
       else {
           if(arr[i] + cnt == S){
               answer++;
           }
           dfs(i + 1, cnt);
           dfs(i + 1, cnt + arr[i]);
       }
    }
}
