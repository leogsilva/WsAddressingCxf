package br.com.devmedia.helloworldservice;


public class CallbackImpl implements Callback {

	public void callBack(String callbackMessage) {
		System.out.println("Recieved callback message " + callbackMessage);
	}
}