package mobil;

import java.util.ArrayList;


public class T9Word extends Word{
	
	StringBuffer t9 = new StringBuffer();
	String substring = "";
	int part = 0;
	
	ArrayList<String>  options;
	

	@Override
	public int getLength() {
		return t9.length();
	}


	@Override
	public
	void delete(int offset) {
		
		
			substring = "";
			t9.deleteCharAt(offset);
			options = readOptions();
			InteligentBorder.part = 0;
			InteligentBorder.parts = options.size();
		

	}
	
	public void next() {
		part = (part + 1) % options.size();
	}


	@Override
	public boolean insert(int offset, char c) {
		if (t9.length() != 0)
		{
			substring = options.get(part);
		}
		
		t9.insert(offset,c);
		ArrayList<String> temp = readOptions();

		
		if (temp.size() == 0)
		{
			return false;
		}
		else
		{
			options = temp;
			part = 0;
			InteligentBorder.part = part;
			InteligentBorder.parts = options.size();
			return true;
		}	
	}
	
	private ArrayList<String> readOptions()
	{
		try {
			//return DatabaseConector.getWords(t9.toString(),substring.toString()); //+ cislo			
			return DatabaseConector.getWords(t9.toString(),"");
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String toString()
	{

		return options.get(part);
		
	}

}
