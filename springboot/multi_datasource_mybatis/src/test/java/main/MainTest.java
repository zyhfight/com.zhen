<<<<<<< HEAD
package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Copyright: Copyright (c) 2017
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: 80234697
 * @date: 2018-7-26
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-26     80234697           v1.0.0               修改原因
 */
public class MainTest {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    public static void main(String[] args) {
        DateFormat dateFormat = df.get();
        System.out.println(dateFormat.format(new Date()));

        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        System.out.println(clock);
        System.out.println(instant);

        ThreadLocalRandom random = ThreadLocalRandom.current();

    }
}
=======
package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Copyright: Copyright (c) 2017
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: 80234697
 * @date: 2018-7-26
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-7-26     80234697           v1.0.0               修改原因
 */
public class MainTest {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    public static void main(String[] args) {
        DateFormat dateFormat = df.get();
        System.out.println(dateFormat.format(new Date()));

        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        System.out.println(clock);
        System.out.println(instant);

        ThreadLocalRandom random = ThreadLocalRandom.current();

    }
}
>>>>>>> e9c0499fbf2b802d8042d77019f8f202c2070c63
