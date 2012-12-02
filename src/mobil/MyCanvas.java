package mobil;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;



public class MyCanvas implements MouseInputListener, KeyListener {
	static JTextAreaE textArea;
	static JFrame jf = new JFrame();
	boolean T9 = false;
	
    //============================================================= main
    public static void main(String[] args) {
       
    	MyCanvas mc = new MyCanvas();

    	textArea = new JTextAreaE();

    	
    	textArea.setPreferredSize(new Dimension(300,200));
    	
    	//textArea.setSelectionStart(5);
    	//textArea.setSelectionEnd(7);
       	textArea.addKeyListener(mc);
    	
    	JButton j = new JButton("Muhehe");
    	JPanel p = new JPanel(true);
    	p.add(textArea);
    	p.add(j);
   


    	
    	jf.getContentPane().add(p);
    	jf.setPreferredSize(new Dimension(400,300));
    	jf.pack();
    	jf.addMouseListener(mc);
 
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Hi");
		int i = textArea.getCaretPosition();
		textArea.setCaretPosition(i - 1);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	

		if (e.getKeyCode() == KeyEvent.VK_F1)
		{
			textArea.nextT9Word();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			textArea.cursor_left();			
		}		
		
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			textArea.cursor_right();			
		}			
		else if (e.getKeyCode() == KeyEvent.VK_F2)
		{
			textArea.send_key("\\b", T9);
		}
		else if (e.getKeyCode() == KeyEvent.VK_F3)
		{
			if (T9)
			{
				T9 = false;
				System.out.println("T9 vypnute");
			}
			else
			{
				T9 = true;
				System.out.println("T9 zapnute");
			}
		}
		else
		{
			char c = e.getKeyChar();
			
			textArea.send_key(c + "", T9);
			//textArea.setCaretPosition(textArea.getDocument().getLength());
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}



