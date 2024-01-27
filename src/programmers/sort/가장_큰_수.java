package programmers.sort;

import java.util.*;

public class 가장_큰_수 {

    public String solution(int[] numbers) {
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            String s1 = "" + o1 + o2;
            String s2 = "" + o2 + o1;

            return s2.compareTo(s1);
        });

        for (int number : numbers) {
            que.add(number);
        }

        if(que.peek()==0) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i<numbers.length; i++) {
            answer.append(que.poll());
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        가장_큰_수 main = new 가장_큰_수();

        int[] input = {3, 30, 34, 5, 9};
        System.out.println(main.solution(input));

        int[] input2 = {0, 0, 0};
        System.out.println(main.solution(input2));

        int[] input3 = {979, 97, 978, 81, 818, 817};
        System.out.println(main.solution(input3));
    }

}

/**
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 입출력 예
 * numbers	return
 * [6, 10, 2]	"6210"
 * [3, 30, 34, 5, 9]	"9534330"
 * */