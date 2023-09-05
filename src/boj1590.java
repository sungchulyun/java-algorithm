import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1590 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //버스 갯수
        int T = Integer.parseInt(st.nextToken());   //터미널 도착 시간
        Long[] starTime = new Long[N];
        Long[] interval = new Long[N];
        Long[] buses = new Long[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            starTime[i] = Long.parseLong(st.nextToken()); //버스 첫 운행
            interval[i] = Long.parseLong(st.nextToken()); //배차 간격
            buses[i] = Long.parseLong(st.nextToken());    //버스 갯수
        }

        long waiting = 0;
        List<Long> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int a = Math.toIntExact(buses[i]);
            Long[] driving = new Long[a];  //버스 모음
            for(int j = 0; j < buses[i]; j++){
                driving[j] = starTime[i] + (interval[i] * j);
            }
            if(driving[0] >= T){
                list.add(driving[0] - T);
            } else if(driving[driving.length - 1] < T){
                list.add((long) -1);
            }
            Arrays.sort(driving);
            long left = 0;
            long right = driving.length-1;

            while(left < right){
                long mid = (left + right) / 2;
                if(T < driving[(int)mid])
                    right = mid;
                else
                    left = mid + 1;
            }
            waiting = driving[(int)right] - T;
            list.add(waiting);
        }
        Collections.sort(list);
        if(list.get(0) < 0){
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(0));
    }
}
