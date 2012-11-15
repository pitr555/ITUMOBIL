import java.util.ArrayList;


public class Test {
	
	public static void main(String [] args)
	{
		
		/*NormalWord nw = new NormalWord();
		//nw.content = "abcdefgh";
		

		nw.nextChar('a');
		nw.nextChar('b');
		nw.nextChar('c');
		System.out.println(nw.content);*/
		
		try {
			ArrayList<String> al = DatabaseConector.getWords("9",""); //+ cislo
			// ak by bolo prazdne zacina nove t9 slovo
			for (int i = 0; i < al.size(); i++)
			{
				System.out.println(al.get(i));
			}
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
	}

}
