import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj3151 {
    static int[] arr;
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long result = 0;

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N-1; j++){
                int sum = arr[i] + arr[j];
                int lower = lowerBound(j+1, N, -sum);
                int upper = upperBound(j+1, N, -sum);
                result += (upper - lower);
            }
        }
        System.out.println(result);
    }

    public static int lowerBound(int left, int right, int target){
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    public static int upperBound(int left, int right, int target){
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] > target) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}
