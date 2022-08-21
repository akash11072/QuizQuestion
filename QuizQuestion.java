/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class QuizQuestion extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	QuizQuestion(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1:  Which of the following is the capital of Arunachal Pradesh?");
			jb[0].setText("Itanagar");jb[1].setText("Dispur");jb[2].setText("Imphal");jb[3].setText("Panaji");	
		}
		if(current==1)
		{
			l.setText("Que2: Name the person who was also known as Deshbandhu?");
			jb[0].setText("S.Radhakrishnan");jb[1].setText("G.K.Gokhale");jb[2].setText("Chittaranjan Das");jb[3].setText("Madan Mohan Malviya");
		}
		if(current==2)
		{
			l.setText("Que3: The capital of Uttarakhand is");
			jb[0].setText("Mussoorie");jb[1].setText("Dehra Dun");jb[2].setText("Nainital");jb[3].setText("None of these");
		}
		if(current==3)
		{
			l.setText("Que4: World Trade Organization came into existance in...");
			jb[0].setText("1992");jb[1].setText("1993");jb[2].setText("1994");jb[3].setText("1995");
		}
		if(current==4)
		{
			l.setText("Que5: Panchayati Raj comes under");
			jb[0].setText("Residual list");jb[1].setText("Concurrent list");jb[2].setText("State list");jb[3].setText("Union list");
		}
		if(current==5)
		{
			l.setText("Que6: The literacy rate of India is...");
			jb[0].setText("57.86%");jb[1].setText("61.34%");jb[2].setText("63.98");jb[3].setText("65.38%");
		}
		if(current==6)
		{
			l.setText("Que7: Which Indian state has the least literacy rate?");
			jb[0].setText("Bihar");jb[1].setText("Rajasthan");jb[2].setText("Arunachal Pradesh");jb[3].setText("Orissa");
		}
		if(current==7)
		{
			l.setText("Que8: Which of the following measurements is not a unit of distance?");
			jb[0].setText("Ammeter");jb[1].setText("Cubit");jb[2].setText("Parsec");jb[3].setText("angstrom");		
		}
		if(current==8)
		{
			l.setText("Que9: Scalars are quantities that are described by");
			jb[0].setText("Magnitude");jb[1].setText("Direction");jb[2].setText("Magnitude&Direction");jb[3].setText("Motion");
		}
		if(current==9)
		{
			l.setText("Que10: The working principle of a washing machine is ");
			jb[0].setText("reverse osmosis");jb[1].setText("diffusion");jb[2].setText("centrifugation");jb[3].setText("dialysis");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[0].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[1].isSelected());
		if(current==3)
			return(jb[3].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[3].isSelected());
		if(current==6)
			return(jb[0].isSelected());
		if(current==7)
			return(jb[0].isSelected());
		if(current==8)
			return(jb[0].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new QuizQuestion("Online Test Of Java");
	}


}
