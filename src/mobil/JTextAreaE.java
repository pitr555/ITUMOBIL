import java.util.ArrayList;

import javax.swing.JTextArea;


public class JTextAreaE extends JTextArea{
	
	ArrayList<Word> words = new ArrayList<Word>();
	
	



	void send_key(String key, boolean T9)
	{
		if (T9)
		{
			
		}
		else
		{
			// je na vrchole normalne slovo alebo nie
			if (words.size() == 0)
			{
				words.add(new NormalWord());
			}
		    
			Word lastWord = words.get(words.size() - 1);
			
			if (lastWord instanceof T9Word)
			{
				words.add(new NormalWord());
				lastWord = words.get(words.size() - 1);
			}
			
			
			// v tomto momente je na vrchole urcite normalne slovo
			NormalWord lastWordNormal = (NormalWord) lastWord;
			
			if (key.charAt(0) == '\\')
			{
				if (key.charAt(1) == 'b')
				{
					if (lastWordNormal.content.length() > 0) // slovo obsahuje nejake pismena
					{
						lastWordNormal.deleteLast();
					}
					else
					{
						words.remove(words.size() - 1); // mazanie prazdneho slova ho odstrani z fronty
					}
				}
			}
			else
			{
				lastWordNormal.nextChar(key.charAt(0));
			}
			
			
			
				
			
		}
	}
	
	
	void updateContent()
	{
		String text = "";
		for (int i = 0; i < words.size(); i++)
		{
			text += words.get(i).toString();
		}
		setText(text);
	}

}
