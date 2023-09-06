import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj20300 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long max = Long.MIN_VALUE;

        if(N % 2 == 0){
            for(int i = 0; i < (N / 2) + 1; i++){
                max = Math.max(max, arr[i] + arr[N - 1 - i]);
            }
        } else {
            for(int i = 0; i < (N / 2) + 1; i++){
                max = Math.max(max, arr[i] + arr[N- 2 - i]);
            }
        }
        System.out.println(max);
    }
}
