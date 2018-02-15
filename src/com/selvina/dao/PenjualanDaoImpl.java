/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.dao;

import com.selvina.entity.Penjualan;
import com.selvina.utility.DaoService;
import com.selvina.utility.HibernateUtil;
import com.selvina.utility.ViewUtil;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Selvina NS (1172149)
 */
public class PenjualanDaoImpl implements DaoService<Penjualan> {

    @Override
    public int tambahData(Penjualan object) {
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
    public int hapusData(Penjualan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ubahData(Penjualan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Penjualan> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Penjualan> penjualans = session.createCriteria(Penjualan.class).
                list();
        session.close();
        return penjualans;
    }

}
