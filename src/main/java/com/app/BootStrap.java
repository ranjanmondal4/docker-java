package com.app;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;
import javax.websocket.DeploymentException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.app.service.SocketService;

@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BootStrap.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		LOGGER.info("Bootstrap is called");
		SocketService clientEndPoint = new SocketService();
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
	
//	@PostConstruct
//    private void postConstructEvent() {
//		LOGGER.info("post construt is called");
//	}
}

