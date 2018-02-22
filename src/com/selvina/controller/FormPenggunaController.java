/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Selvina NS (1172149)
 */
public class FormPenggunaController implements Initializable {

    @FXML
    private Button btnTambah;
    @FXML
    private Button btnUbah;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnReset;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtRePassword;
    @FXML
    private TextField txtNamaLengkap;
    @FXML
    private TextField txtTelepon;
    @FXML
    private ComboBox<?> cmbLevel;
    @FXML
    private TextArea txtAlamat;
    @FXML
    private TableView<?> tableUser;
    @FXML
    private TableColumn<?, ?> colUsername;
    @FXML
    private TableColumn<?, ?> colLevel;
    @FXML
    private TableColumn<?, ?> colNamaLengkap;
    @FXML
    private TableColumn<?, ?> colTelepon;
    @FXML
    private TableColumn<?, ?> colAlamat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnTambahAction(ActionEvent event) {
    }

    @FXML
    private void btnUbahAction(ActionEvent event) {
    }

    @FXML
    private void btnHapusAction(ActionEvent event) {
    }

    @FXML
    private void btnResetAction(ActionEvent event) {
    }

}
