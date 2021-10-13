package fr.nicolas;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;


public class TestNormalisation {
    private Normalisation normalisation;

    @BeforeEach
    public void setUp() {
        Normalisation normalisation = new Normalisation();
    }

    @Test
    public void testPaysLetzebuergOk() {
        Normalisation normalisation = new Normalisation();

        assertEquals("Luxembourg", normalisation.pays("letzebuerg"));
    }

    @Test
    public void testPaysBelgiumOk() {
        Normalisation normalisation = new Normalisation();

        assertEquals("Belgique", normalisation.pays("belgium"));
    }

    @Test
    public void testPaysSwitzerlandOk() {
        Normalisation normalisation = new Normalisation();

        assertEquals("Suisse", normalisation.pays("Switzerland"));
    }

    @Test
    public void testPaysSchweizOk() {
        Normalisation normalisation = new Normalisation();

        assertEquals("Suisse", normalisation.pays("Schweiz"));
    }

    @Test
    public void testPaysEspaceOK() {
        Normalisation normalisation = new Normalisation();

        assertEquals("Luxembourg", normalisation.pays(" letzebuerg "));
    }

    @Test
    public void testPaysPasOK() {
        Normalisation normalisation = new Normalisation();

        assertNull(normalisation.pays("russie"));
    }

    @Test
    public void testVilleLeOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.ville("Ville le Ville");

        } catch (IllegalArgumentException e) {
            fail("nop");

        }
    }

    @Test
    public void testVilleLesOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.ville("Ville lès Ville");
        } catch (IllegalArgumentException e) {
            fail("nop");
        }
    }

    @Test
    public void testVilleSousOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.ville("Ville sous Ville");
        } catch (IllegalArgumentException e) {
            fail("nop");
        }
    }

    @Test
    public void testVilleSurOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.ville("Ville sur Ville");
        } catch (IllegalArgumentException e) {
            fail("nop");
        }
    }

    @Test
    public void testVilleAOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.ville("Ville à Ville");
        } catch (IllegalArgumentException e) {
            fail("nop");
        }
    }

    @Test
    public void testVilleAuxOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.ville("Ville aux Ville");
        } catch (IllegalArgumentException e) {
            fail("");
        }
    }

    @Test
    public void testVillePasOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.ville("ville aux Ville");
        } catch (IllegalArgumentException e) {
            fail("nop");
        }
    }

    @Test
    public void testCodePostalOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.codePostal("8200");
        } catch (IllegalArgumentException e) {
            fail("nop");
        }
    }

    @Test
    public void testCodePostalIndicatifOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.codePostal("L-1234");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "contient un caractère");

        }
    }

    @Test
    public void testSetCodePostalPasOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.setCodePostal("8200");

        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "doit être égal a 5 caractères");

        }
    }

    @Test
    public void testvoieBoulOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.voie("boul");

        } catch (IllegalArgumentException e) {
            fail("");
        }
    }

    @Test
    public void testVoieBoullOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.voie("boul.");

        } catch (IllegalArgumentException e) {
            fail("");
        }
    }

    @Test
    public void testVoieBdOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.voie("bd");

        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testVoieAvvOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.voie("av.");

        } catch (IllegalArgumentException e) {
            fail("");
        }
    }

    @Test
    public void testvoieFaubbOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.voie("faub.");

        } catch (IllegalArgumentException e) {
            fail("");
        }
    }

    @Test
    public void testvoieFgOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.voie("fg");

        } catch (IllegalArgumentException e) {
            fail("");

        }
    }

    @Test
    public void testvoiePlOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.voie("pl");

        } catch (IllegalArgumentException e) {
            fail("");

        }
    }

    @Test
    public void testVoiePasOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.setVoie("pl");

        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Erreur");

        }
    }

    @Test
    public void testNumVoieOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.numVoie("2 rue de la ciboulette");

        } catch (IllegalArgumentException e) {
            fail("");

        }
    }

    @Test
    public void testNumVoiePasOk() {
        Normalisation normalisation = new Normalisation();

        try {
            normalisation.setNumVoie("2 rue de la ciboulette");

        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "erreur");

        }
    }
}
