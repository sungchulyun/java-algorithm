import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1417 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        int[] candidates = new int[n-1];
        int count = 0;
        for(int i = 0; i < n-1; i++){
            candidates[i] = Integer.parseInt(br.readLine());
        }
        //arr[2] 0 1 2 length : 3

        while(true){

            boolean flag = true;
            Arrays.sort(candidates);
            int last = candidates.length-1;

            if(dasom <= candidates[candidates.length-1]){
                dasom++;
                candidates[last]--;
                count++;
                flag = false;
            }
            if(flag)
                break;
        }
        System.out.print(count);
    }
}
