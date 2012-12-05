package mobil;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JEditorPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class JTextAreaE extends JEditorPane implements FocusListener {

	private static final long serialVersionUID = 5303642699878617031L;

	private ArrayList<Word> words = new ArrayList<Word>();

	private Word actual = null;
	private int actualNum = -1;
	private int offset = -1;

	public JTextAreaE() {
		super("text/html", "");
		setKeymap(null); // vypne povodneho KeyListenera
		InteligentBorder border = new InteligentBorder(); // inteligentne
															// oramaovanie
		EmptyBorder margin = new EmptyBorder(17, 17, 17, 17);
		setBorder(new CompoundBorder(border, margin));
                this.setFont(new Font("Verdana", Font.PLAIN, 14));
                
                
		// zabezpeci ze this bude mat vzdy focus
		addFocusListener(this); // nastavi FucusListenera na seba

	}

        /*
         * just shit
         */
	public void cursor_left() {
                     
             // just shit
               setCaretPosition(getCaretPosition()-1);
                      
               int pos=0;
               int cpos=getCaretPosition(); 
              
               for(int i=0;i<actualNum;i++)
               {
                   pos+=words.get(i).getLength();
                   
                   if(pos>cpos)
                   {
                       actual=words.get(i);
                       actualNum=i;
                       offset=pos-cpos;
                       return;
                   }
               }
               
	}

	public void cursor_right() {
		if (offset < actual.getLength() - 1)
			offset++;
		else if (offset == actual.getLength()) {
			if (actualNum < actual.getLength() - 1) {
				actualNum++;
				actual = words.get(actualNum);
				offset = 0;
			}
		}
		updateContent();
	}

	public void nextT9Word() {
		if (actual instanceof T9Word) {
			T9Word w = (T9Word) actual;
			w.next();
			updateContent();
		}

		InteligentBorder.part = (InteligentBorder.part + 1)
				% InteligentBorder.parts;
		repaint();
	}
        
        public void preT9Word() {
		if (actual instanceof T9Word) {
			T9Word w = (T9Word) actual;
			w.pre();
			updateContent();
		}

		InteligentBorder.part = (InteligentBorder.part - 1)
				% InteligentBorder.parts;
                
                if(InteligentBorder.part==-1)
                {
                    InteligentBorder.part=InteligentBorder.parts-1;
                }
                
		repaint();
	}

	public void send_key(String key, boolean T9) {

		// mazanie
		if (key.charAt(0) == '\\') {
			if (key.charAt(1) == 'b') {
                        try {                            
                            
                            //System.out.println("-"+getDocument().getText(getCaretPosition()-1,1)+"-");
                            char xxx=getDocument().getText(getCaretPosition()-1,1).charAt(0);
                            
                            if( xxx==8194) //space shit
                            {
                                offset--;
                                actual.delete(offset);
                                offset--;
                                actual.delete(offset);
                                offset--;
                                actual.delete(offset);
                                offset--;
                                actual.delete(offset);
                                offset--;
                                actual.delete(offset);
                                 offset--;
                                actual.delete(offset);
                                offset--;
                                actual.delete(offset);

                                   
                                if(T9) 
                                {
                                words.remove(actualNum); // mazanie prazdneho slova ho
                                                                                                        // odstrani z fronty
                                                actualNum = words.size() - 1;

                                                if (actualNum >= 0) {
                                                        actual = words.get(actualNum);
                                                        offset = actual.getLength();
                                                } else {
                                                        actual = null;
                                                        offset = -1;
                                                }
                                }
                                updateContent();
                                return;
                            }
                         
                            
                            
                            
                            
                            
                            
                            
                            
                                if (actual != null) {

                                        if (actual.getLength() > 1) // slovo obsahuje nejake pismena
                                        {
                                                if (offset > 0) {
                                                        offset--;
                                                        actual.delete(offset);
                                                }

                                        } else {
                                                words.remove(actualNum); // mazanie prazdneho slova ho
                                                                                                        // odstrani z fronty
                                                actualNum = words.size() - 1;

                                                if (actualNum >= 0) {
                                                        actual = words.get(actualNum);
                                                        offset = actual.getLength();
                                                } else {
                                                        actual = null;
                                                        offset = -1;
                                                }
                                        }
                                }
                        } catch (BadLocationException ex) {
                            //Logger.getLogger(JTextAreaE.class.getName()).log(Level.SEVERE, null, ex);
                        }
			}
		}

		else {         /// ===================== FUCKING SPACE
                               if(key.equals(" "))
                                {
                                    if(T9 || words.size() == 0 || actual instanceof T9Word)
                                    {
                                        words.add(new NormalWord());
					actualNum = words.size() - 1;
					actual = words.get(actualNum);
					offset = 0;
                                    }
                                    actual.insert(offset, '&');
                                    offset++;
                                    actual.insert(offset, '#');
                                    offset++;
                                    actual.insert(offset, '8');
                                    offset++;
                                    actual.insert(offset, '1');
                                    offset++;
                                    actual.insert(offset, '9');
                                    offset++;
                                    actual.insert(offset, '4'); 
                                    offset++;
                                    actual.insert(offset, ';'); 
                                    offset++;
                                    updateContent();
                                    //System.out.println(getText());
                                    return;
                                }
                    
			if (T9) {
				
                            
                                if (words.size() == 0 || actual instanceof NormalWord) {
					words.add(new T9Word());
					actualNum = words.size() - 1;
					actual = words.get(actualNum);

					offset = 0;
				}

				boolean result = actual.insert(offset, key.charAt(0));
				offset++;

				if (result == false) {
					words.add(new T9Word());
					actualNum = words.size() - 1;
					actual = words.get(actualNum);
					offset = 0;
					actual.insert(offset, key.charAt(0));
				}
                                
			}

			else {
                              if (words.size() == 0 || actual instanceof T9Word) {
					words.add(new NormalWord());
					actualNum = words.size() - 1;
					actual = words.get(actualNum);
					offset = 0;
				}
				// v tomto momente je na vrchole urcite normalne slovo
				actual.insert(offset, key.charAt(0));
				offset++;
			}

		}
		updateContent();
	}

	void updateContent() {
		String text = "";
		int cp = 0;

		if (actual instanceof NormalWord || actual == null) {
			InteligentBorder.part = 1;
			InteligentBorder.parts = 1;
		}

		for (int i = 0; i < words.size(); i++) {
			if (i < actualNum) {
				cp += words.get(i).getLength();
			}

			if (i == 0) {
				if (i == actualNum && actual instanceof T9Word) {
					text = "<u>" + words.get(i).toString() + "</u>";

				} else {
					text = words.get(i).toString();
				}
			} else {
				if (i == actualNum && actual instanceof T9Word) {
					text += "<u>" + words.get(i).toString() + "</u>";

				} else {
					text += words.get(i).toString();
				}
			}
		}

		setText(text);

		setCaretPosition(getDocument().getLength());
		/*
		 * if (cp == 0 && offset == 0) { setCaretPosition(0); } else {
		 * setCaretPosition(cp + offset + 1); }
		 */
	}

	// ****************************************************************************************
	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		requestFocusInWindow();

	}

}
