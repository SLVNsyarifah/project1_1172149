/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.controller;

import com.selvina.MainApp;
import com.selvina.dao.BarangDaoImpl;
import com.selvina.dao.DetailPenjualanDaoImpl;
import com.selvina.dao.KategoriDaoImpl;
import com.selvina.dao.PenggunaDaoImpl;
import com.selvina.dao.PenjualanDaoImpl;
import com.selvina.entity.Barang;
import com.selvina.entity.DetailPenjualan;
import com.selvina.entity.Kategori;
import com.selvina.entity.Penjualan;
import com.selvina.entity.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Selvina NS (1172149)
 */
public class AdminFormController implements Initializable {

    @FXML
    private BorderPane borderPane;

    private BarangDaoImpl barangDao;
    private PenggunaDaoImpl penggunaDao;
    private PenjualanDaoImpl penjualanDao;
    private DetailPenjualanDaoImpl detailPenjualanDao;
    private KategoriDaoImpl kategoriDao;

    private ObservableList<Barang> barangs;
    private ObservableList<User> penggunas;
    private ObservableList<Penjualan> penjualans;
    private ObservableList<DetailPenjualan> detailPenjualans;
    private ObservableList<Kategori> kategoris;

    private Stage stageKategori;

    public ObservableList<Kategori> getKategoris() {
        if (kategoris == null) {
            kategoris = FXCollections.observableArrayList();
            kategoris.addAll(getKategoriDao().showAllData());
        }
        return kategoris;
    }

    private Stage barangStage;
    private Stage penjualanStage;
    private Stage penggunaStage;

    public BarangDaoImpl getBarangDao() {
        if (barangDao == null) {
            barangDao = new BarangDaoImpl();
        }
        return barangDao;
    }

    public KategoriDaoImpl getKategoriDao() {
        if (kategoriDao == null) {
            kategoriDao = new KategoriDaoImpl();
        }
        return kategoriDao;
    }

    public PenggunaDaoImpl getPenggunaDao() {
        if (penggunaDao == null) {
            penggunaDao = new PenggunaDaoImpl();
        }
        return penggunaDao;
    }

    public PenjualanDaoImpl getPenjualanDao() {
        if (penggunaDao == null) {
            penjualanDao = new PenjualanDaoImpl();
        }
        return penjualanDao;
    }

    public DetailPenjualanDaoImpl getDetailPenjualanDao() {
        if (detailPenjualanDao == null) {
            detailPenjualanDao = new DetailPenjualanDaoImpl();
        }
        return detailPenjualanDao;
    }

    public ObservableList<DetailPenjualan> getDetailPenjualans() {
        if (detailPenjualans == null) {
            detailPenjualans = FXCollections.observableArrayList();
            detailPenjualans.addAll(getDetailPenjualanDao().showAllData());
        }
        return detailPenjualans;
    }

    public ObservableList<Penjualan> getPenjualans() {
        if (penjualans == null) {
            penjualans = FXCollections.observableArrayList();
            penjualans.addAll(getPenjualanDao().showAllData());
        }
        return penjualans;
    }

    public ObservableList<User> getPenggunas() {
        if (penggunas == null) {
            penggunas = FXCollections.observableArrayList();
            penggunas.addAll(getPenggunaDao().showAllData());
        }
        return penggunas;
    }

    public ObservableList<Barang> getBarangs() {
        if (barangs == null) {
            barangs = FXCollections.observableArrayList();
            barangs.addAll(getBarangDao().showAllData());
        }
        return barangs;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnKeluarAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnBarangAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.
                    setLocation(MainApp.class.
                            getResource("view/FormBarang.fxml"));
            BorderPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stageBarang = new Stage();
            stageBarang.setScene(scene);
            stageBarang.setTitle("Form Barang");
            stageBarang.show();
            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnPenggunaAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/FormPengguna.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stagePengguna = new Stage();
            stagePengguna.setScene(scene);
            stagePengguna.setTitle("Form Pengguna");
            stagePengguna.show();
            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mnBarangAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.
                    setLocation(MainApp.class.
                            getResource("view/FormBarang.fxml"));
            BorderPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stageBarang = new Stage();
            stageBarang.setScene(scene);
            stageBarang.setTitle("Form Barang");
            stageBarang.show();
            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mnPenggunaAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/FormPengguna.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root);
            Stage stagePengguna = new Stage();
            stagePengguna.setScene(scene);
            stagePengguna.setTitle("Form Pengguna");
            stagePengguna.show();
            borderPane.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void mnLaporanAction(ActionEvent event) {
    }

    @FXML
    private void mnTentangAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info Developer");
        alert.setContentText("Created by Selvina NS \n 1172149");
        alert.showAndWait();
    }

    @FXML
    private void mnKeluarAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void mnKategoriAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.
                    setLocation(MainApp.class.
                            getResource("view/FormKategori.fxml"));
            AnchorPane root = loader.load();
            FormKategoriController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(root);
            stageKategori = new Stage();
            stageKategori.setScene(scene);
            stageKategori.setTitle("Form Kategori");
//            stageKategori.show();
//            borderPane.getScene().getWindow().hide();

        } catch (IOException ex) {
            Logger.getLogger(AdminFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        if (stageKategori.isShowing() && !stageKategori.isFocused()) {
            stageKategori.toFront();
        } else {
            stageKategori.show();
        }
    }

}
