/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package culminatingcannon;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Joshua
 */
public class MenuHelper{
        /**
     * getSolution(String s) uses a String to evaluate which formulas are 
     * avaliable to be used with the selected unknown variable.
     * @param b
     * @param s 
     */
    public void getSolution(JComboBox b, String s){
        MainMenu menu = new MainMenu();
       
        b.removeAllItems();//removes all of the items in the ComboBox
        
         switch(s){
        
        case "v1":
            b.addItem("theta1, v1y");
            b.addItem("theta1, v1x");
            b.addItem("v1x, v1y");
                break;
   
        case "v1x":
            b.addItem("dx, t");
            b.addItem("theta1, v1y");
            b.addItem("theta2, v2y"); 
            b.addItem("v1, v1y");
                break;
                
        case "v1y":
            b.addItem("a, dy, t");
            b.addItem("a, t, v2y");
            b.addItem("a, dy, v2y");
            b.addItem("dy, t, v2y");
            b.addItem("theta1, v1x");
            b.addItem("v1, v1x");
                break;
                
        case "v2":
            b.addItem("theta2, v2y");
            b.addItem("theta2, v1x");
            b.addItem("v1x, v2y");
                break;
            
        case "v2y":
            b.addItem("a, dy, t");
            b.addItem("a, t, v1y");
            b.addItem("a, dy, v1y");
            b.addItem("dy,t, v1y");
            b.addItem("theta2, v1x");
            b.addItem("v1x, v2");
                break;
            
        case "dx":
            b.addItem("t, v1x");
                break;
                
        case "dy": 
            b.addItem("a, t, v1y");
            b.addItem("a, t, v2y");
            b.addItem("a, v1y, v2y");
            b.addItem("t, v1y, v2y");
                break;
                
        case "t":
            b.addItem("dx, v1x");
            b.addItem("a, dy, v1y");
            b.addItem("a, dy, v2y");
            b.addItem("a, v1y, v2y");
            b.addItem("dy, v1y, v2y");
                break;
                
        case "a":
            b.addItem("dy, t, v1y");
            b.addItem("dy, t, v2y");
            b.addItem("t, v1y, v2y");
            b.addItem("dy, v1y, v2y");
                break;
            
        case "theta1":
            b.addItem("v1x, v1y");
            b.addItem("v1y, v1");
            b.addItem("v1x, v1");
                break;
            
        case "theta2":
            b.addItem("v1x, v2y");
            b.addItem("v2y, v2");
            b.addItem("v1x, v2");
                break;
            
        default: //condition should never be evaluated
         System.err.print("A variable has been selected that does not exist");
                break;
        }
    }
    
    /**
     * disableJTextFields will use an array of JTextFields to set 'a' amount of 
     * elements to .setEnabled(false). Additionally, any text entered inside a 
     * JTextField will be cleared.
     * @param f
     * @param a 
     */
    public void disableJTextFields(JTextField[] f, int a){
        
        try
        {
            for(int i = 0; i < a; i++)
            {
            f[i].setText("");
            f[i].setEnabled(false);
            }
            
        }catch(IndexOutOfBoundsException e){
            System.err.println("Array index exceedes the length of the array" + 
                    " with an index of " + e.getMessage());
        }
    } 
    
    /**
     * enableJTextFields will use an array of JTextFields to set 'a' amount of 
     * elements to .setEnabled(true).
     * @param f
     * @param a 
     */
     public void enableJTextFields(JTextField[] f, int a){
        
        try
        {
            for(int i = 0; i < a; i++){
            f[i].setEnabled(true);
            }
        }catch(IndexOutOfBoundsException e){
            System.err.println("Array index exceedes the length of the array" + 
                    " with an index of " + e.getMessage());
        }
    }
     /**
      * getSelectedComboBoxItem(JComboBox b) gets the currently selected item of
      * a given JComboBox
      * @param b 
      */
     public String getSelectedJComboBoxItem(JComboBox b){
        
         try
         {
         Object o = b.getModel().getSelectedItem();
         return o.toString();
         
         }
         catch(Exception e){
             System.err.println("An error has occured in method "
                     + "getSelectedJComboBoxItem: " + e.getMessage());
         }
       return ""; //should not eveluate
     }
     
     /**
      * getValues(JTextField[] f, int i) will get the text of every JTextField[]
      * 'f' element, and will return the Strings as a double[].
      * @param f
      * @param i
      * @return 
      */
     public double[] getValues(JTextField[] f){
         double[] values = new double[f.length];
         
         for(int l = 0; l < values.length; l++){
              
             try
             {
             String tempStr = f[l].getText();
             double tempDbl = Double.parseDouble(tempStr);
             values[l] = tempDbl;
             }
             catch(NumberFormatException e)
             {
                 System.err.println("A Number was entered improperly: " 
                         + e.getMessage());
             } 
            finally
             {
                  
             }
         }
         return values;
     }
     public void v1SetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "theta1, v1y":
                 enableJTextFields(f,2);
                 f[0].setText("theta1");
                 f[1].setText("v1y");
                 break;
                 
             case "theta1, v1x":
                 enableJTextFields(f,2);
                 f[0].setText("theta1");
                 f[1].setText("v1x");
                 break;
             
             case "v1x, v1y":
                 enableJTextFields(f,2);
                 f[0].setText("v1x");
                 f[1].setText("v1y");
                 break;
         }
     }
     
     public void v1xSetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "dx, t":
                 enableJTextFields(f,2);
                 f[0].setText("dx");
                 f[1].setText("t");
                 break;
                 
             case "theta1, v1y":
                 enableJTextFields(f,2);
                 f[0].setText("theta1");
                 f[1].setText("v1y");
                 break;
             
             case "theta2, v2y":
                 enableJTextFields(f,2);
                 f[0].setText("theta2");
                 f[1].setText("v2y");
                 break;
                 
             case "v1, v1y":
                 enableJTextFields(f,2);
                 f[0].setText("v1");
                 f[1].setText("v1y");
                 break;
         }
     }
     
     public void v1ySetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "a, dy, t":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("dy");
                 f[2].setText("t");
                 break;
                 
             case "a, t, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("t");
                 f[2].setText("v2y");
                 break;
             
             case "a, dy, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("dy");
                 f[2].setText("v2y");
                 break;
                 
             case "dy, t, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("dy");
                 f[1].setText("t");
                 f[2].setText("v2y");
                 break;
                 
             case "theta1, v1x":
                 enableJTextFields(f,2);
                 f[0].setText("theta1");
                 f[1].setText("v1x");
                 break;
                 
             case "v1, v1x":
                 enableJTextFields(f,2);
                 f[0].setText("v1");
                 f[1].setText("v1x");
                 break;
         }
     }
      
      public void v2SetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "theta2, v2y":
                 enableJTextFields(f,2);
                 f[0].setText("theta2");
                 f[1].setText("v2y");
                 break;
                 
             case "theta2, v1x":
                 enableJTextFields(f,2);
                 f[0].setText("theta2");
                 f[1].setText("v1x");
                 break;
             
             case "v1x, v2y":
                 enableJTextFields(f,2);
                 f[0].setText("v1x");
                 f[1].setText("v2y");
                 break;
         }
     }
      
      public void v2ySetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "a, dy, t":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("dy");
                 f[2].setText("t");
                 break;
                 
             case "a, t, v1y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("t");
                 f[2].setText("v1y");
                 break;
             
             case "a, dy, v1y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("dy");
                 f[2].setText("v1y");
                 break;
                 
             case "dy, t, v1y":
                 enableJTextFields(f,3);
                 f[0].setText("dy");
                 f[1].setText("t");
                 f[2].setText("v1y");
                 break;
                 
             case "theta2, v1x":
                 enableJTextFields(f,2);
                 f[0].setText("theta2");
                 f[1].setText("v1x");
                 break; 
                 
              case "v1x, v2":
                 enableJTextFields(f,2);
                 f[0].setText("v1x");
                 f[1].setText("v2");
                 break;
         }
     }
      
      public void dxSetVars(JTextField[] f, String s){
          disableJTextFields(f,f.length);
          switch(s){
             case "t, v1x":
                 enableJTextFields(f,2);
                 f[0].setText("t");
                 f[1].setText("v1x");
                 break;
            }
        }
      
      public void dySetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "a, t, v1y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("t");
                 f[2].setText("v1y");
                 break;
                 
             case "a, t, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("t");
                 f[2].setText("v2y");
                 break;
             
             case "a, v1y, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("v1y");
                 f[2].setText("v2y");
                 break;
                 
             case "t, v1y, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("t");
                 f[1].setText("v1y");
                 f[2].setText("v2y");
                 break;
         }
     }
      
      public void tSetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "dx, v1x":
                 enableJTextFields(f,2);
                 f[0].setText("dx");
                 f[1].setText("v1x");
                 break;
                 
             case "a, dy, v1y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("dy");
                 f[2].setText("v1y");
                 break;
             
             case "a, dy, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("dy");
                 f[2].setText("v2y");
                 break;
                 
             case "a, v1y, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("a");
                 f[1].setText("v1y");
                 f[2].setText("v2y");
                 break;
                 
             case "dy, v1y, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("dy");
                 f[1].setText("v1y");
                 f[2].setText("v2y");
                 break;
         }
     }
      
      public void aSetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "dy, t, v1y":
                 enableJTextFields(f,3);
                 f[0].setText("dy");
                 f[1].setText("t");
                 f[2].setText("v1y");
                 break;
                 
             case "dy, t, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("dy");
                 f[1].setText("t");
                 f[2].setText("v2y");
                 break;
             
             case "t, v1y, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("t");
                 f[1].setText("v1y");
                 f[2].setText("v2y");
                 break;
                 
             case "dy, v1y, v2y":
                 enableJTextFields(f,3);
                 f[0].setText("dy");
                 f[1].setText("v1y");
                 f[2].setText("v2y");
                 break;
         }
     }
      
      public void theta1SetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "v1x, v1y":
                 enableJTextFields(f,2);
                 f[0].setText("v1x");
                 f[1].setText("v1y");
                 break;
                 
             case "v1y, v1":
                 enableJTextFields(f,2);
                 f[0].setText("v1y");
                 f[1].setText("v1");
                 break;
             
             case "v1x, v1":
                 enableJTextFields(f,2);
                 f[0].setText("v1x");
                 f[1].setText("v1");
                 break;
         }
     }
      
      public void theta2SetVars(JTextField[] f, String s){
         disableJTextFields(f,f.length);
         switch(s){
             case "v1x, v2y":
                 enableJTextFields(f,2);
                 f[0].setText("v1x");
                 f[1].setText("v2y");
                 break;
                 
             case "v2y, v2":
                 enableJTextFields(f,2);
                 f[0].setText("v2y");
                 f[1].setText("v2");
                 break;
             
             case "v1x, v2":
                 enableJTextFields(f,2);
                 f[0].setText("v1x");
                 f[1].setText("v2");
                 break;
         }
     }
      /**
       * The method will format a given String, and will remove any spaces and
       * commas.
       * e.g. a String "You got 43 as the answer, right?" would become
       * "Yougot43astheanswerright?" when passed.
       */
      public String format(String s)
      {
          if(s.contains(" ")){
            s = s.replaceAll(" ", "");
          }
          
          if(s.contains(","))
          {
              s = s.replaceAll(",", "");
          }
          return s;
      }
}
 