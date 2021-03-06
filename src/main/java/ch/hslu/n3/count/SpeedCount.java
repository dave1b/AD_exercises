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
package ch.hslu.n3.count;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Speed-Test für unterschiedlich impementierte Counters.
 */
public final class SpeedCount {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.n3.count.SpeedCount.class);

    /**
     * Privater Konstruktor.
     */
    private SpeedCount() {
    }

    /**
     * Test für einen Counter.
     * @param counter Zählertyp.
     * @param counts Anzahl Zähl-Vorgänge.
     * @param tester Anzahl Tester-Threads.
     * @return Dauer des Tests in mSec.
     */
    public static long speedTest(Counter counter, int counts, int tester) {
    	long startTime = java.lang.System.currentTimeMillis();
    	System.out.println(startTime);
        final ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < tester; i++) {
            executor.submit(new CountTask(counter, counts));
        }
        executor.shutdown();
        try {
			executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long duration = java.lang.System.currentTimeMillis() - startTime;
        System.out.println(duration);
        return duration;
    }

    /**
     * Main-Counter-Test.
     * @param args not used.
     */
    public static void main(final String args[]) {
        final int passes = 13;
        final int tester = 1;
        final int counts = 10_000;
        final Counter counterSync = new SynchronizedCounter();
        long sumSync = 0;
        for (int i = 0; i < passes; i++) {
            sumSync += speedTest(counterSync, counts, tester);
        }
        final Counter counterAtom = new AtomicCounter();
        long sumAtom = 0;
        for (int i = 0; i < passes; i++) {
            sumAtom += speedTest(counterAtom, counts, tester);
        }
        
        System.out.println(counterSync.get());
        if (counterSync.get() == 0) {
            LOG.info("Sync counter ok");
            LOG.info("Sync counter average test duration = {} ms", sumSync / (float) passes);
        } else {
            LOG.info("Sync counter failed");
        }
        if (counterAtom.get() == 0) {
            LOG.info("Atom counter ok");
            LOG.info("Atom counter average test duration = {} ms", sumAtom / (float) passes);
        } else {
            LOG.info("Atom counter failed");
        }
    }
}
