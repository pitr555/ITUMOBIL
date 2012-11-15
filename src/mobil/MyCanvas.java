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
    //============================================================= main
    public static void main(String[] args) {
       
    	MyCanvas mc = new MyCanvas();

    	textArea = new JTextAreaE();
    	textArea.setEditable(false);
    	
    	textArea.setPreferredSize(new Dimension(300,200));
    	textArea.setWrapStyleWord(true);
    	textArea.setLineWrap(true);
    	

    	
    	//textArea.send_key("\n", false);
 
    	
    	
    	textArea.setSelectionStart(5);
    	textArea.setSelectionEnd(7);
    	

    	JPanel p = new JPanel(true);
    	p.add(textArea);
    	
    	
    	InteligentBorder border = new InteligentBorder();
    	EmptyBorder margin = new EmptyBorder(10,10,10,10);
    	textArea.setBorder(new CompoundBorder(border, margin));

    	
    	JFrame jf = new JFrame();
    	jf.getContentPane().add(p);
    	jf.setPreferredSize(new Dimension(400,300));
    	jf.pack();
    	textArea.addMouseListener(mc);
    	textArea.addKeyListener(mc);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Hi");
		InteligentBorder.part = (InteligentBorder.part + 1) % InteligentBorder.parts;
		textArea.repaint();
		
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
		
		
		if (e.getKeyCode() == KeyEvent.VK_0)
		{
			textArea.send_key("\\", false);
		}
		else
		{
			char c = e.getKeyChar();
			//System.out.println(c);
			textArea.send_key(c + "", false);
		}
		textArea.updateContent();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}



