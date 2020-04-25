/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Bhaskor
 */
public class ScreenController {

    private static HashMap<String, URL> screenMap = new HashMap<>();

    public void addScreen(String name, URL path) {
        screenMap.put(name, path);
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public Object getController(String name) throws IOException {
        FXMLLoader Loader = new FXMLLoader(screenMap.get(name));
        Parent root = (Parent) Loader.load();
        return Loader.getController();
    }

    public Parent activate(String name) {
        Parent parent = null;
        try {
            parent = FXMLLoader.load(screenMap.get(name));
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parent;
    }
}
