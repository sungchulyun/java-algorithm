import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class obj2578 {
    public static int[][] arr;
    public static int count;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        count = 0;

        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int a = 1; a <= 25; a++){

            StringTokenizer str = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(str.nextToken());

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(arr[i][j] == num){
                        arr[i][j] = 0;
                    }
                }
            }
            rCheck();
            cCheck();
            leftCheck();
            rightCheck();

            if(count >= 3){
                System.out.println(a);
                break;
            }
            count = 0;
        }
    }
    public static void rCheck(){

        for(int i = 0; i < 5; i++){
            int zerocount = 0;
            for(int j =0; j <5; j++){
                if(arr[i][j] == 0){
                    zerocount++;
                }
                if(zerocount == 5)
                    count++;
            }
        }
    }

    public static void cCheck(){

        for(int i = 0; i <5; i++){
            int zerocount = 0;
            for(int j = 0; j < 5; j++){
                if(arr[j][i] == 0)
                    zerocount++;
            }
            if(zerocount == 5)
                count++;
        }
    }

    public static void leftCheck(){
        int zerocount = 0;
        for(int i = 0; i < 5; i++){

            for(int j = i+1; j < 5; j++){
                if(arr[i][j] == 0) zerocount++;
            }
            if(zerocount == 5)
                count++;
        }
    }

    public static void rightCheck() {
        int zerocount = 0;
        for(int i = 0; i < 5; i++){
            if(arr[i][4-i] == 0) zerocount++;
        }
        if(zerocount == 5) count++;
    }
}
