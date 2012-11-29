package mobil;

public abstract class Word {
	
	public abstract int getLength();
	public abstract void delete(int offset);
	public abstract boolean insert(int offset, char charAt);
	

}
