
public class NormalWord extends Word {
	
	String content = "";
	
	
	
	void nextChar(char c)
	{
		content = content + c;
	}
	
	
	void deleteLast()
	{
		content = content.substring(0, content.length() - 1);
	}
	
	@Override
	public String toString() {
	
		return content;
	}

}
