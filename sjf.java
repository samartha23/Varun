import java.util.Scanner;

public class sjf 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Total number of PROCESSES: ");
        int n=sc.nextInt();
        int pid[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int tat[]=new int[n];
        int wt[]=new int[n];
        int f[]=new int[n];
        int temp,st=0,tot=0;
        float awt=0,ata=0;

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Process "+(i+1)+" ARRIVAL time: ");
            at[i]=sc.nextInt();
            System.out.println("Enter Process "+(i+1)+" BURST time: ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
            f[i]=0;
        }
        boolean a=true;
        while(true)
        {
            int c=n,min=999;
            if(tot==n)
            break;
        for(int i=0;i<n;i++)
        {
            if((at[i]<=st)&&(f[i]==0)&&(bt[i]<min))
            {
                min=bt[i];
                c=i;
            }
        }
        if(c==n)
        st++;
        else{
            ct[c]=st+bt[c];
            st+=bt[c];
            tat[c]=ct[c]-at[c];
            wt[c]=tat[c]-bt[c];
            f[c]=1;
            tot++;
        }
    }
        System.out.println("\nid\t\tarrival\t\tburst\t\tcomplete\t\tturn\t\twaiting");
        for(int i=0;i<n;i++)
        {
            awt+=wt[i];
            ata+=tat[i];
            System.out.println(pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t\t"+tat[i]+"\t\t"+wt[i]);
        }
        System.out.println("Average Waiting Time : "+(awt/n));
        System.out.println("Average Turnaround Time : "+(ata/n));
        sc.close();
    }
    
}

