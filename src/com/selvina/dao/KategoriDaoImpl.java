/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.dao;

import com.selvina.entity.Kategori;
import com.selvina.utility.DaoService;
import com.selvina.utility.HibernateUtil;
import com.selvina.utility.ViewUtil;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 *
 * @author Selvina NS (1172149)
 */
public class KategoriDaoImpl implements DaoService<Kategori> {

    @Override
    public int tambahData(Kategori object) {
        int result = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.
                    showAlert(Alert.AlertType.ERROR, "ERROR", e.getMessage());
        }
        return result;
    }

    @Override
    public int hapusData(Kategori object) {
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
    public int ubahData(Kategori object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Kategori> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Kategori> kategoris = session.createCriteria(Kategori.class).
                addOrder(Order.asc("id")).list();
        session.close();
        return kategoris;
    }

}
