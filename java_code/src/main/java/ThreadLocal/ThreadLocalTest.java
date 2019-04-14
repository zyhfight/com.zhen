package ThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : zyh
 * @Description : ThreadLocal
 * @date : 2019-04-07 16:37
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    private static Executor executor = new AsyncThreadPool().getAsyncExecutor();

    private static ThreadLocal<String> transmitThreadLocal = new TransmittableThreadLocal<>();

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,5,5,
            TimeUnit.MINUTES, new LinkedBlockingDeque<>(100));


    public static void test1() {
        executor.execute( () -> {
           String value = transmitThreadLocal.get();
            transmitThreadLocal.set("Sub Thread");
           System.out.println("Sub Thread Value: " + value);
        } );
    }

    public static void test2() {
        executor.execute( () -> {
            String value = transmitThreadLocal.get();
            System.out.println("Sub Thread Value: " + value);
        } );
    }

    public static void main(String[] args) {

        transmitThreadLocal.set("Hello");

        System.out.println("Main Thread Value: " + transmitThreadLocal.get());

        test1();

        test2();

        System.out.println("Main Thread End.");
    }

}
