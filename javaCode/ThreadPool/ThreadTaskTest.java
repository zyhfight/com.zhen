package thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : zyh
 * @Description : 线程池异常信息优化：submit方法不会抛出异常，因为异常是作为返回值返回的。
 *                个线程任务执行情况，或自定义一些增强
 * @date : 2018-12-22 15:45
 */
public class ThreadTaskTest {

    private static final Logger logger = LoggerFactory.getLogger(ThreadTaskTest.class);


    static class DivideTask implements Runnable {
        BigDecimal a, b;

        public DivideTask(BigDecimal a, BigDecimal b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            BigDecimal rs = a.divide(b, 2, RoundingMode.HALF_UP);
            logger.info(rs.toString());
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 10, 0L,
                TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; ++i) {
            //submit会把异常吞没
            executor.submit(new DivideTask(new BigDecimal(100), new BigDecimal(i)));
            executor.execute(new DivideTask(new BigDecimal(100), new BigDecimal(i)));
        }
    }

}
