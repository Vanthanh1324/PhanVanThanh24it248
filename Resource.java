package baitapDeadlock;
public class Resource extends Thread{
static final Object resource1 =new Object();
static final Object resource2 =new Object();
}
class ThreadA extends Resource{
	public void run() {
			synchronized(Resource.resource1) {
				System.out.println("Thread A locked resource1");
				synchronized (Resource.resource2) {
					System.out.println("Thread A locked resource2");
			}
		}
	}
}
class ThreadB extends Resource{
	public void run() {
		synchronized (Resource.resource1) {
			System.out.println("Thread B locked resource1");
			synchronized (Resource.resource2) {
				System.out.println("Thread B locked resource2");
			}
		}
	}
}