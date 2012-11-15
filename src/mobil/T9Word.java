
public class T9Word extends Word{
	
	String t9;
	String substring;
	int part;
	
	
	void nextChar(char c)
	{
		t9 = t9 + c;
	}
	
	
	void deleteLast()
	{
		t9 = t9.substring(0, t9.length() - 1);
	}

}
