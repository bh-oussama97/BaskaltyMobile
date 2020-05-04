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
    
    public AddProduct(Form previous,Resources theme)
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
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
         
         add.addActionListener(e-> {
             ProductService ps = new ProductService();
           if (ps.addProduct(new Product(Integer.parseInt(quantity.getText()),name.getText(),reference.getText(),Description.getText(),Float.parseFloat(price.getText()),image.getText())))  
           {
               Dialog.show("Success","Product Added Successfully !", "OK", null);
               new ProductsForm(previous, theme).show();
           }
           else {
                Dialog.show("échec","Retry", "OK", null);
           }
         });
        
    }
    
}
