package programmers.map;

import java.util.*;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> songMap = new HashMap<>();
        for(int i = 0; i<genres.length; i++) {
            String genre = genres[i];
            List<Integer> list;
            if(songMap.containsKey(genre)) {
                list = songMap.get(genre);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            songMap.put(genre, list);
        }

        int answerMax = 0;

        Map<String, Integer> genreSum = new HashMap<>();
        for(String genre : songMap.keySet()) {
            List<Integer> list = songMap.get(genre);
            answerMax += (Math.min(list.size(), 2));
            int sum = list.stream().mapToInt(i -> i).sum();
            genreSum.put(genre, sum);
        }

        int[] answer = new int[answerMax];

        for(int i = 0; i<answerMax; i++) {
            String bestGenre = "";
            int max = 0;
            for(String genre : genreSum.keySet()) {
                int sum = genreSum.get(genre);
                if(max < sum) {
                    max = sum;
                    bestGenre = genre;
                }
            }

            List<Integer> songs = songMap.get(bestGenre);

            if(songs == null) {
                System.out.println(answer[0] + ", " + answer[1]);
                System.out.println("songs is null : " + bestGenre + ", i = " + i);
            }

            try {
                songs.sort(Collections.reverseOrder());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if(songs.size()<2) {
                answer[i] = songs.get(i);
            } else {
                answer[i] = songs.get(i);
                answer[i+1] = songs.get(i+1);
            }

            genreSum.remove(bestGenre);
            songMap.remove(bestGenre);
        }

        return answer;
    }

    public static void main(String[] args) {
        베스트앨범 main = new 베스트앨범();
        System.out.println(Arrays.toString(main.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }

}

/**
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 *
 * 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.
 * */