package ch.hslu.einfuehrung;

public interface Memory {

	

    public void free(Allocation block);

    public Allocation malloc(int mallocsize);
    
    public int getAddress();
   
    
    public int getUsedMemory();
	
}
