package ch.hslu.einfuehrung;

import java.util.Objects;



public final class Allocation implements Comparable<Allocation> {

	private final int address;
	private final int size;
	
	public Allocation(int address, int size) {
        this.address = address;
        this.size = size;
	}

	
	public int getAddress() {
		return this.address;
	}
	public int getSize() {
		return this.size;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(this.address), Integer.valueOf(this.size));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Allocation other = (Allocation) obj;
		if (address != other.address)
			return false;
		if (size != other.size)
			return false;
		return true;
	}


	@Override
	public int compareTo(Allocation o) {
		if(this == o) {
			return 0;
		} else {	
			return Integer.compare(this.getAddress(), o.getAddress());
		} // return this.getAddress().compareTo( o.getAddress() );
	}


	@Override
	public String toString() {
		return "Allocation [address=" + address + ", size=" + size + "]";
	}

	

	
	
	
}
