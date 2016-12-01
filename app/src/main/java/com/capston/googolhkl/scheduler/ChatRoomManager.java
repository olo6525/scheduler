package com.capston.googolhkl.scheduler;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.*;

public class ChatRoomManager {

    public HashMap<String,ChatRoom> map = new HashMap<String,ChatRoom>();


    private String FindKey (String msg)
    {
        String Key=new String();//메세지에서 키값을 저장
        int i;//문자열의 글씨 체크를 위한 변수

        i = 0;
        while(msg.charAt(i)!='-')
        {
            Key+=msg.charAt(i);
            i++;
        }

        return Key;
    }
    //멕주소, 닉네임 .걸러내는 함수

    public void AddChatRoom (String msg)
    {
        ClientId checkId = new ClientId();
        String inKey = FindKey(msg);
        String MacID = checkId.FindID(msg);
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext())
        {
            String key=(String)iterator.next();

            if(inKey==key)
            {
                int i=0;
                while(map.get(inKey).clients.get(i)==null)
                {
                    if(map.get(inKey).clients.get(i)==MacID)
                        return;
                    else
                    {
                        i++;
                        if(i==map.get(inKey).clients.size())
                        {
                            map.get(inKey).AddUser(MacID);
                            map.put(inKey,map.get(inKey));
                            return;
                        }
                    }
                }
            }
        }

        ChatRoom chatroom = new ChatRoom();
        chatroom.AddUser(MacID);
        map.put(inKey, chatroom);

    }




}