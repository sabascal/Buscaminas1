package pruebaBusca;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class GrafCasilla extends JButton{
	
    private Casilla c;
	
	public GrafCasilla (Casilla cas){
		c = cas;
		setName("C"+c.getColum()/41+c.getFila()/40);
		setBounds(c.getFila(), c.getColum(), 40,  41);
		setVisible(true);
		setEnabled(true);
		setPreferredSize(new Dimension(40,41));
		setFont(new Font("Dialog", Font.BOLD, 11));
		addActionListener(new manejadorBoton());
		addMouseListener(new botonesMousse());
		//this.setContentAreaFilled(false);
	}
	
	public Casilla getCasilla(){
		return c;
	}
	
	public class manejadorBoton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String sv = "";
			String nomb = null;
			GrafCasilla csPrim = null; 
			sv = Integer.toString(c.getValor());
			int col1 = 0;
			int col2 = 0;
			int fil1 = 0;
			int fil2 = 0;
			System.out.println("Botón pulsado");
			//bc.setLabel("8");
			if (!c.getPrimera()){
				c.setPrimeraInic(true);
				Component listCasillas [] = ((JPanel) getParent()).getComponents();
				for (int i = 0; i < listCasillas.length; i++){
		    		((GrafCasilla)listCasillas[i]).getCasilla().setPrimera(true);
		    	}	
			}
			if (!c.getBandera()){
			if (c.getValor() == -9){
				setOpaque(false);
				setIcon(new ImageIcon("bomba.jpg"));
		    	setBackground(Color.RED);
		    	setEnabled(false);
		    	
		    	Component listCas [] = ((JPanel) getParent()).getComponents();
		    	for (int i = 0; i < listCas.length; i++){
		    		if (((GrafCasilla)listCas[i]).getCasilla().getValor() == -9){
		    			((GrafCasilla)listCas[i]).setOpaque(false);
		    			((GrafCasilla)listCas[i]).setBackground(Color.RED);
		    			((GrafCasilla)listCas[i]).setIcon(new ImageIcon("bomba.jpg"));
		    			((GrafCasilla)listCas[i]).setEnabled(false);
		    			((GrafCasilla)listCas[i]).getCasilla().parar();
		    			
		    		}
		    		else{
		    			((GrafCasilla)listCas[i]).setBackground(Color.GREEN);
		    			((GrafCasilla)listCas[i]).setEnabled(false);
		    		}
		    	}	
		    	
			}
			else{
				   setOpaque(false);
				   if (sv.equals("0")){
			    	   sv = "";
			    	 //  setEnabled(false);
			    	 //  setFocusable(false); 
			    	   setText(sv);
			    	
				       setEnabled(false);
			    	   if (e.getModifiers() != 0){
			    		   csPrim = (GrafCasilla) e.getSource();
			    	   }
			    	   GrafCasilla cs = (GrafCasilla) e.getSource();
			    	   JPanel p = (JPanel) cs.getParent();
			    	   int nv = ((PanelCasillas)p).getNivel();
			    	   int f1 = 0;
			    	   int c1 = 0;
			    	   if (nv == 1){
			    		   f1 = 7;
			    	       c1 = 10;
				       }
			    	   if (nv == 2){
			    		   f1 = 10;
			    	       c1 = 15;
				       }
			    	   if (nv == 3){
			    		   f1 = 12;
			    	       c1 = 25;
				       }
			    	 //  cs.setX(((Casilla) e.getSource()).getX()+41);
			    	  // cs.setY(((Casilla) e.getSource()).getY()+41);
			    	 
			    	  /* if (cs.getName().charAt(2) != '0' ||
			    		   cs.getName().charAt(2) != '9' ||
			    		   cs.getName().charAt(1) != '0' ||
			    		   cs.getName().charAt(1) != '7'){*/
			    	   int casCurrente = p.getComponentZOrder(cs);
			    	   int casVeciDrcha = casCurrente + f1;
			    	   int casVeciIzq = casCurrente - f1;
			    	   int casVeciSup = casCurrente - 1;
			    	   int casVeciInf = casCurrente + 1;
			    	   int casVeciSupIz= casCurrente - f1 - 1;
			    	   int casVeciSupDr= casCurrente + f1 - 1;
			    	   int casVeciInfIz= casCurrente - f1 + 1;
			    	   int casVeciInfDr= casCurrente + f1 + 1;
			    	   boolean dere = false;
			    	   boolean izq = false;
			    	   boolean izsup = false;
			    	   boolean izinf = false;
			    	   boolean drsup = false;
			    	   boolean drinf= false;
			    	   boolean arriba = false;
			    	   boolean abajo = false; 
			    	   col1 = Integer.parseInt(String.valueOf(cs.getName().charAt(2)));
			    	   fil1 = Integer.parseInt(String.valueOf(cs.getName().charAt(1)));
			    	   if (casVeciDrcha >= 0 && casVeciDrcha < f1*c1){
			    	       cs = (GrafCasilla) p.getComponent(casVeciDrcha);
			    	       col2 = Integer.parseInt(String.valueOf(cs.getName().charAt(2)));
			    	       }
			    	       if (col2 == col1 + 1)
			    	       if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	           cs.doClick();
			    	       
			    	   if (casVeciIzq >= 0 && casVeciIzq < f1*c1)  {
			    	       cs = (GrafCasilla) p.getComponent(casVeciIzq);
			    	       col2 = Integer.parseInt(String.valueOf(cs.getName().charAt(2)));
			    	       }
			    	       if (col2 == col1 - 1)
			    	       if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	           cs.doClick();
			    	       
			    	   if (casVeciSup >= 0 && casVeciSup < f1*c1) {     
			    	      cs = (GrafCasilla) p.getComponent(casVeciSup);
			    	      fil2 = Integer.parseInt(String.valueOf(cs.getName().charAt(1))); 
			    	      }
			    	      if (fil2 == fil1 - 1)
			    	      if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	          cs.doClick();
			    	      
			    	   if (casVeciInf >= 0 && casVeciInf < f1*c1) {   
			    	      cs = (GrafCasilla) p.getComponent(casVeciInf);
			    	      fil2 = Integer.parseInt(String.valueOf(cs.getName().charAt(1))); 
			    	      }
			    	      if (fil2 == fil1 + 1)
			    	      if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	          cs.doClick();
			    	      
			    	   if (casVeciSupDr >= 0 && casVeciSupDr < f1*c1)  {  
			    	      cs = (GrafCasilla) p.getComponent(casVeciSupDr);
			    	      fil2 = Integer.parseInt(String.valueOf(cs.getName().charAt(1))); 
			    	      col2 = Integer.parseInt(String.valueOf(cs.getName().charAt(2)));
			    	      }
			    	      if (fil2 == fil1 - 1 && col2 == col1 + 1 )
			    	      if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	          cs.doClick();
			    	      
			    	   if (casVeciSupIz >= 0 && casVeciSupIz < f1*c1) {
			    	      cs = (GrafCasilla) p.getComponent(casVeciSupIz);
			    	      fil2 = Integer.parseInt(String.valueOf(cs.getName().charAt(1))); 
			    	      col2 = Integer.parseInt(String.valueOf(cs.getName().charAt(2)));
			    	      }
			    	      if (fil2 == fil1 - 1 && col2 == col1 - 1)
			    	      if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	          cs.doClick();
			    	      
			    	   if (casVeciInfDr >= 0 && casVeciInfDr < f1*c1){ 
			    	      cs = (GrafCasilla) p.getComponent(casVeciInfDr);
			    	      fil2 = Integer.parseInt(String.valueOf(cs.getName().charAt(1))); 
			    	      col2 = Integer.parseInt(String.valueOf(cs.getName().charAt(2)));
			    	      }
			    	      if (fil2 == fil1 + 1 && col2 == col1 + 1)
			    	      if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	          cs.doClick();
			    	      
			    	   if (casVeciInfIz >= 0 && casVeciInfIz < f1*c1){ 
			    	      cs = (GrafCasilla) p.getComponent(casVeciInfIz);
			    	      fil2 = Integer.parseInt(String.valueOf(cs.getName().charAt(1))); 
			    	      col2 = Integer.parseInt(String.valueOf(cs.getName().charAt(2)));
			    	      }
			    	      if (fil2 == fil1 + 1   && col2 == col1 - 1)
			    	      if (cs.getCasilla().getValor() != -9 && cs.isEnabled())
			    	          cs.doClick(); 
			    	   //}
			    	   System.out.println(getX()+" "+getY()+" "+e.toString());
			    	   System.out.println(getX()+" "+getY()+" "+e.toString()+
			    			   " "+e.getSource());
			    	   
				   }
				   else{
			          setText(sv);
			          setEnabled(false);
			          if (e.getModifiers() == 0){
			        	  csPrim.doClick();  
				      }
				   }
			}
			setFocusable(false);  
			getCasilla().setOculta();
		
			}
        }  
	}
	
	public class botonesMousse implements MouseListener{

		public void mousePressed(MouseEvent me) {
			if (isEnabled()){
				if ((me.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
				  if (!c.getBandera()){
					  c.setIante((ImageIcon)getIcon());;
		     		  setIcon(new ImageIcon("banderaBusc.jpg"));
				      c.setBandera(true);
			      }
				  else{
				       setIcon((ImageIcon)c.getIcante());
				       c.setBandera(false);
				  }
		    }
			}
		}
		public void mouseReleased(MouseEvent me) {
		}
		public void mouseExited(MouseEvent me) {
		}
		public void mouseEntered(MouseEvent me) {
		}
		public void mouseClicked(MouseEvent me) {
		}
	}
	
	
}

