/**
 * 
 */
package multithread;

/**
 * @author Manali & Mrunali
 *
 */
public class MultithreadJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Thread1 obj=new Thread1();//creating instance of Thread1
         obj.start();//start Thread1
         
		 Thread2 obj1=new Thread2();//creating instance of Thread2
		 Thread t1=new Thread(obj1);
		 
         t1.start();//start thread2
         
         
         obj.setName("My Thread1");//setName of the Thread1
         t1.setName("My Thread2");//setName of the Thread2
      
	}

}
//creating thread by extending Thread Class 
class Thread1 extends Thread {
	public void run() {
		
		System.out.println("Thread1 is Running");
		for(int i=0; i<5;i++) {
			Thread.yield();//yield method stop the currently executing thread and it will give a chance to other waiting thread
			  System.out.println("Thread1 started :"+Thread.currentThread().getName());
		}
		System.out.println("Thread1 ended :"+Thread.currentThread().getName());
		
		
		}
	}
	
//end Thread1

//creating thread by implements Runnable interface
class Thread2 implements Runnable{
	public void run() {
		System.out.println("Thread2 is Running");
		for(int i=0; i<5;i++) {
			  System.out.println("Thread2 started :"+Thread.currentThread().getName());
		}
		System.out.println("Thread2 ended :"+Thread.currentThread().getName());
	}
		
			
}//end Thread2

/*Ouput:
 * Thread1 is Running
Thread2 is Running
Thread2 started :My Thread2
Thread2 started :My Thread2
Thread2 started :My Thread2
Thread2 started :My Thread2
Thread2 started :My Thread2
Thread2 ended :My Thread2
Thread1 started :My Thread1
Thread1 started :My Thread1
Thread1 started :My Thread1
Thread1 started :My Thread1
Thread1 started :My Thread1
Thread1 ended :My Thread1

 */
