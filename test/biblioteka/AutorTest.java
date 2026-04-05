package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutorTest {
	
	Autor a;

	@BeforeEach
	void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}
	
	@Test
	void testAutor() {
		assertNotNull(a);
	}
	
	@Test
	void testAutorStringString() {
		a = new Autor("Pera", "Peric");
		
		assertNotNull(a);
		assertEquals("Pera", a.getIme());
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetIme() {
		a.setIme("Pera");
		
		assertEquals("Pera", a.getIme());
	}
	
	@Test
	void testSetImeNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setIme(null));
	}
	
	@Test
	void testSetImePrazno() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setIme(""));
	}
	
	@Test
	void testSetPrezime() {
		a.setPrezime("Peric");
		
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setPrezime(null));
	}
	
	@Test
	void testSetPrezimePrazno() {
		Exception e = assertThrows(java.lang.IllegalArgumentException.class, ()->a.setPrezime(""));
		assertEquals("PREZIME NE SME BITI PRAZNO", e.getMessage());
	}
	
	@Test
	void testToString() {
		a.setIme("Pera");
		a.setPrezime("Peric");
		
		String s = a.toString();
		
		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));
	}

	@Test
	void testHashCode() {
		a.setIme("Pera");
		a.setPrezime("Peric");
		
		Autor a2 = new Autor("Pera", "Peric");
		Autor a3 = new Autor("Mika", "Mikic");
		
		assertEquals(a.hashCode(), a2.hashCode());
		assertNotEquals(a.hashCode(), a3.hashCode());
	}

	
	@ParameterizedTest
	@DisplayName("Testoti za equals metodu")
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Peric, Mika, Peric, false",
		"Pera, Peric, Pera, Mikic, false",
		"Pera, Peric, Mika, Mikic, false"
	})
	void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean isto) {
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor a2 = new Autor(ime2, prezime2);
		
		assertEquals(isto, a.equals(a2));
	}
	
	@Test
	void testEqualsIstiObjekat() {
		assertTrue(a.equals(a));
	}
	
	@Test
	void testEqualsNull() {
		assertFalse(a.equals(null));
	}
	
	@Test
	void testEqualsDrugaKlasa() {
		assertFalse(a.equals(new String()));
	}


}
