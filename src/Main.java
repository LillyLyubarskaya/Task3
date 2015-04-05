import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Main {
	static volatile int p;
	static volatile int n;
	static volatile int h;
	static volatile double sum;
	static ExecutorService service;
	static Thread[] pool;
	static  Scanner keyboard = new Scanner(System.in);
	public static  void calSum(boolean is){
		System.out.println("Main started");
		if(is){
			  pool=new Thread[p];
			  for(int i=0;i<p;i++)
				  pool[i]=new Thread(new Counter(i));
				  for (Thread t: pool) t.start();
				  for (Thread t: pool) {
						try {
							t.join();
						} catch (InterruptedException e) {}
					}
		}else{
			service=Executors.newFixedThreadPool(p);
			for(int i=0;i<p;i++)
				service.execute(new Counter(i));
			service.shutdown();
			try {
				service.awaitTermination(100 , TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("SUM= "+sum);
		System.out.println("Main ended");
		
	}
	public static void setData(int p,int n){
		Main.p=p;
		Main.n=n;
		Main.h=n/p;
	}
	public static void main(String...args){
		count(true);
		count(false);
	}
	public static double count(String file,boolean is){
		sum=0;
		p=0;
		n=0;
		BufferedReader reader=null;
		int n=0;
		int p=0;
		 try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line=null;
		try {
			line=reader.readLine();
			String [] arrayNumbers=line.split("\\D+");
			for(int i=0;i<arrayNumbers.length;i++){
				if(i==0)
					 n=Integer.parseInt(arrayNumbers[i]);
				if(i==1)
					 p=Integer.parseInt(arrayNumbers[i]);
			}
			System.out.println("n= "+n+" p= "+p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setData(p, n);
		calSum(is);
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sum;
	}
    public static double count(boolean is){
    	sum=0;
		p=0;
		n=0;
		 System.out.println("Enter n and number of threads");
		 int n= keyboard.nextInt();
		 int p= keyboard.nextInt();
		 setData(p,n);
		 calSum(is);
		 return sum;
		
	}
	
	

}
