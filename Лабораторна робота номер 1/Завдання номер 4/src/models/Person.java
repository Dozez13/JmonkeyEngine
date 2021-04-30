/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import com.jme3.material.Material;
import com.jme3.math.FastMath;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.shape.Torus;
import java.util.List;

/**
 *
 * @author Pavlo
 */
public class Person {
  
     private final Material body;
     private final Material hat;
    public Person(Material body,Material hat){
      this.body = body;
      this.hat = hat;
      
    }
    public Node personToNode(){
        Geometry bodys = new Geometry("body",new Sphere(100,100,0.8f));
        Geometry head = new Geometry("head",new Box(0.5f,0.5f,0.5f));
        Geometry leftHand = new Geometry("leftHand",new Box(0.5f,0.5f,0.5f));
        Geometry rightHand = new Geometry("rightHand",new Box(0.5f,0.5f,0.5f));
        Geometry leftLeg = new Geometry("leftLeg",new Box(0.5f,0.6f,0.5f));
        Geometry rightLeg = new Geometry("rightLeg",new Box(0.5f,0.6f,0.5f));
        Geometry brim = new Geometry("crown",new Torus(20,20,0.1f,0.5f));
        Geometry crown = new Geometry("brim",new Cylinder(20,20,0.4f,0.6f,true));
        Node hatElements = new Node("hat");
        hatElements.attachChild(crown);
        hatElements.attachChild(brim);
        crown.move(0,0,0.3f);
        hatElements.rotate(-FastMath.PI/2,0,0);
        hatElements.move(0,2.5f,0);
        Node person = new Node("Body");
        person.attachChild(leftLeg);
        person.attachChild(rightLeg);
        person.attachChild(leftHand);
        person.attachChild(rightHand);
        person.attachChild(bodys);
        person.attachChild(head);
        leftLeg.move(-0.7f,-1.2f,0);
        rightLeg.move(0.7f,-1.2f,0);
        leftHand.move(-1f,0.6f,0);
        rightHand.move(1f,0.6f,0);
        head.move(0,1.8f,0);
                
        List<Spatial> spatials = person.getChildren();
        for(Spatial sp:spatials){
            if(sp instanceof Geometry){
                ((Geometry)sp).setMaterial(this.body);
            }
        }
          spatials = hatElements.getChildren();
        for(Spatial sp:spatials){
            if(sp instanceof Geometry){
                ((Geometry)sp).setMaterial(this.hat);
            }
        }     
        Node all = new Node("all");
        all.attachChild(person);
        all.attachChild(hatElements);
        return all;
        
    }
    
}
