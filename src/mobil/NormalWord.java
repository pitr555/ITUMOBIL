package mobil;

public class NormalWord extends Word {
	
	private StringBuffer content = new StringBuffer();
	
	
	public boolean insert(int offset,char c)
	{
		content.insert(offset,c);
		return true;
	}
	
	
	public void delete(int offset)
	{
		if (content.length() > 0)
		{
			content.deleteCharAt(offset);
		}
	}
	
	@Override
	public String toString() {
	
		return content.toString();
	}


	public int getLength() {		
		return content.length();
	}

}
