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
import com.codename1.messaging.Message;
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
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.esprit.entities.Product;
import com.esprit.entities.events;
import com.esprit.entities.mecanicien;
import com.esprit.services.EventsService;
import com.esprit.services.MechanicienService;
import com.esprit.services.PanierService;
import com.esprit.services.ProductService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class MechAfficherDetailsForm extends BaseForm {
 Form current;
Form f;
    SpanLabel lb;
    SpanLabel lb1;
    SpanLabel lb2;
    Button btnd;
    Button ret;
    Button bn;
     int id_product;
    
    public static Form details;

    MechanicienService ps = new MechanicienService();

    ArrayList<mecanicien> products = ps.getAllMec();

    private static MechAfficherDetailsForm instance;
public static MechAfficherDetailsForm getInstance()
    {
        return instance;
    }
                 
    public MechAfficherDetailsForm(int id ,Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Mechancien");
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
               MechanicienService service = new MechanicienService();
        System.out.println("id mtaai  "+ id);
       List<mecanicien> list = new ArrayList<>();
        list = service.getAllMecdetials(id);
        for (mecanicien p : list) {
            add(AddItems(p,res));
                    System.out.println("id mtaai nabddd  "+ add(AddItems(p,res)));

        }
    }
     public Container AddItems(mecanicien c, Resources res) {
           EncodedImage enco = EncodedImage.createFromImage(res.getImage("load.png"), false);
        String url = "http://localhost/Pi-dev-final/web/uploads/" + c.getImage();
        Image im = URLImage.createToStorage(enco, c.getImage(), url);
        ImageViewer image = new ImageViewer(im);

                    System.out.println("id mtaai immamamamama  "+ c.getImage());

        Label ltitre = new Label("titre : " + c.getNom());
        Label ldesc = new Label("Adresse Mail : " + c.getPrenom());
        Label ladr = new Label("Adresse : " + c.getDescription());
        Button confirm = new Button("confirm edit");
        Button annuler = new Button("Annuler");

        btnd = new Button("Modifier Offre");
        ret = new Button("retour");
        bn = new Button("suprimer");
        Button Contact = new Button("Contacter");

        Label titre = new Label("titre :");
        TextField a = new TextField("");

        Label AdresseM = new Label("Adresse Mail:");
        TextField b = new TextField("Adresse Mail : ");

        Label Adresse = new Label("Adresse:");
        TextField cc = new TextField("Adresse : ");

        Label imag = new Label("image:");
        TextField d = new TextField("image");

        a.setText(c.getNom());
        b.setText(c.getPrenom());
        cc.setText(c.getDescription());
        d.setText(c.getImage());

        // a.setText(c.getTitre_annonce());
        Dialog dlg = new Dialog("edit");

        dlg.add(titre);
        dlg.add(a);
        dlg.add(AdresseM);
        dlg.add(b);
        dlg.add(Adresse);
        dlg.add(cc);
        dlg.add(imag);
        dlg.add(d);

        dlg.add(confirm);
        dlg.add(annuler);

        annuler.addActionListener((l) -> {
            {
                
            }
        });
        confirm.addActionListener((evt) -> {
           

        });
        btnd.addActionListener((l) -> {
            dlg.show();

        });
        ret.addActionListener((l) -> {
         

        });

        bn.addActionListener((evt) -> {
           

        });
         

        //  Label ltype = new Label("question :" + c.getQuestion());
        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container cnt1 = new Container(BoxLayout.x());
        //image img= theme.getImage("imagename");
        cnt.add(image);
        cnt.add(ltitre);
        cnt.add(ldesc);
        cnt.add(ladr);
        Contact.addActionListener((evt) -> {

        });
        cnt1.add(btnd);
        cnt1.add(bn);
        cnt1.add(Contact);
        cnt.add(cnt1);
       
        return cnt;
    }
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));

    }

 

}
