/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;
import com.jme3.input.*;
import com.jme3.input.controls.*;
/**
 *
 * @author Home
 */

public class UserInput {
  
 public final static Trigger TRIGGER_COLOR1 = new KeyTrigger(KeyInput.KEY_1);
 public final static Trigger TRIGGER_COLOR2 = new KeyTrigger(KeyInput.KEY_2);
 public final static Trigger TRIGGER_COLOR3 = new KeyTrigger(KeyInput.KEY_3);
 public final static Trigger ROTATE_FIRST = new KeyTrigger(KeyInput.KEY_F);
 public final static Trigger ROTATE_SECOND = new KeyTrigger(KeyInput.KEY_G);
 public final static Trigger ROTATE_THIRD = new KeyTrigger(KeyInput.KEY_H);
 public final static Trigger TO_BEGIN = new KeyTrigger(KeyInput.KEY_Z);
 public final static Trigger REMOVING_HATS = new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
 public final static Trigger SLASH_KEY = new KeyTrigger(KeyInput.KEY_SLASH);
 public final static Trigger COMMA = new KeyTrigger(KeyInput.KEY_COMMA);
 public final static Trigger POINT = new KeyTrigger(KeyInput.KEY_PERIOD);
 public final static Trigger LEFT_SHIFT = new KeyTrigger(KeyInput.KEY_LSHIFT);
 public final static String MAPPING_COLOR_OF_FIRST = "Change first body's color";
 public final static String MAPPING_COLOR_OF_SECOND = "Change second body's color";
 public final static String MAPPING_COLOR_OF_THIRD = "Change third body's color";
 public final static String MAPPING_ROTATE_OF_FIRST = "Change first body's position";
 public final static String MAPPING_ROTATE_OF_SECOND = "Change second body's position";
 public final static String MAPPING_ROTATE_OF_THIRD = "Change third body's position";
 public final static String MAPPING_BEGIN = "Reset to default";
 public final static String MAPPING_REMOVING = "Removing hats";
 public final static String MAPPING_SHIFT = "Pressed LShift";
 public final static String MAPPING_SLASH = "Pressed Slashkey";
 public final static String MAPPING_COMMA = "Pressed comma";
 public final static String MAPPING_POINT = "Pressed Points";
 
}
