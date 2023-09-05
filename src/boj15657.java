import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15657 {
    static int N, M;
    static int[] arr;

    static int[] nums;
    static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        nums = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.print(sb);
    }

    public static void dfs(int at, int depth){
        if(depth == M){
            for(int val : nums){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = at; i < N; i++){
            nums[depth] = arr[i];
            dfs(i, depth+1);

        }
    }
}
