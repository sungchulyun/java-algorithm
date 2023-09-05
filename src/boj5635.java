import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.*;

public class boj5635 {

    public static class Member{
        String name;
        int birth_day;
        int birth_month;
        int birth_year;
        Member(String name, int day, int month, int year){
            this.name = name;
            this.birth_day = day;
            this.birth_month = month;
            this.birth_year = year;
        }
    }
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Member> memberList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            memberList.add(new Member(name, day, month, year));
        }

        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {

                if(o2.birth_year == o1.birth_year){
                    if(o2.birth_month == o1.birth_month){
                        return Integer.compare(o2.birth_day, o1.birth_day);
                    } else {
                        return Integer.compare(o2.birth_month, o1.birth_month);
                    }
                }
                return Integer.compare(o2.birth_year, o1.birth_year);
            }
        });

        System.out.println(memberList.get(0).name);
        System.out.print(memberList.get(memberList.size()-1).name);
    }
}
