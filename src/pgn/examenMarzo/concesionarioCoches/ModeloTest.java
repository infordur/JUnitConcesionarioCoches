package pgn.examenMarzo.concesionarioCoches;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModeloTest {

	@Test
	public void testModelo() {
		assertNotNull(Modelo.CORDOBA);
		assertNotNull(Modelo.IBIZA);
		assertNotNull(Modelo.SERIE1);
		assertNotNull(Modelo.SERIE2);
		assertNotNull(Modelo.SERIE3);
		assertNotNull(Modelo.SERIE5);
		assertNotNull(Modelo.TOLEDO);
	}

	@Test
	public void testModeloMarca(){
		//Modelos que no pertenecen a una Marca
		assertNotEquals(Modelo.CORDOBA.getMarca(),Marca.BMW); //El modelo CORDOBA no pertenece a la marca BMW
		assertNotEquals(Modelo.IBIZA.getMarca(),Marca.BMW); //El modelo IBIZA no pertenece a la marca BMW
		assertNotEquals(Modelo.TOLEDO.getMarca(),Marca.BMW); //El modelo TOLEDO no pertenece a la marca BMW
		
		assertNotEquals(Modelo.SERIE1.getMarca(),Marca.SEAT); //El modelo SERIE1 no pertenece a la marca SEAT
		assertNotEquals(Modelo.SERIE2.getMarca(),Marca.SEAT); //El modelo SERIE2 no pertenece a la marca SEAT
		assertNotEquals(Modelo.SERIE3.getMarca(),Marca.SEAT); //El modelo SERIE3 no pertenece a la marca SEAT
		assertNotEquals(Modelo.SERIE5.getMarca(),Marca.SEAT); //El modelo SERIE5 no pertenece a la marca SEAT
		
		//Modelos que pertenecen a la marca
		assertEquals(Modelo.CORDOBA.getMarca(),Marca.SEAT);
		assertEquals(Modelo.IBIZA.getMarca(),Marca.SEAT);
		assertEquals(Modelo.TOLEDO.getMarca(),Marca.SEAT);
		assertEquals(Modelo.SERIE1.getMarca(),Marca.BMW);
		assertEquals(Modelo.SERIE2.getMarca(),Marca.BMW);
		assertEquals(Modelo.SERIE3.getMarca(),Marca.BMW);
		assertEquals(Modelo.SERIE5.getMarca(),Marca.BMW);
		
	}
}
