import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class softeer_score_avg {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] scores = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr = new int[k][2];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        List<String> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int start = arr[i][0] - 1;
            int end = arr[i][1] - 1;
            double sum = 0.00;

            for(int j = start; j <= end; j++){
                sum += scores[j];
            }
            double avg = sum / (end - start + 1);
            avg = Math.round(avg * 100) / 100.0;
            list.add(String.format("%.2f", avg));
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
