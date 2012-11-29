/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mobil;

import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author Petr Pyszko (xpyszk02)
 */
public class GUI extends javax.swing.JFrame {

    // pomocne promenne
    int i=0;
    long now;
    boolean isT9=false;
    int autorepeat=0;
    boolean isDown=false;


    /**
     * Creates new form GUI
     */
    public GUI() {
                        
      
        // nejaky ten init
        
        s = new Smart(); 
        setLocation(StaticVars.wX, StaticVars.wY);
        setUndecorated(true);
        AWTUtilities.setWindowShape(GUI.this, StaticVars.getMobilShape());
        initComponents();
        initButtons();
        
      
        display.setLayout(new FlowLayout());
        JTextAreaE ta= new JTextAreaE();
        ta.setPreferredSize(new Dimension(310,255));
        s.ta=ta;
        
       ta.addKeyListener(new java.awt.event.KeyAdapter() {
           @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
           @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyReles(evt);
            }
        });
        
        display.add(ta);
        

        
    }
    
    
    /**
     * nastavi pole buttonu 
     */
    private void initButtons()
    {
        
        javax.swing.JButton[] butt={b1,b2,b3,b4,b5,b6,b7,b8,b9,bstar,b0,bsharp,bs,T9,left,right};
        buttons=butt;
        
        for(JButton b : buttons){
           i++;
            // nabarvi
            b.setFocusPainted(false);
            b.setBackground(Color.GRAY);
            
            if(i<=12)
            {   
                
                b.setText("");
                b.setLayout(new BorderLayout());
                JLabel l1 = new JLabel("      "+s.getName(i));
                JLabel l2;
                
                if(!StaticVars.isShift)
                    l2 = new JLabel("   "+s.getChars(i));
                else
                    l2 = new JLabel("   "+s.getCharsShift(i));
                
                l1.setFont(new Font("Ubuntu",Font.BOLD,16));
                b.add(BorderLayout.NORTH,l1);
                b.add(BorderLayout.SOUTH,l2);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        display = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        button_panel = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        bstar = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        bsharp = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        bs = new javax.swing.JButton();
        T9 = new javax.swing.JButton();
        left = new javax.swing.JButton();
        right = new javax.swing.JButton();
        move_panel = new javax.swing.JPanel();
        exit_b = new javax.swing.JLabel();
        phoneImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color( 0.0f,0.0f,0.0f,0.3f));
        setFocusable(false);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display.setBackground(new java.awt.Color(13, 13, 13));

        javax.swing.GroupLayout displayLayout = new javax.swing.GroupLayout(display);
        display.setLayout(displayLayout);
        displayLayout.setHorizontalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        displayLayout.setVerticalGroup(
            displayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 310, 260));

        jPanel1.setBackground(new Color(0f,0f,0f,0f));
        jPanel1.setFocusable(false);
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_click(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, 80, 80));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 88, -1, 40));

        button_panel.setBackground(new Color(0,0,0,0));

        b2.setText("jButton2");
        b2.setFocusable(false);
        b2.setRequestFocusEnabled(false);
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b3.setText("jButton3");
        b3.setFocusable(false);
        b3.setRequestFocusEnabled(false);
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b4.setText("jButton1");
        b4.setFocusable(false);
        b4.setRequestFocusEnabled(false);
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b5.setText("holahej");
        b5.setFocusable(false);
        b5.setRequestFocusEnabled(false);
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b6.setText("jButton3");
        b6.setFocusable(false);
        b6.setRequestFocusEnabled(false);
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b7.setText("jButton1");
        b7.setFocusable(false);
        b7.setRequestFocusEnabled(false);
        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b8.setText("jButton2");
        b8.setFocusable(false);
        b8.setRequestFocusEnabled(false);
        b8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b9.setText("jButton3");
        b9.setFocusable(false);
        b9.setRequestFocusEnabled(false);
        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        bstar.setText("jButton1");
        bstar.setFocusable(false);
        bstar.setRequestFocusEnabled(false);
        bstar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b0.setText("jButton2");
        b0.setFocusable(false);
        b0.setRequestFocusEnabled(false);
        b0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        bsharp.setText("jButton3");
        bsharp.setFocusable(false);
        bsharp.setRequestFocusEnabled(false);
        bsharp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        b1.setBackground(new java.awt.Color(133, 118, 118));
        b1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        b1.setText("jButton1");
        b1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        b1.setFocusable(false);
        b1.setRequestFocusEnabled(false);
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                b9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bXMouseRe(evt);
            }
        });

        bs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobil/backspace.PNG"))); // NOI18N
        bs.setText("smaž");
        bs.setFocusable(false);
        bs.setRequestFocusEnabled(false);
        bs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bsKeyPressed(evt);
            }
        });

        T9.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        T9.setText("T9");
        T9.setFocusable(false);
        T9.setRequestFocusEnabled(false);
        T9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T9MouseClicked(evt);
            }
        });

        left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobil/left_arrow.png"))); // NOI18N
        left.setFocusable(false);

        right.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobil/right_arrow.png"))); // NOI18N
        right.setFocusable(false);

        javax.swing.GroupLayout button_panelLayout = new javax.swing.GroupLayout(button_panel);
        button_panel.setLayout(button_panelLayout);
        button_panelLayout.setHorizontalGroup(
            button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button_panelLayout.createSequentialGroup()
                .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(bs, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(button_panelLayout.createSequentialGroup()
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(button_panelLayout.createSequentialGroup()
                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(button_panelLayout.createSequentialGroup()
                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(button_panelLayout.createSequentialGroup()
                .addComponent(bstar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(bsharp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        button_panelLayout.setVerticalGroup(
            button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button_panelLayout.createSequentialGroup()
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bs, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bstar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsharp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(button_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 310, 210));

        move_panel.setBackground(new Color(0,0,0,0));
        move_panel.setFocusable(false);
        move_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                move_panelMousePressed(evt);
            }
        });
        move_panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                move_panelMouseDragged(evt);
            }
        });

        exit_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobil/Exit.png"))); // NOI18N
        exit_b.setFocusable(false);
        exit_b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_evn(evt);
            }
        });

        javax.swing.GroupLayout move_panelLayout = new javax.swing.GroupLayout(move_panel);
        move_panel.setLayout(move_panelLayout);
        move_panelLayout.setHorizontalGroup(
            move_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, move_panelLayout.createSequentialGroup()
                .addContainerGap(307, Short.MAX_VALUE)
                .addComponent(exit_b, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        move_panelLayout.setVerticalGroup(
            move_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, move_panelLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(exit_b, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(move_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 80));

        phoneImg.setBackground(new java.awt.Color(1, 1, 1));
        phoneImg.setFont(phoneImg.getFont().deriveFont((float)18));
        phoneImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mobil/IPhone_3G.png"))); // NOI18N
        phoneImg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keyPress(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyReles(evt);
            }
        });
        getContentPane().add(phoneImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getAccessibleContext().setAccessibleName("frame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //========== UDALOSTI =========================//
    
    private void exit_click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_click
          if(button_panel.isVisible())
          {
              button_panel.setVisible(false);
              phoneImg.repaint();   
          }
          else
          {
              button_panel.setVisible(true);
          }
    }//GEN-LAST:event_exit_click

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        jPanel1.setBackground(new Color(255,255,255,15));
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        jPanel1.setBackground(new Color(0,0,0,0));
        phoneImg.repaint();
    }//GEN-LAST:event_jPanel1MouseExited

    private void move_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_move_panelMousePressed
      
        // poznamenam si start
        StaticVars.startX=evt.getX();
        StaticVars.startY=evt.getY();
    }//GEN-LAST:event_move_panelMousePressed

    private void move_panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_move_panelMouseDragged
                
        // draguju
         int dx=(StaticVars.startX-evt.getX());
         int dy=(StaticVars.startY-evt.getY());
         StaticVars.wX-=dx;
         StaticVars.wY-=dy;
         this.setLocation(StaticVars.wX, StaticVars.wY);

        
    }//GEN-LAST:event_move_panelMouseDragged

    private void bXMouseRe(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bXMouseRe
        
                
         phoneImg.repaint();      
        // sebere cislo
        JButton b=(JButton)evt.getSource();
        JLabel l=(JLabel)b.getAccessibleContext().getAccessibleChild(0);
        int cislo=Integer.valueOf(l.getText().replaceAll(" ", "").replaceAll("\\*", "10").replaceAll("\\#", "12"));
        
 
        // podrzel?
        if( (System.currentTimeMillis()) - now > 200)
        {
                s.printChar((char)('0'+cislo),false);
        }
        else
        {
            if(isT9 && cislo != 1) //================== T9
            {
                if(cislo==0) // stiskl nulu cili mezeru
                    s.printChar(' ');
                else if (cislo==10) // hvezda
                    {      }
                else if(cislo==12) // # shift
                   changeShift();   
                else
                    s.printChar((char)('0'+cislo),isT9);
                return;
            }
            
            
            if(cislo==0) // stiskl nulu cili mezeru
                s.printChar(' ');
            
            else if (cislo==10) // hvezda
            { 
            
            }
            else if(cislo==12) // # shift
            {
               changeShift();   
               
            }
            else
                s.newKey(Integer.valueOf(l.getText().replaceAll(" ", "")));

        }
    }//GEN-LAST:event_bXMouseRe

    private void b9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MousePressed
        
        now=System.currentTimeMillis();
    }//GEN-LAST:event_b9MousePressed

    private void exit_evn(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_evn
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exit_evn

    private void T9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T9MouseClicked
        
        if(!isT9)
            T9.setBackground(Color.blue);   
        else
            T9.setBackground(Color.gray);
        isT9=!isT9;
    }//GEN-LAST:event_T9MouseClicked

    private void bsKeyPressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bsKeyPressed
        
          s.ta.nextT9Word();
//        s.printChar('\b',isT9);
//        s.printChar(' ',isT9);
//        s.printChar('\b',isT9);
        
        
    }//GEN-LAST:event_bsKeyPressed

    private void keyPress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPress
        
        
        
        phoneImg.repaint();
        if((System.currentTimeMillis()-now) < 10)
            return;
        
        now=System.currentTimeMillis();
        autorepeat=0;
        //System.out.println("--press--");
        
        
    }//GEN-LAST:event_keyPress

    private void keyReles(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyReles
        
       //System.out.println("--rel--");
       autorepeat++;
     
        int num=Smart.getNumberByKeyCode( evt.getKeyCode()); 
      
       if(num<0) // nebudem zpracovavat
           return;
       
       if(autorepeat>1)
       {
           //System.out.println("blocked");
           now=System.currentTimeMillis();
           return;
       }
       
       // podrzel?
        if((System.currentTimeMillis()-now) > 300)
        {
                s.printChar((char)('0'+num));
                
        }
        else
        {
            
            if(num==0) // stiskl nulu cili mezeru
                s.printChar(' ');
            
            else if (num==10)
            { 
            
            }
            else if(num==12)
                changeShift(); 
            else
                s.newKey(num);
        }
        now=System.currentTimeMillis();
    
    }//GEN-LAST:event_keyReles

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton T9;
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton bs;
    private javax.swing.JButton bsharp;
    private javax.swing.JButton bstar;
    private javax.swing.JPanel button_panel;
    private javax.swing.JPanel display;
    private javax.swing.JLabel exit_b;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton left;
    private javax.swing.JPanel move_panel;
    private javax.swing.JLabel phoneImg;
    private javax.swing.JButton right;
    // End of variables declaration//GEN-END:variables
    javax.swing.JButton[] buttons;
    Smart s;
    
    private void changeShift()
    {
        try{
        
            if(StaticVars.isShift)
            {
                StaticVars.isShift=false;
                bsharp.setBackground(Color.gray);

                for (JButton b : buttons)
                    ((JLabel)b.getComponents()[1]).setText(((JLabel)b.getComponents()[1]).getText().toLowerCase());
            }
            else
            {
                StaticVars.isShift=true;
                bsharp.setBackground(Color.blue);
                        for (JButton b : buttons)
                ((JLabel)b.getComponents()[1]).setText(((JLabel)b.getComponents()[1]).getText().toUpperCase());

            }
        }
        catch (Exception x)
        {}
        
    }
    
    
}

