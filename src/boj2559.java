import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2559 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int i = 1;
        while(i <= K){
            sum += arr[i++];
        }
        int max = sum;
        for(int s = K+1, j = 1; s <= N; s++, j++){
            sum += arr[s] - arr[j];
            if(max < sum) max = sum;
        }

        System.out.println(max);
    }
}
