package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Task2 extends SimpleApplication {
    private Person firstPerson,secondPerson,thirdPerson;
    private Person firstDefault,secondDefault,thirdDefault;
    public  Material FIRST,SECOND,THIRD;
    private boolean lShiftPressed;
    private boolean[] toNotIncrease = new boolean[3];
    private float[] scaleMeasure = new float[3];
    private boolean[] color = new boolean[3];
    private boolean[] rotate = new boolean[3];
    private byte a=-1;
    ControlToRotate ctr1;
ControlToRotate ctr2;
ControlToRotate ctr3;

int status1 =1;
int status2 =1;
int status3 =1;
    private final ActionListener changeDirection = new ActionListener(){
        @Override
        public void onAction(String name, boolean isPressed, float tpf) {
            if(!isPressed){
            switch(name){
                case UserInput.MAPPING_ROTATE_OF_FIRST:{
                    
                      rotate[0] = !rotate[0];        
                    break;
                }
                case UserInput.MAPPING_ROTATE_OF_SECOND:{
                    rotate[1] = !rotate[1];   
                    break;
                }
                case UserInput.MAPPING_ROTATE_OF_THIRD:{
                    rotate[2] = !rotate[2]; 
                    break;
                }
                
            }
            
            }
        }
        
    };
    private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
                if(keyPressed){
                switch(name){
                 
                case UserInput.MAPPING_COLOR_OF_FIRST:{
                    
                       if(!color[0]){
                       firstPerson.getBody().setColor("Color",ColorRGBA.Orange);
                       color[0]= true;
                       }else{
                           firstPerson.getBody().setColor("Color", ColorRGBA.Red);
                           color[0]= false;
                       }
                       
                    break;
                }
                 case UserInput.MAPPING_COLOR_OF_SECOND:{  
                  
                       if(!color[1]){
                       secondPerson.getBody().setColor("Color",ColorRGBA.Green );
                       color[1]= true;
                       }else{
                           secondPerson.getBody().setColor("Color", ColorRGBA.Blue);
                           color[1]= false;
                       }
                      
                    break;
                }
                  case UserInput.MAPPING_COLOR_OF_THIRD:{
                       
                        if(!color[2]){
                       thirdPerson.getBody().setColor("Color",ColorRGBA.DarkGray);
                         color[2]= true;
                       }else{
                           thirdPerson.getBody().setColor("Color", ColorRGBA.Gray);
                          color[2]= false;
                       }
                       
                   break;
                }
                
            }
         }
               
                
          
        }
    };
   private final AnalogListener analog = new AnalogListener(){
        @Override
        public void onAnalog(String name, float value, float tpf) {
           
                    
                switch(name){
                 
                case UserInput.MAPPING_ROTATE_OF_FIRST:{
                        if(!rotate[0]){
                            firstPerson.getAll().rotate(0,0,FastMath.DEG_TO_RAD*2);
                            
                        }else{
                            firstPerson.getAll().rotate(0,0,-FastMath.DEG_TO_RAD*2);
                            
                        }
                        
                       a=0;
                    break;
                }
                 case UserInput.MAPPING_ROTATE_OF_SECOND:{  
                     if(!rotate[1]){
                         secondPerson.getAll().rotate(FastMath.DEG_TO_RAD*2,0,0);
                         
                     }else{
                         secondPerson.getAll().rotate(-FastMath.DEG_TO_RAD*2,0,0);
                        
                     }
                  
                   
                      a=1;
                    break;
                }
                  case UserInput.MAPPING_ROTATE_OF_THIRD:{
                      if(!rotate[2]){
                          thirdPerson.getAll().rotate(0,0,FastMath.DEG_TO_RAD*2);
                          
                      }else{
                          thirdPerson.getAll().rotate(0,0,-FastMath.DEG_TO_RAD*2);
                          
                      }
                          
                      a=2;
            
                   break;
                }
                
            }
             
         
                
         }
       
            
   };
   private final ActionListener toBegin = new ActionListener(){
        @Override
        public void onAction(String name, boolean isPressed, float tpf) {
            if(!isPressed){
              
                
               firstPerson.getAll().removeControl(ctr1);
                 
               secondPerson.getAll().removeControl(ctr2);
                 
               thirdPerson.getAll().removeControl(ctr3);
                    
                    firstPerson.getBody().setColor("Color", ColorRGBA.Red);
                    secondPerson.getBody().setColor("Color", ColorRGBA.Blue);
                    thirdPerson.getBody().setColor("Color", ColorRGBA.Gray);
                    
                try {
                    firstPerson.getAll().attachChild(((Person)firstDefault.clone()).getAll().getChild("hat"));
                    secondPerson.getAll().attachChild(((Person)secondDefault.clone()).getAll().getChild("hat"));
                    thirdPerson.getAll().attachChild(((Person)thirdDefault.clone()).getAll().getChild("hat"));
                  
                    firstPerson.getAll().setLocalRotation(((Person)firstDefault.clone()).getAll().getLocalRotation());
                    secondPerson.getAll().setLocalRotation(((Person)secondDefault.clone()).getAll().getLocalRotation());
                    thirdPerson.getAll().setLocalRotation(((Person)thirdDefault.clone()).getAll().getLocalRotation());
                    firstPerson.getAll().setLocalScale(((Person)firstDefault.clone()).getAll().getLocalScale());
                    secondPerson.getAll().setLocalScale(((Person)secondDefault.clone()).getAll().getLocalScale());
                    thirdPerson.getAll().setLocalScale(((Person)thirdDefault.clone()).getAll().getLocalScale());
                    
                    
                    
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                    
                    
                    
               
         
           
            
       
     }
       
     }
       
   };
   private final ActionListener actionListener2 = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {

        
        
      if (name.equals(UserInput.MAPPING_ROTATE_OF_FIRST) && keyPressed) { 
          
          if(status1 == 1){
          
          if(ctr1 == null)
          {
              ctr1 = new ControlToRotate();
              
          }
          
          ctr1.setAngle(new Vector3f(0,0,FastMath.DEG_TO_RAD*10));
          ctr1.setSpeed(40);
          firstPerson.getAll().addControl(ctr1);
          status1 = 2;
          
          
          }
          
          
          else if (status1 ==2)
          {
              if(ctr1 == null)
              {
                   ctr1 = new ControlToRotate();
                  
                  
              }
               ctr1.setSpeed(40);
               ctr1.setAngle(new Vector3f(0,0,-FastMath.DEG_TO_RAD*10));
              status1 = 3;
              
          }
              else
          {
              
               firstPerson.getAll().removeControl(ctr1);
              ctr1 = null;
              status1 = 1;
              
          }
          
         
                         
      }
     else if (name.equals(UserInput.MAPPING_ROTATE_OF_SECOND) && keyPressed) { 
         
              if(status2 == 1){
          
          if(ctr2 == null)
          {
              ctr2 = new ControlToRotate();
              
          }
          
          ctr2.setAngle(new Vector3f(FastMath.DEG_TO_RAD*10,0,0));
          ctr2.setSpeed(40);
           secondPerson.getAll().addControl(ctr2);
          status2 = 2;
          
          
          }
          
          
          else if (status2 ==2)
          {
              if(ctr2 == null)
              {
                   ctr2 = new ControlToRotate();
                  
                  
              }
               ctr2.setSpeed(40);
               ctr2.setAngle(new Vector3f(-FastMath.DEG_TO_RAD*10,0,0));
               status2 = 3;
              
          }
              else
          {
              
              secondPerson.getAll().removeControl(ctr2);
              ctr2 = null;
              status2 = 1;
              
          }
       
         
                         
      }
          else if (name.equals(UserInput.MAPPING_ROTATE_OF_THIRD) && keyPressed) { 
          
       
                    if(status3 == 1){
          
          if(ctr3 == null)
          {
              ctr3 = new ControlToRotate();
              
          }
          
          ctr3.setAngle(new Vector3f(0,0,FastMath.DEG_TO_RAD*10));
          ctr3.setSpeed(40);
           thirdPerson.getAll().addControl(ctr3);
          status3 = 2;
          
          
          }
          
          
          else if (status3 ==2)
          {
              if(ctr3 == null)
              {
                   ctr3 = new ControlToRotate();
                  
                  
              }
               ctr3.setSpeed(40);
               ctr3.setAngle(new Vector3f(0,0,-FastMath.DEG_TO_RAD*10));
               status3 = 3;
              
          }
              else
          {
              
              thirdPerson.getAll().removeControl(ctr3);
              ctr3 = null;
              status3 = 1;
              
          }
              
      }

          

    }
  };
 
    private final ActionListener leftShift = new ActionListener(){
        @Override
        public void onAction(String name, boolean isPressed, float tpf) {
            lShiftPressed = isPressed;
        }
        
        
    };
     private final ActionListener ScaleElement = new ActionListener(){
        @Override
        public void onAction(String name, boolean isPressed, float tpf) {
            if(isPressed&&lShiftPressed){
                switch(name){
              
                    case UserInput.MAPPING_COMMA:{
                        
                        
                  if(scaleMeasure[1]<1.5f&&!toNotIncrease[1]){
                  firstPerson.getAll().setLocalScale(scaleMeasure[1]);
                  scaleMeasure[1]+=0.05f;
                  
              } 
              else if(scaleMeasure[1]>0.66f){
                  toNotIncrease[1] = true;
                  scaleMeasure[1]-=0.05f;
                  firstPerson.getAll().setLocalScale(scaleMeasure[1]);
                  
              }else{
                  toNotIncrease[1] = false;
              }
                        break;
                    }
                    case UserInput.MAPPING_POINT:{
                   if(scaleMeasure[2]<1.5f&&!toNotIncrease[2]){
                  secondPerson.getAll().setLocalScale(scaleMeasure[2]);
                  scaleMeasure[2]+=0.05f;
                  
              } 
              else if(scaleMeasure[2]>0.66f){
                  toNotIncrease[2] = true;
                  scaleMeasure[2]-=0.05f;
                  secondPerson.getAll().setLocalScale(scaleMeasure[2]);
                  
              }else{
                  toNotIncrease[2] = false;
              }
                       break; 
                        
                        
                    }
                    
                    case UserInput.MAPPING_SLASH:{
                        
                if(scaleMeasure[0]<1.5f&&!toNotIncrease[0]){
                  thirdPerson.getAll().setLocalScale(scaleMeasure[0]);
                  scaleMeasure[0]+=0.05f;
                  
              } 
              else if(scaleMeasure[0]>0.66f){
                  toNotIncrease[0] = true;
                  scaleMeasure[0]-=0.05f;
                  thirdPerson.getAll().setLocalScale(scaleMeasure[0]);
                  
              }else{
                  toNotIncrease[0] = false;
              }
                        break;
                    }
                }
            
             
                
            }
        }
        
        
    };
   
    public static void main(String[] args) {
        Task2 app = new Task2();
        app.start();
    }
    public void initInstances(){
      this.FIRST = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
      this.SECOND = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
      this.THIRD = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
      this.FIRST.setColor("Color", ColorRGBA.Red);
      this.SECOND.setColor("Color", ColorRGBA.Blue);
      this.THIRD.setColor("Color", ColorRGBA.Gray);
      this.color[0] = false;
      this.color[1] = false;
      this.color[2] = false;
       this.rotate[0] = false;
      this.rotate[1] = false;
      this.rotate[2] = false;
      this.toNotIncrease[0] = false;
      this.toNotIncrease[1] = false;
      this.toNotIncrease[2] = false;
      this.scaleMeasure[0] = 1;
      this.scaleMeasure[1] = 1;
      this.scaleMeasure[2] = 1;
      
    }
    private void setupKeys(){
        inputManager.addMapping(UserInput.MAPPING_COLOR_OF_FIRST, UserInput.TRIGGER_COLOR1);
        inputManager.addMapping(UserInput.MAPPING_COLOR_OF_SECOND, UserInput.TRIGGER_COLOR2);
        inputManager.addMapping(UserInput.MAPPING_COLOR_OF_THIRD, UserInput.TRIGGER_COLOR3);
        inputManager.addMapping(UserInput.MAPPING_ROTATE_OF_FIRST, UserInput.ROTATE_FIRST);
        inputManager.addMapping(UserInput.MAPPING_ROTATE_OF_SECOND, UserInput.ROTATE_SECOND);
        inputManager.addMapping(UserInput.MAPPING_ROTATE_OF_THIRD, UserInput.ROTATE_THIRD);
        inputManager.addMapping(UserInput.MAPPING_BEGIN,UserInput.TO_BEGIN);
        inputManager.addMapping(UserInput.MAPPING_REMOVING,UserInput.REMOVING_HATS);
        inputManager.addMapping(UserInput.MAPPING_SHIFT,UserInput.LEFT_SHIFT);
        inputManager.addMapping(UserInput.MAPPING_SLASH,UserInput.SLASH_KEY);
        inputManager.addMapping(UserInput.MAPPING_COMMA,UserInput.COMMA);
        inputManager.addMapping(UserInput.MAPPING_POINT,UserInput.POINT);
        inputManager.addListener(ScaleElement, UserInput.MAPPING_SLASH,UserInput.MAPPING_COMMA,UserInput.MAPPING_POINT);
        inputManager.addListener(leftShift, UserInput.MAPPING_SHIFT);
        inputManager.addListener(removingHat,UserInput.MAPPING_REMOVING);
        inputManager.addListener(actionListener,UserInput.MAPPING_REMOVING);
        inputManager.addListener(toBegin, UserInput.MAPPING_BEGIN);
        inputManager.addListener(actionListener, UserInput.MAPPING_COLOR_OF_FIRST,UserInput.MAPPING_COLOR_OF_SECOND,UserInput.MAPPING_COLOR_OF_THIRD);
        inputManager.addListener(actionListener2, UserInput.MAPPING_ROTATE_OF_FIRST,UserInput.MAPPING_ROTATE_OF_SECOND,UserInput.MAPPING_ROTATE_OF_THIRD);
       
        
    }
     protected void initCrossHairs() 
    {
    setDisplayStatView(false);
    guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
    BitmapText ch = new BitmapText(guiFont, false);
    ch.setSize(guiFont.getCharSet().getRenderedSize() * 2);
    ch.setText("+"); // crosshairs
    ch.setLocalTranslation( // center
      settings.getWidth() / 2 - ch.getLineWidth()/2,
      settings.getHeight() / 2 + ch.getLineHeight()/2, 0);
    guiNode.attachChild(ch);
  }
     
    private final ActionListener removingHat = new ActionListener() {

    @Override
    public void onAction(String name, boolean keyPressed, float tpf) {
     
         
        
         CollisionResults results = new CollisionResults();
         
         Ray ray = new Ray(cam.getLocation(), cam.getDirection());
         rootNode.collideWith(ray, results);
         
         for (int i = 0; i < results.size(); i++) {
           
           
           String target = results.getCollision(i).getGeometry().getName();
           if("crown".equals(target)||"brim".equals(target)){
               
                results.getCollision(i).getGeometry().getParent().removeFromParent();
           }
           
         }
    }
  };
    
    @Override
    public void simpleInitApp()  {
        initCrossHairs();
        this.setupKeys();
        this.initInstances();
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Yellow);
        
     
        firstPerson = new Person(FIRST,mat.clone());
   
        secondPerson = new Person(SECOND,mat.clone());
        
        thirdPerson = new Person(THIRD,mat.clone());
        
 
       
        Node node1 = firstPerson.personToNode();
        
        Node node2 = secondPerson.personToNode();
        Node node3 = thirdPerson.personToNode();
        
        initHeads();
        
        DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White);
        sun.setDirection(cam.getDirection());
        rootNode.addLight(sun);
        
        
      
       
          try{
            this.firstDefault =(Person)firstPerson.clone();
            this.secondDefault =(Person) secondPerson.clone();
            this.thirdDefault = (Person)thirdPerson.clone();
           
            
        }catch(CloneNotSupportedException e){
            System.err.print(e.getMessage());
            
        }
        
          
              Spatial l4 = assetManager.loadModel("Models/model.j3o");
        l4.setLocalTranslation(-5f,-1f,0.1f);
        rootNode.attachChild(l4);
       
            
        rootNode.attachChild(node1);
       
        rootNode.attachChild(node2);
       
        rootNode.attachChild(node3);
      
        
        
      
        
    }
    public void initHeads()
    {
        
        Spatial sp1 = assetManager.loadModel("Models/HEAD1.j3o");
        firstPerson.setHeadModel(sp1);
         
          Spatial sp2 = assetManager.loadModel("Models/HEAD2.j3o");
        secondPerson.setHeadModel(sp2);
        
             Spatial sp3 = assetManager.loadModel("Models/HEAD3.j3o");
        thirdPerson.setHeadModel(sp3);
        
    }
    @Override
    public void simpleUpdate(float tpf) {
        
      
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
            

