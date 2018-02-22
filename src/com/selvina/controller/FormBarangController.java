/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.controller;

import com.selvina.MainApp;
import com.selvina.entity.Barang;
import com.selvina.entity.Kategori;
import com.selvina.utility.TextUtil;
import com.selvina.utility.ViewUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Selvina NS (1172149)
 */
public class FormBarangController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private TableColumn<Barang, String> colId;
    @FXML
    private TableColumn<Barang, String> colNamaBarang;
    @FXML
    private TableColumn<Barang, Float> colHarga;
    @FXML
    private TableColumn<Barang, Integer> colStok;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNamaBarang;
    @FXML
    private TextField txtHargaBarang;
    @FXML
    private TextField txtStok;
    @FXML
    private ComboBox<Kategori> cmbKategori;
    @FXML
    private TableColumn<Barang, String> colKategori;
    @FXML
    private TableView<Barang> tableBarang;
    @FXML
    private Button btnTambah;
    @FXML
    private Button btnUbah;
    @FXML
    private Button btnHapus;
    @FXML
    private Button btnReset;

    private Barang selectedBarang;
    private AdminFormController adminController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        cmbKategori.setItems(adminController.getKategoris());
//        tableBarang.setItems(adminController.getBarangs());
        colId.setCellValueFactory(new PropertyValueFactory<>("idBarang"));
        colNamaBarang.setCellValueFactory(new PropertyValueFactory<>(
                "namaBarang"));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
    }

    @FXML
    private void btnKembali(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/AdminForm.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.setTitle("Admin Form");
            secondStage.show();

            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(FormBarangController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnTambah(ActionEvent event) {
        if (!TextUtil.
                isEmptyField(txtId, txtNamaBarang, txtHargaBarang, txtStok)
                || cmbKategori.getSelectionModel().isSelected(0)) {
            Barang barang = new Barang();
            barang.setIdBarang(txtId.getText().trim());
            barang.setNamaBarang(txtNamaBarang.getText().trim());
            barang.setKategori(cmbKategori.getValue());
            barang.setHarga(Float.parseFloat(txtHargaBarang.getText().trim()));
            barang.setStok(Integer.parseInt(txtStok.getText().trim()));
            adminController.getBarangDao().tambahData(barang);
            adminController.getBarangs().clear();
            adminController.getBarangs().addAll(adminController.getBarangDao().
                    showAllData());
            resetFieldDanTombol();
        } else {
            ViewUtil.showAlert(Alert.AlertType.ERROR, "ERROR",
                    "Harap isi seluruh data");
        }
    }

    @FXML
    private void btnUbah(ActionEvent event) {
    }

    @FXML
    private void btnHapus(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi Hapus");
        alert.setContentText("Apakah anda yakin akan menghapus data?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                adminController.getBarangDao().hapusData(selectedBarang);
                adminController.getBarangs().clear();
                adminController.getBarangs().addAll(adminController.
                        getBarangDao().showAllData());
                this.resetFieldDanTombol();
            }
        });
    }

    @FXML
    private void btnReset(ActionEvent event) {
        this.resetFieldDanTombol();
    }

    @FXML
    private void tableBarangMouseClicked(MouseEvent event) {
        selectedBarang = tableBarang.getSelectionModel().getSelectedItem();
        if (selectedBarang != null) {
            txtId.setDisable(true);
            txtId.setText(selectedBarang.getIdBarang());
            txtNamaBarang.setText(selectedBarang.getNamaBarang());
//            cmbKategori.setSelectionModel(selectedBarang.getKategori().getNamaKategori());
            txtHargaBarang.setText(Float.toString(selectedBarang.getHarga()));
            txtStok.setText(Integer.toString(selectedBarang.getStok()));
            btnUbah.setDisable(false);
            btnHapus.setDisable(false);
            btnTambah.setDisable(true);
            btnReset.setDisable(true);
        }
    }

    private void resetFieldDanTombol() {
        txtId.setDisable(false);
        txtNamaBarang.clear();
        cmbKategori.setItems(null);
        txtHargaBarang.clear();
        txtStok.clear();
        btnTambah.setDisable(false);
        btnUbah.setDisable(true);
        btnHapus.setDisable(true);
        selectedBarang = null;
    }
}
