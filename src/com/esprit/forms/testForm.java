package com.esprit.forms;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class testForm extends Form  {
    public testForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.LayeredLayout());
    private com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_ = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    private com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();
    private com.codename1.ui.RadioButton gui_Radio_Button = new com.codename1.ui.RadioButton();
    private com.codename1.ui.ComboBox gui_Combo_Box = new com.codename1.ui.ComboBox();
    private com.codename1.ui.Slider gui_Slider = new com.codename1.ui.Slider();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("testForm");
        setName("testForm");
        addComponent(gui_Container);
        gui_Container.setPreferredSizeStr("170.63492mm inherit");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)170.63492);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)69.57672);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "4.2328033mm 4.748604% 46.958176% 9.788368mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        gui_Container.addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_Y.setPreferredSizeStr("170.63492mm 92.85715mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Box_Layout_Y.addComponent(gui_);
        gui_Box_Layout_Y.addComponent(gui_Label);
        gui_Box_Layout_Y.addComponent(gui_Button);
        gui_Box_Layout_Y.addComponent(gui_Radio_Button);
        gui_Box_Layout_Y.addComponent(gui_Combo_Box);
        gui_Box_Layout_Y.addComponent(gui_Slider);
        gui_.setText("Usernamee");
                gui_.setInlineStylesTheme(resourceObjectInstance);
        gui_.setName("");
        com.codename1.ui.FontImage.setMaterialIcon(gui_,"\ue853".charAt(0));
        gui_Label.setText("Checkout");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Label,"\ue854".charAt(0));
        gui_Button.setText("valider");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_Button.setPressedIcon(com.codename1.ui.FontImage.createMaterial("\ue192".charAt(0), gui_Button.getPressedStyle()));
        gui_Button.setDisabledIcon(com.codename1.ui.FontImage.createMaterial("\ue84e".charAt(0), gui_Button.getDisabledStyle()));
        gui_Radio_Button.setText("Radio");
                gui_Radio_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button.setName("Radio_Button");
        gui_Radio_Button.setPressedIcon(com.codename1.ui.FontImage.createMaterial("\ue853".charAt(0), gui_Radio_Button.getPressedStyle()));
                gui_Combo_Box.setInlineStylesTheme(resourceObjectInstance);
        gui_Combo_Box.setName("Combo_Box");
        gui_Slider.setEditable(true);
        gui_Slider.setFocusable(true);
        gui_Slider.setText("choisir");
                gui_Slider.setInlineStylesTheme(resourceObjectInstance);
        gui_Slider.setName("Slider");
        gui_Slider.setProgress(4);
        com.codename1.ui.FontImage.setMaterialIcon(gui_Slider,"\ue145".charAt(0));
        gui_Box_Layout_Y.setPreferredSizeStr("170.63492mm 92.85715mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
        gui_Container.setPreferredSizeStr("170.63492mm inherit");
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredWidthMM((float)170.63492);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getLayout()).setPreferredHeightMM((float)69.57672);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "4.2328033mm 4.748604% 46.958176% 9.788368mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
