import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj17413 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <str.length(); i++){

            if(str.charAt(i) == '<'){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    flag = true;

            } else if(str.charAt(i) == '>'){
                sb.append(str.charAt(i));
                flag = false;
                continue;
            }

            if(flag == true){
                sb.append(str.charAt(i));

            } else if(flag == false){
                if(str.charAt(i) == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(str.charAt(i));
                }
            }
            if(i == str.length() - 1){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}