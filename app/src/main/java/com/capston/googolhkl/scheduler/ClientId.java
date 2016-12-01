package com.capston.googolhkl.scheduler;

/**
 * Created by 원기 on 2016-12-01.
 */

import java.io.*;

public class ClientId {

    //멕주소
    private String MacId = new String();

    public String FindID (String msg)
    {
        for(int i=0;i<msg.length();i++)
        {
            if(msg.charAt(i)=='(')
            {
                while(msg.charAt(i)!=')')
                {
                    i++;
                    MacId+=msg.charAt(i);

                }

                return MacId;
            }
        }
        return null;
    }


}
