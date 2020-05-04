/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.forms;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import static com.codename1.ui.Dialog.TYPE_CONFIRMATION;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.entities.Panier;
import com.esprit.services.PanierService;
import java.util.ArrayList;

/**
 *
 * @author benha
 */
public class PanierForm extends Form{
    
    Form panier;
   
    
    PanierService ps = new PanierService();
    ArrayList<Panier> contenuPanier ;
   public PanierForm (Form previous, Resources theme)
   {
       panier =this;
       setTitle("Panier");
       setLayout(BoxLayout.y());
       Button btnShopping = new Button("Continue Shopping");
       Button btnCommande = new Button("Order");
       
       //panier.getStyle().setBgColor(0xCACACA);
       
       contenuPanier = ps.getPanier();
       
      
        Container c2 = new Container(BoxLayout.y());
       for (int i=0; i< contenuPanier.size();i++)
       {
           
            Container c1 = new Container(BoxLayout.x());
            c1.setHeight(20000);
            Container c3 = new Container(BoxLayout.y());

            c3.setHeight(5000);
            c1.getStyle().setBorder(Border.createLineBorder(2));
            c1.getStyle().setMargin(1, 1, 1, 1);
            c1.getStyle().setPadding(0, 0, 0, 0);
            c1.getStyle().setBgColor(0xffabab);
            
            
            EncodedImage enco = EncodedImage.createFromImage(theme.getImage("load.png"), false);
            String url = "http://localhost/Pi-dev-final/web/uploads/"+contenuPanier.get(i).getImage();
            Image im = URLImage.createToStorage(enco,contenuPanier.get(i).getImage(), url);
            ImageViewer imv = new ImageViewer(im);
       
           SpanLabel Name = new SpanLabel("Name :"+ contenuPanier.get(i).getName());
           SpanLabel Prix = new SpanLabel("Price :"+Float.toString(contenuPanier.get(i).getPrix())+"DT");
           SpanLabel Quantity = new SpanLabel("Quantity :" +contenuPanier.get(i).getQuantite());
           SpanLabel TotalPrix= new SpanLabel(" Total :"+ Float.toString(contenuPanier.get(i).getPrix()*contenuPanier.get(i).getQuantite())+"DT");
          // SpanLabel produit = new SpanLabel("produit :" +contenuPanier.get(i).getProduitP());
           Label id = new Label(String.valueOf(contenuPanier.get(i).getId_panier()));
           
           int id_panier = contenuPanier.get(i).getId_panier();
           //Prix.setAutoSizeMode(true);
           id.setVisible(false);
           
           Button delete = new Button("Delete");
           delete.getSameHeight();
           delete.addActionListener( evt -> {
               PanierService es = new PanierService();
               
             //  es.DeleteFromPanier(id_panier);
          if (Dialog.show("Confirm", "Do you want to proceed?", "OK", "Cancel")) 
           {
               es.DeleteFromPanier(id_panier);
               new PanierForm(previous, theme).show();
            }
           else 
           {
            Dialog.show("","Error","Ok",null);   
           }
          
           });
           
           
           c1.add(imv);
           
           c3.add(Name);
           c3.add(Quantity);
           c3.add(TotalPrix);
           c3.add(delete);
           c3.add(id);
        
           
          // c1.add(produit);
           c1.add(c3);
          c2.add(c1);
          
           
       }
      
            
           
       float totalpanier = 0.0f;
       for (int j=0;j<contenuPanier.size();j++)
       {
           totalpanier+= (float) contenuPanier.get(j).getPrix() * contenuPanier.get(j).getQuantite();
  
       }
       add(c2);
      add(new Label("Total Panier :"+ String.valueOf(totalpanier)+"DT"));
      add(btnShopping);
      add(btnCommande);
     
       btnShopping.addActionListener(e->{ new ProductsForm(previous, theme).show(); });
       
      getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
   }
    
}
