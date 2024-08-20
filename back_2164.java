package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class back_2164 {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(id.readLine());

        Queue<Integer> card = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            card.add(i);
        }

        while (card.size() != 1) {
            // 큐의 맨 앞에 있는 카드를 제거하고, 그 다음 카드를 큐의 맨 뒤에 추가
            card.poll();
            card.add(card.poll());
        }

        System.out.print(card.peek());
    }
}