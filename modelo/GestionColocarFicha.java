package modelo;

public class GestionColocarFicha {
	/*
	 * PRIMEROS 6 MOVIMIENTOS
	 * LOCIGA DE COLOCAR FICHA
	 */
	private DatosComun datos;
	public GestionColocarFicha(DatosComun datos) {
		this.datos = datos;
	}
	
	public DatosComun hacerMovimiento(Coordenada cords) {
		if(comprobarPosDisponible(cords)) {
			colocarFicha(cords);
			
			//COMPROBAR SI HAS GANADO SI NO SUMAR TURNO
			datos.setHasGanado(datos.getTablero().comprobarTresEnRaya());
			if(!datos.getHasGanado())
				this.datos.aumentarUnaJugada();
			return this.datos;
		}
		return this.datos;
		
	}
	
	public boolean comprobarPosDisponible(Coordenada cords){
		return datos.getTablero().mirarCasillaLibre(cords);
	}
	
	public void colocarFicha(Coordenada cords) {
		datos.getTablero().setValorPosicion(cords, datos.verTurno());
	}
	
}
