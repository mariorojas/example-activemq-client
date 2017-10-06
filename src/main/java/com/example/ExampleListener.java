package com.example;

import java.lang.reflect.Type;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Recurso en escucha para interacción con servidor de mensajes ActiveMQ
 * 
 * @author marojas
 *
 */
@Component
public class ExampleListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExampleListener.class);
	private static final String INBOUND_QUEUE = "inbound.queue"; // Subscripción a cola de mensajes
	private static final String OUTBOUND_QUEUE = "outbound.queue"; // Cola de mensajes destino
	
	/**
	 * Recibe un mensaje desde la cola de mensajes y devuelve uno
	 * nuevo con el valor de la propiedad "name"
	 * 
	 * @param jsonMessaje Mensaje del servidor ActiveMQ
	 * @return Mensaje hacia servidor ActiveMQ
	 * @throws JMSException
	 */
	@JmsListener(destination = INBOUND_QUEUE)
	@SendTo(OUTBOUND_QUEUE)
	public String receiveMessage(Message jsonMessaje) throws JMSException {
		LOG.info("Mensaje recibido: " + jsonMessaje);
		
		if (jsonMessaje instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) jsonMessaje;
			Type type = new TypeToken<Map<String, Object>>(){}.getType();
			Map<String, Object> map = new Gson().fromJson(textMessage.getText(), type);
			return "Hello " + map;
		}
		
		return null;
	}
}
