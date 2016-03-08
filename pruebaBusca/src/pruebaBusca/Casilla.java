package pruebaBusca;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.util.*;

public class Casilla extends Observable{
	private int valor;
	private int x;
	private int y;
	private boolean bandera;
	private boolean bomba; 
	private String imagen;
	private Icon icanterior;
	private boolean oculta;
	private boolean primera;
	
	public Casilla (int pV, int pX, int pY, String pImg){
		bandera = false;
		bomba = false;
		oculta = true;
		if (pV == -9){
			bomba = true;
		}
		valor = pV;
		x = pX;
		y = pY;
		imagen = pImg;
		icanterior = new ImageIcon(pImg);
		primera = false;
	}
	
	public int getValor(){
		return valor;
	}
	
	public int getFila(){
		return x;
	}
	public int getColum(){
		return y;
	}
	public String getImagen(){
		return imagen;
	}
	public boolean getBandera(){
		return bandera;
	}
	public boolean getBomba(){
		return bomba;
	}
	public Icon getIcante(){
		return icanterior;
	}
	public boolean getOculta(){
		return oculta;
    }
	public void setX(int x){
	    this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setImg (String pImg){
		icanterior = new ImageIcon(imagen);
		imagen = pImg;
	}
	public void setValor(int v){
		valor = v;
	}
	public void setBandera(boolean b){
		bandera = b;
		setChanged();
	    this.notifyObservers(b);
	}
	public void setBomba(boolean b){
		bomba = b;
	}
	public void setIante(ImageIcon img){
		icanterior = img;
	}
	public boolean getPrimera(){
		return primera;
	}
	public void setPrimeraInic(boolean b){
		primera = b;
		setChanged();
		this.notifyObservers("iniciar");
	}
	
	public void setPrimera(boolean b){
		primera = b;
	}
	public void setOculta(){
		oculta = false;
	}
	public void parar(){
		setChanged();
		this.notifyObservers("parar");
	}
	
	
}
