package co.com.codesoftware.logic;

import java.util.ArrayList;
import java.util.List;

import co.com.codesoftware.entities.GenericProductEntity;
import co.com.codesoftware.server.PantallaPrincipalFacTable;
import co.com.codesoftware.server.RecetaTable;
import co.com.codesoftware.server.SAFWS;
import co.com.codesoftware.server.SAFWSService;
import co.com.codesoftware.utilities.ImagesUtilities;

public class RecetasLogic {

	/**
	 * Metodo que consulta las recetas de la pantalla principal
	 * @return
	 */
	public List<PantallaPrincipalFacTable> getEspecialReceta() {

		List<PantallaPrincipalFacTable> list = new ArrayList<PantallaPrincipalFacTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		list = port.getDishesPrincipalScreen();
		list = getImage(list);
		return list;
	}

	public List<RecetaTable> getReceta() {
		List<RecetaTable> list = new ArrayList<RecetaTable>();
		SAFWSService service = new SAFWSService();
		SAFWS port = service.getSAFWSPort();
		list = port.getRecetas(1);
		return list;

	}
	
	public GenericProductEntity setGenericProduct(GenericProductEntity result,RecetaTable product,int cantidad){
		result.setCode(product.getCodigo());
		result.setId(product.getId());
		result.setName(product.getNombre());	
		result.setAmount(cantidad);
		result.setPrice(String.valueOf(product.getPrecios().get(0).getPrecio()));
		return result;
	}
	
	public  List<PantallaPrincipalFacTable> getImage(List<PantallaPrincipalFacTable> list){
		ImagesUtilities ut = new ImagesUtilities();
		String img ="/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAAA8AAD/4QMtaHR0cDov"+
				"L25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENl"+
				"aGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4"+
				"OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjAtYzA2MSA2NC4xNDA5NDksIDIwMTAvMTIvMDctMTA6"+
				"NTc6MDEgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5"+
				"OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHht"+
				"bG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6"+
				"Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUu"+
				"Y29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBo"+
				"b3Rvc2hvcCBDUzUuMSBNYWNpbnRvc2giIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6OENBMTA1"+
				"MjEyOEI3MTFFNEJFQjU5RDc4OTNBMEQxNjkiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6OENB"+
				"MTA1MjIyOEI3MTFFNEJFQjU5RDc4OTNBMEQxNjkiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6"+
				"aW5zdGFuY2VJRD0ieG1wLmlpZDo1OUYxMkJCQzI4OTYxMUU0QkVCNTlENzg5M0EwRDE2OSIgc3RS"+
				"ZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo4Q0ExMDUyMDI4QjcxMUU0QkVCNTlENzg5M0EwRDE2OSIv"+
				"PiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVu"+
				"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"+
				"kaj4AaITsFUdABohOdEIaIT/2Q==";
		for(int i=0;i<list.size();i++){
			if(ut.encodeB64ToImage(img,list.get(i).getNombre()+".jpeg")){
				list.get(i).setRuta(list.get(i).getCodigo()+".jpeg");
			}
		}
		return list;
	}
	
}
