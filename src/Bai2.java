public class Bai2 {
    public static class myTask implements Runnable{
        private String name;
        public myTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            for (int i = 0; i <=10; i++) {
                System.out.println("Thread đang chạy: " + name + " i = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
      Thread t1 = new Thread(new myTask("luông 1"));

      t1.start();

    }
}
