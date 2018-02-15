/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.utility;

import java.util.List;

/**
 *
 * @author Selvina NS (1172149)
 */
public interface DaoService<E> {

    int tambahData(E object);

    int hapusData(E object);

    int ubahData(E object);

    List<E> showAllData();
}
