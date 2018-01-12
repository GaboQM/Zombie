package clases.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Font;





import javax.swing.JFrame;

import recursos.sonido.DisparoBalas;
import recursos.sonido.FondoMusica;
import clases.central.LogicaCentral;
import clases.elementos.Zombie;

public class PintadoZombie extends JFrame implements Runnable {

	
	Image imgMarciano;
	Image imgCuriosity;
	Image imgPantallas;
	Image imgPortada;
	Image imgExplosion;
	Image imgGuia;
	Image imgZombie;
	Image imgCampeon;
	Image imgCofre;
	
	/* 
	 ---algoritmo--
	 frame
	 gameloop
	 update()
	 pintar()
	 sleep()
	 
	 */

	LogicaCentral base = new LogicaCentral();

	BufferedImage bi = new BufferedImage(800, 600, BufferedImage.TYPE_3BYTE_BGR);
	Graphics gbi = bi.getGraphics();

	// Etapa 2
	public void cargarImagenes() {
		base.pedirUsuario();

		Toolkit tk = Toolkit.getDefaultToolkit();
 int q=(int) (Math.random()*(2-(0)+1)+(0));
// System.out.println(q);
		imgMarciano = tk.getImage(getClass().getResource(
				"/recursos/grafico/Marciano"+q+".gif"));
		imgCuriosity = tk.getImage(getClass().getResource(
				"/recursos/grafico/Curiosity.gif"));
		
		imgPantallas = tk.getImage(getClass().getResource(
					"/recursos/grafico/Pantallas.jpg"));
		imgPortada = tk.getImage(getClass().getResource(
				"/recursos/grafico/Portada.jpg"));
		imgExplosion=tk.getImage(getClass().getResource(
				"/recursos/grafico/explosion.gif"));
		imgGuia=tk.getImage(getClass().getResource(
				"/recursos/grafico/guia.png"));
		imgZombie=tk.getImage(getClass().getResource(
				"/recursos/grafico/zombie.gif"));
		// System.out.println(imgPantallas);
		imgCampeon=tk.getImage(getClass().getResource(
				"/recursos/grafico/Campeon.png"));
		imgCofre=tk.getImage(getClass().getResource("/recursos/grafico/Cofre.gif"));

	}

	

	

public void pintarMarcianos(Graphics g) {
	
		ArrayList<Zombie> marcianos = base.getMarcianos();
		//recorremos el ArrayList marciano
		for (Zombie marc : marcianos) {
			int tam = marc.getTam();
			//dibujamos un  marciano por cada ciclo
			g.drawImage(imgMarciano, marc.getX() - tam, marc.getY() - tam,
					tam * 2, tam * 2, this);
		
		}
	}
public void pintarCuriosity(Graphics g) {
	int x = base.getX(); // valor definido en la clase logica central,x=400, se coloca en medio
	int y[] = base.getYSuelo();//el valor de y se obtiene del suelo
	//float ang[] = base.getAnguloSuelo(); //el mismo angulo que el de suelo
	BufferedImage biCuriosity = new BufferedImage(200, 150,
			BufferedImage.TYPE_4BYTE_ABGR);// creamos buffer imagen
	//para poder rotar usamos Graphis2D
	Graphics2D g2d = (Graphics2D) biCuriosity.getGraphics();
	//g2d.rotate(ang[x], 100, 100); //rotamos 
	//dibujamos curiosity
	g2d.drawImage(imgCuriosity, 30, 0, this);
	//dibujasmo en el graphics general
	g.drawImage(biCuriosity, x - 100, y[x] -100, this);

	g.drawImage(imgGuia,x-25 , y[x] -598, this);

}

	public void pintarDisparo(Graphics g) {

		int dis = base.getDisDisparo(); //distancia de disparo
		if (dis > 0) {
			int x = base.getXDisparo();
			float ang = base.getAngDisparo();
			int suelo[] = base.getYSuelo();
			int xI = x;// inicion del dispro en x
			int yI = suelo[x];// inicion de disparo en y de acuerdo al posicion x
			int xF = (int) (xI + Math.cos(ang) * dis); //x final
			int yF = (int) ((yI - 50) + Math.sin(ang) * dis);// y final

	
			//	g.drawLine(xI + n - 2, yI - 35, xF, yF);
				g.drawImage(imgExplosion, xF-10,yF, this);
			//}
			// sonido de disparo
	

		}

	}

public void pintarPuntaje(Graphics g) {
		
		//imagenes de fondo de puntaje(trasparente)
		Toolkit tk2 = Toolkit.getDefaultToolkit();
		Image puntuacion = tk2.getImage(getClass().getResource(
				"/recursos/grafico/puntaje.png"));
		g.drawImage(puntuacion, 145, 30, this);
//font nos permite personalizar los texto
		Font fuente = new Font("Arial", Font.BOLD, 18);
		g.setFont(fuente);
		g.setColor(Color.YELLOW);
		String texto = "JUGADOR:                            "
				+ "NIVEL:                 " + "PUNTAJE:                    ";
		g.drawString(texto, 170, 55);
		g.setColor(Color.WHITE);

		String jugadorNombre = base.getJugador();
		g.drawString(jugadorNombre, 270, 55);
		String numeroNivel = "" + (base.getNivel() + 1);
		g.drawString(numeroNivel, 470, 55);
		String numeroPuntaje = "" + (base.getPuntaje());

		g.drawString(numeroPuntaje, 645, 55);

	}
	
	
public void pintarScort(Graphics g) {

	if (base.getEstado() == 2) {
		Toolkit tk2 = Toolkit.getDefaultToolkit();
		Image puntuacion = tk2.getImage(getClass().getResource(
				"/recursos/grafico/puntuacion.png"));
		// g.drawImage(img,-30,-80, this);
		g.drawImage(puntuacion, 100, 100, this);
		Font fuente = new Font("Arial", Font.BOLD, 36);
		g.setFont(fuente);
		g.setColor(Color.YELLOW);
		String jugadorPuntuacion = base.getJugador();
		g.drawString(jugadorPuntuacion, 410, 315);
        String pintarPuntuacion=""+base.getPuntaje();
        g.drawString(pintarPuntuacion, 410, 383);
        String pintarNivel=""+(base.getNivel()+1);
        g.drawString(pintarNivel, 410, 458);
		
		
		
		
		g.setColor(Color.WHITE);
		Font fuente2 = new Font("Arial", Font.BOLD, 14);
		g.setFont(fuente2);
		String indica="   [ PULSA LA TECLA ESPACIO PARA CONTINUAR O ESC PARA SALIR]";
		g.drawString(indica, 160, 500);
	} else {

	}

}

public void pintarCampeon(Graphics g){
	gbi.drawImage(imgCampeon, 0, 0, this);
	gbi.drawImage(imgCofre, 220, 130, this);
}


	
	public void update(Graphics g) {
		//repintar
		paint(g);
	}

	// etapa3, cargar portada
	public void paint(Graphics g) {
		// estado, pregutamos el estado,para saber que pintar
		switch (base.getEstado()) {
		case 0:
			//cargando todas las imagenes
			 
			gbi.drawImage(imgPantallas, 0, 0, this);

			 
			gbi.drawImage(imgPortada, 0, 0, this);
			gbi.drawImage(imgZombie, 440, 470, this);
			break;
		case 1:
		case 2:
			gbi.drawImage(imgPantallas, 0, 0, this);
		
			
			pintarDisparo(gbi);
		
			
			pintarCuriosity(gbi);
	
			pintarMarcianos(gbi);
			pintarPuntaje(gbi);
			pintarScort(gbi);
			break;
		case 3:
			pintarCampeon(gbi);
			break;
		}
		g.drawImage(bi, 0, 0, this);
	}
	

	public PintadoZombie() {
		Toolkit herram = Toolkit.getDefaultToolkit();
		Dimension tamanoPanta = herram.getScreenSize();
		int posicionX = tamanoPanta.height;
		int posicionY = tamanoPanta.width;
		this.setResizable(false);

		this.setSize(800, 600);
		this.setLocation(posicionX / 3, posicionY / 10);
		//this.setUndecorated(true);
		this.setTitle("Zombies 1.0 ( Version Libre )");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cargarImagenes();

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				//
				base.guardarTeclaPulsada(e.getKeyCode());
				// codigo pulsado
				// System.out.println(e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);

				// al liberar o solar tecla, remover de hastable
				base.romoverTeclaPulsada(e.getKeyCode());
			}
		});

		Thread hilo = new Thread(this);
		hilo.start();

		FondoMusica mfondo = new FondoMusica();

		mfondo.iniciarMusicaFondo();
	}

	public void run() {

		// ciclo infinito que mantiene activo la ejecucion
		for (int i = 0; i < 10;) {
			try {
 
				  Thread.sleep(45);
				//System.out.println(velocidad);
			} catch (Exception e) {
			}
			base.iniciarJuego();
			repaint();
		}
	}
}
