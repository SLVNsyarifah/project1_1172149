/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.controller;

import com.selvina.entity.Kategori;
import com.selvina.utility.TextUtil;
import com.selvina.utility.ViewUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Selvina NS (1172149)
 */
public class FormKategoriController implements Initializable {

    @FXML
    private TextField txtIdKategori;
    @FXML
    private TextField txtNamaKategori;
    @FXML
    private TableView<Kategori> tableKategori;
    @FXML
    private TableColumn<Kategori, String> colIdKategori;
    @FXML
    private TableColumn<Kategori, String> colNamaKategori;

    private AdminFormController mainController;
    private Kategori selectedKategori;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colIdKategori.setCellValueFactory(new PropertyValueFactory<>(
                "idKategori"));
        colNamaKategori.setCellValueFactory(new PropertyValueFactory<>(
                "namaKategori"));
    }

    @FXML
    private void btnSimpanAction(ActionEvent event) {
        if (!TextUtil.isEmptyField(txtNamaKategori)) {
            Kategori kategori = new Kategori();
            kategori.setIdKategori(txtIdKategori.getText().trim());
            kategori.setNamaKategori(txtNamaKategori.getText().trim());
            mainController.getKategoriDao().tambahData(kategori);
            mainController.getKategoris().clear();
            mainController.getKategoris().addAll(
                    mainController.getKategoriDao().showAllData());
        } else {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "ERROR",
                    "Nama Kategori harap diisi");
        }
    }

    public void setMainController(AdminFormController mainController) {
        this.mainController = mainController;
        this.tableKategori.setItems(mainController.getKategoris());
    }
}
