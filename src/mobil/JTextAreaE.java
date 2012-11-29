import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class JTextAreaE extends JEditorPane implements FocusListener{
	

	private static final long serialVersionUID = 5303642699878617031L;

	private ArrayList<Word> words = new ArrayList<Word>();
	
	private Word actual = null;
	private int actualNum = -1;
	private int offset = -1;
	
	public JTextAreaE()
	{
		super("text/html", "");
    	setKeymap(null); // vypne povodneho KeyListenera
    	InteligentBorder border = new InteligentBorder(); // inteligentne oramaovanie
    	EmptyBorder margin = new EmptyBorder(10,10,10,10);
    	setBorder(new CompoundBorder(border, margin));
    	
    	// zabezpeci ze this bude mat vzdy focus
    	addFocusListener(this); // nastavi FucusListenera na seba 	
    	
	}
	
	
	public void cursor_left()
	{
		System.out.println("offset " + offset);
		if (offset > 1)
			offset--;
		else if(offset == 1)
		{
			if (actualNum > 0)
			{
				actualNum--;
				actual = words.get(actualNum);
				offset = actual.getLength();
			}
		}
		updateContent();
	}
	
	public void cursor_right()
	{
		if (offset < actual.getLength() - 1)
			offset++;
		else if(offset == actual.getLength())
		{
			if (actualNum < actual.getLength() - 1)
			{
				actualNum++;
				actual = words.get(actualNum);
				offset = 0;
			}
		}
		updateContent();
	}

	
	public void nextT9Word()
	{
		InteligentBorder.part = (InteligentBorder.part + 1) % InteligentBorder.parts;
		repaint();
	}


	public void send_key(String key, boolean T9)
	{
		if (T9)
		{
			
			if (words.size() == 0 || actual instanceof NormalWord)
			{
				words.add(new T9Word());
				actualNum = words.size() - 1;
				actual = words.get(actualNum);
				
				offset = 0;
			}		
			
			if (key.charAt(0) == '\\')
			{
				if (key.charAt(1) == 'b')
				{
					if (actual.getLength() > 0) // slovo obsahuje nejake pismena
					{
						if (offset > 0)
						{
							offset--;
							actual.delete(offset);
						}
						
					}
					else
					{
						words.remove(words.size() - 1); // mazanie prazdneho slova ho odstrani z fronty
					}
				}
			}
			else
			{
				
				boolean result = actual.insert(offset, key.charAt(0));
				offset++;
				
				if (result == false)
				{
					words.add(new T9Word());
					actualNum = words.size() - 1;
					actual = words.get(actualNum);
					offset = 0;
					actual.insert(offset, key.charAt(0));
				}
				
				
			}				
		}
		else
		{
	
			if (words.size() == 0 || actual instanceof T9Word)
			{
				words.add(new NormalWord());
				actualNum = words.size() - 1;
				actual = words.get(actualNum);
				offset = 0;
			}
	
			// v tomto momente je na vrchole urcite normalne slovo
			
			if (key.charAt(0) == '\\')
			{
				if (key.charAt(1) == 'b')
				{
					if (actual.getLength() > 0) // slovo obsahuje nejake pismena
					{
						if (offset > 0)
						{
							offset--;
							actual.delete(offset);
						}
						
					}
					else
					{
						words.remove(words.size() - 1); // mazanie prazdneho slova ho odstrani z fronty
					}
				}
			}
			else
			{
				
				actual.insert(offset, key.charAt(0));
				offset++;
				
			}	
			
		}
		updateContent();
	}
	
	
	void updateContent()
	{
		String text = null;
		int cp = 0;
		
		for (int i = 0; i < words.size(); i++)
		{
			if (i < actualNum)
			{
				cp += words.get(i).getLength();
			}
			
			if (i == 0)
			{
				if (i == actualNum)
				{
					text = "<u>" + words.get(i).toString() + "</u>";
				}
				else
				{
					text = words.get(i).toString();
				}
			}
			else
			{
				if (i == actualNum)
				{
					text += "<u>" + words.get(i).toString() + "</u>";
				}
				else
				{
					text += words.get(i).toString();
				}
			}
		}

		setText(text);
		
		
		setCaretPosition(cp + offset + 1);
	}

//****************************************************************************************
	@Override
	public void focusGained(FocusEvent e) {
	
		
	}


	@Override
	public void focusLost(FocusEvent e) {
		requestFocusInWindow();
		
	}

}