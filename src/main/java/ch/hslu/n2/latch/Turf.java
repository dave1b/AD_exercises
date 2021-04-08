/*
 * Copyright 2021 Hochschule Luzern - Informatik.
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
package ch.hslu.n2.latch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LogManager.getLogger(ch.hslu.n2.latch.Turf.class);

    /**
     * Privater Konstruktor.
     */
    private Turf() {
    }

    /**
     * Main-Demo.
     * @param args not used.
     * @throws InterruptedException 
     */
    public static void main(final String[] args) throws InterruptedException {
        final Synch starterBox = new Latch();
        Thread thread;
        Thread[] pferde = new Thread[6];
        for (int i = 1; i < 6; i++) {
            pferde[i] = new Thread(new RaceHorse(starterBox), "Horse " + i);
            pferde[i].start();
        }
        LOG.info("Start...");
      
    	  java.util.concurrent.TimeUnit.MILLISECONDS.sleep(100);
	

        starterBox.release();
//        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(100);
//        for (int i = 1; i < 6; i++) {
//        	pferde[i].interrupt();
//        }
    }
}
