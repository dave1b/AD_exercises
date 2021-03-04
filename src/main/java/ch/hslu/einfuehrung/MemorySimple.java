package ch.hslu.einfuehrung;

public class MemorySimple implements Memory {

	private int memorysize;
	private int address;
	private int usedmemory;

	public MemorySimple(int memorysize) {
		// super(memorysize);
		this.memorysize = memorysize;
		this.usedmemory = 0;
	}

	@Override
	public Allocation malloc(int mallocsize) {
		this.memorysize = memorysize - mallocsize;
		this.usedmemory = usedmemory + mallocsize;
		// this.address = address;
		address = address + mallocsize;
		// System.out.println("MemorySimple Klasse!");
		return new Allocation(address - mallocsize, mallocsize);
	}

	@Override
	public String toString() {
		return "MemorySimple[" + usedmemory + " von " + memorysize + " belegt]";
	}

	@Override
	public void free(Allocation block) {
		this.address = 0;
		this.memorysize = 0;
		this.usedmemory = 0;
	}

	@Override
	public int getAddress() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public int getUsedMemory() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

}
