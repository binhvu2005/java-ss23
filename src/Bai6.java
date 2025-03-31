public class Bai6 {


    public static class myTask implements Runnable {
        private String name;
        public myTask(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
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
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
    //Trả lời câu hỏi sau: Liệu mức độ ưu tiên (priority) của các luồng có đảm bảo 100% thứ tự thực hiện giữa chúng không? Giải thích tại sao.
    // //Trả lời: Không, mức độ ưu tiên của các luồng không đảm bảo 100% thứ tự thực hiện giữa chúng. Mặc dù mức độ ưu tiên có thể ảnh hưởng đến thứ tự thực hiện của các luồng, nhưng nó không phải là yếu tố duy nhất quyết định thứ tự này. Hệ điều hành và lịch trình luồng cũng đóng vai trò quan trọng trong việc quyết định khi nào và bao lâu mỗi luồng sẽ được thực thi. Do đó, ngay cả khi một luồng có mức độ ưu tiên cao hơn, nó vẫn có thể bị tạm dừng hoặc chờ đợi nếu hệ điều hành quyết định cho phép các luồng khác chạy trước.
}
