/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.forms;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.entities.Product;
import com.esprit.services.ProductService;


/**
 *
 * @author benha
 */
public class AddProduct extends Form{
    
    Form current;
    
    public AddProduct(Resources theme)
    {
        current = this;
        setTitle("Add Product");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        TextField name = new TextField("","Name");
        TextField reference = new TextField("","Référence  Ex : RPL01987");
        TextField price = new TextField("","Price");
        TextField quantity = new TextField("","Quantity");
        TextField Description = new TextField("", "Description", 20, TextArea.ANY);
        TextField image = new TextField("","Nom d'image");
        Button add = new Button("Add");
        addAll(name,reference,price,quantity,Description,image,add);
         getToolbar().addMaterialCommandToLeftSideMenu("",FontImage.MATERIAL_MENU,new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    
                }
            });
        
        getToolbar().addMaterialCommandToLeftSideMenu("Add product",FontImage.MATERIAL_ADD_CIRCLE, ev-> new AddProduct( theme).show());
        
        getToolbar().addMaterialCommandToLeftSideMenu("Products",FontImage.MATERIAL_STORE, ev-> new ProductsForm(theme).show());
      
        getToolbar().addMaterialCommandToLeftSideMenu("Panier",FontImage.MATERIAL_SHOPPING_CART, ev-> new PanierForm(theme).show());
         
         add.addActionListener(e-> {
             ProductService ps = new ProductService();
           if (ps.addProduct(new Product(Integer.parseInt(quantity.getText()),name.getText(),reference.getText(),Description.getText(),Integer.parseInt(price.getText()),image.getText())))  
           {
               Dialog.show("Success","Product Added Successfully !", "OK", null);
               new ProductsForm( theme).show();
           }
           else {
                Dialog.show("échec","Retry", "OK", null);
           }
         });
        
    }
    
}
