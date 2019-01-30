import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
public class Game extends JPanel implements ActionListener{
   static ImageIcon Ace1, Ace2, Ace3, Ace4, KingH, KingS, KingC, KingD, QueenS, QueenD, QueenC, QueenH, JackH,
    JackS, JackC, JackD, TenS, TenD, TenC, TenH, NineS, NineD, NineH, NineC, EightD, EightC, EightS, EightH, 
    SevenH, SevenD, SevenC, SevenS, SixD, SixH, SixS, SixC, FiveD, FiveH, FiveC, FiveS, FourD, FourS, FourC, 
    FourH, ThreeH, ThreeS, ThreeD, ThreeC, TwoD, TwoC, TwoS, TwoH, Deck1, Temp1, S,C, D, H;
   Image DeckImage;
   static JButton AH, AC, AS, AD, KS, KH, KD, KC, QH, QD, QS, QC, JH, JD, JS, JC, TeH, TeD, TeS, TeC,
    NH, ND, NS, NC, EH, EC, ED, ES, SeH, SeC, SeS, SeD, SiS, SiD, SiC, SiH, FH, FD, FC, FS, FoH, FoD, FoS, FoC,
     ThH, ThD, ThC, ThS, TwD, TwS, TwC, TwH, D1, T1, TS;
   static JButton emptySpace1, emptySpace2, emptySpace3, emptySpace4, emptySpace5, emptySpace6, emptySpace7;
   static JButton Spade, Clubs, Hearts, Diamond;
   static ArrayList<Card> deck;
   static Card[] cardArray;
   static Card[] temp;
   static int count;
   static JFrame frame;
   static JPanel panel;
   static Game ga;
   static int c=1;
   static ArrayList<Card> numClicks= new ArrayList<Card>();
   static ArrayList<Card> col1;
   static ArrayList<Card> col2;
   static ArrayList<Card> col3;
   static ArrayList<Card> col4;
   static ArrayList<Card> col5;
   static ArrayList<Card> col6;
   static ArrayList<Card> col7;
 
   public Game () {
   //Empty Spaces 
      emptySpace1= new JButton();
      emptySpace1.setBounds(100,250,110,120);
      emptySpace1.setOpaque(false);
      emptySpace1.setContentAreaFilled(false);
      emptySpace1.setActionCommand( "empty" );  
      emptySpace1.addActionListener( this );
   
      emptySpace2= new JButton();
      emptySpace2.setBounds(300,250,110,120);
      emptySpace2.setOpaque(false);
      emptySpace2.setContentAreaFilled(false);
      emptySpace2.setActionCommand( "empty" );  
      emptySpace2.addActionListener( this );
   
      emptySpace3= new JButton();
      emptySpace3.setBounds(500,250,110,120);
      emptySpace3.setOpaque(false);
      emptySpace3.setContentAreaFilled(false);
      emptySpace3.setActionCommand( "empty" );  
      emptySpace3.addActionListener( this );
         
      emptySpace4= new JButton();
      emptySpace4.setBounds(700,250,110,120);
      emptySpace4.setOpaque(false);
      emptySpace4.setContentAreaFilled(false);
      emptySpace4.setActionCommand( "empty" );  
      emptySpace4.addActionListener( this );
   
      emptySpace5= new JButton();
      emptySpace5.setBounds(900,250,110,120);
      emptySpace5.setOpaque(false);
      emptySpace5.setContentAreaFilled(false);
      emptySpace5.setActionCommand( "empty" );  
      emptySpace5.addActionListener( this );
   
   
      emptySpace6= new JButton();
      emptySpace6.setBounds(1100,250,110,120);
      emptySpace6.setOpaque(false);
      emptySpace6.setContentAreaFilled(false);
      emptySpace6.setActionCommand( "empty" );  
      emptySpace6.addActionListener( this );
      
      emptySpace7= new JButton();
      emptySpace7.setBounds(1300,250,110,120);
      emptySpace7.setOpaque(false);
      emptySpace7.setContentAreaFilled(false);
      emptySpace7.setActionCommand( "empty" );  
      emptySpace7.addActionListener( this );
   
     //Empty Ace Spaces
      ImageIcon S = new ImageIcon("Spade.png");
      Image tempS1 = S.getImage();
      Image newtempS1 = tempS1.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      S = new ImageIcon(newtempS1);  
      Spade = new JButton(S);
      Spade.setBounds(700, 80, 110,120);
      Spade.addActionListener( this );
      
      ImageIcon D = new ImageIcon("Diamond.png");
      Image tempDi1 = D.getImage();
      Image newtempDi1 = tempDi1.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      D = new ImageIcon(newtempDi1);  
      Diamond= new JButton(D);
      Diamond.setBounds(900, 80, 110,120); 
      Diamond.addActionListener( this );
   
      ImageIcon C = new ImageIcon("Clubs.png");
      Image tempC1 = C.getImage();
      Image newtempC1 = tempC1.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      C = new ImageIcon(newtempC1);  
      Clubs = new JButton(C);
      Clubs.setBounds(1100, 80, 110,120); 
      Clubs.addActionListener( this );
   
      ImageIcon H = new ImageIcon("Heart.png");
      Image tempH1 = H.getImage();
      Image newtempH1 = tempH1.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      H = new ImageIcon(newtempH1);  
      Hearts = new JButton(H);
      Hearts.setBounds(1300, 80, 110,120); 
      Hearts.addActionListener( this );
   
   //Deck
      ImageIcon Deck1 = new ImageIcon("deck.png");
      Image tempD1 = Deck1.getImage();
      Image newtempD1 = tempD1.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      Deck1 = new ImageIcon(newtempD1);  
      D1 = new JButton(Deck1);
      D1.setBounds(100, 80, 110,120); 
      D1.addActionListener(this); 
     //AceHearts
      ImageIcon Ace1 = new ImageIcon("Ace2.png");
      Image tempA1 = Ace1.getImage();
      Image newtempA1 = tempA1.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      Ace1 = new ImageIcon(newtempA1);  
      AH = new JButton(Ace1);
      AH.addActionListener( this );   
   
     //AceSpades
      ImageIcon Ace2 = new ImageIcon("AceS.png");
      Image tempA2 = Ace2.getImage();
      Image newtempA2 = tempA2.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      Ace2 = new ImageIcon(newtempA2);  
      AS = new JButton(Ace2);
      AS.addActionListener( this ); 
   //AceClubs
      ImageIcon Ace3 = new ImageIcon("AceC.png");
      Image tempA3 = Ace3.getImage();
      Image newtempA3 = tempA3.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      Ace3 = new ImageIcon(newtempA3);  
      AC = new JButton(Ace3);
     // set the  command 
      AC.addActionListener( this );  
   //AceDiamonds
      ImageIcon Ace4 = new ImageIcon("AceD.png");
      Image tempA4 = Ace4.getImage();
      Image newtempA4 = tempA4.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      Ace4 = new ImageIcon(newtempA4);  
      AD = new JButton(Ace4);
   // set the  command 
      AD.addActionListener( this );  
   
   //KingHearts
      ImageIcon KingH = new ImageIcon("KingH.png");
      Image tempK1 = KingH.getImage();
      Image newtempK1 = tempK1.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      KingH = new ImageIcon(newtempK1);  
      KH = new JButton(KingH);
      KH.addActionListener( this );  
   
   
   //KingSpades
      ImageIcon KingS = new ImageIcon("KingS.png");
      Image tempKS = KingS.getImage();
      Image newtempKS = tempKS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      KingS = new ImageIcon(newtempKS);  
      KS = new JButton(KingS);
   
      KS.addActionListener( this );  
   
   //KingClubs
      ImageIcon KingC = new ImageIcon("KingC.png");
      Image tempKC = KingC.getImage();
      Image newtempKC = tempKC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      KingC = new ImageIcon(newtempKC);  
      KC = new JButton(KingC);
     
      KC.addActionListener( this ); // set the  command KC.addActionListener( this );  
   
   //KingDiamonds
      ImageIcon KingD = new ImageIcon("KingD.png");
      Image tempKD = KingD.getImage();
      Image newtempKD = tempKD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      KingD = new ImageIcon(newtempKD);  
      KD = new JButton(KingD);
      KD.addActionListener( this );  
   
   //QueenHearts
      ImageIcon QueenH = new ImageIcon("QueenH.png");
      Image tempQH = QueenH.getImage();
      Image newtempQH = tempQH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      QueenH = new ImageIcon(newtempQH);  
      QH = new JButton(QueenH);
      
      QH.addActionListener( this );  
   
   //QueenSpades
      ImageIcon QueenS = new ImageIcon("QueenS.png");
      Image tempQS = QueenS.getImage();
      Image newtempQS = tempQS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      QueenS = new ImageIcon(newtempQS);  
      QS = new JButton(QueenS);
     
      QS.addActionListener( this );  
   
   //QueenClubs
      ImageIcon QueenC = new ImageIcon("QueenC.png");
      Image tempQC = QueenC.getImage();
      Image newtempQC = tempQC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      QueenC = new ImageIcon(newtempQC);  
      QC = new JButton(QueenC);
      QC.addActionListener( this );  
   
   //QueenDiamonds
      ImageIcon QueenD = new ImageIcon("QueenD.png");
      Image tempQD = QueenD.getImage();
      Image newtempQD = tempQD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      QueenD = new ImageIcon(newtempQD);  
      QD = new JButton(QueenD);
      QD.addActionListener( this );  
   
   //JackHearts
      ImageIcon JackH = new ImageIcon("JackH.png");
      Image tempJH = JackH.getImage();
      Image newtempJH = tempJH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      JackH = new ImageIcon(newtempJH);  
      JH = new JButton(JackH);
      JH.addActionListener( this );  
   
   //JackSpades
      ImageIcon JackS = new ImageIcon("JackS.png");
      Image tempJS = JackS.getImage();
      Image newtempJS = tempJS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      JackS = new ImageIcon(newtempJS);  
      JS = new JButton(JackS);
      //JS.setBounds(50, 80, 110,120); 
      //JS.setActionCommand( "JS" ); // set the  command 
      JS.addActionListener( this );  
   
   //JackClubs
      ImageIcon JackC = new ImageIcon("JackC.png");
      Image tempJC = JackC.getImage();
      Image newtempJC = tempJC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      JackC = new ImageIcon(newtempJC);  
      JC = new JButton(JackC);
      JC.addActionListener( this );  
   
   //JackDiamonds
      ImageIcon JackD = new ImageIcon("JackD.png");
      Image tempJD = JackD.getImage();
      Image newtempJD = tempJD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      JackD = new ImageIcon(newtempJD);  
      JD = new JButton(JackD);
      JD.addActionListener( this );  
   
   //TenHearts
      ImageIcon TenH = new ImageIcon("TenH.png");
      Image tempTeH = TenH.getImage();
      Image newtempTeH = tempTeH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TenH = new ImageIcon(newtempTeH);  
      TeH = new JButton(TenH);
      TeH.addActionListener( this );  
   
   //TenSpades
      ImageIcon TenS = new ImageIcon("TenS.png");
      Image tempTeS = TenS.getImage();
      Image newtempTeS = tempTeS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TenS = new ImageIcon(newtempTeS);  
      TeS = new JButton(TenS);
      TeS.addActionListener( this );  
   
   //TenClubs
      ImageIcon TenC = new ImageIcon("TenC.png");
      Image tempTeC = TenC.getImage();
      Image newtempTeC = tempTeC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TenC = new ImageIcon(newtempTeC);  
      TeC = new JButton(TenC);
      TeC.addActionListener( this );  
   
   //TenDiamonds
      ImageIcon TenD = new ImageIcon("TenD.png");
      Image tempTeD = TenD.getImage();
      Image newtempTeD = tempTeD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TenD = new ImageIcon(newtempTeD);  
      TeD = new JButton(TenD);
      TeD.addActionListener( this );  
   
   //NineHearts
      ImageIcon NineH = new ImageIcon("NineH.png");
      Image tempNH = NineH.getImage();
      Image newtempNH = tempNH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      NineH = new ImageIcon(newtempNH);  
      NH = new JButton(NineH);
      NH.addActionListener( this );  
   
   //NineSpades
      ImageIcon NineS = new ImageIcon("NineS.png");
      Image tempNS = NineS.getImage();
      Image newtempNS = tempNS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      NineS = new ImageIcon(newtempNS);  
      NS = new JButton(NineS);
      NS.addActionListener( this );  
   
   //NineClubs
      ImageIcon NineC = new ImageIcon("NineC.png");
      Image tempNC = NineC.getImage();
      Image newtempNC = tempNC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      NineC = new ImageIcon(newtempNC);  
      NC = new JButton(NineC);
      NC.addActionListener( this );  
   
   //NineDiamonds
      ImageIcon NineD = new ImageIcon("NineD.png");
      Image tempND = NineD.getImage();
      Image newtempND = tempND.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      NineD = new ImageIcon(newtempND);  
      ND = new JButton(NineD);
      ND.addActionListener( this );  
   
   //EightHearts
      ImageIcon EightH = new ImageIcon("EightH.png");
      Image tempEH = EightH.getImage();
      Image newtempEH = tempEH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      EightH = new ImageIcon(newtempEH);  
      EH = new JButton(EightH);
      EH.addActionListener( this );  
   
   //EightSpades
      ImageIcon EightS = new ImageIcon("EightS.png");
      Image tempES = EightS.getImage();
      Image newtempES = tempES.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      EightS = new ImageIcon(newtempES);  
      ES = new JButton(EightS);
      ES.addActionListener( this );  
   
   //EightClubs
      ImageIcon EightC = new ImageIcon("EightC.png");
      Image tempEC = EightC.getImage();
      Image newtempEC = tempEC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      EightC = new ImageIcon(newtempEC);  
      EC = new JButton(EightC);
      EC.addActionListener( this );  
   
   //EightDiamonds
      ImageIcon EightD = new ImageIcon("EightD.png");
      Image tempED = EightD.getImage();
      Image newtempED = tempED.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      EightD = new ImageIcon(newtempED);  
      ED = new JButton(EightD);
      ED.addActionListener( this );  
   
   //SevenHearts
      ImageIcon SevenH = new ImageIcon("SevenH.png");
      Image tempSeH = SevenH.getImage();
      Image newtempSeH = tempSeH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SevenH = new ImageIcon(newtempSeH);  
      SeH = new JButton(SevenH);
      SeH.addActionListener( this );  
   
   //SevenSpades
      ImageIcon SevenS = new ImageIcon("SevenS.png");
      Image tempSeS = SevenS.getImage();
      Image newtempSeS = tempSeS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SevenS = new ImageIcon(newtempSeS);  
      SeS = new JButton(SevenS);
      SeS.addActionListener( this );  
   
   //SevenClubs
      ImageIcon SevenC = new ImageIcon("SevenC.png");
      Image tempSeC = SevenC.getImage();
      Image newtempSeC = tempSeC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SevenC = new ImageIcon(newtempSeC);  
      SeC = new JButton(SevenC);
      SeC.addActionListener( this );  
   
   //SevenDiamonds
      ImageIcon SevenD = new ImageIcon("SevenD.png");
      Image tempSeD = SevenD.getImage();
      Image newtempSeD = tempSeD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SevenD = new ImageIcon(newtempSeD);  
      SeD = new JButton(SevenD);
      SeD.addActionListener( this );  
   
   //SixHearts
      ImageIcon SixH = new ImageIcon("SixH.png");
      Image tempSiH = SixH.getImage();
      Image newtempSiH = tempSiH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SixH = new ImageIcon(newtempSiH);  
      SiH = new JButton(SixH);
      SiH.addActionListener( this );  
   
   //SixSpades
      ImageIcon SixS = new ImageIcon("SixS.png");
      Image tempSiS = SixS.getImage();
      Image newtempSiS = tempSiS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SixS = new ImageIcon(newtempSiS);  
      SiS = new JButton(SixS);
      SiS.addActionListener( this );  
   
   //SixClubs
      ImageIcon SixC = new ImageIcon("SixC.png");
      Image tempSiC = SixC.getImage();
      Image newtempSiC = tempSiC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SixC = new ImageIcon(newtempSiC);  
      SiC = new JButton(SixC);
      SiC.addActionListener( this );  
   
   //SixDiamonds
      ImageIcon SixD = new ImageIcon("SixD.png");
      Image tempSiD = SixD.getImage();
      Image newtempSiD = tempSiD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      SixD = new ImageIcon(newtempSiD);  
      SiD = new JButton(SixD);
      SiD.addActionListener( this );  
     
   //FiveClubs
      ImageIcon FiveC = new ImageIcon("FiveC.png");
      Image tempFC = FiveC.getImage();
      Image newFC = tempFC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FiveC = new ImageIcon(newFC);  
      FC = new JButton(FiveC);    
      FC.addActionListener( this );
   
   //FiveDiamonds
   
      ImageIcon FiveD = new ImageIcon("FiveD.png");
      Image tempFD = FiveD.getImage();
      Image newFD = tempFD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FiveD = new ImageIcon(newFD);  
      FD = new JButton(FiveD);    
      FD.addActionListener( this );
   
   //FiveHearts
      ImageIcon FiveH = new ImageIcon("FiveH.png");
      Image tempFH = FiveH.getImage();
      Image newFH = tempFH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FiveH = new ImageIcon(newFH);  
      FH = new JButton(FiveH);    
      FH.addActionListener( this );
   
   
   //FiveSpades
      ImageIcon FiveS = new ImageIcon("FiveS.png");
      Image tempFS = FiveS.getImage();
      Image newFS = tempFS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FiveS = new ImageIcon(newFS);  
      FS = new JButton(FiveS);    
      FS.addActionListener( this );
   
   //FourHearts
      ImageIcon FourH = new ImageIcon("FourH.png");
      Image tempFoH = FourH.getImage();
      Image newFoH = tempFoH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FourH = new ImageIcon(newFoH);  
      FoH = new JButton(FourH);    
      FoH.addActionListener( this );
   
   //FourSpades
      ImageIcon FourS = new ImageIcon("FourS.png");
      Image tempFoS = FourS.getImage();
      Image newFoS = tempFoS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FourS = new ImageIcon(newFoS);  
      FoS = new JButton(FourS);    
      FoS.addActionListener( this );
   
   //FourDiamonds
      ImageIcon FourD = new ImageIcon("FourD.png");
      Image tempFoD = FourD.getImage();
      Image newFoD = tempFoD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FourD = new ImageIcon(newFoD);  
      FoD = new JButton(FourD);    
      FoD.addActionListener( this );
   
   //FourClubs
      ImageIcon FourC = new ImageIcon("FourC.png");
      Image tempFoC = FourC.getImage();
      Image newFoC = tempFoC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      FourC = new ImageIcon(newFoC);  
      FoC = new JButton(FourC);    
      FoC.addActionListener( this );
   
   //ThreeSpades
      ImageIcon ThreeS = new ImageIcon("ThreeS.png");
      Image temp3S = ThreeS.getImage();
      Image new3S = temp3S.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      ThreeS = new ImageIcon(new3S);  
      ThS = new JButton(ThreeS);    
      ThS.addActionListener( this );
   
   //ThreeClubs
      ImageIcon ThreeC = new ImageIcon("ThreeC.png");
      Image temp3C = ThreeC.getImage();
      Image new3C = temp3C.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      ThreeC = new ImageIcon(new3C);  
      ThC = new JButton(ThreeC);    
      ThC.addActionListener( this );
   
   //ThreeDiamonds
      ImageIcon ThreeD = new ImageIcon("ThreeD.png");
      Image temp3D = ThreeD.getImage();
      Image new3D = temp3D.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      ThreeD = new ImageIcon(new3D);  
      ThD = new JButton(ThreeD);    
      ThD.addActionListener( this );
   
   //ThreeHearts
      ImageIcon ThreeH = new ImageIcon("ThreeH.png");
      Image temp3H = ThreeH.getImage();
      Image new3H = temp3H.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      ThreeH = new ImageIcon(new3H);  
      ThH = new JButton(ThreeH);    
      ThH.addActionListener( this );
   
   //TwoHearts 
      ImageIcon TwoH = new ImageIcon("TwoH.png");
      Image tempTH = TwoH.getImage();
      Image newtempTH = tempTH.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TwoH = new ImageIcon(newtempTH);  
      TwH = new JButton(TwoH);
      TwH.addActionListener( this ); 
   
   //TwoDiamonds
      ImageIcon TwoD = new ImageIcon("TwoD.png");
      Image tempTD = TwoD.getImage();
      Image newtempTD = tempTD.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TwoD = new ImageIcon(newtempTD);  
      TwD = new JButton(TwoD);
      TwD.addActionListener( this ); 
   //TwoSpades
      ImageIcon TwoS = new ImageIcon("TwoS.png");
      Image tempTS = TwoS.getImage();
      Image newtempTS = tempTS.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TwoS = new ImageIcon(newtempTS);  
      TwS = new JButton(TwoS);
      TwS.addActionListener( this ); 
   //TwoClubs
      ImageIcon TwoC = new ImageIcon("TwoC.png");
      Image tempTC = TwoC.getImage();
      Image newtempTC = tempTC.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
      TwoC = new ImageIcon(newtempTC);  
      TwC = new JButton(TwoC);
      TwC.addActionListener( this );            
   }
   public void init(){  
   }
   
   public boolean canMove(Card a, Card b){
      setLayout(null);
      
      if((a.getValue()<b.getValue())&& (!a.getColor().equals(b.getColor()))){
         double x= b.getButton().getLocation().getX();
         double y=    b.getButton().getLocation().getY();
         a.getButton().setBounds((int)x,(int)y+50,110,120);
         return true;
      }
      
      return false;
   }
 
   public void actionPerformed( ActionEvent evt){
   
      if ( evt.getSource()==D1 )
         count=1;
    
      if(evt.getSource()==AH){
         if(numClicks.size()==0)
            numClicks.add(temp[0]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[0]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[0]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
      if(evt.getSource()==AS){
         if(numClicks.size()==0)
            numClicks.add(temp[1]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[1]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[1]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
      if(evt.getSource()==AC){
         if(numClicks.size()==0)
            numClicks.add(temp[2]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[2]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[2]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
      if(evt.getSource()==AD){
         if(numClicks.size()==0)
            numClicks.add(temp[3]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[3]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[3]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
     
      if(evt.getSource()==KD){
         if(numClicks.size()==0)
            numClicks.add(temp[7]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[7]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[7]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
      
      if(evt.getSource()==KH){
         if(numClicks.size()==0)
            numClicks.add(temp[4]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[4]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[4]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==KS){
         if(numClicks.size()==0)
            numClicks.add(temp[5]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[5]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[5]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==KC){
         if(numClicks.size()==0)
            numClicks.add(temp[6]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[6]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[6]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==QH){
         if(numClicks.size()==0)
            numClicks.add(temp[8]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[8]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[8]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==QS){
         if(numClicks.size()==0)
            numClicks.add(temp[9]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[9]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[9]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==QC){
         if(numClicks.size()==0)
            numClicks.add(temp[10]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[10]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[10]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()== QD){
         if(numClicks.size()==0)
            numClicks.add(temp[11]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[11]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[11]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==JH){
         if(numClicks.size()==0)
            numClicks.add(temp[12]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[12]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[12]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==JS){
         if(numClicks.size()==0)
            numClicks.add(temp[13]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[13]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[13]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==JC){
         if(numClicks.size()==0)
            numClicks.add(temp[14]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[14]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[14]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==JD){
         if(numClicks.size()==0)
            numClicks.add(temp[15]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[15]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[15]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==TeH){
         if(numClicks.size()==0)
            numClicks.add(temp[16]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[16]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[16]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==TeS){
         if(numClicks.size()==0)
            numClicks.add(temp[17]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[17]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[17]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==TeC){
         if(numClicks.size()==0)
            numClicks.add(temp[18]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[18]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[18]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==TeD){
         if(numClicks.size()==0)
            numClicks.add(temp[19]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[19]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[19]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==NH){
         if(numClicks.size()==0)
            numClicks.add(temp[20]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[20]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[20]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==NS){
         if(numClicks.size()==0)
            numClicks.add(temp[21]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[21]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[21]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==NC){
         if(numClicks.size()==0)
            numClicks.add(temp[22]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[22]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[22]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==ND){
         if(numClicks.size()==0)
            numClicks.add(temp[23]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[23]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[23]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==EH){
         if(numClicks.size()==0)
            numClicks.add(temp[24]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[24]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[24]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==ES){
         if(numClicks.size()==0)
            numClicks.add(temp[25]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[25]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[25]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==EC){
         if(numClicks.size()==0)
            numClicks.add(temp[26]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[26]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[26]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==ED){
         if(numClicks.size()==0)
            numClicks.add(temp[27]);
           
         
         else if(numClicks.size()==1){
            numClicks.add(temp[27]);
            canMove(numClicks.get(0),numClicks.get(1)); 
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[27]);
            canMove(numClicks.get(0),numClicks.get(1));}
      }
   
      if(evt.getSource()==SeH){
      
         if(numClicks.size()==0)
            numClicks.add(temp[28]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[28]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[28]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==SeS){
      
         if(numClicks.size()==0)
            numClicks.add(temp[29]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[29]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[29]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==SeC){
      
         if(numClicks.size()==0)
            numClicks.add(temp[30]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[30]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[30]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==SeD){
      
         if(numClicks.size()==0)
            numClicks.add(temp[31]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[31]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[31]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==SiH){
      
         if(numClicks.size()==0)
            numClicks.add(temp[32]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[32]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[32]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==SiS){
      
         if(numClicks.size()==0)
            numClicks.add(temp[33]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[33]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[33]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
   
      if(evt.getSource()==SiC){
         if(numClicks.size()==0)
            numClicks.add(temp[34]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[34]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[34]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
   
      if(evt.getSource()==SiD){
      
         if(numClicks.size()==0)
            numClicks.add(temp[35]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[35]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[35]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==FH){
      
         if(numClicks.size()==0)
            numClicks.add(temp[36]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[36]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[36]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==FS){
      
         if(numClicks.size()==0)
            numClicks.add(temp[37]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[37]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[37]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==FC){
      
         if(numClicks.size()==0)
            numClicks.add(temp[38]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[38]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[38]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==FD){
      
         if(numClicks.size()==0)
            numClicks.add(temp[39]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[39]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[39]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==FoH){
      
         if(numClicks.size()==0)
            numClicks.add(temp[40]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[40]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[40]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==FoS){
      
         if(numClicks.size()==0)
            numClicks.add(temp[41]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[41]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[41]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==FoC){
      
         if(numClicks.size()==0)
            numClicks.add(temp[42]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[42]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[42]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==FoD){
      
         if(numClicks.size()==0)
            numClicks.add(temp[43]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[43]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[43]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==ThH){
      
         if(numClicks.size()==0)
            numClicks.add(temp[44]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[44]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[44]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==ThS){
      
         if(numClicks.size()==0)
            numClicks.add(temp[45]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[45]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[45]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==ThC){
      
         if(numClicks.size()==0)
            numClicks.add(temp[46]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[46]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[46]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
      if(evt.getSource()==ThD){
      
         if(numClicks.size()==0)
            numClicks.add(temp[47]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[47]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[47]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==TwH){
      
         if(numClicks.size()==0)
            numClicks.add(temp[48]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[48]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[48]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
           
      }
      if(evt.getSource()==TwS){
      
         if(numClicks.size()==0)
            numClicks.add(temp[49]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[49]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[49]);
            canMove(numClicks.get(0),numClicks.get(1));
         } 
      }
   
      if(evt.getSource()==TwC){
      
         if(numClicks.size()==0)
            numClicks.add(temp[50]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[50]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[50]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
           
      }
   
      if(evt.getSource()==TwD){
      
         if(numClicks.size()==0)
            numClicks.add(temp[51]);
                    
         else if(numClicks.size()==1){
            numClicks.add(temp[51]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
         else {
            numClicks.remove(0);
            numClicks.add(temp[51]);
            canMove(numClicks.get(0),numClicks.get(1));
         }
           
      }
   
      repaint();
   }
 
 
   
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      Color darkGreen= new Color(28,147,17);
      ga.setBackground(darkGreen); 
      Color darkBlue= new Color(0,0,139);
   
           
      if(count==1){
         count=0;
      
         deck.get(0).getButton().setOpaque(true);
         deck.get(0).getButton().setContentAreaFilled(true);
         deck.get(0).getButton().setBorderPainted(true);
         deck.get(0).getButton().setBounds(220,80,110,120);
       
         deck.get(deck.size()-1).getButton().setVisible(false);
         deck.add(deck.remove(0));        
         if(deck.size()==0){
            D1.setOpaque(false);
            D1.setContentAreaFilled(false);
            D1.setBorderPainted(false);
         }
      }
         //col1
      col1.get(0).getButton().setBounds(100,250,110,120);
      
         //col2 
      col2.get(0).getButton().setBounds(300,250,110,120);
      col2.get(1).getButton().setBounds(300,300,110,120);
      if( col2.size()==2)
      {
         g.setColor(darkBlue);
         col2.get(0).getButton().setVisible(false);
         g.fillRect(300, 250, 110,120);     }
         
         //col3
      col3.get(0).getButton().setBounds(500,250,110,120);
      col3.get(1).getButton().setBounds(500,300,110,120);
      col3.get(2).getButton().setBounds(500,350,110,120);
     
      if( col3.size()==3)
      {
         g.setColor(darkBlue);
         col3.get(1).getButton().setVisible(false);
         col3.get(0).getButton().setVisible(false);
         g.fillRect(500, 250, 110,120);  
         g.fillRect(500, 300, 110,120);   
      }
      else if( col3.size()==2)
      {
         g.setColor(darkBlue);
         col3.get(0).getButton().setVisible(false);
         g.fillRect(500, 250, 110,120);  
      }
    //col4
      col4.get(0).getButton().setBounds(700,250,110,120);
      col4.get(1).getButton().setBounds(700,300,110,120);
      col4.get(2).getButton().setBounds(700,350,110,120);
      col4.get(3).getButton().setBounds(700,400,110,120);
   
      if( col4.size()==4)
      {
         g.setColor(darkBlue);
         col4.get(1).getButton().setVisible(false);
         col4.get(0).getButton().setVisible(false);
         col4.get(2).getButton().setVisible(false);
         g.fillRect(700, 250, 110,120);  
         g.fillRect(700, 300, 110,120);   
         g.fillRect(700, 350, 110,120); 
      }
      else if( col4.size()==3)
      {
         g.setColor(darkBlue);
         col4.get(0).getButton().setVisible(false);
         col4.get(1).getButton().setVisible(false);
         g.fillRect(700, 300, 110,120); 
         g.fillRect(700, 250, 110,120);  
      }
      else if( col4.size()==2)
      {
         g.setColor(darkBlue);
         col4.get(0).getButton().setVisible(false);
         g.fillRect(700, 250, 110,120); 
      }
   //col5
      col5.get(0).getButton().setBounds(900,250,110,120);
      col5.get(1).getButton().setBounds(900,300,110,120);
      col5.get(2).getButton().setBounds(900,350,110,120);
      col5.get(3).getButton().setBounds(900,400,110,120);
      col5.get(4).getButton().setBounds(900,450,110,120);
      if( col5.size()==5)
      {
         g.setColor(darkBlue);
         col5.get(0).getButton().setVisible(false);
         col5.get(1).getButton().setVisible(false);
         col5.get(2).getButton().setVisible(false);
         col5.get(3).getButton().setVisible(false);
         g.fillRect(900, 250, 110,120);  
         g.fillRect(900, 300, 110,120);   
         g.fillRect(900, 350, 110,120); 
         g.fillRect(900, 400, 110,120); 
      }
      else if( col5.size()==4)
      {
         g.setColor(darkBlue);
         col5.get(0).getButton().setVisible(false);
         col5.get(1).getButton().setVisible(false);
         col5.get(2).getButton().setVisible(false);
         g.fillRect(900, 300, 110,120); 
         g.fillRect(900, 250, 110,120);  
         g.fillRect(900, 350, 110,120); 
      }
      else if( col5.size()==3)
      {
         g.setColor(darkBlue);
         col5.get(0).getButton().setVisible(false);
         col5.get(1).getButton().setVisible(false);
         g.fillRect(900, 250, 110,120); 
         g.fillRect(900, 300, 110,120); 
      }
      else if(col5.size()==2){
         col5.get(0).getButton().setVisible(false);
         g.fillRect(900, 250, 110,120); 
      }
      //col6
      col6.get(0).getButton().setBounds(1100,260,110,120);
      col6.get(1).getButton().setBounds(1100,300,110,120);
      col6.get(2).getButton().setBounds(1100,360,110,120);
      col6.get(3).getButton().setBounds(1100,400,110,120);
      col6.get(4).getButton().setBounds(1100,460,110,120);
      col6.get(5).getButton().setBounds(1100,500,110,120);
      if( col6.size()==6)
      {
         g.setColor(darkBlue);
         col6.get(0).getButton().setVisible(false);
         col6.get(1).getButton().setVisible(false);
         col6.get(2).getButton().setVisible(false);
         col6.get(3).getButton().setVisible(false);
         col6.get(4).getButton().setVisible(false);
         g.fillRect(1100, 250, 110,120);  
         g.fillRect(1100, 300, 110,120);   
         g.fillRect(1100, 350, 110,120); 
         g.fillRect(1100, 400, 110,120); 
         g.fillRect(1100, 450, 110,120);   
      
      }
      else if( col6.size()==5)
      {
         g.setColor(darkBlue);
         col6.get(0).getButton().setVisible(false);
         col6.get(1).getButton().setVisible(false);
         col6.get(2).getButton().setVisible(false);
         col6.get(3).getButton().setVisible(false);
         g.fillRect(1100, 300, 110,120); 
         g.fillRect(1100, 250, 110,120);  
         g.fillRect(1100, 350, 110,120); 
         g.fillRect(1100, 400, 110,120);   
      }
      else if( col6.size()==4)
      {
         g.setColor(darkBlue);
         col6.get(0).getButton().setVisible(false);
         col6.get(1).getButton().setVisible(false);
         col6.get(2).getButton().setVisible(false);
         g.fillRect(1100, 250, 110,120); 
         g.fillRect(1100, 300, 110,120); 
         g.fillRect(1100, 350, 110,120);  
      }  
      else if(col6.size()==3){
         col6.get(0).getButton().setVisible(false);
         col6.get(1).getButton().setVisible(false);
         g.fillRect(1100, 250, 110,120); 
         g.fillRect(1100, 300, 110,120);   
      }
      else if(col6.size()==2){
         col6.get(0).getButton().setVisible(false);
         g.fillRect(1100, 250, 110,120); 
      }
   //col7
      col7.get(0).getButton().setBounds(1300,270,110,120);
      col7.get(1).getButton().setBounds(1300,300,110,120);
      col7.get(2).getButton().setBounds(1300,370,110,120);
      col7.get(3).getButton().setBounds(1300,400,110,120);
      col7.get(4).getButton().setBounds(1300,470,110,120);
      col7.get(5).getButton().setBounds(1300,500,110,120);
      col7.get(6).getButton().setBounds(1300,550,110,120);
      if( col7.size()==7)
      {
         col7.get(0).getButton().setVisible(false);
         col7.get(1).getButton().setVisible(false);
         col7.get(2).getButton().setVisible(false);
         col7.get(3).getButton().setVisible(false);
         col7.get(4).getButton().setVisible(false);
         col7.get(5).getButton().setVisible(false);
         g.fillRect(1300, 250, 110,120);  
         g.fillRect(1300, 300, 110,120);   
         g.fillRect(1300, 350, 110,120); 
         g.fillRect(1300, 400, 110,120); 
         g.fillRect(1300, 450, 110,120);  
         g.fillRect(1300, 500, 110,120);   
      
      }
      else if( col7.size()==6)
      { 
         col7.get(0).getButton().setVisible(false);
         col7.get(1).getButton().setVisible(false);
         col7.get(2).getButton().setVisible(false);
         col7.get(3).getButton().setVisible(false);
         col7.get(4).getButton().setVisible(false);
         g.fillRect(1300, 300, 110,120); 
         g.fillRect(1300, 250, 110,120);  
         g.fillRect(1300, 350, 110,120); 
         g.fillRect(1300, 400, 110,120);   
         g.fillRect(1300, 450, 110,120);  
      }
      else if( col7.size()==5)
      {
         g.setColor(darkBlue);
         col7.get(0).getButton().setVisible(false);
         col7.get(1).getButton().setVisible(false);
         col7.get(2).getButton().setVisible(false);
         col7.get(3).getButton().setVisible(false);
         g.fillRect(1300, 250, 110,120); 
         g.fillRect(1300, 300, 110,120); 
         g.fillRect(1300, 350, 110,120);  
         g.fillRect(1300, 400, 110,120);  
      }  
      else if(col7.size()==4){
         col7.get(0).getButton().setVisible(false);
         col7.get(1).getButton().setVisible(false);
         col7.get(2).getButton().setVisible(false);
         g.fillRect(1300, 250, 110,120); 
         g.fillRect(1300, 300, 110,120);  
         g.fillRect(1300, 350, 110,120);   
      }
      else if(col7.size()==3){
         col7.get(0).getButton().setVisible(false);
         col7.get(1).getButton().setVisible(false); 
         g.fillRect(1300, 250, 110,120); 
         g.fillRect(1300, 300, 110,120);   
      }
      else if(col7.size()==2){
         col7.get(0).getButton().setVisible(false);
         g.fillRect(1300, 250, 110,120); 
      }
   }
        
   public static void main(String [] args){
   
      frame= new JFrame("Solitaire");
      ga= new Game();
      ga.setOpaque(true);
      ga.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      panel = new JPanel();
   
      frame.setSize(2000,2000);
      frame.add(ga);
      ga.add(D1);
      ga.add(AH);
      ga.add(AC);
      ga.add(AS);
      ga.add(AD);
      ga.add(KS);
      ga.add(KD);
      ga.add(KH);
      ga.add(KC);
      ga.add(QH);
      ga.add(QS);
      ga.add(QC);
      ga.add(QD);
      ga.add(JH);
      ga.add(JS);
      ga.add(JC);
      ga.add(JD);
      ga.add(TeH);
      ga.add(TeS);
      ga.add(TeC);
      ga.add(TeD);
      ga.add(NH);
      ga.add(NS);
      ga.add(NC);
      ga.add(ND);
      ga.add(EH);
      ga.add(ES);
      ga.add(EC);
      ga.add(ED);
      ga.add(SeH);
      ga.add(SeS);
      ga.add(SeC);
      ga.add(SeD);
      ga.add(SiS);
      ga.add(SiH);
      ga.add(SiC);
      ga.add(SiD);
      ga.add(FS);
      ga.add(FC);
      ga.add(FH);
      ga.add(FD);
      ga.add(FoC);
      ga.add(FoH);
      ga.add(FoS);
      ga.add(FoD);
      ga.add(ThD);
      ga.add(ThC);
      ga.add(ThS);
      ga.add(ThH);
      ga.add(TwH);
      ga.add(TwD);
      ga.add(TwC);
      ga.add(TwS);
      ga.add(emptySpace1);
      ga.add(emptySpace2);
      ga.add(Spade);
      ga.add(Diamond);
      ga.add(Clubs);
      ga.add(Hearts);
   
      temp=  new Card[52]; 			 
      temp[0] = new Card (14, "Hearts","red", Ace1,AH);
      temp[1]= new Card (14, "Spades","black", Ace2,AS);
      temp[2]= new Card (14, "Club", "black", Ace3, AC);
      temp[3]= new Card (14, "Diamonds", "black", Ace4, AD);  
      temp[4]= new Card(13, "Hearts", "red", KingH, KH);
      temp[5] = new Card(13, "Spades","black", KingS, KS);
      temp[6] = new Card(13, "Club", "black", KingC, KC);
      temp[7] = new Card(13, "Diamonds", "red", KingD, KD);
      temp[8] = new Card(12, "Hearts", "red", QueenH, QH);
      temp[9] = new Card(12, "Spades", "black", QueenS, QS);
      temp[10] = new Card(12, "Club", "black", QueenC, QC);
      temp[11] = new Card(12, "Diamonds", "red", QueenD, QD);
      temp[12] = new Card(11, "Hearts", "red", JackH, JH);
      temp[13] = new Card(11, "Spades", "black", JackS, JS);
      temp[14] = new Card(11, "Club", "black", JackC, JC);
      temp[15] = new Card(11, "Diamonds", "red", JackD, JD);
      temp[16] = new Card(10, "Hearts", "red", TenH, TeH);
      temp[17] = new Card(10, "Spades", "black", TenS, TeS);
      temp[18] = new Card(10, "Club", "black", TenC, TeC);
      temp[19] = new Card(10, "Diamonds", "red", TenD, TeD);
      temp[20] = new Card(9, "Hearts", "red", NineH, NH);
      temp[21] = new Card(9, "Spades", "black", NineS, NS);
      temp[22] = new Card(9, "Club", "black", NineC, NC);
      temp[23] = new Card(9, "Diamonds", "red", NineD, ND);
      temp[24] = new Card(8, "Hearts", "red", EightH, EH);
      temp[25] = new Card(8, "Spades", "black", EightS, ES);
      temp[26] = new Card(8, "Club", "black", EightC, EC);
      temp[27] = new Card(8, "Diamonds", "red", EightD, ED);
      temp[28] = new Card(7, "Hearts", "red", SevenH, SeH);
      temp[29] = new Card(7, "Spades", "black", SevenS, SeS);
      temp[30] = new Card(7, "Club", "black", SevenC, SeC);
      temp[31] = new Card(7, "Diamonds", "red", SevenD, SeD);
      temp[32] = new Card(6, "Hearts", "red", SixH, SiH);
      temp[33] = new Card(6, "Spades", "black", SixS, SiS);
      temp[34] = new Card(6, "Club", "black", SixC, SiC);
      temp[35] = new Card(6, "Diamonds", "red", SixD, SiD);
      temp[36] = new Card(5, "Hearts", "red", FiveH, FH);
      temp[37] = new Card(5, "Spades", "black", FiveS, FS);
      temp[38] = new Card(5, "Club", "black", FiveC, FC);
      temp[39] = new Card(5, "Diamonds", "red", FiveD, FD);
      temp[40] = new Card(4, "Hearts", "red", FourH, FoH);
      temp[41] = new Card(4, "Spades", "black", FourS, FoS);
      temp[42] = new Card(4, "Club", "black", FourC, FoC);
      temp[43] = new Card(4, "Diamonds", "red", FourD, FoD);
      temp[44] = new Card(3, "Hearts", "red", ThreeH, ThH);
      temp[45] = new Card(3, "Spades", "black", ThreeS, ThS);
      temp[46] = new Card(3, "Club", "black", ThreeC, ThC);
      temp[47] = new Card(3, "Diamonds", "red", ThreeD, ThD);
      temp[48] = new Card(2, "Hearts", "red", TwoH, TwH);
      temp[49] = new Card(2, "Spades", "black", TwoS, TwS);
      temp[50] = new Card(2, "Club", "black", TwoC, TwC);
      temp[51] = new Card(2, "Diamonds", "red", TwoD, TwD);
      
      cardArray =new Card [52];
      Random rand= new Random();
      int counter=0;
      while(counter<=51){
         int index= rand.nextInt(52);
         for(int k=0; k<52;k++){
            if(cardArray[index]==null){
               cardArray[index]= temp[counter];
               
               counter++;
            }
         }
      }
      deck= new ArrayList<Card>();
      for(int n=0;n<24;n++){
         deck.add(cardArray[n]);
         deck.get(0).getButton().setOpaque(false);
         deck.get(0).getButton().setContentAreaFilled(false);
         deck.get(0).getButton().setBorderPainted(false);
      }
      
      col1= new ArrayList<Card>();
      col1.add(cardArray[24]);
      
      col2= new ArrayList<Card>();
      for(int n=25; n<27;n++)
         col2.add(cardArray[n]);
         
      col3= new ArrayList<Card>();
      for(int n=27; n<30;n++)
         col3.add(cardArray[n]);
   
      col4= new ArrayList<Card>();
      for(int n=30;n<34;n++)
         col4.add(cardArray[n]);
         
      col5= new ArrayList<Card>();
      for(int n=34;n<39;n++)
         col5.add(cardArray[n]);
         
      col6 = new ArrayList<Card>();
      for (int n=39; n<45;n++)
         col6.add(cardArray[n]);
         
      col7= new ArrayList<Card>();
      for(int n=45;n<52;n++)
         col7.add(cardArray[n]);
   } 
}
 
 
 

