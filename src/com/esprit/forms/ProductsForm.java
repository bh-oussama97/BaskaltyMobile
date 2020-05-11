/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.forms;

import static com.codename1.charts.util.ColorUtil.*;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.Style;
import com.esprit.entities.Product;
import com.esprit.services.ProductService;
import com.codename1.ui.util.Resources;
import com.codename1.ui.spinner.*;
import com.esprit.services.PanierService;

/**
 *
 * @author benha
 */
public class ProductsForm extends Form {

    Form current;
    
     int id_product;
    
    public static Form details;

    ProductService ps = new ProductService();

    ArrayList<Product> products = ps.getAllProducts();

      
    private static ProductsForm instance;
    
    public static ProductsForm getInstance()
    {
        return instance;
    }
                 
   public ProductsForm()
   {
       instance = this;
   }

    public ProductsForm( Resources theme) {
        current = this;
        setTitle("All Products");

        setLayout(BoxLayout.y());
        for (Product p : products) {
            add(AddItems(p, theme));
        }

        getToolbar().addMaterialCommandToLeftSideMenu("",FontImage.MATERIAL_MENU,new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                }
            });
        
        getToolbar().addMaterialCommandToLeftSideMenu("Add product",FontImage.MATERIAL_ADD_CIRCLE, ev-> new AddProduct(theme).show());
        
        getToolbar().addMaterialCommandToLeftSideMenu("Products",FontImage.MATERIAL_STORE, ev-> new ProductsForm(theme).show());
      
        getToolbar().addMaterialCommandToLeftSideMenu("Panier",FontImage.MATERIAL_SHOPPING_CART, ev-> new PanierForm(theme).show());
    }

    public Container AddItems(Product pro, Resources theme) {
        Container item = new Container(new BoxLayout(BoxLayout.X_AXIS_NO_GROW));

        EncodedImage enco = EncodedImage.createFromImage(theme.getImage("load.png"), false);
        String url = "http://localhost/Pi-dev-final/web/uploads/" + pro.getImage();
        Image im = URLImage.createToStorage(enco, pro.getImage(), url);
        ImageViewer imv = new ImageViewer(im);
        item.add(imv);

        Container data = new Container(BoxLayout.y());

        Label lname = new Label("Name :");
        Font fnt = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        lname.getUnselectedStyle().setFont(fnt);
        Label tfname = new Label(pro.getName());

        Container nom = new Container(BoxLayout.x());
        nom.add(lname);
        nom.add(tfname);

        data.add(nom);

        Label lreference = new Label("Reference:");
        Font fnt2 = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        lreference.getUnselectedStyle().setFont(fnt2);
        SpanLabel tfreference = new SpanLabel(pro.getReference());

        Container reference = new Container(BoxLayout.x());
        reference.add(lreference);
        reference.add(tfreference);

        data.add(reference);

        Label lquantity = new Label("Quantity Available :");
        Font fnt3 = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        lquantity.getUnselectedStyle().setFont(fnt3);
        SpanLabel tfquantity = new SpanLabel(Integer.toString(pro.getQuantity()));

        Container quantity = new Container(BoxLayout.x());
        quantity.add(lquantity);
        quantity.add(tfquantity);

        data.add(quantity);

        Label lprix = new Label("Price :");
        Font fnt4 = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        lprix.getUnselectedStyle().setFont(fnt4);
        Label tfprix = new Label(Integer.toString(pro.getPrice()) + "DT");

        Container prix = new Container(BoxLayout.x());
        prix.add(lprix);
        prix.add(tfprix);

        data.add(prix);
        
        
        Container sliQut = new Container(BoxLayout.y());
        Label l = new Label("Choose :");
        Slider sliderquatity = new Slider();
        Style styleslider = sliderquatity.getAllStyles();
       
        Button checkout = new Button("Add to cart");
        sliderquatity.setEditable(true);
        //sliderquatity.setMinValue(0);
        sliderquatity.setMinValue(0);
        sliderquatity.setMaxValue(pro.getQuantity());
        sliQut.add(l);
        sliQut.add(sliderquatity);
        sliQut.add(checkout);
        sliderquatity.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
                  
                   l.setText("Choose :"+sliderquatity.getProgress());
               }
           });
        data.add(sliQut);
        
        checkout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                PanierService ps = new PanierService();
                if (ps.AddToPanier(pro.getId(),sliderquatity.getProgress()))
                {
                    Dialog.show("Sucess", "Product Added !", "OK",null);
                    new PanierForm(theme).show();
                }
                else
                {
                    Dialog.show("échec","There is a problem,verify ! ","OK",null);
                }
                 
            }
            
        });
                
        //int id_produit = pro.getId();

      //   id_product = pro.getId();
        
       // id_product.setVisible(false);

        

       /* btnDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         
                ProductsDetails det = new ProductsDetails(current, theme);
                
            }
        });*/
        
    
                
            
                
                
                
              /*  Container Details = new Container(BoxLayout.x());

                EncodedImage encoded = EncodedImage.createFromImage(theme.getImage("load.png"), false);
                String url2 = "http://localhost/Pi-dev-final/web/uploads/" + pro.getImage();
                Image img = URLImage.createToStorage(encoded, pro.getImage(), url2);
                ImageViewer imagev = new ImageViewer(img);
                Details.add(imagev);

                SpanLabel nomd = new SpanLabel("Name :" + pro.getName());
                SpanLabel Reference = new SpanLabel("Reference :" + pro.getReference());
                SpanLabel price = new SpanLabel("Price :" + pro.getPrice() + "DT");
                SpanLabel qtedisponible = new SpanLabel("Quantity available : " + pro.getQuantity());
                SpanLabel description = new SpanLabel("Description :" + pro.getDescription());

                Details.add(nomd);
                Details.add(Reference);
                Details.add(price);
                Details.add(qtedisponible);
                Details.add(description);

                Container buttons = new Container(BoxLayout.y());
                Button Back = new Button("Back");
                Button Order = new Button("ORDER");

                buttons.add(Order);

                Details.add(buttons);

                details.show();
                details.refreshTheme();*/

   
        item.add(data);
        return item;
    }
    
    public  int get_id_produit()
    {
        return id_product;
    }
    
    
}
