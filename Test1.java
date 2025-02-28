package Usingthreads;

public class Test1 {
public static void main(String[] args) {
	int max=10;
	bai1 pri=new bai1(max);
	Thread i1=new Thread(pri::in1);
	Thread i2=new Thread(pri::in2);
	i1.start();
	i2.start();
}
}
