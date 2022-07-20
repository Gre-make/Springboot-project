package com.lwc.admin.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class PoolUnit {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    private static final ExecutorService singleService1 = Executors.newSingleThreadExecutor();

    public static ExecutorService getInstance() {
        return executorService;
    }

    public static ExecutorService getSingle() {
        return singleService1;
    }
}
