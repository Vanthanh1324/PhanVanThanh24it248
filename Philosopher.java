package baitapDeadlock;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
public class Philosopher extends Thread{
private int id;
private ReentrantLock leftchopstick,rightchopstick;
private Semaphore table;
public Philosopher(int id,ReentrantLock leftchopstick,ReentrantLock rightchopstick,Semaphore table) {
	this.id=id;
	this.leftchopstick=leftchopstick;
	this.rightchopstick=rightchopstick;
	this.table=table;
}
private void think() throws InterruptedException {
	System.out.println("triet gia so: "+id+"dang suy nghi");
	Thread.sleep((int)(Math.random()*1000));
}
private void eat() throws InterruptedException{
	System.out.println("triet gia so: "+id+"dang an");
	Thread.sleep((int)(Math.random()*1000));
}
public void run() {
	try {
		while(true) {
			think();
			table.acquire();
			leftchopstick.lock();
			System.out.println("triet gia so: "+id+"cam dua ben trai");
			rightchopstick.lock();
			System.out.println("triet gia so: "+id+"cam dua ben phai");
			eat();
		rightchopstick.unlock();
		leftchopstick.unlock();
		System.out.println("triet gia so: "+id+"bo dua xuong");
		table.release();
		}
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}