package modelo;
/* DESPUÉS DE 6 MOVIMIENTO
 * LOGICA DE MOVER FICHA
 * 
 *  
 * */
public class GestionMoverFicha {
	private Coordenada coordenadaFicha;
	DatosComun datos; 
	public GestionMoverFicha (DatosComun datos) {
		coordenadaFicha=null;
		this.datos = datos;
		
	}
	
	public DatosComun hacerMovimiento(Coordenada cords) {
		//SELECCIONAR FICHA
		if(coordenadaFicha==null && posibleMoverSubyacente(cords) && esMismaFichaTurno(cords)) {
			this.coordenadaFicha = cords;
			this.datos.getTablero().setValorPosicion(cords, 0);
		}
		//RESETEAR PIEZA SI ELIGO LA MISMA POS
		else if(coordenadaFicha!=null && this.coordenadaFicha.isEqualTo(cords)) {
			this.coordenadaFicha=null;
			this.datos.getTablero().setValorPosicion(cords, datos.verTurno());
		}
		//MOVER A SUBYACENTE LA SELECCIONADA
		else if(coordenadaFicha!=null && this.coordenadaFicha.casillaContigua(cords) && casillaLibre(cords)) {
			this.datos.getTablero().setValorPosicion(cords, datos.verTurno());
			this.coordenadaFicha=null;
			comprobarSiHasGanadoSiNoSumarTurno();
		}
		
		return this.datos;
		
	}
	public void setDatos(DatosComun datos) {
		this.datos=datos;
	}
	public Coordenada getCoordenadaFicha() {
		return coordenadaFicha;
	}
	
	
	private void comprobarSiHasGanadoSiNoSumarTurno() {
		//COMPROBAR SI HAS GANADO SI NO SUMAR TURNO
		datos.setHasGanado(datos.getTablero().comprobarTresEnRaya());
		if(!datos.getHasGanado())
			this.datos.aumentarUnaJugada();
	}

	
	
	//PARA CODIGO MAS LIMPIO (MUCHOS ".")
	private boolean esMismaFichaTurno(Coordenada cords) {
		return datos.verTurno()==datos.getTablero().getValorPosicion(cords);
	}
	private boolean casillaLibre(Coordenada cords) {
		return datos.getTablero().mirarCasillaLibre(cords);
		}
	
	private boolean posibleMoverSubyacente(Coordenada cords) {
		return datos.getTablero().comprobarBloqueada(cords);
	}
		
}
