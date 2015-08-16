
package co.com.codesoftware.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getProductForCodeResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getProductForCodeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductoTable" type="{http://server.codesoftware.com.co/}productoTable" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductForCodeResponse", propOrder = {
    "productoTable"
})
public class GetProductForCodeResponse {

    @XmlElement(name = "ProductoTable")
    protected ProductoTable productoTable;

    /**
     * Obtiene el valor de la propiedad productoTable.
     * 
     * @return
     *     possible object is
     *     {@link ProductoTable }
     *     
     */
    public ProductoTable getProductoTable() {
        return productoTable;
    }

    /**
     * Define el valor de la propiedad productoTable.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductoTable }
     *     
     */
    public void setProductoTable(ProductoTable value) {
        this.productoTable = value;
    }

}
