package algo;
import java.io.*;
import java.util.*;

public class softeer_namo {
    static class index
        {
            public int y;
            public int x;
            public int n;
            public index(int y,int x,int n)
            {
                this.x=x;
                this.y=y;
                this.n=n;
            }
        }
    static int N_min=Integer.MAX_VALUE;    
    static boolean visited[][];
    static boolean map[][];
    static int dx[]={0,0,1,-1};
    static int dy[]={1,1,0,0};
    public static void main(String[] args) throws IOException 
    {
        BufferedReader id =new BufferedReader(new InputStreamReader(System.in));
        String input[]=id.readLine().split(" ");
        map=new boolean [Integer.parseInt(input[0])][Integer.parseInt(input[1])];
        visited=new boolean [Integer.parseInt(input[0])][Integer.parseInt(input[1])];
        index nam=null;
        index finish=null;
        List<index>Ghost=new ArrayList<>();
        for(int i=0;i<map.length;i++)
            {
                String input2=id.readLine();
                for(int j=0;j<map[0].length;j++)
                    {
                        if(input2.charAt(j)=='#')
                            map[i][j]=true;
                        if(input2.charAt(j)=='N')
                            nam=new index(i,j,0);
                         if(input2.charAt(j)=='D')
                            finish=new index(i,j,0);
                        if(input2.charAt(j)=='G')
                            Ghost.add(new index(i,j,0));
                    }
            }
        Queue <index> queue=new LinkedList<>();
        queue.add(nam);
        visited[nam.y][nam.x]=true;
        while(!queue.isEmpty())
        {
            index now=queue.poll();
            int x=now.x;
            int y=now.y;
           if(finish.y==y&&finish.x==x)
         {   
             N_min=Math.min(N_min,now.n);
             System.out.println(N_min);
             continue;
         }
         for(int i=0;i<4;i++)
            {
                int cx=x+dx[i];
                int cy=y+dy[i];
                if(cx<0||cy<0||cx>=visited[0].length||cy>=visited.length)
                    continue;
                if(map[cy][cx]||visited[cy][cx])
                    continue;
                visited[cy][cx]=true;
                queue.add(new index(cy,cx,now.n+1));
            }
        }
        if(N_min==Integer.MAX_VALUE)
        {
            System.out.print("Nok");
            System.exit(0);
        }
        int G_min=Integer.MAX_VALUE;    
        for(index a : Ghost)
        {
            int sum=Math.abs(a.x-finish.x)+Math.abs(a.y-finish.y);
            G_min=Math.min(sum,G_min); 
           
        }
        if(G_min<=N_min)
            System.out.print("No");
        else
            System.out.print("Yes");
    }
   
    
}
