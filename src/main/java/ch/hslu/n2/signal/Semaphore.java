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
package ch.hslu.n2.signal;

/**
 * Ein nach oben nicht begrenztes Semaphor, d.h. der Semaphorenzähler kann
 * unendlich wachsen.
 */
public final class Semaphore {

	private int sema; // Semaphorenzähler
	private int count; // Anzahl der wartenden Threads.
	private int limit; // maximale Anzahl paralelle Zugriffe

	/**
	 * Erzeugt ein Semaphore mit 0 Passiersignalen.
	 */
	public Semaphore() {
		this(0);
	}

	/**
	 * Erzeugt ein Semaphore mit einem Initalwert für den Semaphorenzähler.
	 *
	 * @param permits Anzahl Passiersignale zur Initialisierung.
	 * @throws IllegalArgumentException wenn der Initalwert negativ ist.
	 */
	public Semaphore(final int permits) throws IllegalArgumentException {
		if (permits < 0) {
			throw new IllegalArgumentException(permits + " < 0");
		}
		this.sema = permits;
		this.limit = permits;
		count = 0;
	}

	/**
	 * Erzeugt ein nach oben begrenztes Semaphore.
	 *
	 * @param permits Anzahl Passiersignale zur Initialisierung.
	 * @param limit   maximale Anzahl der Passiersignale.
	 * @throws IllegalArgumentException wenn Argumente ungültige Werte besitzen.
	 */
	public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
		if (permits < 0 || limit < 0 || permits > limit) {
			throw new IllegalArgumentException(permits + " < 0");
		}
		this.limit = limit;
		this.sema = permits;
		count = 0;
	}

	/**
	 * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten Bereich,
	 * wobei mitgezählt wird, der wievielte Eintritt es ist. Falls der Zähler null
	 * ist wird der Aufrufer blockiert.
	 *
	 * @throws java.lang.InterruptedException falls das Warten unterbrochen wird.
	 */
	public synchronized void acquire() throws InterruptedException {
		while (sema == 0) {
			count++;
			this.wait();
			count--;
		}
		sema--;
	}

	/**
	 * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten Bereich,
	 * wobei mitgezählt wird, der wievielte Eintritt es ist.Falls der Zähler null
	 * ist wird der Aufrufer blockiert.
	 *
	 * @param permits Anzahl Passiersignale zum Eintritt.
	 * @throws java.lang.InterruptedException falls das Warten unterbrochen wird.
	 */
	public synchronized void acquire(final int permits) throws InterruptedException {
		while (sema < permits) {
			count = count + permits;
			this.wait();
			count--;
		}
		sema = sema - permits;

	}

	/**
	 * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten Bereiches,
	 * wobei ebenfalls mitgezählt wird, wie oft der Bereich verlassen wird.
	 * 
	 * @throws Exception
	 */
	public synchronized void release() throws Exception {
		if (sema == limit) {
			throw new Exception("The max limit of open Semaphors has been reacherd:" + limit);
		} else {
			sema++;
			if (limit == sema) {
				this.notifyAll();
			} else {
				this.notify();
			}
		}
	}

	/**
	 * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten Bereiches,
	 * wobei mitgezählt wird, wie oft der Bereich verlassen wird.
	 *
	 * @param permits Anzahl Passiersignale zur Freigabe.
	 * @throws Exception 
	 */
	public synchronized void release(final int permits) throws Exception {
		if (sema+permits >= limit) {
			throw new Exception("The max limit of open Semaphors has been reacherd:" + limit);
		} else {
			sema = sema + permits;
			if (limit == sema) {
				this.notifyAll();
			} else {
				this.notify();
			}
		}
	}

	/**
	 * Lesen der Anzahl wartenden Threads.
	 *
	 * @return Anzahl wartende Threads.
	 */
	public synchronized int pending() {
		return count;
	}
}
