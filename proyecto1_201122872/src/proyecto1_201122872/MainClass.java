/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201122872;

/**
 *
 * @author Ramonella
 */
import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class MainClass {
  public static void main(String args[]) throws Exception {
    JFrame contenedor = new JFrame("ejemplo");
      JPanel frame = new JPanel();
   contenedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);

    Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
    StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
    StyleConstants.setFontSize(style, 14);
    StyleConstants.setSpaceAbove(style, 4);
    StyleConstants.setSpaceBelow(style, 4);

    SimpleAttributeSet attributes = new SimpleAttributeSet();
    StyleConstants.setBold(attributes, true);
    StyleConstants.setItalic(attributes, true);

    // Third style for icon/component
    Style labelStyle = context.getStyle(StyleContext.DEFAULT_STYLE);

    Icon icon = new ImageIcon("Computer.gif");
    JLabel label = new JLabel(icon);
    JButton boton = new JButton("gfufgdsf");
    
    StyleConstants.setComponent(labelStyle, label);

    try {
      document.insertString(document.getLength(), "Hello www.java2s.com", attributes);
      
       StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
      
      document.insertString(document.getLength(), "fsfdfdfdfdfsdf", labelStyle);
    } catch (BadLocationException badLocationException) {
      System.err.println("Oops");
    }

    JTextPane textPane = new JTextPane(document);
    textPane.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textPane);
    frame.add(scrollPane, BorderLayout.CENTER);

    frame.setSize(300, 150);
    frame.setVisible(true);
    contenedor.add(frame);
    contenedor.setVisible(true);
  }
}