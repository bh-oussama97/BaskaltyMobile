/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.entities.events;
import com.esprit.utils.DataSource;
import com.esprit.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author selmi
 */
public class EventsService {
     private ConnectionRequest request;

    private boolean responseResult;
    ArrayList<events> Events = new ArrayList<>();

    public EventsService() {
         request = DataSource.getInstance().getRequest();
    }
    
    
        public boolean addEvent(events p) {
        String url = Statics.BASE_URL2 + "/AddM?name=" + p.getTitre()+ "&location=" +p.getLocation()+
                "&image="+p.getImage()+"&description="+p.getContenu()+"&start="+p.getStart()+"&end="+p.getEnd()+"&prix="+p.getPrix()+"&themeid="+1
                +"&quantity="+ p.getQuantity();

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
     
       public ArrayList<events> parseProducts (String jsonText) {
        try {
        
            JSONParser jp = new JSONParser(); 
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                
               int id = (int)Float.parseFloat(obj.get("id").toString());
               
               String name = obj.get("name").toString();
             
               
               String location  = obj.get("location").toString();
           
               
               String description = obj.get("description").toString();
                             String start = obj.get("start").toString();
               String end = obj.get("end").toString();

               
                              String image = obj.get("image").toString();

               int prix = (int) Float.parseFloat(obj.get("prix").toString());
                              int quantity = (int) Float.parseFloat(obj.get("quantity").toString());

                Events.add(new events(id, name, description, location, start, image, end, prix, quantity));
            }

        } catch (IOException ex) {
        }

        return Events;
    }
       


       
       
       
        public ArrayList<events> getAllEvents() {
        String url = Statics.BASE_URL2 + "/Affichermobile";
        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Events = parseProducts(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return Events;
    }
    
 
         
       
         
       
}
