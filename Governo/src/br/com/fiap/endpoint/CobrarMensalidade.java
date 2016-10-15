
package br.com.fiap.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cobrarMensalidade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cobrarMensalidade">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="indentificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cobrarMensalidade", propOrder = {
    "indentificador"
})
public class CobrarMensalidade {

    protected String indentificador;

    /**
     * Gets the value of the indentificador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndentificador() {
        return indentificador;
    }

    /**
     * Sets the value of the indentificador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndentificador(String value) {
        this.indentificador = value;
    }

}
