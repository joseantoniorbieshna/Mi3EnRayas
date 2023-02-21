package controler;

import javax.swing.JButton;

import modelo.Coordenada;

public class MyButton extends JButton {
	
	private Coordenada cordenadas;
	

	public MyButton(String text,int x, int y) {
		super(text);
		this.cordenadas = new Coordenada(x, y);
	}
	
	public Coordenada getCordenadas() {
		return cordenadas;
	}

}
