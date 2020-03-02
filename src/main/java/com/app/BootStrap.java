package com.app;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;
import javax.websocket.DeploymentException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.app.service.SocketService;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BootStrap.class);
	
	@Autowired
	private SocketService clientEndPoint;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//SocketService clientEndPoint = new SocketService();
		try {
			clientEndPoint.getWebSocketEndPoint();
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Bean("clientEndPoint")
	public SocketService getClientEndPoint(){
		SocketService clientEndPoint = new SocketService();
		return clientEndPoint;
	}
	
//	@PostConstruct
//    private void postConstructEvent() {
//		LOGGER.info("post construt is called");
//	}
}

