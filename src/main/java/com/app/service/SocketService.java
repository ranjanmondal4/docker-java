package com.app.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ClientEndpoint
public class SocketService {
	private Session userSession = null;
	private static final Logger LOGGER = LoggerFactory.getLogger(SocketService.class);
	
	public void getWebSocketEndPoint() throws DeploymentException, IOException, URISyntaxException{
	
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		userSession = container.connectToServer(SocketService.class, new URI("wss://ws.kraken.com/"));
		
		LOGGER.info("User session {} ", userSession.isOpen());
		
		try {
			TimeUnit.SECONDS.sleep(4);
        	subscribeSingleChannel("XBT/USD");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	
	@OnOpen
    public void onOpen(Session session) {
		LOGGER.info("onOpen is called");
    }

	@OnMessage
	public void onMessage(String message){
//		LOGGER.info("On Message called {}", message);
		try {
			if (message.startsWith("[")) {
				LOGGER.info(message);
			}
		} catch (Exception ex) {
			LOGGER.error("Error in onMessage: {}", ex.getMessage());
		}
	}
	
	private void sendMessage(String text) {
		userSession.getAsyncRemote().sendText(text);
	}

	
	private void subscribeSingleChannel(String instrument) throws JSONException {
		String payload = getPayLoad(instrument);
		sendMessage(payload);
	}
	
	private String getPayLoad(String symbol) throws JSONException {
		JSONObject objectPayload = new JSONObject();
		objectPayload.put("event", "subscribe");
		JSONArray marketPair = new JSONArray();
		marketPair.put(symbol);
		JSONObject typeOfSubscribtion = new JSONObject();
		typeOfSubscribtion.put("name", "ticker");
		objectPayload.put("pair", marketPair);
		objectPayload.put("subscription", typeOfSubscribtion);
		return objectPayload.toString();
	}

	
}
