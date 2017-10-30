package algorithm;


import java.util.*;
public class Semaphore {
  
  public static void main(String[] args)  {
    
    Map<String, String> map = new HashMap<String, String>();
    
    map.put("one", "1");
    
    Test t = new Test();
   Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(1);
    
    Thread t1 = new Thread() {
      
      public void run() {
         t.A();
        s1.accquire();
      }
      
    };
    t1.start();
    
    Thread t2 = new Thread() {
      
      public void run() {
        s1.release();
         t.B();
        s2.accquire();
      }
      
    };
    t2.start();
    
    Thread t3 = new Thread() {
      
      public void run() {
        s2.release();
         t.C();
        
      }
      
    };
    t3.start();
    
    //System.out.println(Thread.currentThread().getId());
    
  }
  
  
  
}

class Test {
  
  public void A() {
    System.out.println("A");
  }
  
  public void B() {
    System.out.println("B");
  }
  
  public void C() {
    System.out.println("C");
  }
  
}

class Semaphore {
  
  int count = 0;
  int signal = 0;
  
  public Semaphore(int count) {
    this.count = count;
  }
  
  
  public  synchronized void accquire() {
    try {
      ++signal;
      if (count < signal) {
        --signal;
        wait();
      }
    
    notify();
    } catch(InterruptedException e) {
      
    }
    
  }
  
  public  synchronized void release()  {
    try {
      --signal;
    if (signal < 0) {
      ++signal;
      wait();
    }
    
    
    notify();
      } catch(InterruptedException e) {
      
    }
  }
}