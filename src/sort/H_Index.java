package sort;

import java.util.Arrays;

public class H_Index {

    public int search(int[] arr, int length, int target) {
        int l = 0, r = length-1, mid = 0;

        while(l <= r) {
            mid = (l + r) / 2;

            if(target == arr[mid]) {
                return mid;
            } else if(target > arr[mid]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return arr[mid]<target ? mid+1 : mid;
    }

    public int solution(int[] citations) {
        int answer = -1;
        int n = citations.length;
        int h = 0;

        Arrays.sort(citations);

        while(true) {
            int index = search(citations, n, h);

            if(n-index >= h) {
                answer = h;
            } else {
                break;
            }

            h++;
        }

        return answer;
    }

}

/**
 * 문제 설명
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 *
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 *
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 * 입출력 예
 * citations	return
 * [3, 0, 6, 1, 5]	3
 * 입출력 예 설명
 * 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
 *
 * 문제가 잘 안풀린다면😢
 * 힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → 클릭
 *
 * ※ 공지 - 2019년 2월 28일 테스트 케이스가 추가되었습니다.
 *
 * https://en.wikipedia.org/wiki/H-index "위키백과" ↩
 * */