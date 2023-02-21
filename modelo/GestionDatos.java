package modelo;

public class GestionDatos{
	private DatosComun datos;
	private GestionMoverFicha gestionMover;
	public GestionDatos() {
		this.datos = new DatosComun();
		this.gestionMover = new GestionMoverFicha(datos);
		
	}
	
	
	public boolean hacerMovimiento(Coordenada cords) {
		if(datos.getNumerojugada()<6 && !datos.getHasGanado()) {
			GestionColocarFicha gestionColocar = new GestionColocarFicha(datos);
			datos = gestionColocar.hacerMovimiento(cords);
			return true;
		}else if(datos.getNumerojugada()>=6 && !datos.getHasGanado()){
			gestionMover.setDatos(datos);
			this.datos = gestionMover.hacerMovimiento(cords);
			//COMPROBAR SI HAS GANADO
			datos.setHasGanado(datos.getTablero().comprobarTresEnRaya());
			return true;
		}
		
		
		return false;
	}



	public DatosComun getDatos() {
		return datos;
	}
	
	public int[][] getTablero(){
		return datos.getTablero().getTableroCompleto();
	}
	public Coordenada fichaSelec7Mov() {
		return gestionMover.getCoordenadaFicha();
	}
	
	
	
}


