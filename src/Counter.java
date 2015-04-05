
public class Counter implements Runnable {
	private int tid;
	private int h;
	private int n;
	private int p;
	public void run(){
		System.out.println("Thread "+tid+" started");
		int leftBound=(tid+1)*h;
		if(tid==p-1)
			leftBound=n;
		for(int i=tid*h;i<leftBound;i++){
			int ³=i+1;
			double j=Math.pow(-1, ³);
			Main.sum+=Math.pow(2, ³-j);
		}
		System.out.println("Thread "+tid+" ended");
	}
	public Counter(int tid){
		this.tid=tid;
		this.h=Main.h;
		this.n=Main.n;
		this.p=Main.p;
	}

}
