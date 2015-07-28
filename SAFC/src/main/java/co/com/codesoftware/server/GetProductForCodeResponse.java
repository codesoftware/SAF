
package co.com.codesoftware.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProductForCodeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the productoTable property.
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
     * Sets the value of the productoTable property.
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
