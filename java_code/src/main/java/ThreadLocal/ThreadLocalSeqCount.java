package ThreadLocal;

/**
 * @author : zyh
 * @Description : ThreadLocal
 * @date : 2019-04-07 16:43
 */
public class ThreadLocalSeqCount {

    private static ThreadLocal<Integer> seqCountThreadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public int nextSeq() {
        seqCountThreadLocal.set(seqCountThreadLocal.get() + 1);
        return seqCountThreadLocal.get();
    }

    public static void main(String[] args) {

        ThreadLocalSeqCount seqCount = new ThreadLocalSeqCount();

        SeqSubThread thread1 = new SeqSubThread(seqCount);
        SeqSubThread thread2 = new SeqSubThread(seqCount);
        SeqSubThread thread3 = new SeqSubThread(seqCount);

        thread1.start();
        thread2.start();
        thread3.start();
    }

   private static class SeqSubThread extends Thread {
        private ThreadLocalSeqCount seqCount;

        SeqSubThread(ThreadLocalSeqCount seqCount) {
            this.seqCount = seqCount;
        }

        @Override
        public void run() {

            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " seqCount: " + seqCount.nextSeq());
            }

        }
   }

}
