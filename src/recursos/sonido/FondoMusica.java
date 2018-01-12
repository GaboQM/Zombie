package recursos.sonido;

import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class FondoMusica implements Runnable {

	private BufferedInputStream buffer = null;
	private Player player = null;

	public FondoMusica() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileInputStream archivo = new FileInputStream(this.getClass()
					.getResource("/recursos/sonido/MusicaFondo.mp3").toURI()
					.getPath());
			buffer = new BufferedInputStream(archivo);
			player = new Player(buffer);
			player.play();
			while (true) {
				if (player.isComplete()) {
					archivo.close();
					try {
						archivo = new FileInputStream(
								this.getClass()
										.getResource(
												"/recursos/sonido/MusicaFondo.mp3")
										.toURI().getPath());
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					buffer = new BufferedInputStream(archivo);
					player = new Player(buffer);
					player.play();
				}

			}

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

	public void iniciarMusicaFondo() {
		FondoMusica mfondo = new FondoMusica();
		Thread hilo = new Thread(mfondo);
		hilo.start();
	}

}
