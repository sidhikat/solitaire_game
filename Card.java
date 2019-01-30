 
import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
public class Card
{
   private int value;
   private ImageIcon card;
   private String suit;
   private JButton b;
   boolean clicked;
   String color;
 
   public Card(int value, String suit, String color, ImageIcon card,  JButton b){
      this.value= value;
      this.suit= suit;
      this.color= color;
      this.card=card;
      this.b=b;
   }
   
   public String getColor(){
      return color;}
   
   public int getValue(){
      return value;}
 
   public String getSuit(){
      return suit;}
      
   public ImageIcon getImageIcon() {
      return card;
   }  
   
   public JButton getButton(){
      return b;}
      
   
   public boolean isClicked(){
   
      return clicked;}
   
   public void setClicked(boolean f){
      clicked=f;
   }
 
}
 
