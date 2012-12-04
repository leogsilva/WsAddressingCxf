package br.com.devmedia.helloworldservice;

public class SimpleHelloService implements HelloService {

	public String digaOla(String user) {
		return "Hello " + user;
	}
	public String digaUla(String user) {
		return "Hello " + user;
	}
}