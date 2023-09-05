import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654 {
    static int N, M;
    static int[] arr;
    static int[] nums;

    static boolean[] visit;
    static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        nums = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(N, M, 0);
        System.out.print(sb);
    }
    public static void dfs(int N, int M, int depth){
        if(depth == M){
            for(int val : nums){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                nums[depth] = arr[i];
                dfs(N , M , depth+1);

                visit[i] = false;
            }
        }

    }
}
