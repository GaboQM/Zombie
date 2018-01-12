package clases.elementos;

import java.util.Random;

import clases.central.LogicaCentral;

public class Zombie {
	private int x;
	private int y;
	private double dx;//direccion x
	private double dy;//direccion y
	private int tam; //tamaño del marciano

	LogicaCentral base=new LogicaCentral();
	//primer constructor arranque inicial del marciano(marciano original)
	public Zombie() {
		x =(int) (Math.random() * 780 + 10); //posicion aleatoeria en x que va de 50 a 700
		y = (int) (Math.random()*(-20-(-300)+1)+(-300));//posicion aleatoria en y que va de 50 a 100
		dx = 1;//inicialmente se deplazara a 5 pixiles en x
		dy = 0; //0 en y
		tam = 40;//tamaño  inicial del marciano
	}

	
	
	//este segundo  constructor sera para las nuevas generacion de los marcionos
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public int getTam() {
		return tam;
	}

	public void mover(int suelo[]) {
		
		

		dy =1;
		y += dy;
		
		
		
		
	}
	
	
public void mover2(int suelo[]){
	
	
	dy =1;
	y += dy;
	
int	parImpar=(int) (Math.random()*(50-(0)+1)+(0));

if((parImpar ==1)){
	
	x=(int)(Math.random()*(795-(0)+1)+(0));
}else{
	
}
}
}

