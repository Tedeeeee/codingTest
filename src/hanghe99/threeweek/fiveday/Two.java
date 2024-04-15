package hanghe99.threeweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Two {

    public static void main(String [] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, total;
        Student students[]= new Student[101];
        List<Student> list= new ArrayList<>();

        N= Integer.parseInt(br.readLine());
        total= Integer.parseInt(br.readLine());

        st= new StringTokenizer(br.readLine());
        int num;
        for(int i=0; i<total; i++) {
            num= Integer.parseInt(st.nextToken());
            if(students[num]==null) {
                students[num]= new Student(num, 0, 0, false);
            }

            if(students[num].isPosted) {
                students[num].cnt++;
            }
            else {
                if(list.size()==N) {
                    list.sort(new Comparator<Student>() {
                        public int compare(Student o1, Student o2) {
                            if (o1.cnt == o2.cnt) {
                                return o1.time - o2.time;
                            }
                            return o1.cnt - o2.cnt;
                        }
                    });
                    list.get(0).isPosted=false;
                    list.remove(0);
                }
                students[num].cnt=1;
                students[num].time=i;
                students[num].isPosted=true;
                list.add(students[num]);
            }
        }

        list.sort((o1, o2) -> o1.idx - o2.idx);
        for(Student i: list) {
            System.out.print(i.idx+" ");
        }

    }

    static class Student{
        int idx;
        int cnt;
        int time;
        boolean isPosted;

        public Student(int idx, int cnt, int time, boolean isPosted) {
            this.idx = idx;
            this.cnt = cnt;
            this.time = time;
            this.isPosted = isPosted;
        }
    }
}
