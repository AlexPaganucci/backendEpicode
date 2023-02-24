package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Observable;

import org.junit.Before;
import org.junit.Test;

import it.epicode.gestione_incendi.application.models.CanaleDiComunicazione;
import it.epicode.gestione_incendi.application.models.CentroControllo;
import it.epicode.gestione_incendi.application.models.MioCanaleDiComunicazione;
import it.epicode.gestione_incendi.application.models.Sonda;

public class CentroControlloTest {

	private Sonda sonda;
    private CentroControllo centroControllo;
    CanaleDiComunicazione canale = (CanaleDiComunicazione) new MioCanaleDiComunicazione();

    @Before
    public void setUp() {
        sonda = new Sonda(1, 45.4642, 9.1900, 3.5, canale);
        centroControllo = CentroControllo.getInstance(canale);
    }

    @Test
    public void testAddSonda() {
        centroControllo.addSonda(sonda);
        assertTrue(centroControllo.getSonde().containsKey(1));
    }

    @Test
    public void testRemoveSonda() {
        centroControllo.addSonda(sonda);
        centroControllo.removeSonda(sonda);
        assertFalse(centroControllo.getSonde().containsKey(1));
    }

    @Test
    public void testSendAlarm() {
        centroControllo.addSonda(sonda);
        centroControllo.update(sonda, sonda);
        assertEquals("http://host/alarm?idsonda=1&lat=45.4642&lon=9.19&smokelevel=3.5", "http://host/alarm?idsonda=" + sonda.getIdSonda() + "&lat=" + sonda.getLatitude() + "&lon=" + sonda.getLongitude() + "&smokelevel=" + sonda.getSmokeLevel());
    }
}
