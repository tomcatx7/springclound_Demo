package com.example.zxj.websocket.demo;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/mywebsocket")
@Component
public class MyWebSocket
{
    private static volatile AtomicInteger count = new AtomicInteger( 0 );

    //服务端会为每个客户请求生成一个MyWebSocket实例
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    //与客户端建立的连接后产生的session
    private Session session;

    @OnOpen
    public void openSession( Session session ) throws Exception
    {
        this.session = session;
        System.out.println( "protocol : " + session.getProtocolVersion() );
        sendMsg( "establish connection !!!" );
        webSocketSet.add( this );
        System.out.println( "连接数 :" + count.incrementAndGet() );
        System.out.println( "webSocketSet 数量 :" + webSocketSet.size() );
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose()
    {
        webSocketSet.remove( this );  //从set中删除
        System.out.println( "有一连接关闭！当前在线人数为" + count.decrementAndGet() );
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);

        //群发消息
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMsg( message );
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendMsg( String msg ) throws IOException
    {
        if( session == null )
            throw new IOException( "session is null !" );
        session.getBasicRemote().sendText( msg );
    }
}
