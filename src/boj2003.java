import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2003 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = 0, cnt = 0, sum = 0;

        while(true){
            if(sum >= M){
                sum -= arr[left++];
            }
            else if(right == N) break;

            else if(sum < M)
                sum += arr[right++];

            if(sum == M) cnt++;
        }
        System.out.println(cnt);
    }
}
