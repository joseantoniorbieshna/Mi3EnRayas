package controler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.UI;

public class ParaUI extends UI {
	
	private ActionListener comportamiento;
	private Controlador controlador;
	private Color JdefaultColor;
	
	public ParaUI() {
		super();
		JdefaultColor = getBotones()[0][0].getBackground();
		this.controlador = new Controlador();
		crearComportamientoBotones();
		addComportamientoBotones();
		//SET CURRENT LABEL AL CONSTRUIR
		getLblCurrentPlayer().setText(controlador.devolverTurnoActual());
	}
	
	
	public void crearComportamientoBotones(){
		this.comportamiento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyButton botonPulsado = (MyButton)e.getSource();
				//HACER MOVIMIENTO
				if(controlador.hacerMovimiento(((MyButton)e.getSource()).getCordenadas())) {
					imprimirBotones(controlador.getTablero());
				}

				
				//IMPRIMIR EL TURNO ACTUAL
				getLblCurrentPlayer().setText(controlador.devolverTurnoActual());
				//IMPRIMIR MENSAJE SI HAS GANADO O SI NO HAS GANADO
				getLblMensaje().setText(controlador.mensajeHasGanado());
			}
		};
	}
	
	
	
	private void addComportamientoBotones() {
		for(int i=0;i<getBotones().length;i++) {
			for(int j=0;j<getBotones()[0].length;j++) {
				getBotones()[i][j].addActionListener(comportamiento);
			}
		}
	}
	private void imprimirBotones(int[][] tablero) {
		for(int x=0;x<getBotones().length;x++) {
			for(int y=0;y<getBotones()[0].length;y++) {
				//VALOR
				if(tablero[x][y]==1) {
					getBotones()[x][y].setText("X");
				}else if(tablero[x][y]==2){
					getBotones()[x][y].setText("O");
				}else {
					getBotones()[x][y].setText("");
				}
				if(controlador.getFichaSelec()!=null && controlador.getFichaSelec().getY()==y && controlador.getFichaSelec().getX()==x) {
					getBotones()[x][y].setBackground(Color.GRAY );
					getBotones()[x][y].setText("Selec");
				}else {
					getBotones()[x][y].setBackground(JdefaultColor);
				}
				

			}
		}
	}
	
	

}
