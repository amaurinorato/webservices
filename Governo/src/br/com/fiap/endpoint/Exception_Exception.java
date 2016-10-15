
package br.com.fiap.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.4.6
 * 2016-10-14T23:10:59.323-03:00
 * Generated source version: 2.4.6
 */

@WebFault(name = "Exception", targetNamespace = "http://endpoint.fiap.com.br/")
public class Exception_Exception extends java.lang.Exception {
    
    private br.com.fiap.endpoint.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, br.com.fiap.endpoint.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, br.com.fiap.endpoint.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public br.com.fiap.endpoint.Exception getFaultInfo() {
        return this.exception;
    }
}