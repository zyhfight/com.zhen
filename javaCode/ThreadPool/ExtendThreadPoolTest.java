package thread;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : zyh
 * @Description : 扩展线程池，重写beforeExecute、afterExecute、terminated方法，
 *                这三个方法默认为空，是JDK线程池预留接口。
 *                通过重写这三个方法，可以监控每个线程任务执行情况，或自定义一些增强
 * @date : 2018-12-22 15:10
 */
public class ExtendThreadPoolTest {

    private static final Logger logger = LoggerFactory.getLogger(ExtendThreadPoolTest.class);

    static class ThreadTask implements Runnable {

        private String taskName;

        public ThreadTask (String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            logger.info("Thread ID: {} - Thread Name：{}", Thread.currentThread().getId(), Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        }
    }

    public static void main(String[] args) {
        //手动创建线程池并扩展预留接口
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L,
                                            TimeUnit.SECONDS, new LinkedBlockingDeque<>(32)) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                logger.info("Thread start: {}" , ( (ThreadTask) r ).taskName );
            }


            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                logger.info("Thread end: {}" , ( (ThreadTask) r ).taskName );
            }

            @Override
            protected void terminated() {
                logger.info("Thread pool terminated." );
            }
        };

        for (int i = 0; i < 5; ++i) {
            ThreadTask threadTask = new ThreadTask("THREAD-ZYH-" + i);
            executorService.execute(threadTask);
        }

        executorService.shutdown();
    }
}
