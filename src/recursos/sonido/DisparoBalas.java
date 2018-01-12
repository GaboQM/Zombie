package recursos.sonido;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class DisparoBalas implements Runnable {
	private BufferedInputStream buffer = null;
	private Player player = null;

	public DisparoBalas() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileInputStream archivo = new FileInputStream(this.getClass()
					.getResource("/recursos/sonido/Disparo.mp3")
					.toURI().getPath());
			buffer = new BufferedInputStream(archivo);
			player = new Player(buffer);
			player.play();

			archivo.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void disparandoLaser() {
		DisparoBalas mDisparo = new DisparoBalas();
		Thread hilo = new Thread(mDisparo);
		hilo.start();
	}

}
