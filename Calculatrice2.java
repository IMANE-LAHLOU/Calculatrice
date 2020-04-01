package calculatrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Calculatrice extends JFrame implements ActionListener,ItemListener
{   //JFrame frame=new JFrame();On peut ne pas l'inserer si on fait extends JFrame
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b,bexp,bc,bcl,bMult,bDiv,bSom,bSoust;
	JButton bRes,bOff,bX1Y,b1X,bpm,bSqrt,bLog,bRand,bnCr,bnAr,bFact,bSin,bCos;
	JButton bTan,bPuis,bX2,b10x,bEx,bF,bE,bD,bC,bB,bA,b2ndF;
	JRadioButton Scie,Norm,Bin,Dec,Oct,Hex;
	ButtonGroup bg1,bg2;
	JPanel pTxt,p2,p3;
	JTextField txt;
	double xp=1,xs=0,aux=0;
	boolean op=false,mult=false,div=false,som=false,soust=false,init=true;
	boolean dec=true,bin=false,oct=false,hex=false,YX=false,X1Y=false;
	boolean nAr=false,nCr=false,shift=false,virg=false;
	Calculatrice()
	{
	super("Calculatrice IMANE");
	// Initialisation des bouton et champs de saisie
	b0=new JButton("0"); b0.setBackground(Color.GRAY);
    b0.setForeground(Color.BLACK);b1=new JButton("1");b1.setBackground(Color.GRAY);
    b1.setForeground(Color.BLACK);b2=new JButton("2");b2.setBackground(Color.GRAY);
    b2.setForeground(Color.BLACK);
	b3=new JButton("3");b3.setBackground(Color.GRAY);
    b3.setForeground(Color.BLACK);b4=new JButton("4");b4.setBackground(Color.GRAY);
    b4.setForeground(Color.BLACK);b5=new JButton("5");b5.setBackground(Color.GRAY);
    b5.setForeground(Color.BLACK);
	b6=new JButton("6");b6.setBackground(Color.GRAY);
    b6.setForeground(Color.BLACK);b7=new JButton("7");b7.setBackground(Color.GRAY);
    b7.setForeground(Color.BLACK);b8=new JButton("8");b8.setBackground(Color.GRAY);
    b8.setForeground(Color.BLACK);
	b9=new JButton("9");b9.setBackground(Color.GRAY);
    b9.setForeground(Color.BLACK);b=new JButton(".");b.setBackground(Color.GRAY);
    b.setForeground(Color.BLACK);bexp=new JButton("Pi");bexp.setBackground(Color.GRAY);
    bexp.setForeground(Color.BLACK);
	bX1Y=new JButton("X^(1/Y)");bX1Y.setBackground(Color.BLACK);
	bX1Y.setForeground(Color.GRAY);bpm=new JButton("+/-");bpm.setBackground(Color.BLACK);
    bpm.setForeground(Color.GRAY);bMult=new JButton("*");bMult.setBackground(Color.BLACK);
    b6.setForeground(Color.GRAY);
	bDiv=new JButton("/");bDiv.setBackground(Color.BLACK);
    bDiv.setForeground(Color.GRAY);bSom=new JButton("+");bSom.setBackground(Color.BLACK);
    bSom.setForeground(Color.GRAY);bSoust=new JButton("-");bSoust.setBackground(Color.BLACK);
    b6.setForeground(Color.GRAY);
	bRes=new JButton("=");bRes.setBackground(Color.BLACK);
    bRes.setForeground(Color.GRAY);b1X=new JButton("1/X");b1X.setBackground(Color.BLACK);
    bRes.setForeground(Color.GRAY);txt =new JTextField("0");txt.setBackground(Color.blue);
    txt.setForeground(Color.BLACK);
	bSqrt=new JButton("Rac");bSqrt.setBackground(Color.BLACK);
	bSqrt.setForeground(Color.GRAY);bLog=new JButton("Ln/Log");bLog.setBackground(Color.BLACK);
	bLog.setForeground(Color.GRAY);bRand=new JButton("Rand");bRand.setBackground(Color.BLACK);
	bRand.setForeground(Color.GRAY);
	bnCr=new JButton("nCr");bnCr.setBackground(Color.BLACK);
	bnCr.setForeground(Color.GRAY);bnAr=new JButton("nAr");bnAr.setBackground(Color.BLACK);
	bnAr.setForeground(Color.GRAY);bFact=new JButton("n!");bFact.setBackground(Color.BLACK);
	bFact.setForeground(Color.GRAY);
	bSin=new JButton("Sin");bSin.setBackground(Color.BLACK);
	bSin.setForeground(Color.GRAY);bCos=new JButton("Cos");bCos.setBackground(Color.BLACK);
	bCos.setForeground(Color.GRAY);bTan=new JButton("Tan");bTan.setBackground(Color.BLACK);
	bTan.setForeground(Color.GRAY);
	bPuis=new JButton("Y^X");bPuis.setBackground(Color.BLACK);
	bPuis.setForeground(Color.GRAY);bX2=new JButton("X^2");bX2.setBackground(Color.BLACK);
	bX2.setForeground(Color.GRAY);b10x=new JButton("10^x");b10x.setBackground(Color.BLACK);
	b10x.setForeground(Color.GRAY);
	bEx=new JButton("e^x");bEx.setBackground(Color.BLACK);
	bEx.setForeground(Color.GRAY);bF=new JButton("F");bF.setBackground(Color.BLACK);
	bF.setForeground(Color.GRAY);bE=new JButton("E");bE.setBackground(Color.BLACK);
	bE.setForeground(Color.GRAY);
	bD=new JButton("D");bD.setBackground(Color.BLACK);
	bD.setForeground(Color.GRAY);bC=new JButton("C");bC.setBackground(Color.BLACK);
	bC.setForeground(Color.GRAY);bB=new JButton("B");bB.setBackground(Color.BLACK);
	bB.setForeground(Color.GRAY);
	bA=new JButton("A");bA.setBackground(Color.BLACK);
	bA.setForeground(Color.GRAY);b2ndF=new JButton("2nF");b2ndF.setBackground(Color.BLACK);
	b2ndF.setForeground(Color.GRAY);bc=new JButton("C");bc.setBackground(Color.BLACK);
	bc.setForeground(Color.GRAY);
	bOff=new JButton("OFF");bOff.setBackground(Color.BLACK);
	bOff.setForeground(Color.GRAY);bcl=new JButton("Del");bcl.setBackground(Color.BLACK);
	bcl.setForeground(Color.GRAY);
	Scie=new JRadioButton("Sci");Scie.setBackground(Color.BLACK);
	Scie.setForeground(Color.GRAY);Norm=new JRadioButton("Std");Norm.setBackground(Color.BLACK);
	Norm.setForeground(Color.GRAY);
	Bin=new JRadioButton("Bin");Bin.setBackground(Color.red);
	Bin.setForeground(Color.orange);Dec=new JRadioButton("Dec");Dec.setBackground(Color.red);
	Dec.setForeground(Color.orange);
	Oct=new JRadioButton("Oct");Oct.setBackground(Color.red);
	Oct.setForeground(Color.orange);Hex=new JRadioButton("Hex");Hex.setBackground(Color.red);
	Hex.setForeground(Color.orange);
	bg1=new ButtonGroup();bg2=new ButtonGroup();
	bg1.add(Norm);bg1.add(Scie);bg2.add(Bin);bg2.add(Oct);bg2.add(Hex);bg2.add(Dec);
	Dec.setSelected(true);Norm.setSelected(true);
	bA.setEnabled(false);bB.setEnabled(false);bC.setEnabled(false);
	bD.setEnabled(false);bE.setEnabled(false);bF.setEnabled(false);
	// Definir la taille préférer des composants
	b0.setPreferredSize(new Dimension(80,30));b1.setPreferredSize(new Dimension(80,30));
	b2.setPreferredSize(new Dimension(80,30));b3.setPreferredSize(new Dimension(80,30));
	b4.setPreferredSize(new Dimension(80,30));b5.setPreferredSize(new Dimension(80,30));
	b6.setPreferredSize(new Dimension(80,30));b7.setPreferredSize(new Dimension(80,30));
	b8.setPreferredSize(new Dimension(80,30));b9.setPreferredSize(new Dimension(80,30));
	b.setPreferredSize(new Dimension(80,30));bexp.setPreferredSize(new Dimension(80,30));
	bDiv.setPreferredSize(new Dimension(80,30));bSom.setPreferredSize(new Dimension(80,30));
        bSoust.setPreferredSize(new Dimension(80,30));bRes.setPreferredSize(new Dimension(165,30));
	bX1Y.setPreferredSize(new Dimension(80,30));b1X.setPreferredSize(new Dimension(80,30));
	bpm.setPreferredSize(new Dimension(80,30));bMult.setPreferredSize(new Dimension(80,30));
	bSqrt.setPreferredSize(new Dimension(80,30));bLog.setPreferredSize(new Dimension(80,30));
	bRand.setPreferredSize(new Dimension(80,30));bnCr.setPreferredSize(new Dimension(80,30));
	bnAr.setPreferredSize(new Dimension(80,30));bFact.setPreferredSize(new Dimension(80,30));
	bCos.setPreferredSize(new Dimension(80,30));bPuis.setPreferredSize(new Dimension(80,30));
	bX2.setPreferredSize(new Dimension(80,30));b10x.setPreferredSize(new Dimension(80,30));
	bEx.setPreferredSize(new Dimension(80,30));bF.setPreferredSize(new Dimension(80,30));
	bE.setPreferredSize(new Dimension(80,30));bD.setPreferredSize(new Dimension(80,30));
	bC.setPreferredSize(new Dimension(80,30));bB.setPreferredSize(new Dimension(80,30));
	bA.setPreferredSize(new Dimension(80,30));b2ndF.setPreferredSize(new Dimension(80,30));
	Scie.setPreferredSize(new Dimension(80,30));Norm.setPreferredSize(new Dimension(80,30));
	Bin.setPreferredSize(new Dimension(80,30));Dec.setPreferredSize(new Dimension(80,30));
	Oct.setPreferredSize(new Dimension(80,30));Hex.setPreferredSize(new Dimension(80,30));
	bSin.setPreferredSize(new Dimension(80,30));bc.setPreferredSize(new Dimension(80,30));
	bOff.setPreferredSize(new Dimension(80,30));bcl.setPreferredSize(new Dimension(80,30));
	bTan.setPreferredSize(new Dimension(80,30));txt.setPreferredSize(new Dimension(440,35));
	txt.setHorizontalAlignment(SwingConstants.RIGHT);
	txt.setBackground(Color.black);txt.setForeground(Color.GREEN);
	txt.setFont(new Font("DIALOG",Font.CENTER_BASELINE+Font.BOLD,12));
	// Declaration des Panel et leurs contenues
	JPanel pNorm=new JPanel();
	pNorm.add(b7);pNorm.add(b8);pNorm.add(b9);pNorm.add(bexp);pNorm.add(bSqrt);
	pNorm.add(b4);pNorm.add(b5);pNorm.add(b6);pNorm.add(bMult);pNorm.add(bDiv);
	pNorm.add(b1);pNorm.add(b2);pNorm.add(b3);pNorm.add(bSom);pNorm.add(bSoust);
	pNorm.add(b0);pNorm.add(b);pNorm.add(bpm);pNorm.add(bRes);
	p2=new JPanel(new GridLayout(1,1));p2.add(pNorm);
	JPanel pStd=new JPanel();pStd.add(Scie);pStd.add(Norm);pStd.add(bcl);
	pStd.add(bc);pStd.add(bOff);
	JPanel pSci=new JPanel();
	pSci.add(Bin);pSci.add(Oct);pSci.add(Hex);pSci.add(Dec);pSci.add(b2ndF);
	pSci.add(bA);pSci.add(bB);pSci.add(bC);pSci.add(bD);pSci.add(bE);
	pSci.add(bPuis);pSci.add(bX2);pSci.add(b10x);pSci.add(bEx);pSci.add(bF);
	pSci.add(bFact);pSci.add(bLog);pSci.add(bSin);pSci.add(bCos);pSci.add(bTan);
	pSci.add(bX1Y);pSci.add(b1X);pSci.add(bRand);pSci.add(bnCr);pSci.add(bnAr);
	p3 =new JPanel(new GridLayout(1,1)); p3.add(pSci);
	pTxt=new JPanel();pTxt.add(txt);pTxt.add(pStd);
	// Ajout des écouteurs aux deffirents boutons
        b0.addActionListener(this);b1.addActionListener(this);b2.addActionListener(this);
        b3.addActionListener(this);b4.addActionListener(this);b5.addActionListener(this);
        b6.addActionListener(this);b7.addActionListener(this);b8.addActionListener(this);
        b9.addActionListener(this);b.addActionListener(this);bexp.addActionListener(this);
        b1X.addActionListener(this);bpm.addActionListener(this);bMult.addActionListener(this);
        bDiv.addActionListener(this);bSom.addActionListener(this);bSoust.addActionListener(this);
        bRes.addActionListener(this);bX1Y.addActionListener(this);bc.addActionListener(this);
        bcl.addActionListener(this);bOff.addActionListener(this);bSqrt.addActionListener(this);
        bLog.addActionListener(this);bRand.addActionListener(this);bnCr.addActionListener(this);
        bnAr.addActionListener(this);bFact.addActionListener(this);bSin.addActionListener(this);
        bCos.addActionListener(this);bTan.addActionListener(this);bPuis.addActionListener(this);
        bX2.addActionListener(this);b10x.addActionListener(this);bEx.addActionListener(this);
        b2ndF.addActionListener(this);bA.addActionListener(this);bB.addActionListener(this);
        bC.addActionListener(this);bD.addActionListener(this);bE.addActionListener(this);
        bF.addActionListener(this);
        Scie.addItemListener(this);Norm.addItemListener(this);Bin.addItemListener(this);
        Dec.addItemListener(this);Oct.addItemListener(this);Hex.addItemListener(this);
        // Mise en forme de la fenetre
        // ImageIcon image=new ImageIcon("Clock.png");
        // this.setIconImage(image.getImage());
        this.setSize(new Dimension(452,331));
        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(pTxt);this.getContentPane().add(p2);
        this.setLocation(300,100);
        this.setCursor(12);this.setResizable(true);this.show();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    void activatehex(boolean b)
    {
    bA.setEnabled(b);bB.setEnabled(b);bC.setEnabled(b);
	bD.setEnabled(b);bE.setEnabled(b);bF.setEnabled(b);	
    }
    void activateP2P3(boolean v)
    {
    b0.setEnabled(v);b1.setEnabled(v);b2.setEnabled(v);b3.setEnabled(v);
    b4.setEnabled(v);b5.setEnabled(v);b6.setEnabled(v);b7.setEnabled(v);
    b8.setEnabled(v);b9.setEnabled(v);b.setEnabled(v);bexp.setEnabled(v);
    bMult.setEnabled(v);bDiv.setEnabled(v);bSom.setEnabled(v);bSoust.setEnabled(v);
    bRes.setEnabled(v);bX1Y.setEnabled(v);b1X.setEnabled(v);bpm.setEnabled(v);
    bSqrt.setEnabled(v);bLog.setEnabled(v);bRand.setEnabled(v);bnCr.setEnabled(v);
    bnAr.setEnabled(v);bFact.setEnabled(v);bSin.setEnabled(v);bCos.setEnabled(v);
	bTan.setEnabled(v);bPuis.setEnabled(v);bX2.setEnabled(v);b10x.setEnabled(v);
	bEx.setEnabled(v);b2ndF.setEnabled(v);Scie.setEnabled(v);
	Norm.setEnabled(v);Bin.setEnabled(v);Dec.setEnabled(v);Oct.setEnabled(v);
	Hex.setEnabled(v);bA.setEnabled(v);bB.setEnabled(v);bC.setEnabled(v);
	bD.setEnabled(v);bE.setEnabled(v);bF.setEnabled(v);
    }
    void activateOp(boolean v)
    {
    b.setEnabled(v);bexp.setEnabled(v);bMult.setEnabled(v);bDiv.setEnabled(v);
    bSom.setEnabled(v);bSoust.setEnabled(v);bRes.setEnabled(v);bX1Y.setEnabled(v);
    b1X.setEnabled(v);bpm.setEnabled(v);bSqrt.setEnabled(v);bLog.setEnabled(v);
    bRand.setEnabled(v);bnCr.setEnabled(v);bnAr.setEnabled(v);bFact.setEnabled(v);
    bSin.setEnabled(v);bCos.setEnabled(v);bTan.setEnabled(v);bPuis.setEnabled(v);
    bX2.setEnabled(v);b10x.setEnabled(v);bEx.setEnabled(v);b2ndF.setEnabled(v);
    }
    int detBaseSource()
    {
    	if(dec) return 10;
    	else if(bin) return 2;
    	else if(oct) return 8;
    	else  return 16;
    }
    int detBaseDestination(Object src)
    {
    	if(src==Dec)
    	{
    		dec=true;bin=false;oct=false;hex=false;
    		activatehex(false);activateOp(true);
    		b0.setEnabled(true);b1.setEnabled(true);b2.setEnabled(true);
    		b3.setEnabled(true);b4.setEnabled(true);b5.setEnabled(true);
    		b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
    		b9.setEnabled(true);
    		return 10;
    	}
    	else if(src==Bin)
    	{
    		dec=false;bin=true;oct=false;hex=false;
    		activatehex(false);activateOp(false);
    		b0.setEnabled(true);b1.setEnabled(true);b2.setEnabled(false);
    		b3.setEnabled(false);b4.setEnabled(false);b5.setEnabled(false);
    		b6.setEnabled(false);b7.setEnabled(false);b8.setEnabled(false);
    		b9.setEnabled(false);
    		return 2;
    	}
    	else if(src==Oct)
    	{
    		dec=false;bin=false;oct=true;hex=false;
    		activatehex(false);activateOp(false);
    		b0.setEnabled(true);b1.setEnabled(true);b2.setEnabled(true);
    		b3.setEnabled(true);b4.setEnabled(true);b5.setEnabled(true);
    		b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(false);
    		b9.setEnabled(false);    		
    		return 8;
    	}
    	else
    	{
    		dec=false;bin=false;oct=false;hex=true;
    		activatehex(true);activateOp(false);
    		b0.setEnabled(true);b1.setEnabled(true);b2.setEnabled(true);
    		b3.setEnabled(true);b4.setEnabled(true);b5.setEnabled(true);
    		b6.setEnabled(true);b7.setEnabled(true);b8.setEnabled(true);
    		b9.setEnabled(true); 
    		return 16;
    	}
    }
    int conversionCarct(char c)
    {
    	if(c=='F') return 15;
    	else if(c=='E') return 14;
    	else if(c=='D') return 13;
    	else if(c=='C') return 12;
    	else if(c=='B') return 11;
    	else if(c=='A') return 10;
    	else return(Character.getNumericValue(c));
    }
    char toHexaCarct(int x)
    {
    	if(x==10) return 'A';
    	else if(x==11) return 'B';
    	else if(x==12) return 'C';
    	else if(x==13) return 'D';
    	else if(x==14) return 'E';
    	else return 'F';
    }
    boolean isValide(String s)
    {
    	for(int i=0;i<s.length();i++)
    	{
    		if(s.charAt(i)=='.' || s.charAt(i)=='-')
    		return false;
    	}
    	return true;
    }
    int toDec(String dep,int bs)
    {
    int i=(dep.length())-1;
    String s=dep;
    int puis=0;
    int res=0;
    while(i>=0)
    {
    	res=res+conversionCarct(s.charAt(i))*((int)(Math.pow(bs,puis)));
    	puis++;
    	i--;
    }
    return res;
    }
    String fromDec(String dep,int bd)
    {
       	String s="";
    	int aux=Integer.parseInt(dep);
    	while(aux/bd!=0)
    	{
    		if(aux%bd<10)
    		{s=(aux%bd)+s;}
    		else
    		{s=toHexaCarct(aux%bd)+s;}
    		aux=aux/bd;
    	}
    	if(aux%bd<10) {s=(aux%bd)+s;}
    	else {s=toHexaCarct(aux%bd)+s;}
    	return s;
    }
    void Resultat()
    {
    	double x2=Double.parseDouble(txt.getText());
    	if(mult) {txt.setText(""+(xp*x2));xp=Double.parseDouble(txt.getText());}
		else if(div) 
		{
			if(x2!=0)
			{
			txt.setText(""+(xp/x2));
			xp=Double.parseDouble(txt.getText());
			}
			else
			{
				activateP2P3(false);
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText("  ERROR !!  DIVISION   PAR   ZERO   IMPOSSIBLE  ");
			}		
		}
		else if(som) {txt.setText(""+(xs+x2));xs=Double.parseDouble(txt.getText());}
		else if(soust){ txt.setText(""+(xs-x2));xs=Double.parseDouble(txt.getText());}
		else if(YX)	{double res=Math.pow(aux,x2);txt.setText(""+res);}
		else if(nAr)
		{
			if((aux>=x2)&&(aux>=0)&&(x2>=0))
			{
			double res=(fact(aux)/fact((aux-x2)));
			txt.setText(""+res);
			}
			else
			{
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText("  ERROR!!  RULE  :  \"  n  doit  etre >= r  et  n >= 0  et  r >= 0  \" ");
			    activateP2P3(false);}
		}
		else if(nCr)
		{
			if((aux>=x2)&&(aux>=0)&&(x2>=0))
			{
				double res=(fact(aux)/(fact(x2)*fact((aux-x2))));
				txt.setText(""+res);
			}
			else
			{
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText(" ERROR!!   RULE  :  \"  n  doit  etre  >= r  et  n  >= 0  et  r  >= 0  \" ");
			    activateP2P3(false);}
		}
		else if(X1Y)
		{
			if(x2!=0)
			{double res=Math.pow(aux,(1/x2));txt.setText(""+res);}
			else
			{
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  DEUXIEME  NOMBRE  DOIT  ETRE  DIFFERENT  DE  0 ");
			    activateP2P3(false);}
		}
		 init=false;   
		 virg=false; 
    }
    double fact(double x)
    {
    	double res=1;
    	if(x>=0)
    	{
    	for(int i=2;i<=x;i++)
		{
			res=res*i;
		}
		return res;
		}
		else return 0;
    }
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		JButton baux=(JButton)src;
		////////////*********Bouton des chiffres********//////////////
		if((src==b0)||src==b1||src==b2||src==b3||src==b4||src==b5||src==b6||src==b7||src==b8||src==b9||src==bA||src==bB||src==bC||src==bD||src==bE||src==bF)
		{ 
		if(!op) txt.setText(txt.getText()+baux.getLabel());
		else if(op)
		{
			txt.setText(baux.getLabel());
			op=false;
		}
		}
		////////////*********Bouton virgule********//////////////
		else if(src==b)
		{
			if(!virg)
			{
				txt.setText(txt.getText()+".");
				virg=true;
			}
		}
		////////////*********Bouton Pi********//////////////
		else if(src==bexp)
		{
			txt.setText(""+Math.PI);
			virg=true;
		}
		////////////*********Bouton clear********//////////////
		else if(src==bc)
		{txt.setText("0");xp=1;xs=0;init=true;aux=0;shift=false;op=false;X1Y=true;
		mult=false;div=false;som=false;soust=false;nAr=false;nCr=false;
		activateP2P3(true);activatehex(false);Dec.setSelected(true);virg=false;
		txt.setBackground(Color.black);txt.setForeground(Color.GREEN);}
		////////////*********Bouton de +/-********//////////////
		else if(src==bpm)
		txt.setText(""+Double.parseDouble(txt.getText())*-1);
		else if(src==bcl)
		 txt.setText(txt.getText().substring(0,txt.getText().length()-1));
		 
		 ////////////*********Multiplication********//////////////
		else if(src==bMult)
		{
		try
		{
		if(init || op)
		{
			xp=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xp);
		}
		else
		{
			Resultat();
			xp=(Double.parseDouble(txt.getText()));
		}
			op=true;mult=true;div=false;som=false;soust=false;YX=false;
			nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
	     	activateP2P3(false);}
		}
		////////////*******Division******////////////
		else if(src==bDiv)
		{
		try
		{
		if(init || op)
		{
			xp=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xp);
		}
		else
		{
			 Resultat();
		 xp=(Double.parseDouble(txt.getText()));
		}
		op=true;mult=false;div=true;som=false;soust=false;YX=false;
		nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
		    activateP2P3(false);}
		}
		////////////////***********Somme**********////////////////
		else if(src==bSom)
		{
		try
		{
		if(init || op)
		{
			xs=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xs);
		}
		else
		{
			 Resultat();
			 xs=(Double.parseDouble(txt.getText()));
		}
		op=true;mult=false;div=false;som=true;soust=false;YX=false;
		nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
		    activateP2P3(false);}
		}
		////////////////************Soustraction***********//////////////////
		else if(src==bSoust)
		{
		try
		{
		if(init || op)
		{
			xs=(Double.parseDouble(txt.getText()));
			init=false;virg=false;
			txt.setText(""+xs);
		}
		else
		{
			Resultat();
			xs=(Double.parseDouble(txt.getText()));
		}
	    op=true;mult=false;div=false;som=false;soust=true;YX=false;
	    nAr=false;nCr=false;X1Y=true;
		}catch(NumberFormatException execp)
    	{
    		txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
    		txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
		    activateP2P3(false);}
	    }
	    //////////////////**************Resultat*************//////////////////
		else if(e.getSource()==bRes)
		{
			Resultat();
			init=true;virg=false;
		}
		//////////************Les fonction Scientifiques********/////////////
	 	else if(src==b2ndF)
	 	{shift=true;}
		else if(src==bPuis)
		{
			aux=Double.parseDouble(txt.getText());
			YX=true;init=false;nAr=false;nCr=false;X1Y=true;
			op=true;mult=false;div=false;som=false;soust=false;
		}
		else if(src==b10x)
		{
			double  x=Double.parseDouble(txt.getText());
			double  res=Math.pow(10,x);
			txt.setText(""+res);
		}
		else if(src==bX2)
		{
			double  x=Double.parseDouble(txt.getText());
			double res=Math.pow(x,2);
			txt.setText(""+res);
		}
		else if(src==bX1Y)
		{
		    aux=Double.parseDouble(txt.getText());
			YX=false;init=false;nAr=false;nCr=false;X1Y=true;
			op=true;mult=false;div=false;som=false;soust=false;			
		}
		else if(src==b1X)
		{
		    double x=Double.parseDouble(txt.getText());
		    if(x!=0)
		    {txt.setText(""+(1/x));}
		    else {txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
		    	  txt.setText(" ERROR!!  DIVISION  PAR  ZERO  IMPOSSIBLE ");
		          activateP2P3(false);}
		}
		else if(src==bLog)
		{
			double  x=Double.parseDouble(txt.getText());
			if(!shift && x>0)
			{
			double  res=Math.log(x);
			txt.setText(""+res);
			}
			else if(shift && x>0)
			{
			double  res=Math.log10(x);
			txt.setText(""+res);
			shift=false;	
			}
			else if(x<=0)
			{
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  RULE : \"  X  DOIT  ETRE  >  A  ZERO  \" ");
			    activateP2P3(false);}
		}
		else if(src==bEx)
		{
			double  x=Double.parseDouble(txt.getText());
			double  res=Math.exp(x);
			txt.setText(""+res);
		}
		else if(src==bFact)
		{
			
		
			if(isValide(txt.getText()))
			{double res=fact(Double.parseDouble(txt.getText()));
			txt.setText(""+res);}
			else
			{
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  RULE :  \"  N  DOIT  ETRE  UN ENTIER  >  A  ZERO \" ");
			    activateP2P3(false);}
		}
		else if(src==bSin)
		{
			if(!shift)
			{
			double  x=Math.toRadians(Double.parseDouble(txt.getText()));
		    double res=Math.sin(x);
			txt.setText(""+res);
			}
			else
			{
			double  x=Double.parseDouble(txt.getText());
			double  res=Math.asin(x);
			txt.setText(""+Math.toDegrees(res));
			shift=false;	
			}
		}
		else if(src==bCos)
		{
			if(!shift)
			{
			double  x=Math.toRadians(Double.parseDouble(txt.getText()));
			double res=Math.cos(x);
			txt.setText(""+res);
			}
			else
			{
			double  x=Double.parseDouble(txt.getText());
			double  res=Math.acos(x);
			txt.setText(""+Math.toDegrees(res));
			shift=false;	
			}
		}
		else if(src==bTan)
		{
			if(!shift)
			{
			double  x=Math.toRadians(Double.parseDouble(txt.getText()));
			double res=Math.tan(x);
			txt.setText(""+res);
			}
			else
			{
			double  x=Double.parseDouble(txt.getText());
			double  res=Math.atan(x);
			txt.setText(""+Math.toDegrees(res));
			shift=false;	
			}
		}
		else if(src==bSqrt)
		{
			double  x=Double.parseDouble(txt.getText());
			if(x>=0)
			{double res=Math.sqrt(x);
			txt.setText(""+res);}
			else {
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText(" ERROR!!  RULE  :  \"  X  DOIT  ETRE  >  A  ZERO  \" ");
			    activateP2P3(false);}
		}
		else if(src==bRand)
		{
			double  x=Double.parseDouble(txt.getText());
			double res=Math.random();
			txt.setText(""+res);
		}
		else if(src==bnAr)
		{
			aux=Double.parseDouble(txt.getText());
			nAr=true;YX=false;init=false;
			op=true;mult=false;div=false;som=false;soust=false;			
		}
			else if(src==bnCr)
		{
			aux=Double.parseDouble(txt.getText());
			nCr=true;YX=false;init=false;
			op=true;mult=false;div=false;som=false;soust=false;			
		}
		/////////************FIN des Fonctions Scientifiques********/////////
	
	    else if(src==bOff) System.exit(0);
	}
	public void itemStateChanged(ItemEvent i)
	{
		Object srci=i.getSource();
		if(srci==Scie)
		{
		this.resize(452,564);
		this.getContentPane().setLayout(new GridLayout(3,1));
        this.getContentPane().add(pTxt);this.getContentPane().add(p3);
        this.getContentPane().add(p2); this.setLocation(300,100);
        
		}
		else if(srci==Norm)
		{
		//Calculatrice c=new Calculatrice();
		this.getContentPane().removeAll();
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.resize(452,331);
        this.getContentPane().add(pTxt);this.getContentPane().add(p2);
        this.setLocation(300,100);	
        //	c.show();
        //	this.dispose();
		}
		else if(dec)
		{
			activateOp(false);
			String dep=txt.getText();
			try
			{
			String s=fromDec(dep,detBaseDestination(srci));
			txt.setText(s);}
			catch(NumberFormatException e)
			{
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE  ");
			    activateP2P3(false);}
		}
		else if(bin||oct||hex)
		{
			try
			{
			int x= toDec(txt.getText(),detBaseSource());
			String s=""+x;
			txt.setText(fromDec(s,detBaseDestination(srci)));}
			catch(NumberFormatException e)
			{
				txt.setBackground(Color.LIGHT_GRAY);txt.setForeground(Color.RED);
				txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE  ");
			    activateP2P3(false);}
		}
	}
	public static void main (String[] args) 
	{
		Calculatrice c=new  Calculatrice();
	}
}