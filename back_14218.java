package algo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class back_14218 {
    static void bfsdo(int[] check, Node map[], int count, int start) {
    	check[start] = count++;
        
        for (int w : map[start].roadto) {
        	if(check[w]<count)
        		continue;
        	bfsdo(check, map, count, w);
        }
    }

    static class Node {
        public List<Integer> roadto;

        public Node() {
            this.roadto = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int city = scanner.nextInt();
        int road = scanner.nextInt();

        Node map[] = new Node[city + 1];
        int check[] = new int[city + 1];

        for (int i = 0; i < city + 1; i++)
            map[i] = new Node();

        for (int i = 0; i < road; i++) {
            int city1 = scanner.nextInt();
            int city2 = scanner.nextInt();
            map[city1].roadto.add(city2);
            Collections.sort(map[city1].roadto);
        }

        int newroad = scanner.nextInt();

        for (int i = 0; i < newroad; i++) {
            int count = 0;
            int city1 = scanner.nextInt();
            int city2 = scanner.nextInt();
            map[city1].roadto.add(city2);
            Collections.sort(map[city1].roadto);
            Arrays.fill(check, Integer.MAX_VALUE);
            bfsdo(check, map, count, 1);
            for (int j = 1; j <= city; j++) {
                if (j != 1 && check[j] ==  Integer.MAX_VALUE) {
                    System.out.print(-1 + " ");
                    continue;
                }
                System.out.print(check[j] + " ");
            }
            System.out.println();
        }
    }
}
