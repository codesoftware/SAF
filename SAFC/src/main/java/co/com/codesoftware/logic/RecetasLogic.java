package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.server.RecetaTable;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;

public class RecetasLogic {

	public List<RecetaTable> getEspecialReceta() {
		List<RecetaTable> list = new ArrayList<RecetaTable>();
		for (int i = 1; i <= 10; i++) {
			RecetaTable obj = new RecetaTable();
			obj.setNombre("nombre" + i);
			list.add(obj);
		}

		return list;
	}

	public List<RecetaTable> getReceta() {
		List<RecetaTable> list = new ArrayList<RecetaTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		list = port.getRecetas(1);
		return list;

	}
}
