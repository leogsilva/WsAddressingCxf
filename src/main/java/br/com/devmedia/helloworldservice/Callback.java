package br.com.devmedia.helloworldservice;

import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;

@WebService()
@org.apache.cxf.interceptor.InInterceptors(interceptors = { "org.apache.cxf.interceptor.LoggingInInterceptor" })
@org.apache.cxf.interceptor.OutInterceptors(interceptors = { "org.apache.cxf.interceptor.LoggingOutInterceptor" })
public interface Callback {
	String NS = "http://devmedia.sayhello";

	@Oneway
	@RequestWrapper(localName = "digaOlaResponse", targetNamespace = NS)
	public void callBack(@WebParam(name = "response") String callbackMessage);

}