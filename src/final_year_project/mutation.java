/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package final_year_project;

/**
 *
 * @author SMIT
 */
public class mutation extends mainpanel{
    
           int mutate=0,mutate2=0;
           public mutation()
           {
               
           }
    public void domutation(int i)
    {
        int x=blue[i];
        int y=green[i];
        int z=red[i];
        int bluearri[]=new int[6];
        int j1=0;
        while(x>0)
        {
            if(x%2==0)
                bluearri[j1]=0;
            else
                bluearri[j1]=1;
                       x=x/2;
                       j1+=1;
                   }
                   int greenarri[]=new int[6];
                   j1=0;
                   while(y>0)
                   {
                       if(y%2==0)
                           greenarri[j1]=0;
                       else
                           greenarri[j1]=1;
                       y=y/2;
                       j1+=1;
                   }
                   int redarri[]=new int[6];
                   j1=0;
                   while(z>0)
                   {
                       if(z%2==0)
                           redarri[j1]=0;
                       else
                           redarri[j1]=1;
                       z=z/2;
                       j1+=1;
                   }
                   x=blue[mutate2];
                   y=green[mutate2];
                   z=red[mutate2];
                   int bluearrm[]=new int[6];
                   j1=0;
                   while(x>0)
                   {
                       if(x%2==0)
                           bluearrm[j1]=0;
                       else
                           bluearrm[j1]=1;
                       x=x/2;
                       j1+=1;
                   }
                   int greenarrm[]=new int[6];
                   j1=0;
                   while(y>0)
                   {
                       if(y%2==0)
                           greenarrm[j1]=0;
                       else
                           greenarrm[j1]=1;
                       y=y/2;
                       j1+=1;
                   }
                   int redarrm[]=new int[6];
                   j1=0;
                   while(z>0)
                   {
                       if(z%2==0)
                           redarrm[j1]=0;
                       else
                           redarrm[j1]=1;
                       z=z/2;
                       j1+=1;
                   }
                   blue[countorg]=0;
                   if(bluearri[5]==1)
                       blue[countorg]+=32;
                   if(bluearri[4]==1)
                       blue[countorg]+=16;
                   if(bluearri[3]==1)
                       blue[countorg]+=8;
                   if(bluearri[2]==1)
                       blue[countorg]+=4;
                   if(bluearrm[1]==1)
                       blue[countorg]+=2;
                   if(bluearrm[0]==1)
                       blue[countorg]+=1;
                   blue[countorg+1]=0;
                   if(bluearrm[5]==1)
                       blue[countorg+1]+=32;
                   if(bluearrm[4]==1)
                       blue[countorg+1]+=16;
                   if(bluearrm[3]==1)
                       blue[countorg+1]+=8;
                   if(bluearrm[2]==1)
                       blue[countorg+1]+=4;
                   if(bluearri[1]==1)
                       blue[countorg+1]+=2;
                   if(bluearri[0]==1)
                       blue[countorg+1]+=1;
                   
                   green[countorg]=0;
                   if(greenarri[5]==1)
                       green[countorg]+=32;
                   if(greenarri[4]==1)
                       green[countorg]+=16;
                   if(greenarri[3]==1)
                       green[countorg]+=8;
                   if(greenarri[2]==1)
                       green[countorg]+=4;
                   if(greenarrm[1]==1)
                       green[countorg]+=2;
                   if(greenarrm[0]==1)
                       green[countorg]+=1;
                   green[countorg+1]=0;
                   if(greenarrm[5]==1)
                       green[countorg+1]+=32;
                   if(greenarrm[4]==1)
                       green[countorg+1]+=16;
                   if(greenarrm[3]==1)
                       green[countorg+1]+=8;
                   if(greenarrm[2]==1)
                       green[countorg+1]+=4;
                   if(greenarri[1]==1)
                       green[countorg+1]+=2;
                   if(greenarri[0]==1)
                       green[countorg+1]+=1;
                   
                   red[countorg]=0;
                   if(redarri[5]==1)
                       red[countorg]+=32;
                   if(redarri[4]==1)
                       red[countorg]+=16;
                   if(redarri[3]==1)
                       red[countorg]+=8;
                   if(redarri[2]==1)
                       red[countorg]+=4;
                   if(redarrm[1]==1)
                       red[countorg]+=2;
                   if(redarrm[0]==1)
                       red[countorg]+=1;
                   red[countorg+1]=0;
                   if(redarrm[5]==1)
                       red[countorg+1]+=32;
                   if(redarrm[4]==1)
                       red[countorg+1]+=16;
                   if(redarrm[3]==1)
                       red[countorg+1]+=8;
                   if(redarrm[2]==1)
                       red[countorg+1]+=4;
                   if(redarri[1]==1)
                       red[countorg+1]+=2;
                   if(redarri[0]==1)
                       red[countorg+1]+=1;
    }
}
