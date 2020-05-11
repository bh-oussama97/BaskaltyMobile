/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.forms;


import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;


/**
 *
 * @author benha
 */
public class HomeForm  extends Form{
 
     Form home;
   
    public HomeForm(Resources theme)
    {
     home = this;
     setTitle("Baskalty Home");
     setLayout(BoxLayout.y());
    
    
    Container ch = new Container(BoxLayout.y());
    
   Image logo = theme.getImage("logobaskalty.png");
   
   ImageViewer imagelogo = new ImageViewer(logo);
   
   Style imagestyle = imagelogo.getAllStyles();
   
   imagestyle.setMarginTop(100);
   
   ch.add(imagelogo);
    
     Label texthome = new Label("Welcome To Baskalty");
     int fontsize = Display.getInstance().convertToPixels(50);
     Font font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
     Style styletext = texthome.getUnselectedStyle();
     styletext.setMarginTop(100);
     styletext.setMarginBottom(50);
     styletext.setFont(font);
     styletext.setFgColor(0xE3051A);
    Container centered = BorderLayout.centerAbsolute(texthome);
     
    String s = "products";
     Button Products = new Button(s.toUpperCase());
     Products.setPreferredSize(new Dimension(500,130));
     Style pro = Products.getAllStyles();
     
     Products.addActionListener(e-> new ProductsForm(theme).show());
     
     
     
     Container containerproducts = BorderLayout.centerAbsolute(Products);
     
     String s1 = "add product";
     Button addproduct = new Button(s1.toUpperCase());
     addproduct.setPreferredSize(new Dimension(500,130));
     Container contaddpro = BorderLayout.centerAbsolute(addproduct);
     addproduct.addActionListener(e-> new AddProduct(theme).show());
     
     
     String s2 = "panier";
     Button Panier = new Button (s2.toUpperCase());
     Panier.setPreferredSize(new Dimension(500,130));
     Container contpanier = BorderLayout.centerAbsolute(Panier);
     
     Panier.addActionListener(e-> new PanierForm(theme).show());
     
     
     String s3 = "order";
     Button order = new Button (s3.toUpperCase());
     order.setPreferredSize(new Dimension(500,130));
     Container contorder = BorderLayout.centerAbsolute(order);
     
     int total = 500;
     order.addActionListener(e-> new OrderForm(theme,total).show());
     
     
     
  
        home.add(ch);
        home.add(centered);
        home.add(containerproducts);
        home.add(contaddpro);
        home.add(contpanier);
        home.add(contorder);
        home.show();
    }
  
}
