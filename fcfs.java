import java.util.*;

public class fcfs {
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
        int temp;
        float awt=0,ata=0;

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Process "+(i+1)+" ARRIVAL time: ");
            at[i]=sc.nextInt();
            System.out.println("Enter Process "+(i+1)+" BURST time: ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }

        for(int i=0;i<n;i++)
        {
            for (int j=0;j<n-(i+1);j++)
            {
                if(at[j]>at[j+1])
                {
                    temp=at[j];
                    at[j]=at[j+1];
                    at[j+1]=temp;
                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;
                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            if(i==0)
            ct[i]=at[i]+bt[i];
            else
            {
                if(at[i]>ct[i-1])
                ct[i]=at[i]+bt[i];
                else
                ct[i]=ct[i-1]+bt[i];
            }
            tat[i]=ct[i]-at[i];
            wt[i]=tat[i]-bt[i];
            awt+=wt[i];
            ata+=tat[i];
        }

        System.out.println("\nid\t\tarrival\t\tburst\t\tcomplete\t\tturn\t\twaiting");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
        }
        sc.close();
        System.out.println("Average Waiting Time : "+(awt/n));
        System.out.println("Average Turnaround Time : "+(ata/n));
    }
}

