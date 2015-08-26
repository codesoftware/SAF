package co.com.codesoftware.logic;

import java.util.Date;
import java.util.List;

import co.com.codesoftware.server.FacturaTable;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;

public class ConsultaFacturaLogic {
	/**
	 * Funcion con la cual obtengo las facturas registradas en el sistema
	 * 
	 * @param fechaIni
	 * @param fechaFin
	 * @return
	 */
	public List<FacturaTable> consultaFacturasRangoFechas(Date fechaIni, Date fechaFin) {
		List<FacturaTable> rta = null;
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			rta = port.getFacturas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

	/**
	 * Funcion con la cual busco una factura por su id
	 * 
	 * @param id
	 * @return
	 */
	public FacturaTable consutlaFacturaXId(int id) {
		FacturaTable rta = null;
		try {
			SAFWSService service = new SAFWSService();
			SAFWS port = service.getSAFWSPort();
			rta = port.getFacturaForId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rta;
	}

}
