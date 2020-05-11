/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.forms;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;

import com.codename1.ui.Container;
import com.codename1.ui.Dialog;

import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

import com.codename1.ui.util.Resources;
import com.esprit.entities.Panier;
import com.esprit.services.PanierService;

import java.util.ArrayList;

/**
 *
 * @author benha
 */
public class PanierForm extends Form {

    Form panier;
    int totalpanier = 0;
    //int id_panier;
    ImageViewer imv;
   SpanLabel Name,Prix,Quantity,TotalPrix;
    Button delete,Order;
    //float totalprixitem;
    PanierService ps = new PanierService();
    ArrayList<Panier> contenuPanier;

    public PanierForm(Resources theme) {
        panier = this;
        setTitle("Panier");
        setLayout(BoxLayout.y());
        Button btnShopping = new Button("Continue Shopping");
        Button btnOrderAll = new Button("Order All");
       
        contenuPanier = ps.getPanier();
       
        for (Panier p:contenuPanier)
        {
            add(AddToPanierItems(theme, p));
        }
     
            add(new Label("Total Panier :" + String.valueOf(totalpanier) + "DT"));
            add(btnShopping);
            add(btnOrderAll);

         

            btnShopping.addActionListener(e -> {
                new ProductsForm(theme).show();
            });

            btnOrderAll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {

                    if (Dialog.show("Order", "Proceed to order?", "YES", "Cancel")) {
                        PanierService paserv = new PanierService();
                       paserv.OrderAll(totalpanier);
                      new OrderForm(theme, totalpanier).show();
                    } 

                }
            });
            
         /*    delete.addActionListener(evt -> {
                PanierService es = new PanierService();

                //  es.DeleteFromPanier(id_panier);
                if (Dialog.show("Confirm", "Delete?", "YES", "NO")) {
                    es.DeleteFromPanier(id_panier);
                    new PanierForm(panier, theme).show();
                } 

            });*/
               
             /*  Order.addActionListener((evt) -> {
                   PanierService paserv = new PanierService();
                   if (Dialog.show("Order", "Proceed to order?", "YES", "Cancel")) {
                   paserv.Order(id_panier,totalprixitem);
                    new PanierForm(panier, theme).show();
                   } 
               });*/

         getToolbar().addMaterialCommandToLeftSideMenu("",FontImage.MATERIAL_MENU,new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                }
            });
        
        getToolbar().addMaterialCommandToLeftSideMenu("Add product",FontImage.MATERIAL_ADD_CIRCLE, ev-> new AddProduct(theme).show());
        
        getToolbar().addMaterialCommandToLeftSideMenu("Products",FontImage.MATERIAL_STORE, ev-> new ProductsForm( theme).show());
      
        getToolbar().addMaterialCommandToLeftSideMenu("Panier",FontImage.MATERIAL_SHOPPING_CART, ev-> new PanierForm(theme).show());
    }
    
    
      public Container AddToPanierItems(Resources theme,Panier p)
        {
            Container c1 = new Container(BoxLayout.x());
            c1.getStyle().setBorder(Border.createLineBorder(2));
            // Container c2 = new Container(BoxLayout.y());
            Container c3 = new Container(BoxLayout.y());
            
             EncodedImage enco = EncodedImage.createFromImage(theme.getImage("load.png"), false);
            String url = "http://localhost/Pi-dev-final/web/uploads/" + p.getImage();
            Image im = URLImage.createToStorage(enco, p.getImage(), url);
             imv = new ImageViewer(im);

            Name = new SpanLabel("Name :" + p.getName());
             Prix = new SpanLabel("Price :" + Integer.toString(p.getPrix()) + "DT");
           Quantity = new SpanLabel("Quantity :" + p.getQuantite());
            int totalprixitem = (int)  p.getPrix() * p.getQuantite();
           TotalPrix = new SpanLabel(" Total :" + Integer.toString(totalprixitem) + "DT");
            // SpanLabel produit = new SpanLabel("produit :" +contenuPanier.get(i).getProduitP());
            Label idpan = new Label(String.valueOf(p.getId_panier()));

            int id_panier = p.getId_panier();
            totalpanier += (int) p.getPrix() * p.getQuantite();
            //Prix.setAutoSizeMode(true);
            // id.setVisible(false);
            
            delete = new Button("Delete");
            delete.getSameHeight();
            
             delete.addActionListener(evt -> {
                PanierService es = new PanierService();

                //  es.DeleteFromPanier(id_panier);
                if (Dialog.show("Confirm", "Delete?", "YES", "NO")) {
                    es.DeleteFromPanier(id_panier);
                    new PanierForm(theme).show();
                } 

            });
            
          Order = new Button ("Order ");
          
          Order.addActionListener((evt) -> {
                   PanierService paserv = new PanierService();
                   if (Dialog.show("Order", "Proceed to order?", "Confirm", "Cancel")) {
                   paserv.Order(id_panier,totalprixitem);
                    new OrderForm( theme, totalprixitem).show();
                   } 
               });
              
               
               
             c1.add(imv);
            c3.add(Name);
            c3.add(Quantity);
            c3.add(TotalPrix);
            c3.add(delete);
            c3.add(Order);
            c1.add(c3);
            
            return c1;
        }

}
