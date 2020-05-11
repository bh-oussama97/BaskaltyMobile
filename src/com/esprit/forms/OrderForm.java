/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.forms;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.entities.Orders;
import com.esprit.services.OrderService;
import com.esprit.services.PaymentService;
import com.stripe.exception.StripeException;


/**
 *
 * @author benha
 */
public class OrderForm extends Form {
    
    Form order;
    
    public OrderForm (Resources theme,int total)
    {
        order = this;
        setTitle ("order");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        
        TextField name = new TextField("","name");
        TextField email = new TextField("","email");
        TextField phonenumber = new TextField("","phonenumber");
        TextField adresse = new TextField("","adresse");
        TextField city = new TextField("","city");
        SpanLabel totalapayer = new SpanLabel ("Total Card :" + String.valueOf(total) +"DT");
        
        Button confirmpayment = new Button("Proceed to payment");
        
       confirmpayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
          // OrderService ord = new OrderService();
           if (Dialog.show("", "Add order ?", "Confirm", "Cancel"))
           {
                PaymentService ps = new PaymentService();
                try {
                 String id_customer = ps.createCustomer(city.getText(), adresse.getText(), name.getText(), email.getText(), phonenumber.getText());
          
                   Dialog.show("","Order created successfully !","OK",null);
                     new PaymentForm(String.valueOf(total),id_customer, theme).show();
                } catch (StripeException ex) {
                    Dialog.show("error",ex.getMessage(),"OK",null);
                }
             
               
           }
          // ord.AddOrder(new Orders(name.getText(), email.getText(), phonenumber.getText(), adresse.getText(), city.getText(),total));
           
               
          
            }
        });
        
        addAll(name,email,phonenumber,adresse,city,totalapayer,confirmpayment);
        getToolbar().addMaterialCommandToLeftSideMenu("",FontImage.MATERIAL_MENU,new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                }
            });
        
        getToolbar().addMaterialCommandToLeftSideMenu("Add product",FontImage.MATERIAL_ADD_CIRCLE, ev-> new AddProduct(theme).show());
        
        getToolbar().addMaterialCommandToLeftSideMenu("Products",FontImage.MATERIAL_STORE, ev-> new ProductsForm(theme).show());
      
        getToolbar().addMaterialCommandToLeftSideMenu("Panier",FontImage.MATERIAL_SHOPPING_CART, ev-> new PanierForm(theme).show());
        
    }
}
