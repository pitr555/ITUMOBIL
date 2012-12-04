/*--------------------------------------//
 * AUTOR: PETR PYSZKO (xpyszk02)*       
 * PROJEKT:
 *  - tento komentar jsem udelal v githubu
 * - a tento na lokalu
 *  - znovu v githubu
 */
 //-------------------------------------//

package mobil;

import java.awt.event.KeyEvent;
import java.util.Timer;

/**
 * chytra trida pro vypis mobilnim zpusobem
 * @author Petr Pyszko (xpyszk02)
 */
public class Smart {

    public JTextAreaE ta=null;
    int i=0;
    int curKey=0;
    Timer timer=new Timer();
    static final char[] t1={'.',',','!','?'};
    static final char[] t2={'a','b','c'};
    static final char[] t3={'d','e','f'};
    static final char[] t4={'g','h','i'};
    static final char[] t5={'j','k','l'};
    static final char[] t6={'m','n','o'};
    static final char[] t7={'p','q','r','s'};
    static final char[] t8={'t','u','v'};
    static final char[] t9={'w','x','y','z'};
    static final char[] t10={' '};
    static final char[] t11={' '};
    static final char[] t12={' '};
    static char[][] bchars={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12};
    
    
    /**
     * chytra funkce pro psani znaku
     * @param key 
     */
    public void newKey(int key)
    {
        char[] chars; 
        chars=bchars[key-1];
                
        
//        // novy znak konec timoutu vypis hned
//        if(curKey!=key)
//        {
//           timer.cancel();
//           timer=new Timer(); 
//           timer.schedule(new Timeout(), 300);
//           System.out.print((chars[i%chars.length]));           
//           return;
//        }
            
        // kontrola timeoutu
        if(StaticVars.isTimeoff() || curKey!=key)
        {        
            i=0;
            printChar('x');
            StaticVars.isTimeoff(false);
        }
        printChar('\b');
        printChar((chars[i%chars.length]));                
        i++;
                
        timer.cancel();
        timer=new Timer(); 
        timer.schedule(new Timeout(), 350);
        curKey=key;
    
    }
    
    /**
     * chytre vrati popisek butonu
     * @param number
     * @return 
     */
    public String getName(int number)
    {
        if(number==10)
            return "*";
        if(number==12)
            return "#";
        if(number==11)
            return "0";
        else 
            return String.valueOf(number);
            
    }
    
    /**
     * chytre vrati znaky na butonu
     * @param number
     * @return 
     */
    public String getChars(int number)
    {

        String str="";  
        if(number==11)
             return "__";
                       
        if(number==10)
             return "<-T9->";
        if(number==12)
            return "^shift^";
        
        for(char c : bchars[number-1])
            str+=" "+c;
        return str;
    
    }
    
    /**
     *
     * @param number
     * @return
     */
    public String getCharsShift(int number)
    {

        String str="";  
        if(number==11)
             return "__";
                       
        if(number==10)
             return "<-T9->";
        if(number==12)
            return "^shift^";
        
        for(char c : bchars[number-1])
            str+=" "+ c;
        return str.toUpperCase();
    
    }
    
    public void printChar(char c)
    {
        if(c=='\b')
        {
            ta.send_key("\\b",false);
            return;
        }
        if (StaticVars.isShift)
        {
            c=Character.toUpperCase(c);
        }
        
        if(StaticVars.isShift)
        {
            //System.out.print(Character.toUpperCase(c));
            ta.send_key(c+"",false);
        }
        else
        {
           //System.out.print(c);
           ta.send_key(c+"",false);
        }    
    }
    // tiskne
    public void printChar(char c,boolean isT9)
    {
        ta.send_key(c+"", isT9);
    }
    
    
    static int getNumberByKeyCode(int k)
    {
        
        if(k==KeyEvent.VK_Q)
            return 1;
        if(k==KeyEvent.VK_W)
            return 2;
        if(k==KeyEvent.VK_E)
            return 3;
        if(k==KeyEvent.VK_A)
            return 4;
        if(k==KeyEvent.VK_S)
            return 5;
        if(k==KeyEvent.VK_D)
            return 6;
        if(k==KeyEvent.VK_Y)
            return 7;
        if(k==KeyEvent.VK_X)
            return 8;
        if(k==KeyEvent.VK_C)
            return 9;
        if(k==KeyEvent.VK_CONTROL)
            return 10;
        if(k==KeyEvent.VK_SPACE)
            return 0;
        if(k==KeyEvent.VK_SHIFT)
            return 12;     
        if(k==KeyEvent.VK_BACK_SPACE)
            return 666;   
        
       return -1;
    }
    
    
}
