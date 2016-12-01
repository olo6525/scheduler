package com.capston.googolhkl.scheduler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.io.*;


public class ChatRoom {

    public List<String> clients;


    ChatRoom()
    {
        clients = new LinkedList<String>();
    }

    public void AddUser (String msg)
    {
        clients.add(msg);
    }

    public void DeletUser (String msg)
    {
        clients.remove(msg);
    }
}

