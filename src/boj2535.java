import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class boj2535 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][]records = new int[n][3];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nation = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            records[i][0] = nation;
            records[i][1] = num;
            records[i][2] = score;
        }

        Arrays.sort(records, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        int limit = 2;
        if(records[0][0] == records[1][0]){
            for(int i = 2; i < n; i++){
                if(records[0][0] != records[i][0]){
                    limit = i;
                    break;
                }
            }
        }
        System.out.println(records[0][0]);
        System.out.println(records[1][0]);
        System.out.println(records[limit][0]);

    }
}
