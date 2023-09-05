import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4158 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(br.readLine());
            }
            for (int j = 0; j < n; j++) {
                arr2[j] = Integer.parseInt(br.readLine());
            }

            int ptr1 = 0, ptr2 = 0;
            int count = 0;
            while(ptr1 < n && ptr2 < m){
                if(arr1[ptr1] < arr2[ptr2]){
                    ptr1++;
                } else if(arr1[ptr1] > arr2[ptr2]){
                    ptr2++;
                } else {
                    count++;
                    ptr1++;
                    ptr2++;
                }
            }
            System.out.println(count);
        }
    }
}
