package com.trigonometria.ferramentas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Trigonometrando extends Application {

    private Stage stage;
    private final int  xLength = 475, yLength = 340, radio = 170;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Trigonometrando");
        stage.setResizable(false);
        goCircunferencia();
        primaryStage.show();
    }


    public void goCircunferencia() {
        try {
            CicloTrigonometricoController controller = (CicloTrigonometricoController) replaceSceneContent("Ciclo.fxml");
            controller.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Trigonometrando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goTriangulos() {
//        try {
//            TrianguloController controller = (TrianguloController) replaceSceneContent("Triang.fxml");
//            controller.setApp(this);
//        } catch (Exception ex) {
//            Logger.getLogger(Trigonometrando.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void goEixo() {
//        try {
//            EixoCartesianoController controller = (EixoCartesianoController) replaceSceneContent("EixoCart.fxml");
//            controller.setApp(this);
//        } catch (Exception ex) {
//            Logger.getLogger(Trigonometrando.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Trigonometrando.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Trigonometrando.class.getResource(fxml));

        Map<String, Object> namespace = loader.getNamespace();
        namespace.put("x", xLength);
        namespace.put("y", yLength);
        namespace.put("r", radio);
        namespace.put("rn", -radio);
        namespace.put("rx", radio + xLength);
        
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
        Scene scene = new Scene(page, 1090, 660);//screenSize.width-20, screenSize.height-85);
        stage.setScene(scene);
        stage.centerOnScreen();
        //stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        Application.launch(Trigonometrando.class, (java.lang.String[]) null);
    }

}
