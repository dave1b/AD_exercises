package ch.hslu.n2.signal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SemaphoreTest {

	Semaphore simpleSem = new Semaphore(5);
	Semaphore sem = new Semaphore(5,7);
	
	@Test
	void testSemaphore() throws InterruptedException {
		System.out.println(simpleSem.pending());
		assertEquals(0, simpleSem.pending());
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		assertEquals(0, simpleSem.pending());
	}

	

	@Test
	void testAcquire() throws Exception {
		assertEquals(0, simpleSem.pending());
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.release();
	}
	@Test
	void testRelease() throws Exception {
		assertEquals(0, simpleSem.pending());
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.acquire();
		simpleSem.release();
		simpleSem.release();
		simpleSem.release();
		simpleSem.release();
		simpleSem.release();
		Assertions.assertThrows(Exception.class, () -> {
			simpleSem.release();;
		});
		sem.acquire(2);
		sem.release(2);
		Assertions.assertThrows(Exception.class, () -> {
			sem.release(2);;
		});
	}
	
	@Test
	void testAquirePermit() throws InterruptedException {
		Semaphore sema = new Semaphore(3,3);
		sema.acquire(5);
		
		
	}

	@Test
	void testDefaultConstructor() {
		Semaphore sem2 = new Semaphore();
	}
	@Test
	void testConstructor1Parameter() {
		Semaphore sem2 = new Semaphore(10);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Semaphore sem = new Semaphore(-5);;
		});
	}

	@Test
	void testConstructor2Parameter() {
		Semaphore sem2 = new Semaphore(10,10);
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 Semaphore sem = new Semaphore(15,10);;
			  });
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 Semaphore sem = new Semaphore(-2,0);;
		 });
		
	}

	


}
