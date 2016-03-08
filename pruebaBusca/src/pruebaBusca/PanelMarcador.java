package pruebaBusca;

import javax.management.timer.Timer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;






import java.awt.*;
import java.awt.event.*;

import javax.swing.border.*;
import javax.swing.*;

import java.util.*;

public class PanelMarcador extends JPanel implements Observer{
	//private static final long serialVersionUID = 8313442043392839053L;
	private int nivel;
	private JButton reinicio;
	private JLabel tminas;
	private JLabel ttiempo;
	private int segundos;
	private javax.swing.Timer tim;
	public PanelMarcador(int n){
		nivel = n;
		int m = 0;
		if (n == 1){
			m = n * 10;
		}
		if (n == 2){
			m = n * 15;
		}
		if (n == 3){
			m = n * 25;
		}
		tminas = new JLabel(String.valueOf(m));
		ttiempo = new JLabel("000");
		reinicio = new JButton();
		ttiempo.setOpaque(true);
		tminas.setOpaque(true);
		setPreferredSize(new Dimension(41*10, 50));
		setLayout(new GridLayout(1,3,80*n,1));
		add(tminas);
		add(reinicio);
		add(ttiempo);
	
		reinicio.setIcon(new ImageIcon("cfeliz.jpg"));
		reinicio.setEnabled(true);
		reinicio.setPreferredSize(new Dimension(41,41));
		tminas.setFont(new Font("Dialog", Font.BOLD, 20));
		tminas.setEnabled(true);
		ttiempo.setFont(new Font("Dialog", Font.BOLD, 20));
		ttiempo.setEnabled(true);
		Border brd = BorderFactory.createLineBorder(Color.BLUE, 5);
		ttiempo.setBorder(brd);
		tminas.setBorder(brd);
		tminas.setPreferredSize(new Dimension(41,41));
		ttiempo.setPreferredSize(new Dimension(41,41));
		ttiempo.setForeground(Color.RED);
		ttiempo.setBackground(Color.BLACK);
		tminas.setForeground(Color.RED);
		tminas.setBackground(Color.BLACK);
		segundos = 0;
		tim = new javax.swing.Timer (1000, new ActionListener(){
    		public void actionPerformed(ActionEvent evt) {
                setTiempo();
            }    		
    	});
		reinicio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("REINICIAR JUEGO....");
				String jug = ((Tablero)(getParent().getParent().getParent().getParent())).getJugador();
			    ((Tablero)(getParent().getParent().getParent().getParent())).cerrar();
				
				Tablero t = new Tablero(n);
				t.setJugador(jug);
			}
		});
	}
    public int getMinas(){
    	return Integer.parseInt(tminas.getText());
    }
    public int getTiempo(){
    	return Integer.parseInt(ttiempo.getText());
    }
    public void sumaMinas(){
    	tminas.setText(String.valueOf(Integer.parseInt(tminas.getText())+1));
    }
    public void restaMinas(){
    	tminas.setText(String.valueOf(Integer.parseInt(tminas.getText())-1));
    }
    public void setTiempo(){
    	
    	segundos = segundos + 1;
    	ttiempo.setText(String.valueOf(segundos));
    }
    public void evaluarJuego(){
    	    int co = 0;
    	    int cb = 0;
    	    Component lCas []=((JPanel)(getParent()).getComponent(2)).getComponents();
    	    for (int i = 0; i < lCas.length; i++){
	    		if (((GrafCasilla)lCas[i]).getCasilla().getBandera()){
	    			cb = cb + 1;
	    		}
	    		if (((GrafCasilla)lCas[i]).getCasilla().getOculta()){
	    			co = co + 1;
	    		}
    	    }
    		if (Integer.parseInt(tminas.getText()) != 0 &&
    		   !(Integer.parseInt(tminas.getText()) + cb == 10 && co == 0) &&
    		    Integer.parseInt(tminas.getText()) != co
    		   )
    			reinicio.setIcon(new ImageIcon("Ctriste.jpg"));
    }
    public void update (Observable o, Object arg){
    	if (arg.equals("iniciar")){
    		tim.start();
    	}
    	else{
    		if (arg.equals("parar")){
    			tim.stop();
    			evaluarJuego();
    		}
    		else
        	   if ((boolean)arg == true)
    		       restaMinas();
    	       else
    		       sumaMinas();
    	}
    }
	
}
