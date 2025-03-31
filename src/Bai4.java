public class Bai4 {
    public static class myTask implements Runnable{
        private String name;
        public myTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            for (int i = 1; i <=5; i++) {
                System.out.println("Thread đang chạy: " + name + " i = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread bị ngắt: " + name);
                }
            }
        }
    }
    public static void main(String[] args) {
      Thread t1 = new Thread(new myTask("luông 1"));
      Thread t2 = new Thread(new myTask("luông 2"));
      Thread t3 = new Thread(new myTask("luông 3"));
      t1.start();
      try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread bị ngắt: " + t1.getName());
      }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread bị ngắt: " + t2.getName());
        }
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread bị ngắt: " + t3.getName());
        }
    }
}
