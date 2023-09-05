import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1205 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if(n == 0){
            System.out.print(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list, Collections.reverseOrder());

        if(n == p && score <= list.get(list.size()-1)){
            System.out.println(-1);
            return;
        } else {
            int rank = 1;
            for(int i = 0; i < list.size(); i++){
                if(score < list.get(i))
                    rank++;
                else
                    break;
            }
            System.out.print(rank);
        }
    }
}
