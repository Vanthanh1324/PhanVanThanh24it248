package Usingthreads;

public class Buffer {
	 private int data;
	    private boolean available = false; 

	    public synchronized int get() {
	        while (!available) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        available = false;
	        notify();
	        System.out.println("Consumer lấy: " + data);
	        return data;
	    }

	    public synchronized void put(int value) {
	        while (available) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        data = value;
	        available = true;
	        notify();
	        System.out.println("Producer đặt: " + value);
	    }
	}

	class Producer extends Thread {
	    private Buffer buffer;

	    public Producer(Buffer buffer) {
	        this.buffer = buffer;
	    }

	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            buffer.put(i);
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	class Consumer extends Thread {
	    private Buffer buffer;

	    public Consumer(Buffer buffer) {
	        this.buffer = buffer;
	    }

	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            buffer.get();
	            try {
	                Thread.sleep(1500);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
