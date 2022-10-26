/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.calculator;

/**
 *
 * @author abhay
 */
//import java.swing.*;
/*import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[9];
    JButton add,sub,mul,div;
    JButton dec,equ,del,clr,neg;
    Font myFont=new Font("serif",Font.BOLD,30);
    
    double num1=0,num2=0,result=0;
    char operator;
    private final JPanel panel;
    
    
    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        
        textfield=new JTextField();
        textfield.setBounds(50,20, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        dec=new JButton(".");
        equ=new JButton("=");
        del=new JButton("del");
        clr=new JButton("cle");
        neg=new JButton("-");
        
        functionButtons[0]=add;
        functionButtons[1]=sub;
        functionButtons[2]=mul;
        functionButtons[3]=div;
        functionButtons[4]=dec;
        functionButtons[5]=equ;
        functionButtons[6]=del;
        functionButtons[7]=clr;
        functionButtons[8]=neg;
        
        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            }
        
        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            }
        
        neg.setBounds(50,430,100,50);
        clr.setBounds(150,430,100,50);
        del.setBounds(250,430,100,50);
        
        panel=new JPanel();
        panel.setBounds(50, 100, 300, 300);
	panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(add);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(equ);
        panel.add(numberButtons[0]);
        panel.add(div);
        
        frame.add(panel);
	frame.add(neg);
	frame.add(del);
	frame.add(clr);
	frame.add(textfield);
	frame.setVisible(true);
        
    }
    

    
    
    
    
    
    
    
    
    
    

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Calculator calc = new Calculator();
    }
    
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==dec) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==add) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==sub) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mul) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==div) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equ) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clr){
			textfield.setText("");
		}
		if(e.getSource()==del){
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==neg) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	
    }
}
