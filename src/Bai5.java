public class Bai5 {
    public static class SharedData {
        private String message;
        public synchronized void setMessage(String message) {
            this.message = message;
            notify();
        }
        public synchronized String getMessage() throws InterruptedException {
            while (message == null) {
                wait();
            }
            return message;
        }
    }
    public static class Writer implements Runnable {
        private SharedData sharedData;
        public Writer(SharedData sharedData) {
            this.sharedData = sharedData;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                sharedData.setMessage("Hello from Writer!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class Reader implements Runnable {
        private SharedData sharedData;
        public Reader(SharedData sharedData) {
            this.sharedData = sharedData;
        }
        @Override
        public void run() {
            try {
                String message = sharedData.getMessage();
                System.out.println("Received message: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread writerThread = new Thread(new Writer(sharedData));
        Thread readerThread = new Thread(new Reader(sharedData));

        writerThread.start();
        readerThread.start();
    }
}
