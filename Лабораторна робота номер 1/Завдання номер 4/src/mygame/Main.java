package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import models.Person;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Material body = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        body.setColor("Color",ColorRGBA.Yellow);
        Material hat = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
        hat.setColor("Color",ColorRGBA.Green);
       Person person = new Person(body,hat);
        rootNode.attachChild(person.personToNode());
    }

}
