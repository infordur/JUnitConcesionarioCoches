package pgn.examenMarzo.concesionarioCoches;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcesionarioTest {
	static Concesionario almacen=new Concesionario();
	ArrayList<Coche> arrCochesP;
	ArrayList<Coche> arrCochesR;
	ArrayList<Coche> arrCochesA;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Añadimos unos coches al concesionario para hacer pruebas
		almacen.annadir("0000BBB", Color.AZUL, Modelo.CORDOBA);
		almacen.annadir("1111FGT", Color.ROJO, Modelo.SERIE1);
		almacen.annadir("2222PHY", Color.PLATA, Modelo.IBIZA);
	}

	@Test
	public void testConcesionarioAnnadir() {
		
		//IAñadir Coches incorrectos
		assertFalse(almacen.annadir("0000ABB", Color.ROJO, Modelo.TOLEDO)); //Contiene un carácter inválido (A)
		assertFalse(almacen.annadir("0000-OBB", Color.AZUL, Modelo.CORDOBA)); //Contiene un carácter inválido (O)
		assertFalse(almacen.annadir("0000_TBB", Color.PLATA, Modelo.SERIE2)); //Contiene un carácter inválido ( _ )
		assertFalse(almacen.annadir("0000 ÑBB", Color.PLATA, Modelo.SERIE2)); //Contiene un carácter inválido (Ñ)
		assertFalse(almacen.annadir("1113-PIQ", Color.ROJO, Modelo.TOLEDO)); //Contiene un carácter inválido(Q)
		assertFalse(almacen.annadir("111PBB", Color.ROJO, Modelo.TOLEDO)); //Falta 1 dígito
		assertFalse(almacen.annadir("11112PBB", Color.ROJO, Modelo.TOLEDO)); //Sobra 1 dígito
		assertFalse(almacen.annadir("1111PBBB", Color.ROJO, Modelo.TOLEDO)); //Sobra 1 carácter
		assertFalse(almacen.annadir("PTR3333", Color.AZUL, Modelo.IBIZA)); //Orden de dígitos y y caracteres invertido
				
		//Añadir un coche con campos null
		assertFalse(almacen.annadir("0000ABC", null, null));
		assertFalse(almacen.annadir("1111-PRT", Color.ROJO, null));
		assertFalse(almacen.annadir("2222 PTR", null, Modelo.SERIE1));
				
		//Añadir coche Correcto
		assertTrue(almacen.annadir("0000BBR", Color.AZUL, Modelo.CORDOBA));
		
		//Añadir coche repetido
		assertFalse(almacen.annadir("1111FGT", Color.AZUL, Modelo.TOLEDO));
	}

	@Test
	public void testConcesionarioEliminar() {		
		//Eliminar coche Existente
		assertTrue(almacen.eliminar("0000BBB"));
		//Comprobar tamaño concesionario despues de eliminar un coche
		assertEquals(2, almacen.size());
		
		//Eliminar coche no existente
		assertFalse(almacen.eliminar("0000BYB"));
		//Comprobar que el tamaño sigue siendo 2
		assertEquals(2, almacen.size());
	}

	@Test
	public void testGetCocheMatricula() {
		//Mostrar un coche del concesionario
		assertNotNull(almacen.get("2222PHY"));
		
		//Mostrar un coche que no existe
		assertNull(almacen.get("1234JKL"));
		
	}
	
	@Test
	public void testGetCocheColor() {
		//Comprobar que el almacen contiene coches de un color
		assertNotNull(almacen.getCochesColor(Color.PLATA));
		assertNotNull(almacen.getCochesColor(Color.ROJO));
		assertNotNull(almacen.getCochesColor(Color.AZUL));
		
		//Generar arrays con los coches de color PLATA/ROJO/AZUL
		arrCochesP=almacen.getCochesColor(Color.PLATA);
		arrCochesR=almacen.getCochesColor(Color.ROJO);
		arrCochesA=almacen.getCochesColor(Color.AZUL);		
						
		//Comprobar que los arrays de coches de colores tiene algún coche dentro
		assertEquals(1,arrCochesP.size());
		assertEquals(1,arrCochesR.size());
		assertEquals(1, arrCochesA.size());
		
		//Comprobar que los arrays no contienen coches de otros colores diferentes del que deben contener
		assertNotEquals(arrCochesP, arrCochesR);
		assertNotEquals(arrCochesP, arrCochesA);
		assertNotEquals(arrCochesR, arrCochesP);
		assertNotEquals(arrCochesR, arrCochesA);
		
		//Añadimos otro coche del mismo color
		almacen.annadir("3333HHH", Color.PLATA, Modelo.SERIE2);
		almacen.annadir("2222HYP", Color.AZUL, Modelo.IBIZA);
		almacen.annadir("3333-KKK", Color.ROJO, Modelo.CORDOBA);
		
		//Volver a generar los array de coches de colores
		arrCochesP=almacen.getCochesColor(Color.PLATA);
		arrCochesR=almacen.getCochesColor(Color.AZUL);
		arrCochesA=almacen.getCochesColor(Color.ROJO);
		
		//Comprobamos que el tamaño del array de coches aumenta
		assertEquals(2,arrCochesP.size());
		assertEquals(2,arrCochesR.size());
		assertEquals(2,arrCochesA.size());
	}

}
