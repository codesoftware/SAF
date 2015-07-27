
package co.com.codesoftware.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getProductForCode complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getProductForCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dska_cod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductForCode", propOrder = {
    "dskaCod"
})
public class GetProductForCode {

    @XmlElement(name = "dska_cod")
    protected String dskaCod;

    /**
     * Obtiene el valor de la propiedad dskaCod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDskaCod() {
        return dskaCod;
    }

    /**
     * Define el valor de la propiedad dskaCod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDskaCod(String value) {
        this.dskaCod = value;
    }

}
