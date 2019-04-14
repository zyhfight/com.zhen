package ThreadLocal;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : zyh
 * @Description : ThreadLocal
 * @date : 2019-04-14 21:55
 */
public class AsyncThreadPool implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,5,5,
                TimeUnit.MINUTES, new LinkedBlockingDeque<>(100));
        return TtlExecutors.getTtlExecutor(threadPoolExecutor);
    }


    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
