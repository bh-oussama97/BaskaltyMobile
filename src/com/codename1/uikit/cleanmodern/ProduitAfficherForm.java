/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.cleanmodern;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.entities.Product;
import com.esprit.services.PanierService;
import com.esprit.services.ProductService;
import java.util.ArrayList;

/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ProduitAfficherForm extends BaseForm {
 Form current;
    
     int id_product;
    
    public static Form details;

    ProductService ps = new ProductService();

    ArrayList<Product> products = ps.getAllProducts();
    private static ProduitAfficherForm instance;
public static ProduitAfficherForm getInstance()
    {
        return instance;
    }
                 
    public ProduitAfficherForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Produit");
        getContentPane().setScrollVisible(false);
        
         super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        Image img = res.getImage("profile-background.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3
                            
                            
                            
                    )
                )
        ));

       setLayout(BoxLayout.y());
        for (Product p : products) {
            add(AddItems(p,res));
        }
    }
    public Container AddItems(Product pro, Resources res) {
        Container item = new Container(new BoxLayout(BoxLayout.X_AXIS_NO_GROW));

        EncodedImage enco = EncodedImage.createFromImage(res.getImage("load.png"), false);
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
        Label tfprix = new Label(Float.toString(pro.getPrice()) + "DT");

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
                    new PanierProductForm(res).show();
                }
                else
                {
                    Dialog.show("Ã©chec","There is a problem,verify ! ","OK",null);
                }
                 
            }
            
        });
                

   
        item.add(data);
        return item;
    }
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));

    }
}
