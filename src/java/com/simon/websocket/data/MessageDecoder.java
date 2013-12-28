/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.simon.websocket.data;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Simon
 */
public class MessageDecoder implements Decoder.Text<Message>{

    @Override
    public Message decode(String string) throws DecodeException {
        JsonObject json = Json.createReader(new StringReader(string)).readObject();
        return new Message(json);
    }

    @Override
    public boolean willDecode(String string) {
        try{
            Json.createReader(new StringReader(string)).read();
            return true;
        }catch (JsonException ex){
            System.out.println(string);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
    
}
