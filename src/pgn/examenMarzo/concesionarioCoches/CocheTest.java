package pgn.examenMarzo.concesionarioCoches;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CocheTest {
Coche coche;
	
	@Test
	public void testInstanciarCoche() {
		//Coches Invalidos
		assertNull(coche.instanciarCoche("0000ABC",Color.PLATA,Modelo.CORDOBA)); //Contiene un caracter inv�lido
		assertNull(coche.instanciarCoche("0000 ABC",Color.ROJO,Modelo.IBIZA)); //Contiene un caracter inv�lido (A)
		assertNull(coche.instanciarCoche("00JPR",Color.AZUL,Modelo.SERIE1)); //La matr�cula no tiene 4 digitos
		assertNull(coche.instanciarCoche("1111_RTY",Color.AZUL,Modelo.SERIE5)); //Contiene un gui�n bajo( _ )
		assertNull(coche.instanciarCoche("4444-GGGG", Color.ROJO, Modelo.SERIE3)); //Contiene 4 caracteres
		assertNull(coche.instanciarCoche("RPF0000", Color.PLATA, Modelo.TOLEDO)); //El orden de d�gitos y caracteres est� al rev�s
		assertNull(coche.instanciarCoche("0000�EQ", Color.ROJO, Modelo.CORDOBA)); //Contiene un car�cter inv�lido (�)
		
		
		//Coches Validos
		assertNotNull(coche.instanciarCoche("0000BBB",Color.ROJO,Modelo.TOLEDO));
		assertNotNull(coche.instanciarCoche("1111 FGH", Color.AZUL, Modelo.CORDOBA));
		assertNotNull(coche.instanciarCoche("2222-TYP", Color.ROJO, Modelo.SERIE2));
				
		//Coche con campos a null
		assertNull(coche.instanciarCoche("0000ABC", null, null));
	}

	@Test
	public void testInstanciarCocheMatricula() {
		//Coches Invalidos
		assertNull(coche.instanciarCoche("0000ABC")); //Car�cter inv�lido (A)
		assertNull(coche.instanciarCoche("1111_RTY")); //Car�cter inv�lido (_)
		assertNull(coche.instanciarCoche("3333 EPK")); //Car�cter inv�lido (E)
		assertNull(coche.instanciarCoche("5555-�PF")); //Car�cter inv�lido (�)
		assertNull(coche.instanciarCoche("RTY-0000")); //El orden de caracteres y d�gitos est� al rev�s
		assertNull(coche.instanciarCoche("666QIO")); //Numero de d�gitos insuficientes y car�cter inv�lido (Q)
		
		//Coche valido
		assertNotNull(coche.instanciarCoche("0000BBB"));
		assertNotNull(coche.instanciarCoche("1111-RTY"));
		assertNotNull(coche.instanciarCoche("6666 HGJ"));
	}

}
