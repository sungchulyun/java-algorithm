import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj7795 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arrA = new int[n];
            int[] arrB = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrB);
            int result = 0;

            for(int i = 0; i < n; i++){
                int left = 0;
                int right = m - 1;
                int index = 0;

                while(left <= right){
                    int mid = (left + right) / 2;
                    if(arrB[mid] < arrA[i]){
                        left = mid + 1;
                        index = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                result += index;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
