package br.com.fiap.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2016-10-14T23:10:59.378-03:00
 * Generated source version: 2.4.6
 * 
 */
@WebServiceClient(name = "EndpointFinanceiroService", 
                  wsdlLocation = "http://54.191.197.37:8080/FinanceiroWS/EndpointFinanceiro?wsdl",
                  targetNamespace = "http://endpoint.fiap.com.br/") 
public class EndpointFinanceiroService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.fiap.com.br/", "EndpointFinanceiroService");
    public final static QName EndpointFinanceiroPort = new QName("http://endpoint.fiap.com.br/", "EndpointFinanceiroPort");
    static {
        URL url = null;
        try {
            url = new URL("http://54.191.197.37:8080/FinanceiroWS/EndpointFinanceiro?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EndpointFinanceiroService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://54.191.197.37:8080/FinanceiroWS/EndpointFinanceiro?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EndpointFinanceiroService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EndpointFinanceiroService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EndpointFinanceiroService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public EndpointFinanceiroService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public EndpointFinanceiroService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public EndpointFinanceiroService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns EndpointFinanceiro
     */
    @WebEndpoint(name = "EndpointFinanceiroPort")
    public EndpointFinanceiro getEndpointFinanceiroPort() {
        return super.getPort(EndpointFinanceiroPort, EndpointFinanceiro.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EndpointFinanceiro
     */
    @WebEndpoint(name = "EndpointFinanceiroPort")
    public EndpointFinanceiro getEndpointFinanceiroPort(WebServiceFeature... features) {
        return super.getPort(EndpointFinanceiroPort, EndpointFinanceiro.class, features);
    }

}