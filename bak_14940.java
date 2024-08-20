package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class CustomPoint {
    int x;
    int y;

    public CustomPoint(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class bak_14940 {
    public static void doDikstra(int y, int x, int map[][], int distance[][], int found[][]) {
        Queue<CustomPoint> queue = new LinkedList<>();
        CustomPoint point = new CustomPoint(y, x);
        queue.offer(point);
        int plusx[] = {-1, 1, 0, 0};
        int plusy[] = {0, 0, -1, 1};

        found[y][x] = 1;
        int rows = map.length;
        int lows = map[0].length;

        while (!queue.isEmpty()) {
            point = queue.poll();
            int newx = point.x;
            int newy = point.y;

            for (int i = 0; i < 4; i++) {
                int pnewx = newx + plusx[i];
                int pnewy = newy + plusy[i];

                if (pnewx >= lows || pnewy >= rows || pnewx < 0 || pnewy < 0 || map[pnewy][pnewx] == 0 || found[pnewy][pnewx] == 1)
                    continue;

                found[pnewy][pnewx] = 1;
                queue.offer(new CustomPoint(pnewy, pnewx));
                distance[pnewy][pnewx] = distance[newy][newx] + 1;

            }
        }
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int w, q;
        w = Integer.parseInt(input[0]);
        q = Integer.parseInt(input[1]);
        int map[][] = new int[w][q];

        int distance[][] = new int[w][q];
        int found[][] = new int[w][q];
        int i, j;

        for (i = 0; i < w; i++) {
            Arrays.fill(found[i], 0);
        }

        for (i = 0; i < w; i++) {
            input = br.readLine().split(" ");
            for (j = 0; j < q; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (i = 0; i < w; i++) {
            for (j = 0; j < q; j++)
                if (map[i][j] == 2) {
                    doDikstra(i, j, map, distance, found);
                    break;
                }
        }

        for (int y = 0; y < w; y++) {
            for (int x = 0; x < q; x++)
                if (map[y][x] == 1 && distance[y][x] == 0)
                    System.out.print("-1 ");
                else
                    System.out.print(distance[y][x] + " ");
            System.out.println();
        }

    }
}