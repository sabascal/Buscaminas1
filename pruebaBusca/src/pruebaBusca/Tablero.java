package pruebaBusca;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tablero extends JFrame{
	  private int nivel;
      private PanelMarcador pm;
      private JLabel jugador; 
      private PanelCasillas pc;
      public Tablero(int n){
    	  this.setTitle("Buscaminas");
    	  setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
    	 
    	  pm = new PanelMarcador(n);
    	  pc = new PanelCasillas(n);
  		  for (int k = 0; k < pc.getComponentCount(); k++){
  		      ((GrafCasilla)pc.getComponent(k)).getCasilla().addObserver(pm);
  		  }
  		  jugador = new JLabel();
  		  jugador.setFont(new Font("Dialog", Font.BOLD, 20));
  		  jugador.setForeground(Color.RED);
  		 
  		  jugador.setPreferredSize(new Dimension(30,20));
  		  
  		  add(pm);
  		  add(jugador);
  		  add(pc);
  		 
  		  pack();
  		  setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
  		  setVisible(true);  
      }
      public String getJugador(){
    	  return jugador.getText();
      }
      public void setJugador(String jug){
    	  jugador.setText(jug);
      }
      public void cerrar(){
    	  this.dispose();
      }
      
}
