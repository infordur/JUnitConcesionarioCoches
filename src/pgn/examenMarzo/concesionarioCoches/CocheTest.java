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
		assertNull(coche.instanciarCoche("0000ABC",Color.PLATA,Modelo.CORDOBA)); //Contiene un caracter inválido
		assertNull(coche.instanciarCoche("0000 ABC",Color.ROJO,Modelo.IBIZA)); //Contiene un caracter inválido (A)
		assertNull(coche.instanciarCoche("00JPR",Color.AZUL,Modelo.SERIE1)); //La matrícula no tiene 4 digitos
		assertNull(coche.instanciarCoche("1111_RTY",Color.AZUL,Modelo.SERIE5)); //Contiene un guión bajo( _ )
		assertNull(coche.instanciarCoche("4444-GGGG", Color.ROJO, Modelo.SERIE3)); //Contiene 4 caracteres
		assertNull(coche.instanciarCoche("RPF0000", Color.PLATA, Modelo.TOLEDO)); //El orden de dígitos y caracteres está al revés
		assertNull(coche.instanciarCoche("0000ÑEQ", Color.ROJO, Modelo.CORDOBA)); //Contiene un carácter inválido (Ñ)
		
		
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
		assertNull(coche.instanciarCoche("0000ABC")); //Carácter inválido (A)
		assertNull(coche.instanciarCoche("1111_RTY")); //Carácter inválido (_)
		assertNull(coche.instanciarCoche("3333 EPK")); //Carácter inválido (E)
		assertNull(coche.instanciarCoche("5555-ÑPF")); //Carácter inválido (Ñ)
		assertNull(coche.instanciarCoche("RTY-0000")); //El orden de caracteres y dígitos está al revés
		assertNull(coche.instanciarCoche("666QIO")); //Numero de dígitos insuficientes y carácter inválido (Q)
		
		//Coche valido
		assertNotNull(coche.instanciarCoche("0000BBB"));
		assertNotNull(coche.instanciarCoche("1111-RTY"));
		assertNotNull(coche.instanciarCoche("6666 HGJ"));
	}

}
