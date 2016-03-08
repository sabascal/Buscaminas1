package pruebaBusca;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;

import pruebaBusca.GrafCasilla.manejadorBoton;

public class PanelCasillas extends JPanel {
	private int nivel;
	
	public PanelCasillas (int n){
	     nivel = n;
		//super (new BorderLayout());
		//jp = new JPanel();
		//jp.setLayout(new BorderLayout(10, 7 ));
		int cb = 0;
		int f = 0;
		int c = 0;
		
		
		switch (n){
		case 1:
			f = 7;
			c = 10;
		
		
			break;
		case 2:
			f= 10;
			c= 15;
			
			break;
		case 3:
		    f=12;
		    c=25;
			break;
		default:
			break;
		}
		cb = c*n;
		Random r = new Random();
		int vf = 0;
		int vc = 0;
		int fila = 0;
		int colum = 0;
		
		PosiBomb [] pb = new PosiBomb[cb];
		for (int s = 0; s < cb; s++){
			pb[s]= new PosiBomb(0,0);
		}
		int ipb = 0;
		
		int [][] cas = new int [f][c];
		for (int k = 0; k < cb; k++){
			vf = r.nextInt(f);
			vc = r.nextInt(c);
			System.out.println (vf+" "+vc);
			int l = 0;
			while (l < cb){
				PosiBomb psb = new PosiBomb(vf,vc);
				
				if ((pb [l].getFbomb() == psb.getFbomb()) && 
				    (pb [l].getCbomb() == psb.getCbomb()) ){
					vf = r.nextInt(f);
				    vc = r.nextInt(c);
				    l = 0;
				    System.out.println ("aqui"+vf+" "+vc);
				}
				else
			       l = l + 1;
				     
			}
			cas [vf][vc] = -9;
			pb [ipb] = new PosiBomb(vf,vc);
			ipb = ipb + 1;
			
			fila = vf+1;
			colum = vc+1;
			if (fila < f && colum < c && fila >=0 && colum >=0)
				if (cas[fila][colum] != -9)
			       cas [fila][colum] = cas [fila][colum] +1;
			
			if (fila < f && vc < c && fila >=0 && vc>=0)
				if (cas[fila][vc] != -9)
		        	cas [fila][vc] = cas [fila][vc] +1;
			
			if (vf < f && colum < c && vf >=0 && colum>=0)
				if (cas[vf][colum] != -9)
			      cas [vf][colum] = cas [vf][colum] +1;
			
			fila = vf -1;
			if (fila < f && vc < c && fila >=0 && vc>=0)
				if (cas[fila][vc] != -9)
			       cas [fila][vc] = cas [fila][vc] +1;
			
			colum = vc -1;
			if (vf < f && colum < c && vf >=0 && colum>=0)
				if (cas[vf][colum] != -9)
			      cas [vf][colum] = cas [vf][colum] +1;
			
			fila = vf -1;
			colum = vc - 1;
			if (fila < f && colum < c && fila >=0 && colum>=0)
				if (cas[fila][colum] != -9)
			        cas [fila][colum] = cas [fila][colum] +1;
			
			fila = vf +1;
			colum = vc -1;
			if (fila < f && colum < c && fila >=0 && colum>=0)
				if (cas[fila][colum] != -9)
			       cas [fila][colum] = cas [fila][colum] +1;
			fila = vf -1;
			colum = vc +1;
			if (fila < f && colum < c && fila >=0 && colum>=0)
				if (cas[fila][colum] != -9)
			      cas [fila][colum] = cas [fila][colum] +1;
			
			
			 
		}
		
		//jp.setLayout(new GridLayout(10,7000));
		//setLayout(new GridBagLayout());
		//GridLayout g = new GridLayout(f ,c);
		Dimension d = new Dimension (41*c,41*f);
		setPreferredSize(d);
		//FlowLayout flow = new FlowLayout();
		
		setLayout(null);
		
		Casilla c1;
		GrafCasilla gc1;
		for (int i= 0; i < c; i++)
		  for (int j = 0; j < f; j++){
			c1 = new Casilla (cas[j][i],i*41,j*41,"");
			gc1 = new GrafCasilla(c1);
			add(gc1, null);
			
		   }
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		//jp.setVisible(true);
		

	}
	public int getNivel(){
		return nivel;
	}

}
