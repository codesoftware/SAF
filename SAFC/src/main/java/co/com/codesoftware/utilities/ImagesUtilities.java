package co.com.codesoftware.utilities;

import java.io.File;
import java.io.FileOutputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.util.Base64;

public class ImagesUtilities {

	/**
	 * Funcion que convierte un String en base 64 a Imagen
	 * @param image
	 * @return
	 */
	public boolean encodeB64ToImage(String image,String name){
		try {
			ExternalContext tmpEC;      
			tmpEC = FacesContext.getCurrentInstance().getExternalContext();   
			String realPath=tmpEC.getRealPath("/resources/images/products/");
			System.out.println(realPath);
			Base64 decoder = new Base64();
			byte[] imgBytes = decoder.decode(image);
			FileOutputStream osf = new FileOutputStream(new File(realPath,name));
			osf.write(imgBytes);
			osf.flush();
			osf.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
