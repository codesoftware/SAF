
package co.com.codesoftware.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getProductForCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getProductForCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dska_cod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sede_sede" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "dskaCod",
    "sedeSede"
})
public class GetProductForCode {

    @XmlElement(name = "dska_cod")
    protected String dskaCod;
    @XmlElement(name = "sede_sede")
    protected Integer sedeSede;

    /**
     * Gets the value of the dskaCod property.
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
     * Sets the value of the dskaCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDskaCod(String value) {
        this.dskaCod = value;
    }

    /**
     * Gets the value of the sedeSede property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSedeSede() {
        return sedeSede;
    }

    /**
     * Sets the value of the sedeSede property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSedeSede(Integer value) {
        this.sedeSede = value;
    }

}
