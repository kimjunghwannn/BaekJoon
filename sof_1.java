package algo;
import java.io.*;
import java.util.*;

public class sof_1 {
    static int map[][];
    static class Node implements Comparable<Node> {
        public int y;
        public int x;
        public int direction;
        public String commands;
        public int n;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
            this.direction = 0;
            this.commands = "";
            this.n = 1;
        }

        // n에 따른 우선순위를 비교 (n이 클수록 높은 우선순위)
        @Override
        public int compareTo(Node other) {
            // 내림차순 정렬 (n 값이 큰 것이 우선순위 높음)
            return Integer.compare(other.n, this.n);
        }}
    static Node startNode;
    static int answer=Integer.MAX_VALUE;
    static int dx[]={0,2,0,-2};//위,오,아래,왼
    static int dy[]={2,0,-2,0};
    static int CDirect[]= {0,1,-1};
    static String command[]= {"A","L","R"};
    static String a[]= {"^",">","v","<"};
    static int height;
    static int width;
    static int shapN=0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        String input[]=br.readLine().split(" ");
        
        height=Integer.parseInt(input[0]);
        width=Integer.parseInt(input[1]);
        map=new int [height][width];
        
        for(int i=0;i<height;i++)
        {
            String inputLine=br.readLine();
            for(int j=0;j<width;j++)
            {
                if(inputLine.charAt(j)=='#')
                {    
                    map[i][j]=1;
                    shapN++;
                    if(startNode==null)
                        startNode=new Node(i,j);
                }
                else
                    map[i][j]=0;
            }
        }
        System.out.println((startNode.y+1)+" "+(startNode.x+1));
        String sb = "";
        String answerD="";
        for(int i=0;i<4;i++)
        {
             String c=bfs(startNode,i);
            if(sb.equals("")||c.length()<sb.length())
            {	
            	sb=c;
            	answerD=a[i];
            }
        }   
        System.out.println(answerD);
        System.out.println(sb.toString());
    }
    
    static String bfs(Node a,int dr)
    {
        a.direction=dr;
        boolean visited[][]=new boolean[height][width];
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(a);
        visited[a.y][a.x]=true;
        while(!queue.isEmpty())
        {
        	
            Node now=queue.poll();
            
            for(int i=0;i<3;i++)
            { 

                Node now2=new Node(now.y,now.x);
                
                now2.direction=now.direction;
                now2.commands=now.commands;
                now2.n=now.n;
                now2.direction+=CDirect[i];
                now2.commands+=command[i];
                if(now2.direction==4)
                    now2.direction=0;
                if(now2.direction==-1)
                    now2.direction=3;
                if(i==0)
                {
                
                int cx=now2.x+dx[now2.direction];
                int cy=now2.y+dy[now2.direction];
                if(cx<0||cx>=width||cy<0||cy>=height)
                {    
                	
                	continue;
                }
                if(visited[cy][cx]||visited[now2.y+(dy[now2.direction]/2)][now2.x+(dx[now2.direction]/2)])
                {     
                	
                	continue;
                }
                if(map[cy][cx]==1&&map[now2.y+(dy[now2.direction]/2)][now2.x+(dx[now2.direction]/2)]==1)
                {
                	
                    now2.n+=2;
                    if(now2.n==shapN)
                        return now2.commands;
                    visited[cy][cx]=true;
                    visited[now2.y+(dy[now2.direction]/2)][now2.x+(dx[now2.direction]/2)]=true;
                    now2.y=cy;
                    now2.x=cx;
                    queue.add(now2);
                }
                
                }
                else
                	queue.add(now2);
            }
        }
        return "";
    }
}