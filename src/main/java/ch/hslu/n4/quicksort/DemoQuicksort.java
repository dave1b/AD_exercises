/*
 * Copyright 2021 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.n4.quicksort;

import ch.hslu.n4.array.init.RandomInitTask;
import ch.hslu.n4.array.sum.SumTask;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Vergleich von verschiedenen Quicksort-Implementationen.
 */
public final class DemoQuicksort {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.n4.quicksort.DemoQuicksort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoQuicksort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 1_000_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();
        
        
        RandomInitTask initTask = new RandomInitTask(array, 100);
        
        
        // pool.invoke(sortTask);
        pool.invoke(initTask);
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.info("Init. Checksum : {}", result);
        final QuicksortTask sortTask = new QuicksortTask(array);
        long startTime = java.lang.System.currentTimeMillis();
        pool.invoke(sortTask);
        long duration = java.lang.System.currentTimeMillis() - startTime;
        LOG.info("QuicksortTask  : {} ms.", duration);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Conc. Checksum : {}", result);
        System.out.println();
        
        // QuicksortRecursive.quicksort(array);
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. Checksum : {}", result);
        startTime = java.lang.System.currentTimeMillis();
        QuicksortRecursive.quicksort(array);
        duration = java.lang.System.currentTimeMillis() - startTime;
        LOG.info("QuicksortRec.  : {} ms.", duration);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Recu. Checksum : {}", result);
        System.out.println();
        
        
        // Arrays.sort(array);
        initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. checksum : {}", result);
        startTime = java.lang.System.currentTimeMillis();
        Arrays.sort(array);
        duration = java.lang.System.currentTimeMillis() - startTime;
        LOG.info("Arrays.sort    : {} ms.", duration);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Sort checksum  : {}", result);
        System.out.println();
    }
}
