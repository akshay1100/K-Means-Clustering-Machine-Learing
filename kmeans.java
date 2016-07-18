
import java.util.*;
import java.math.*;
import java.net.*;
import java.io.*;


//------------------------------------------------------------------------
 class Cluster {
	double min=0;
	double max=1;
	Random r = new Random();
	public List<Integer> points;
	public double cen1[]=new double[2];
	public int id;
	
	
	//Creates a new Cluster
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList<Integer>();
		//this.cen1 = null;
		 cen1[0] = (double)(Math.round(r.nextDouble()*1000))/1000;
		 cen1[1] =(double)(Math.round(r.nextDouble()*1000))/1000;
		
	}
 
	public List<Integer> getPoints() {
		return points;
	}
	
	public void addPoint(Integer point) {
		points.add(point);
	}
 
	public void setCentroid(double[] cent) {
		this.cen1[0] = cent[0];
		this.cen1[1] = cent[1];
	}
 
}

public class kmeans {

	int len1,id1;
	double min,r2,r3,dist;
	double r1[]=new double[60];
	double arr2[][]= new double[101][3];
	
	public void  distance(Cluster clu1[])
	{
		for(int i12 =1;i12<arr2.length;i12++)
		{ min=12;
			for(int j12=0;j12<len1;j12++)
			{
				dist=Math.sqrt(Math.pow((clu1[j12].cen1[0] - arr2[i12][1]), 2) + Math.pow((clu1[j12].cen1[1] - arr2[i12][2]), 2));
				if(dist<min)
				{
					min=dist;
					id1=j12;
					}} 
			clu1[id1].addPoint(i12);
		}
		//for(int i13=0;i13<len1;i13++)
	//System.out.println(clu1[i13].getPoints());
	}
	

	public void mean(Cluster clu2[])
	{double x1=0,y1=0;
		for(int i23=0;i23<len1;i23++)
		{x1=0;y1=0;
			for(int i12:clu2[i23].points)
			{
				x1=x1+arr2[i12][1];
				y1=y1+arr2[i12][2];
			}
			//System.out.println("x: "+x1);
			//System.out.println("y: "+y1);
			//System.out.println(clu2[i23].points.size());
			if(clu2[i23].points.size()!=0)
			{clu2[i23].cen1[0]=x1/clu2[i23].points.size();}
			
			if(clu2[i23].points.size()!=0)
			{clu2[i23].cen1[1]=y1/clu2[i23].points.size();		
			
			//System.out.println(clu2[i23].cen1[0]);
			//System.out.println(clu2[i23].cen1[1]);
			
			
			}
		}
		for(int l1=0;l1<len1;l1++)
		{
		//System.out.print(clu2[l1].cen1[0]+" ");
//System.out.println(clu2[l1].cen1[1]);
		}
	}
	
	
	public void clear(Cluster clu2[])
	{
		for(int l1=0;l1<len1;l1++)
		{
		clu2[l1].points.clear();
		}
	
	}
	public void sse(Cluster clu3[])
	{
		double sse1[]=new double[len1];
		 
			for(int j12=0;j12<len1;j12++)
			{
				for(int i12 =1;i12<arr2.length;i12++)
				{ 
			sse1[j12]=	sse1[j12]+Math.pow((clu3[j12].cen1[0] - arr2[i12][1]), 2) + Math.pow((clu3[j12].cen1[1] - arr2[i12][2]), 2);
			}
			}
		double total=0;
	for(int i12 =0;i12<len1;i12++)
	{ total=total+sse1[i12];
		
	}
System.out.println("Sum of Squared Error: "+total);
	}
	

	public static void main(String[] args) throws Exception
	{
		
		try{
			FileOutputStream fout=new FileOutputStream(args[2]);
			PrintStream pw=new PrintStream(fout);
			System.setOut(pw);}
			 catch(IOException e1) {
			        System.out.println("Error during reading/writing");
			   }
	
		String inputL;
		Scanner s2=new Scanner(System.in);
		kmeans a1= new kmeans();
	    a1.arr2[0][0]=123;a1.arr2[0][1]=123;a1.arr2[0][2]=123;
	    int i=0;
		
		
//		URL u1 = new URL("http://www.utdallas.edu/~axn112530/cs6375/assignment5/test_data.txt");
//        URLConnection y1 = u1.openConnection();
//        BufferedReader in = new BufferedReader(new InputStreamReader(y1.getInputStream()));
               
        try {
			s2 = new Scanner(new File(args[1]));
			//sc1 = new Scanner(new File("D:/test/seeds.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();  
		}
        
    //    Scanner s3=new Scanner(System.in);
        
        Scanner s1 = null;
		 while (s2.hasNextLine())
		 {
		 s1 = new Scanner(s2.nextLine()).useDelimiter("	");
		  
		   if(i==0)
		   {  i++; continue; } 
		   
		   a1.arr2[i][0] = Double.parseDouble(s1.next());
		   a1.arr2[i][1]=Double.parseDouble(s1.next());
		   a1.arr2[i][2]=Double.parseDouble(s1.next());  
		 i++;} 
		 s1.close();
		
		/* System.out.println("---------------------------------");
		 for(int j=1;j<a1.arr2.length;j++)
		 {
			System.out.print(a1.arr2[j][0]);
			System.out.print("  "+a1.arr2[j][1]); System.out.println("  "+a1.arr2[j][2]);
		 }
		System.out.println(""); */
		
	//System.out.println("Enter the number of clusters");
		 a1.len1=Integer.parseInt(args[0]);
		
		Cluster[] clu =new Cluster[a1.len1];
		for(int u2=0; u2<a1.len1;u2++)
		{
			
		clu[u2] = new Cluster(u2);
		}
		
		for(int l1=0;l1<a1.len1;l1++)
		{
		//System.out.print(clu[l1].cen1[0]+" ");System.out.println(clu[l1].cen1[1]);
		}
		for(int l1=0;l1<60;l1++)
		{
			a1.r1[l1]=0.0;
		}
		s2.close();
	for(int f=0;f<25;f++)
	{ int count=0;
		a1.distance(clu);
		a1.mean(clu);
		for(int i13=0;i13<a1.len1*2;i13++)
		{int p=0;
			if(a1.r1[i13]==clu[p].cen1[0]&&a1.r1[i13+1]==clu[p].cen1[1])
			{
			count=count+1;}
			i13++;
			p++;}
		if(count==a1.len1)
		{
			for(int i13=1;i13<=a1.len1;i13++)
			{
			System.out.println("Cluster "+i13+": "+clu[i13-1].getPoints());
			
			}
			a1.sse(clu);System.exit(0);
		}
		
		
		for(int i13=0;i13<a1.len1*2;i13++)
		{int p=0;
			a1.r1[i13]=clu[p].cen1[0];i13++;
			a1.r1[i13]=clu[p].cen1[1];
	p++;	}
		
        a1.clear(clu);	}
	
	for(int i13=0;i13<a1.len1;i13++)
	{
	System.out.println("Cluster "+i13+": "+clu[i13-1].getPoints());

	}
	a1.sse(clu);
	System.exit(0);
	}
	 
}
