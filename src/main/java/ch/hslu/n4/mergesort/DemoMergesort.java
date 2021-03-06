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
package ch.hslu.n4.mergesort;

import ch.hslu.a1.Sort;
import ch.hslu.n4.array.init.RandomInitTask;
import ch.hslu.n4.array.sum.SumTask;

import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Performance Vergleich der Mergesort-Implementation.
 */
public final class DemoMergesort {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.n4.mergesort.DemoMergesort.class);

    /**
     * Privater Konstruktor.
     */
    private DemoMergesort() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        final int size = 500_000_000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();
        RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        SumTask sumTask = new SumTask(array);
        long result = pool.invoke(sumTask);
        LOG.info("Init. Checksum  : {}", result);
        
        final MergesortTask sortTask = new MergesortTask(array);
        long startTime = java.lang.System.currentTimeMillis();
        pool.invoke(sortTask);
        long testDuration = java.lang.System.currentTimeMillis() - startTime;
        LOG.info("Conc. Mergesort : {} ms.", testDuration);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Merge Checksum  : {}", result);
        initTask = new RandomInitTask(array, 100);
        
        /*
		// Gleicher Test mit sequentiellem BubbleSort()
        testDuration = java.lang.System.currentTimeMillis();
        Sort.bubbleSort(array);
        testDuration = java.lang.System.currentTimeMillis() - startTime;
        LOG.info("Conc. bubbleSort : {} ms.", testDuration);
        
        pool.invoke(initTask);
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Init. checksum  : {}", result);
        MergesortRecursive.mergeSort(array);
        LOG.info("MergesortRec.   : {} sec.", '?');
        sumTask = new SumTask(array);
        result = pool.invoke(sumTask);
        LOG.info("Sort checksum   : {}", result);
        */
    }
}
