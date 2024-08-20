package algo;
import java.util.*;
class Solution {
    static Map<String,Integer> friendsIndex;
    static String [] kakaoName= {"A","C","F","J","M","N","R","T"};
    static int [][] kakaoDistance;
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        friendsIndex=new HashMap<>();
        kakaoDistance= new int [8][8];
         for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                kakaoDistance[i][j] = 7;
            }
        }
        for(int i=0;i<8;i++)
            friendsIndex.put(kakaoName[i],i);
        for(int i=0;i<data.length;i++)
        {
            String[] firstSplit=data[i].split("~");
            String start=firstSplit[0];
            String end=String.valueOf(firstSplit[1].charAt(0));
            int startIndex=friendsIndex.get(start);
            int endIndex=friendsIndex.get(end);
            int distance=firstSplit[1].charAt(2)-48;
            if(firstSplit[1].charAt(1)=='<')
                distance*=-1;
            System.out.println(distance);
            System.out.println(startIndex+"     "+endIndex);
            kakaoDistance[startIndex][endIndex]=distance;
            kakaoDistance[endIndex][startIndex]=distance;
        }
        goKaKao(0,"");
        return answer;
    }
    static void goKaKao(int length, String Name)
    {
        if(length==8)
            answer++;
        for(int i=0;i<8;i++)
        {
        	boolean check=false;
            if(length!=0)
            {
                if(Name.contains(kakaoName[i]))
                    continue;
                for(int j=0;j<Name.length();j++)
                {
                    int start=friendsIndex.get(String.valueOf(Name.charAt(j)));
                    int distance=kakaoDistance[start][friendsIndex.get(kakaoName[i])];
                    if(distance>6)
                    {	
                    	continue;
                    }
                    if(distance>0)
                    {
                        if(Name.length()-(j+1)<=distance)
                        {   
                        	check=true;
                        	break;
                        }    
                    }
                    if(distance<=0)
                    {
                        if(Name.length()-(j+1)>distance)
                        {   
                        	check=true;
                        	break;
                        }    
                    }
                }
                if(check)
                	continue;
            }
            goKaKao(length+1,Name+kakaoName[i]);
        }
    }
}