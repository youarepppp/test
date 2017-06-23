package com.wstest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketEndPoint extends TextWebSocketHandler {
	
	private final static List<WebSocketSession> sessions = Collections.synchronizedList(new ArrayList<WebSocketSession>());
	
	 @Override  
	 protected void handleTextMessage(WebSocketSession session,  
	            TextMessage message) throws Exception {  
	        super.handleTextMessage(session, message);  
	        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
	        //session.sendMessage(returnMessage);  
	        for(WebSocketSession tsession:sessions){
	        	tsession.sendMessage(returnMessage);  
	        }
	        
	    }  
	 
	//连接建立后处理
	    @SuppressWarnings("unchecked")
	    @Override
	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	        sessions.add(session);
	        //处理离线消息
	    }
	    
	    //连接关闭后处理
	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
	        sessions.remove(session);
	    }

	 
}
