package com.trigonometria.ferramentas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;

public abstract class BackGround  {

    private Trigonometrando application;

    @FXML
    private Pane panePopUp;
    private DropShadow dropShadow = new DropShadow();
    private int numang, sen, cos, tan, cotan, sec, cossec, NumVoltas, congruo;
    private double z = 170, iniciox = 0, inicioy = 0;

    public void setApp(Trigonometrando application) {
        this.application = application;
    }
    @FXML
    protected void fim(MouseEvent de) {
        if (panePopUp.getLayoutX() < 0) {
            panePopUp.setLayoutX(0);
        }
        if (panePopUp.getLayoutY() < 0) {
            panePopUp.setLayoutY(0);
        }
        if (panePopUp.getLayoutX() > 800 - panePopUp.getPrefWidth()) {
            panePopUp.setLayoutX(800 - panePopUp.getPrefWidth());
        }
        if (panePopUp.getLayoutY() > 600 - panePopUp.getPrefHeight()) {
            panePopUp.setLayoutY(600 - panePopUp.getPrefHeight());
        }
    }

    @FXML
    protected void inicio(MouseEvent de) {
        iniciox = de.getSceneX() - panePopUp.getLayoutX();
        inicioy = de.getSceneY() - panePopUp.getLayoutY();
    }

    @FXML
    protected void drag(MouseEvent de) {
        if ((de.getSceneX() - iniciox < 0) || (de.getSceneX() - iniciox > 800 - panePopUp.getPrefWidth())) {
            iniciox = de.getSceneX() - panePopUp.getLayoutX();
        } else {
            panePopUp.setLayoutX(de.getSceneX() - iniciox);
        }
        if ((de.getSceneY() - inicioy < 0) || (de.getSceneY() - inicioy > 600 - panePopUp.getPrefHeight())) {
            inicioy = de.getSceneY() - panePopUp.getLayoutY();
        } else {
            panePopUp.setLayoutY(de.getSceneY() - inicioy);
        }
    }

    @FXML
    protected void zoom(ScrollEvent me) {
        if ((me.getDeltaY() < 0) && (z > 30)) {
            z = z - 30;
        }
        if ((me.getDeltaY() > 0) && (z < 200)) {
            z = z + 30;
        }
    }


    public static void addTextFLimiter(final TextField tf, final int maxLength)
    {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue)
                {
                    if(tf.getText().length() > maxLength)
                    {
                        String s = oldValue;
                        tf.setText(s);
                    }
                }
        });
    }
    
 
    @FXML
    protected void goTriangulos(MouseEvent me) {
        application.goTriangulos();
    }
    @FXML
    protected void goEixo(MouseEvent me) {
        application.goEixo();
    }
    @FXML
    protected void goCircunferencia(MouseEvent me) {
        application.goCircunferencia();
    }
}
