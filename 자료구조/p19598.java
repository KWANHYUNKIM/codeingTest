import java.util.*;
import java.io.*;

class Lecture {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class p19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            lectures.add(new Lecture(start, end));
        }
        lectures.sort(Comparator.comparingInt(lecture -> lecture.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 강의실 배정
        for (Lecture lecture : lectures) {
            if (!pq.isEmpty() && pq.peek() <= lecture.start) {
                pq.poll(); 
            }
            pq.add(lecture.end);
        }

        System.out.println(pq.size());
    }
}
