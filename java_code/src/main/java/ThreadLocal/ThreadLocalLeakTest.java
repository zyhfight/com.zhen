package ThreadLocal;

/**
 * @author : zyh
 * @Description : ThreadLocal
 * @date : 2019-04-07 17:01
 */
public class ThreadLocalLeakTest {

    private static LeakA a = new LeakA();
//    private static final ThreadLocal<A> threadLocal = new ThreadLocal<A>(){
//        @Override
//        protected A initialValue() {
//            return a;
//        }
//    };

    private static final ThreadLocal<LeakA> threadLocal = ThreadLocal.withInitial(() -> a);


        public static void main(String[] args) {

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.get().setNumber(threadLocal.get().getNumber() + 1);

                    System.out.println(Thread.currentThread().getName() + ":"
                        + threadLocal.get().getNumber());
                }
            }, "Thread-" + i);
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }

}

 class LeakA{
    private int number = 0;

     public int getNumber() {
         return number;
     }

     public void setNumber(int number) {
         this.number = number;
     }
 }
