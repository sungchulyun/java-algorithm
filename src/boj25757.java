import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj25757 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());// 게임 참가할 사람
        String game = st.nextToken();   //할 게임
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }
        int participants = set.size();
        int count = 0;

        if(game.equals("Y")){
            while(true){
                participants--;
                if(participants < 0){
                    break;
                }
                count++;
            }
        } else if(game.equals("F")){
            while(true){
                participants -= 2;
                if(participants < 0){
                    break;
                }
                count++;}

        } else {
            while(true){
                participants -=3;
                if(participants < 0){
                    break;
                }
                count++;
            }

        }
        System.out.print(count);
    }
}
