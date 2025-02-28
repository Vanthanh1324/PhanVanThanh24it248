package Usingthreads;

public class bai1test {
private int num=0;
private final int max;
public bai1test(int max) {
	this.max=max;
}
public synchronized void a() {
	while(num<max) {
		while(num%2==0) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			}if(num<=max) {
				System.out.println("le"+num);
				num++;
				notify();
			}
	}
}
public synchronized void b() {
	while(num<max) {
		while(num%2!=0) {
			try {
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}if(num<=max) {
				System.out.println("chan"+num);
				num++;
				notify();
			}
		}
}
}
