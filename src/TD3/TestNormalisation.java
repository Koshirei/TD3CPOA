package TD3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNormalisation {
	
	Normalisation n = new Normalisation();

	@Test
	public void testPaysLuxembourg() {
		assertEquals("luxembourg",n.pays("letzebuerg"));
	}
	@Test
	public void testPaysLuxembourgTrad() {
		assertEquals("luxembourg",n.pays("luxembourg"));
	}
	@Test
	public void testPaysBelgique() {
		assertEquals("belgique",n.pays("belgique"));
	}
	@Test
	public void testPaysBelgiqueTrad() {
		assertEquals("belgique",n.pays("belgium"));
	}
	@Test
	public void testPaysSuisse() {
		assertEquals("suisse",n.pays("suisse"));
	}
	@Test
	public void testPaysSuisseTrad1() {
		assertEquals("suisse",n.pays("schweiz"));
	}
	@Test
	public void testPaysSuisseTrad2() {
		assertEquals("suisse",n.pays("switzerland"));
	}
	
	@Test
	public void testVilleMajuscule() {
		assertEquals("Uckange",n.ville("uckange"));
	}
	
	@Test
	public void testVillePreposition() {
		assertEquals("Montigny-lès-metz",n.ville("   Montigny lès Metz"));
	}
	
	@Test
	public void testVilleSaint() {
		assertEquals("Saint",n.ville("St"));
	}
	@Test
	public void testVilleSainte() {
		assertEquals("Sainte",n.ville("Ste"));
	}
	
	@Test
	public void testVilleComplète() {
		assertEquals("Sainte-julien-les-metz",n.ville("   ste julien les metz"));
	}
	
	@Test
	public void testCodePostalNormal() {
		assertEquals("54321",n.codepos(" 54321 "));
	}
	
	@Test
	public void testCodePostalZeroNonSignification() {
		assertEquals("00001",n.codepos(" 1 "));
	}
	
	@Test
	public void testCodePostalIndicatifn() {
		assertEquals("57270",n.codepos(" FRANCE - 57270 "));
	}
	
	@Test
	public void testCodePostalComplet() {
		assertEquals("00002",n.codepos(" FRANCE - 2 "));
	}
	
	@Test
	public void testVoieBoulevard1() {
		assertEquals("boulevard",n.voie("boul"));
	}
	@Test
	public void testVoieBoulevard2() {
		assertEquals("boulevard",n.voie("boul."));
	}
	@Test
	public void testVoieBoulevard3() {
		assertEquals("boulevard",n.voie("bd"));
	}
	
	@Test
	public void testVoieFaubourg1() {
		assertEquals("faubourg",n.voie("faub."));
	}
	@Test
	public void testVoieFaubourg2() {
		assertEquals("faubourg",n.voie("fg"));
	}
	@Test
	public void testVoieAvenue() {
		assertEquals("avenue",n.voie("av."));
	}
	
	@Test
	public void testVoiePlace() {
		assertEquals("place",n.voie("pl."));
	}
	
	@Test 
	public void testVoieComplet() {
		assertEquals("place du marché",n.voie(" pl. du marché "));
	}
	
	@Test 
	public void testVoieNumVirgule() {
		assertEquals("3,",n.voie(" 3 "));
	}
	
	@Test 
	public void testVoieCompletVraiment() {
		assertEquals("3, place du marché",n.voie(" 3 pl. du marché    "));
	}
}
