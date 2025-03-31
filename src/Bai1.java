public class Bai1 {
    public class myThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread đang chạy: " + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Bai1 bai1 = new Bai1();
        myThread thread1 = bai1.new myThread();
        thread1.start();
    }
}
