package controler;

import modelo.Coordenada;
import modelo.GestionDatos;

//ESTE SE LLAMA DESDE CUANDO HAY UNA ACCION EN LA VISTA Y SERÁ UN INTERMEDIARIO ENTRE EL MODELO Y LA VISTA,
//LA VISTA ME DA UNA SOLICITUD Y ESTA SOLICITUD DEMANDA DATOS AL MODELO
//ESTE ME DA UNA RESPUESTA QUE SE LA DEVUELVO A LA UI A TRAVÉS DE ESTE CONTROLADOR
public class Controlador {
	
	//CONECTAMOS EL MODELO AL CONTROLADOR PARA PEDIR DATOS Y CAMBIAR DATOS
	GestionDatos gestion = new GestionDatos();
	
	public Controlador(){
		
	}
	
	//PETICIONES DE LA UI AL MODELO
	public boolean hacerMovimiento(Coordenada cords) {
		return gestion.hacerMovimiento(cords);
		
	}
	public String devolverTurnoActual() {
		if(gestion.getDatos().verTurno()==1) {
			return "X";
		}else {
			return "O";
		}
	}
	public String mensajeHasGanado() {
		if(gestion.getDatos().getHasGanado()) {
			return "JUGADOR \""+devolverTurnoActual()+"\". HAS GANADO!!";
		}
		return "";
	}
	public int[][] getTablero(){
		return gestion.getTablero();
	}
	public Coordenada getFichaSelec() {
		return gestion.fichaSelec7Mov();
	}
	

}
