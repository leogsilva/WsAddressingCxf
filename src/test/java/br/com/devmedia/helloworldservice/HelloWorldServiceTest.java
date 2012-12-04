package br.com.devmedia.helloworldservice;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.ws.addressing.AddressingBuilder;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.ObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.apache.cxf.ws.addressing.JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldServiceTest {

    private static final ObjectFactory WSA_OBJECT_FACTORY =
            new ObjectFactory();

	private static HelloService getHelloService() {
		QName serviceName = new QName(HelloService.NS, "HelloServiceService");
		QName portName = new QName(HelloService.NS, "HelloServicePort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,
				"http://localhost:9292/hello");

		HelloService hello = service.getPort(portName, HelloService.class);
		return hello;
	}	

	@Test
	public void testAddressing() throws Exception {
		HelloService hello = getHelloService();

        AddressingBuilder builder = AddressingBuilder.getAddressingBuilder();
        AddressingProperties maps = builder.newAddressingProperties();
        EndpointReferenceType replyType = WSA_OBJECT_FACTORY.createEndpointReferenceType();
        AttributedURIType uriType = WSA_OBJECT_FACTORY.createAttributedURIType();
        uriType.setValue("http://localhost:9293/reply");
        replyType.setAddress(uriType);
        maps.setReplyTo(replyType);
        
        Map<String, Object> requestContext =
                ((BindingProvider)hello).getRequestContext();
            requestContext.put(CLIENT_ADDRESSING_PROPERTIES, maps);

		String result2 = hello.digaOla("Tester2");
        Assert.assertNull(result2);
	}
	


}
