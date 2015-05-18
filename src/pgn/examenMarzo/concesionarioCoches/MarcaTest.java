package pgn.examenMarzo.concesionarioCoches;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MarcaTest {

	@Test
	public void testMarca() {
		assertNotNull(Marca.BMW);
		assertNotNull(Marca.SEAT);
		
	}

}
