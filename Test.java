package baitapDeadlock;

public class Test {
public static void main(String[] args) {
	ThreadA a=new ThreadA();
	ThreadB b=new ThreadB();
	a.start();
	b.start();
}
}
