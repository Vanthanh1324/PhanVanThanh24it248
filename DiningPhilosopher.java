package baitapDeadlock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopher {
	public static void main(String[] args) {
		int numberofphisopher=5;
		ReentrantLock[] chopsticks= new ReentrantLock[numberofphisopher];
		Semaphore table= new Semaphore(numberofphisopher-1);
		for(int i=0;i<numberofphisopher;i++) {
			chopsticks[i]=new ReentrantLock();
		}
		Philosopher[] philosopher =new Philosopher[numberofphisopher];
		for(int i=0;i<numberofphisopher;i++) {
		philosopher[i]=new Philosopher(i,chopsticks[i],chopsticks[(i+1)%numberofphisopher],table);
		philosopher[i].start();
		}
	}
}
