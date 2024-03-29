import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2805 {
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

        Arrays.sort(arr);

        int left = 0;
        int right = arr[N-1];

        while(left < right){
            int mid = (left + right) / 2;
            long answer = 0;

            for(int i = 0; i < N; i++){
                if(arr[i] > mid){
                    answer += (arr[i] - mid);
                }
            }

            if(answer < M){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
