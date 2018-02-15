/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selvina.utility;

import javafx.scene.control.TextInputControl;

/**
 *
 * @author Selvina NS (1172149)
 */
public class TextUtil {

    public static boolean isEmptyField(TextInputControl... textFields) {
        for (TextInputControl textInputControl : textFields) {
            if (textInputControl.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
