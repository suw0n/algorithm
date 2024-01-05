package heap;

import java.util.PriorityQueue;

public class 더_맵게 {

    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Long> que = new PriorityQueue<>();

        for(int s : scoville) {
            que.add((long) s);
        }

        while(que.size()>=2) {
            if(que.peek() >= K) {
                break;
            }

            long first = que.poll();
            long second = que.poll();
            que.add(first + second*2);
            cnt++;
        }

        if(que.peek()<K) {
            return -1;
        }

        return cnt;
    }

}