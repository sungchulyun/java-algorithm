import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10815 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] answer = new int[m];

        for(int i = 0;i < m; i++){
            int target = Integer.parseInt(st.nextToken());

            int low, mid, high;
            low = 0;
            high = arr.length;

            while(low < high){
                mid = (low + high) / 2;

                if(target == arr[mid]){
                    answer[i]++;
                    break;
                } else if(target < arr[mid]){
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            System.out.print(answer[i] + " ");
        }

    }
}
