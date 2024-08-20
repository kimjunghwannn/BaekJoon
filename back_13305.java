package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class back_13305 {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader id = new BufferedReader(new InputStreamReader(System.in));
        int cityn = Integer.parseInt(id.readLine());
        int cityroad[] = new int[cityn - 1];
        String input[] = id.readLine().split(" ");
        long answer = 0;
        for (int i = 0; i < cityn - 1; i++)
            cityroad[i] = Integer.parseInt(input[i]);

        String input2[] = id.readLine().split(" ");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < cityn; i++)
            linkedList.add(Integer.parseInt(input2[i]));

        linkedList.removeLast(); // 맨 마지막 요소 제거
        Collections.sort(linkedList);
        long allline = 0;
        for (int i = cityn - 2; i >= 0; i--) {
            long smallthing = linkedList.peek();
            allline += cityroad[i];
            long a=Integer.parseInt(input2[i]);
            if (i == 0) {
                if (smallthing == a ) {
                    answer += allline * smallthing;
                    allline = 0;
                    linkedList.poll();
                } else {
                    answer += cityroad[i] * a;
                }
            } else {
                if (smallthing == a) {
                    answer += allline * smallthing;
                    allline = 0;
                    linkedList.poll();
                }
               
                else {
                    linkedList.remove(a);
                }
            }
        }

        System.out.println(answer);
    }
}