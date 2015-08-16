
package co.com.codesoftware.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para facturarResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="facturarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="respuestaFacturacon" type="{http://server.codesoftware.com.co/}respuestaFacturacion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "facturarResponse", propOrder = {
    "respuestaFacturacon"
})
public class FacturarResponse {

    protected RespuestaFacturacion respuestaFacturacon;

    /**
     * Obtiene el valor de la propiedad respuestaFacturacon.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaFacturacion }
     *     
     */
    public RespuestaFacturacion getRespuestaFacturacon() {
        return respuestaFacturacon;
    }

    /**
     * Define el valor de la propiedad respuestaFacturacon.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaFacturacion }
     *     
     */
    public void setRespuestaFacturacon(RespuestaFacturacion value) {
        this.respuestaFacturacon = value;
    }

}
