import java.util.*;
import java.io.*;

public class p18115 {

    static class Card {
        int value; // 카드 값
        int index; // 인덱스 값

        public Card(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 카드 개수 입력
        String[] input = br.readLine().split(" "); // 기술 배열 입력
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]); // 기술 배열 정수 변환
        }

        LinkedList<Card> list = new LinkedList<>(); // 카드 상태를 저장할 LinkedList 생성

        for (int i = N; i >= 1; i--) {
            int technique = A[i - 1];
            Card card = new Card(i, i); // 카드의 값과 인덱스 저장

            if (technique == 1) {
                list.addFirst(card); // 맨 위에 추가
            } else if (technique == 2) {
                list.add(1, card); // 두 번째 위치에 추가
            } else if (technique == 3) {
                list.addLast(card); // 맨 아래에 추가
            }
        }

        // 최종 LinkedList에서 카드 값 출력
        for (Card card : list) {
            sb.append(card.value).append(" ");
        }

        System.out.println(sb.toString().trim()); // 결과 출력
    }
}

