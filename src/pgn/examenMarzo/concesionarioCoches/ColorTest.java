package pgn.examenMarzo.concesionarioCoches;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ColorTest {

	@Test
	public void test() {
		assertNotNull(Color.AZUL);
		assertNotNull(Color.PLATA);
		assertNotNull(Color.ROJO);
	}

}
