package com.trigonometria.ferramentas;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

@SuppressWarnings("restriction")
public class CicloTrigonometricoController extends BackGround implements Initializable {

	// Linha -> representa o valor da função
	// Traco -> prolongamento da reta do ângulo até a função
	@FXML
	private Line linhaSeno, linhaCosseno, linhaTangente, linhaCotangente, linhaSecante, linhaCossecante, tracoTangente,
			tracoCotangente, tracoSecante, tracoCossecante, anguloComplementar, anguloSuplementar, EixoX, EixoY,
			tracoSimetricoAngulo1, tracoSimetricoAngulo2, tracoSimetricoAngulo3, 
			ladoSuperior, ladoEsquerdo, ladoInferior, ladoDireito;
	@FXML
	private TextField txtAng;
	@FXML
	private Label labelNumVoltas, labelGrau, labelSeno, labelCoseno, labelTangente, labelCotangente, labelSecante,
			labelCossecante, labelRad;
	@FXML
	private CheckBox checkTangente, checkCotangente, checkSecante, checkCossecante, checkComplementar, checkSuplementar,
			checkSimetricos;
	@FXML
	private Arc arcoMaior, arcoMenor;
	@FXML
	private Slider slide;
	@FXML
	private Button btnAng;
	@FXML
	private Circle circunferencia;
	@FXML
	private Pane panePopUp;

	private int numeroAngulo, seno, cosseno, tangente, cotangente, secante, cossecante, numVoltas, congruente;
	private double radious = 170;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		addTextFLimiter(txtAng, 5);
		txtAng.setText("0");
		marcAng(null);
	}

	@FXML
	protected void marcAng(ActionEvent event) {
		numeroAngulo = (Integer.parseInt(txtAng.getText()));
		numVoltas = (int) (numeroAngulo / 360);
		congruente = numeroAngulo - (360 * numVoltas);
		cosseno = (int) (Math.cos(-(congruente * Math.PI) / 180) * radious);
		seno = (int) (Math.sin(-(congruente * Math.PI) / 180) * radious);
		tangente = (int) (Math.tan(-(congruente * Math.PI) / 180) * radious);
		cotangente = (int) ((1 / (Math.tan(-(congruente * Math.PI) / 180))) * radious);
		secante = (int) ((1 / (Math.cos(-(congruente * Math.PI) / 180))) * radious);
		cossecante = (int) ((1 / (Math.sin(-(congruente * Math.PI) / 180))) * radious);
		slide.setValue(congruente);
		linhaCosseno.setLayoutX((cosseno + circunferencia.getLayoutX()));
		linhaSeno.setLayoutY((seno + circunferencia.getLayoutY()));
		arcoMaior.setLength(congruente);
		arcoMenor.setLength(congruente);
		arcoMaior.setRadiusX(radious + 1);
		arcoMenor.setRadiusX(radious + 1);
		arcoMaior.setRadiusY(radious + 1);
		arcoMenor.setRadiusY(radious + 1);
		circunferencia.setRadius(radious + 1);

		// Simétricos
		if (checkSimetricos.isSelected()) {
			checkFuncoesSimetricas();
		}

		// Labels
		DecimalFormat df = new DecimalFormat("0.000000");

		labelGrau.setText("" + numeroAngulo + "º");
		switch (numeroAngulo) {
		case 0:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=0");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=1");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=0");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=---");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=1");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=---");
			labelRad.setText("" + numeroAngulo + " º=0 π rad");
			break;
		case 30:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=1/2");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=√3/2");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=√3/3");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=√3");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=2√3/3");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=2");
			labelRad.setText("" + numeroAngulo + " º=" + df.format((numeroAngulo * Math.PI) / 180) + " π rad");
			break;
		case 45:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=√2/2");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=√2/2");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=1");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=1");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=√2");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=√2");
			labelRad.setText("" + numeroAngulo + " º=" + df.format((numeroAngulo * Math.PI) / 180) + " π rad");
			break;
		case 60:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=√3/2");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=1/2");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=√3");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=1/√3");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=2");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=2√3/3");
			labelRad.setText("" + numeroAngulo + " º=" + df.format((numeroAngulo * Math.PI) / 180) + " π rad");
			break;
		case 90:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=1");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=0");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=---");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=---");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=---");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=1");
			labelRad.setText("" + numeroAngulo + " º= π/2 rad");
			break;
		case 180:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=0");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=-1");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=0");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=---");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=-1");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=---");
			labelRad.setText("" + numeroAngulo + " º= π rad");
			break;
		case 270:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=-1");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=0");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=---");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=---");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=---");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=-1");
			labelRad.setText("" + numeroAngulo + " º= 2π/3 rad");
			break;
		case 360:
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º)=0");
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º)=1");
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º)=0");
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º)=---");
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º)=1");
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º)=---");
			labelRad.setText("" + numeroAngulo + " º= 2π rad");
			break;
		default:
			double radio = Math.toRadians(congruente);
			labelGrau.setText("" + numeroAngulo + " º");
			labelSeno.setText("" + "Sen(" + numeroAngulo + " º) = " + df.format(Math.sin(radio)));
			labelCoseno.setText("" + "Cos(" + numeroAngulo + " º) = " + df.format(Math.cos(radio)));
			labelTangente.setText("" + "Tan(" + numeroAngulo + " º) = " + df.format(Math.tan(radio)));
			labelCotangente.setText("" + "Cotg(" + numeroAngulo + " º) = " + df.format(1 / Math.tan(radio)));
			labelSecante.setText("" + "Sec(" + numeroAngulo + " º) = " + df.format(1 / Math.cos(radio)));
			labelCossecante.setText("" + "Cossec(" + numeroAngulo + " º) = " + df.format(1 / Math.sin(radio)));
			labelRad.setText("" + numeroAngulo + " º=" + df.format((numeroAngulo * Math.PI) / 180) + " π rad");
			break;
		}

		// Complementar
		anguloComplementar.setEndX(Math.abs((Math.cos((((90 - congruente) * Math.PI)) / 180) * radious)));
		anguloComplementar.setEndY(-Math.abs(-(Math.sin(((90 - congruente) * Math.PI) / 180) * radious)));

		// Suplementar
		anguloSuplementar.setEndX(-Math.abs((Math.cos(-((180 - congruente) * Math.PI) / 180) * radious)));
		anguloSuplementar.setEndY(-Math.abs(Math.sin(-((180 - congruente) * Math.PI) / 180) * radious));

		// Cossecante
		linhaCossecante.endYProperty().set(cossecante);
		tracoCossecante.startYProperty().set(cossecante);
		tracoCossecante.endXProperty().set(cosseno);
		tracoCossecante.endYProperty().set(seno);

		// Secante
		linhaSecante.endXProperty().set(secante);
		tracoSecante.startYProperty().set(seno);
		tracoSecante.layoutXProperty().set(cosseno + circunferencia.getLayoutX());
		tracoSecante.endXProperty().set(secante - cosseno);
		tracoSecante.layoutYProperty().set(linhaTangente.getLayoutY());

		// Tangente
		linhaTangente.endYProperty().set(tangente);
		linhaTangente.layoutXProperty().set(circunferencia.getLayoutX() + radious);
		tracoTangente.endYProperty().set(linhaTangente.getEndY());
		tracoTangente.endXProperty().set(linhaTangente.getLayoutX() - circunferencia.getLayoutX());

		// Cotangente
		linhaCotangente.endXProperty().set(-cotangente);
		linhaCotangente.layoutYProperty().set(circunferencia.getLayoutY() - radious);
		tracoCotangente.endXProperty().set(linhaCotangente.getEndX());
		tracoCotangente.endYProperty().set(linhaCotangente.getLayoutY() - circunferencia.getLayoutY());

		labelNumVoltas.setText(Integer.toString(numVoltas));
	}

	private void checkFuncoesSimetricas() {
		double cos = (Math.cos(((congruente) * Math.PI) / 180) * radious);
		double sin = (Math.sin(((congruente) * Math.PI) / 180) * radious);

		if (congruente < 90) {
			tracoSimetricoAngulo2.setEndY(sin);
			tracoSimetricoAngulo2.setEndX(-cos);
			tracoSimetricoAngulo3.setEndY(-sin);
			tracoSimetricoAngulo3.setEndX(-cos);
			tracoSimetricoAngulo1.setEndY(sin);
			tracoSimetricoAngulo1.setEndX(cos);
		} else if (congruente >= 90 && congruente < 180) {
			tracoSimetricoAngulo2.setEndY(sin);
			tracoSimetricoAngulo2.setEndX(cos);
			tracoSimetricoAngulo3.setEndY(-sin);
			tracoSimetricoAngulo3.setEndX(-cos);
			tracoSimetricoAngulo1.setEndY(sin);
			tracoSimetricoAngulo1.setEndX(-cos);
		} else if (congruente >= 180 && congruente < 270) {
			tracoSimetricoAngulo2.setEndY(sin);
			tracoSimetricoAngulo2.setEndX(-cos);
			tracoSimetricoAngulo3.setEndY(-sin);
			tracoSimetricoAngulo3.setEndX(-cos);
			tracoSimetricoAngulo1.setEndY(sin);
			tracoSimetricoAngulo1.setEndX(cos);
		} else {
			tracoSimetricoAngulo2.setEndY(sin);
			tracoSimetricoAngulo2.setEndX(cos);
			tracoSimetricoAngulo3.setEndY(-sin);
			tracoSimetricoAngulo3.setEndX(-cos);
			tracoSimetricoAngulo1.setEndY(sin);
			tracoSimetricoAngulo1.setEndX(-cos);
		}
		ladoSuperior.setStartX(-cos);
		ladoSuperior.setEndX(cos);
		ladoSuperior.setStartY(-sin);
		ladoSuperior.setEndY(-sin);

		ladoEsquerdo.setStartX(-cos);
		ladoEsquerdo.setEndX(-cos);
		ladoEsquerdo.setStartY(-sin);
		ladoEsquerdo.setEndY(sin);

		ladoInferior.setStartX(-cos);
		ladoInferior.setEndX(cos);
		ladoInferior.setStartY(sin);
		ladoInferior.setEndY(sin);

		ladoDireito.setStartX(cos);
		ladoDireito.setEndX(cos);
		ladoDireito.setStartY(-sin);
		ladoDireito.setEndY(sin);
	}

	@FXML
	protected void slideact(MouseEvent me) {
		txtAng.setText("" + Math.round(slide.getValue()));
		btnAng.fire();
	}

	@FXML
	protected void checkComp(ActionEvent event) {
		anguloComplementar.setVisible(checkComplementar.isSelected());
	}

	@FXML
	protected void checkSup(ActionEvent event) {
		anguloSuplementar.setVisible(checkSuplementar.isSelected());
	}

	@FXML
	protected void checkTan(ActionEvent event) {
		tracoTangente.setVisible(checkTangente.isSelected());
		linhaTangente.setVisible(checkTangente.isSelected());
	}

	@FXML
	protected void checkCotan(ActionEvent event) {
		tracoCotangente.setVisible(checkCotangente.isSelected());
		linhaCotangente.setVisible(checkCotangente.isSelected());
	}

	@FXML
	protected void checkSec(ActionEvent event) {
		tracoSecante.setVisible(checkSecante.isSelected());
		linhaSecante.setVisible(checkSecante.isSelected());
	}

	@FXML
	protected void checkCossec(ActionEvent event) {
		tracoCossecante.setVisible(checkCossecante.isSelected());
		linhaCossecante.setVisible(checkCossecante.isSelected());
	}

	@FXML
	protected void checkSimet(ActionEvent event) {
		boolean check = checkSimetricos.isSelected();
		tracoSimetricoAngulo1.setVisible(check);
		tracoSimetricoAngulo2.setVisible(check);
		tracoSimetricoAngulo3.setVisible(check);
		ladoSuperior.setVisible(check);
		ladoEsquerdo.setVisible(check);
		ladoInferior.setVisible(check);
		ladoDireito.setVisible(check);
		checkSuplementar.setVisible(check);
		checkComplementar.setVisible(check);
		checkFuncoesSimetricas();
	}

	@FXML
	protected void hotkey(KeyEvent ke) throws IOException {
		// if (ke.getText().contains(new StringBuilder("0123456789"))){
		if ((!ke.getText().isEmpty()) && ("1234567890".contains(new StringBuilder(ke.getText())))) {
			// if (ke.getText().equals("1")){
			int a, b;
			if (txtAng.getAnchor() > txtAng.getCaretPosition()) {
				a = txtAng.getCaretPosition();
				b = txtAng.getAnchor();
			} else {
				a = txtAng.getAnchor();
				b = txtAng.getCaretPosition();
			}
			if (txtAng.getText().equals("0")) {
				txtAng.setText(ke.getText());
			} else {
				/// lblExibir.setText(lblExibir.getText().substring(0,
				/// lblExibir.getCaretPosition()) + tecla
				// + lblExibir.getText().substring(lblExibir.getCaretPosition(),
				/// lblExibir.getText().length()));
				txtAng.setText(txtAng.getText().substring(0, a) + ke.getText()
						+ txtAng.getText().substring(b, txtAng.getText().length()));
			}
			txtAng.positionCaret(a + 1);
		}
		if (ke.getCode().equals(KeyCode.ENTER)) {
			marcAng(null);
		}
	}
}
