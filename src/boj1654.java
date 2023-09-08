import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1654 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long left = 0, right = arr[arr.length-1];
        right++;

        while(left < right){
            long mid = (left + right) / 2;
            long sum = 0;

            for(int i = 0; i < arr.length; i++){
                sum += (arr[i] / mid);
            }

            if(sum < N)
                right = mid;
            else
                left = mid + 1;
        }
        System.out.println(left-1);
    }
}
