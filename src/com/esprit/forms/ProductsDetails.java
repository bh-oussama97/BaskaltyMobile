/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.forms;

import com.esprit.entities.Product;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.services.ProductService;
import java.util.ArrayList;

/**
 *
 * @author benha
 */
public class ProductsDetails extends Form {
    
    Form details;
    ProductService pser = new ProductService();
     ArrayList<Product> productdetails;
     
     //int id_prod = ProductsForm.get_id_produit();
     
     public int id_pro;
     
   
     
    public ProductsDetails(Form previous,Resources theme)
    {
        System.out.println("*****************************************");
        
        
        System.out.println("id produit : " +ProductsForm.getInstance().get_id_produit());
        System.out.println("*****************************************");
        details =this;
        setTitle("Product number"+ProductsForm.getInstance().get_id_produit());
        setLayout(BoxLayout.x());
    productdetails = pser.searchProduct2(ProductsForm.getInstance().get_id_produit());
    
    
        
         for (Product details : productdetails)
        {
               Container Details = new Container(BoxLayout.x());
        
        EncodedImage enco = EncodedImage.createFromImage(theme.getImage("load.png"), false);
        String url = "http://localhost/Pi-dev-final/web/uploads/" + details.getImage();
        Image im = URLImage.createToStorage(enco, details.getImage(), url);
        ImageViewer imv = new ImageViewer(im);
        Details.add(imv);
        
        SpanLabel nom = new SpanLabel("Name :" +details.getName());
        SpanLabel Reference = new SpanLabel("Reference :"+details.getReference());
        SpanLabel price = new SpanLabel ("Price :" +details.getPrice() +"DT");
        SpanLabel qtedisponible = new SpanLabel ("Quantity available : " + details.getQuantity());
        SpanLabel description = new SpanLabel("Description :" +details.getDescription());
        
        
        Details.addAll(nom,Reference,price,qtedisponible,description);
        
        Container buttons = new Container(BoxLayout.y());
        Button Back = new Button("Back");
        Button Order = new Button("ORDER");
        
        buttons.add(Order);
        
        Details.add(buttons);
          
        }
         
      getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
    }
    
    
    public Form getForm ()
            {
                return details;
            }
}
