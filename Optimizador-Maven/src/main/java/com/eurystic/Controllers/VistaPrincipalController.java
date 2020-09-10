package com.eurystic.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


public class VistaPrincipalController {


    //Maestros maestros = Maestros.getInstance();

    public static Date fechaFinProduccion;

    @FXML
    private ListView<String> listEscenarios;

    @FXML
    private TextArea taDescripcionEscenarios;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnMinimize;

    @FXML
    private Button btnOptimizarProduccion;

    @FXML
    private Button btnComparacion;

    @FXML
    private AnchorPane mainLayout;

    @FXML
    private Label labelFechaInicioProduccion;

    // Periodo de optimizacion

    @FXML
    public RadioButton rbtnM0Completo;

    @FXML
    private RadioButton rbtnM1Completo;

    @FXML
    private RadioButton rbtnHorizontePredeterminado;

    @FXML
    private TextField textFieldFechaFin;

    // Criterio de producion ATR

    @FXML
    private RadioButton rbtnCarretesLlenos;

    @FXML
    private RadioButton rbtnLlenadoParcial;

    @FXML
    private TextField textFieldDemandaLimite;

    @FXML
    private TextField textFieldLlenadoMinimo;

    // Criterio de WH de mallas

    @FXML
    private RadioButton rbtnSinMezcla;

    @FXML
    private RadioButton rbtnConMezcla;

    @FXML
    private TextField textFieldLlenadoMaximoAlmacen;






    @FXML
    private void handleClose(ActionEvent event){
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }

    @FXML
    private void handleMinimize(ActionEvent event){
        if (event.getSource() == btnMinimize){
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setIconified(true);
        }
    }

    @FXML
    private void handleComparacionHistorica(ActionEvent event){
//        AnimationFX slideOutLeft = new SlideOutLeft(mainLayout);
//        slideOutLeft.play();
//        slideOutLeft.setOnFinished(e -> {
//            try {
//                Parent rootComparacion = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ComparacionHistorica.fxml")));
//                Scene sceneComparacion = new Scene(rootComparacion);
//                Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
//                borderlessWindow(rootComparacion, primaryStage);
//                primaryStage.setScene(sceneComparacion);
//                new SlideInRight(rootComparacion).play();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
    }

    @FXML
    private void handleOptimizarProduccion(ActionEvent event) throws InterruptedException {
//        File escenarioSelected = new File(descripcionEscenarios.get(listEscenarios.getSelectionModel().getSelectedItem())[1]);
//
//        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
//        final Scene[] sceneMenu = new Scene[1];
//        final Parent[] rootMenu = new Parent[1];
//
//        AnimationFX pulse = new Pulse(btnOptimizarProduccion);
//        AnimationFX pulse2 = new Pulse(mainLayout);
//        AnimationFX slideOutUp = new SlideOutUp(mainLayout);
//        Thread animationThread = new Thread(() -> {
//            pulse.play();
//            pulse.setOnFinished(event1 -> pulse2.play());
//            pulse2.setOnFinished(event1 -> slideOutUp.play());
//        });
//
//        Thread processThread = new Thread(() ->{
//            setPeriodoDeOptimizacion();
//            setCriterioDeProduccionATR();
//            setCriterioWhMallas();
//            maestros.leerInput(escenarioSelected);
//            new RunWriteResultados().runSimulador();
//            rootMenu[0] = null;
//            try {
//                rootMenu[0] = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            sceneMenu[0] = new Scene(rootMenu[0]);
//        });
//
//        processThread.start();
//        animationThread.start();
//
//        animationThread.join();
//        slideOutUp.setOnFinished(e -> {
//            try {
//                processThread.join();
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            borderlessWindow(rootMenu[0], primaryStage);
//            primaryStage.setScene(sceneMenu[0]);
//        });
//
//

    }

    public void setPeriodoDeOptimizacion() {
//        if (rbtnM0Completo.isSelected()) {
//            Date fechaFin = addToDate(fechaInicioProduccion, TimeUnits.MONTH, 1);
//            fechaFin.setHours(6);
//            maestros.fechaFin = fechaFin;
//            fechaFinProduccion = fechaFin;
//        } else if (rbtnM1Completo.isSelected()) {
//            Date fechaFin = addToDate(fechaInicioProduccion, TimeUnits.MONTH, 2);
//            fechaFin.setHours(6);
//            maestros.fechaFin = fechaFin;
//            fechaFinProduccion = fechaFin;
//        } else if (rbtnHorizontePredeterminado.isSelected()) {
//            String fechaFinString = textFieldFechaFin.getText();
//            Date fechaFin = stringToDate(fechaFinString);
//            fechaFin = addToDate(fechaFin, TimeUnits.DAY,1);
//            fechaFin.setHours(6);
//            maestros.fechaFin = fechaFin;
//            fechaFinProduccion = fechaFin;
//        }
    }

    public void setCriterioDeProduccionATR(){
//        if (rbtnCarretesLlenos.isSelected()){
//            maestros.carreteSiempreLleno = true;
//        } else if (rbtnLlenadoParcial.isSelected()){
//            maestros.carreteSiempreLleno = false;
//            maestros.demandaLimiteLlenadoParical = (Double.parseDouble(textFieldDemandaLimite.getText()))/100;
//            maestros.llenadoMinimoDeCarrete = Double.parseDouble(textFieldLlenadoMinimo.getText());
//        }
    }

    public void setCriterioWhMallas(){
//        if (rbtnSinMezcla.isSelected()){
//            maestros.almacenMallasConMezclaDeProductos = false;
//        } else if (rbtnConMezcla.isSelected()) {
//            maestros.almacenMallasConMezclaDeProductos = true;
//        }
    }

    @FXML
    private void handleLabelFechaFin(ActionEvent event){
        if (event.getSource() == rbtnHorizontePredeterminado){
            textFieldFechaFin.setDisable(false);
        } else{
            textFieldFechaFin.setDisable(true);
        }
    }

    @FXML
    private void handleLabelsProduccionATR(ActionEvent event){
        if (event.getSource() == rbtnLlenadoParcial){
            textFieldDemandaLimite.setDisable(false);
            textFieldLlenadoMinimo.setDisable(false);
        } else{
            textFieldDemandaLimite.setDisable(true);
            textFieldLlenadoMinimo.setDisable(true);
        }
    }

    @FXML
    private void handleLabelLlenadoMaximo(ActionEvent event){
        if (event.getSource() == rbtnConMezcla){
            textFieldLlenadoMaximoAlmacen.setDisable(false);
        } else{
            textFieldLlenadoMaximoAlmacen.setDisable(true);
        }
    }

    @FXML
    private void handleEleccionEscenario(MouseEvent event) throws IOException {
//        taDescripcionEscenarios.setText(descripcionEscenarios.get(listEscenarios.getSelectionModel().getSelectedItem())[0]);
//        labelFechaInicioProduccion.setText(descripcionEscenarios.get(listEscenarios.getSelectionModel().getSelectedItem())[2]);
//        fechaInicioProduccion = stringToDate(labelFechaInicioProduccion.getText());
    }

    public Date stringToDate(String dateString){
        int dia = Integer.parseInt(dateString.substring(0,dateString.indexOf('/')));
        int mes = Integer.parseInt(dateString.substring(dateString.indexOf('/')+1, dateString.indexOf('/', dateString.indexOf('/') + 1)));
        int año = Integer.parseInt(dateString.substring(dateString.indexOf('/', dateString.indexOf('/') + 1)+1));
        Date date = new Date();
        date.setDate(dia);
        date.setMonth(mes-1);
        date.setYear(año -1900);
        return  date;
    }

    public static String dateToString(Date date){
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
    }

    @FXML
    public void initialize() {
//        loadEscenarios();
//        listEscenarios.getSelectionModel().select(0);
//        taDescripcionEscenarios.setText(descripcionEscenarios.get(listEscenarios.getSelectionModel().getSelectedItem())[0]);
//        labelFechaInicioProduccion.setText(descripcionEscenarios.get(listEscenarios.getSelectionModel().getSelectedItem())[2]);
//
//        btnComparacion.setDisable(true);
//
//        rbtnM0Completo.setSelected(true);
//        rbtnCarretesLlenos.setSelected(true);
//        rbtnSinMezcla.setSelected(true);
//        textFieldFechaFin.setDisable(true);
//        textFieldDemandaLimite.setDisable(true);
//        textFieldLlenadoMinimo.setDisable(true);
//        textFieldLlenadoMaximoAlmacen.setDisable(true);
//        new FadeIn(mainLayout).play();
    }

    private void loadEscenarios() {
//        for (String escenario :
//                descripcionEscenarios.keySet()) {
//            listEscenarios.getItems().add(escenario);
//        }
    }
}
