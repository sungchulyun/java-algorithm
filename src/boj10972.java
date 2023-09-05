import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj10972 {
    static int N;
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }
    private static void nextPermutation(int[] arr){
        int n = arr.length;
        boolean flag = true;

        Loop1:
        for (int i = n - 1; i > 0; i--){

            if(arr[i - 1] < arr[i]){

                for(int j = n-1; j >= i; j--){

                    if(arr[j] > arr[i-1]){
                        int temp = arr[j];
                        arr[j] = arr[i-1];
                        arr[i-1] = temp;

                        int k = n - 1;

                        while(i < k ){
                            int temp2 = arr[i];
                            arr[i] = arr[k];
                            arr[k] = temp2;
                            i++;
                            k--;
                        }

                        flag = false;
                        break Loop1;
                    }
                }
            }
        }
        if(flag){
            System.out.print(-1);
        } else {
            for (int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
