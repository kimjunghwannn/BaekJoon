package algo;
import java.io.*;
import java.util.*;

public class back_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        boolean zero=false;
        int result = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positives.add(num);
            } else if (num < 0) {
                negatives.add(num);
            } else {
            	if(num==1)
            		result += num;
            	else
            		zero=true;
            }
        }

        // 양수와 음수를 각각 정렬
        Collections.sort(positives, Collections.reverseOrder()); // 양수는 큰 순서대로
        Collections.sort(negatives); // 음수는 작은 순서대로
        if(negatives.size()%2==1)
        	if(zero)
        		negatives.add(0);
        	
        // 양수는 큰 것끼리 묶어 곱하기
        result += getMaxSum(positives);
        // 음수는 작은 것끼리 묶어 곱하기
        result += getMaxSum(negatives);

        System.out.println(result);
    }

    private static int getMaxSum(List<Integer> list) {
        int sum = 0;
        // 두 개씩 묶어 곱하여 합계에 추가
        for (int i = 0; i < list.size(); i += 2) {
            if (i + 1 < list.size()) {
                sum += list.get(i) * list.get(i + 1);
            } else {
                // 남은 값이 홀수면 그대로 더하기
                sum += list.get(i);
            }
        }
        return sum;
    }
}