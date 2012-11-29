package mobil;

import java.util.ArrayList;


public class Test {
	
	public static void main(String [] args)
	{
		
		NormalWord nw = new NormalWord();
		
		T9Word w = new T9Word();
		w.insert(0, '2');
		w.insert(1, '2');
		w.insert(2, '3');
		

		
		System.out.println(w);
		
		//nw.content = "abcdefgh";
		

		/*nw.nextChar('a');
		nw.nextChar('b');
		nw.nextChar('c');
		nw.deleteLast();
		nw.deleteLast();
		nw.deleteLast();
		nw.deleteLast();*/
		//System.out.println(nw.content);
		
		/*try {
			ArrayList<String> al = DatabaseConector.getWords("9872",""); //+ cislo
			// ak by bolo prazdne zacina nove t9 slovo
			for (int i = 0; i < al.size(); i++)
			{
				System.out.println(al.get(i));
			}
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}*/
		
	}

}
