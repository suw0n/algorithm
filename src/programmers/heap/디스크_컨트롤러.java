package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    static class Job {

        int requestAt;
        int time;

        public Job(int requestAt, int time) {
            this.requestAt = requestAt;
            this.time = time;
        }
    }

    public int solution(int[][] jobs) {
        int sum = 0;
        int time = 0;
        int jobCnt = jobs.length;
        boolean isWorking = false;
        PriorityQueue<Job> que = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {

                return 0;
            }
        });

        for(int i = 0; i<jobCnt; i++) {
            que.add(new Job(jobs[i][0], jobs[i][1]));
        }

        while(!que.isEmpty()) {
            
        }

        return sum/jobCnt;
    }

}