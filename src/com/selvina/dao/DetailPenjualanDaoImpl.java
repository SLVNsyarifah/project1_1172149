/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.dao;

import com.selvina.entity.DetailPenjualan;
import com.selvina.utility.DaoService;
import com.selvina.utility.HibernateUtil;
import com.selvina.utility.ViewUtil;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Selvina NS (1172149)
 */
public class DetailPenjualanDaoImpl implements DaoService<DetailPenjualan> {

    @Override
    public int tambahData(DetailPenjualan object) {
        int result = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.showAlert(Alert.AlertType.ERROR, "ERROR", e.getMessage());
        }
        return result;
    }

    @Override
    public int hapusData(DetailPenjualan object) {
        int result = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.showAlert(Alert.AlertType.ERROR, "ERROR", e.getMessage());
        }
        return result;
    }

    @Override
    public int ubahData(DetailPenjualan object) {
        int result = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.showAlert(Alert.AlertType.ERROR, "ERROR", e.getMessage());
        }
        return result;
    }

    @Override
    public List<DetailPenjualan> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DetailPenjualan> detailPenjualans = session.createCriteria(
                DetailPenjualan.class).setFetchMode("barang", FetchMode.JOIN).
                setFetchMode("penjualan", FetchMode.JOIN).list();
        session.close();
        return detailPenjualans;
    }

}
