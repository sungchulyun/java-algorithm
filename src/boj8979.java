import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class boj8979 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int end_point = 0;
        ArrayList<int[]> list = new ArrayList<>();
        int gold, silver, bronze;


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            gold = Integer.parseInt(st.nextToken());
            silver = Integer.parseInt(st.nextToken());
            bronze = Integer.parseInt(st.nextToken());
            list.add(new int[]{nation, gold, silver, bronze, 0});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    if(o1[2] == o2[2]){
                        return o2[3] - o1[3];
                    } else {
                        return o2[2] - o1[2];
                    }
                }
                return o2[1] - o1[1];
            }
        });

        list.get(0)[4] = 1;
        for(int i = 1; i < list.size(); i++){
            int tmp_gold = list.get(i-1)[1];
            int tmp_silver = list.get(i-1)[2];
            int tmp_bronze = list.get(i-1)[3];

            if(list.get(i)[0] == k){
                end_point = i;
            }
            if(list.get(i)[1] == tmp_gold && list.get(i)[2] == tmp_silver && list.get(i)[3] == tmp_bronze){
                list.get(i)[4] = list.get(i-1)[4];
            } else {
                list.get(i)[4] = list.get(i-1)[4] + 1;
            }
        }
        System.out.print(list.get(end_point)[4]);
    }
}
