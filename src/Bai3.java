public class Bai3 {
    public static class SharedResource {
        public SharedResource() {
        }
        public void printAlphabet() {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.print(c + " ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class myTask implements Runnable {
        private SharedResource sharedResource;
        private String name;
        public myTask(SharedResource sharedResource) {
            this.name = name;
            this.sharedResource = sharedResource;
        }
        @Override
        public void run() {
            synchronized (sharedResource) {
                System.out.println("Thread đang chạy: " + Thread.currentThread().getName());
                sharedResource.printAlphabet();
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(new myTask(sharedResource));
        Thread t2 = new Thread(new myTask(sharedResource));
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
