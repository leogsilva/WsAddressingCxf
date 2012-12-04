package br.com.devmedia.helloworldservice;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@WebService(targetNamespace = HelloService.NS)
@Addressing(enabled = true, required = true)
@org.apache.cxf.interceptor.InInterceptors(interceptors = { "org.apache.cxf.interceptor.LoggingInInterceptor" })
@org.apache.cxf.interceptor.OutInterceptors(interceptors = { "org.apache.cxf.interceptor.LoggingOutInterceptor" })
public interface HelloService {
	String NS = "http://devmedia.sayhello";

	@WebResult(name = "response")
	public abstract String digaOla(String user) ;
}