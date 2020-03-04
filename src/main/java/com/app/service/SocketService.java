package com.app.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(SocketService.class);

	private static Session session = null;
	
//	List<Session> sessions = new ArrayList<>();
	
	private static SocketService socketService = null;
	
	public void getWebSocketEndPoint() throws DeploymentException, IOException, URISyntaxException {

		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		
		LOGGER.info("Creation, Session is null ? {}", session == null);
		Session localSession = container.connectToServer(SocketService.class, new URI("wss://ws.kraken.com/"));
		session = localSession;
		
		LOGGER.info("Creation, Local Session {} ", localSession);
		LOGGER.info("Creation, session {} ", session);

		String marketNames[] = new String[] {"XBT/USD", "BCH/USD"};
		Arrays.asList(marketNames).stream().forEach(name -> {
//			try {
//				TimeUnit.SECONDS.sleep(4);
				subscribeSingleChannel(name);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		});
		
	}

	@OnOpen
	public void onOpen(Session session) {
		LOGGER.info("OnOpen is called, session id {}", session.getId());
	}

	@OnMessage
	public void onMessage(String message) {
		try {
			if (message.startsWith("[")) {
			//	LOGGER.info(message);
			}
		} catch (Exception ex) {
			LOGGER.error("Error in onMessage: {}", ex.getMessage());
		}
	}

	@OnClose
	public void onClose(Session lastSession, CloseReason reason) throws IOException {

		LOGGER.info("On close, last session {}", lastSession);
		LOGGER.info("On close, session {}", session);
		LOGGER.info("On close, last session {}", lastSession);
		
		if(!lastSession.isOpen()) {
			session = null;
		}
		
		startSocketConnection();
		
	}

	@OnError
	public void onError(Session session, Throwable t) {
		LOGGER.error("Session id {}, Error {}", session.getId(), t.getMessage());
		t.printStackTrace();
	}
	
	private void startSocketConnection() {
	LOGGER.info("startSocketConnection, Session is null {} ", session == null);
		while(session == null) {
			try {
				getWebSocketEndPoint();
			} catch (Exception e) {
				LOGGER.error("Error in startSocketConnection {}", e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	
	//@Async
	public void closeSession() {
		LOGGER.info("closeSession, last session {}", session);
		try {
			session.close(new CloseReason(CloseReason.CloseCodes.CLOSED_ABNORMALLY, "Socket closed"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("closeSession, session {}", session);
	}
	

	private void sendMessage(String text) {
		session.getAsyncRemote().sendText(text);
	}

	private void subscribeSingleChannel(String instrument) throws JSONException {
//		LOGGER.info("instrument {}", instrument);
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
	
	public static SocketService getInstance() throws InterruptedException {
		synchronized (SocketService.class) {
			if (socketService == null) {
				socketService = new SocketService();
			}
		}
		return socketService;
	}

}
