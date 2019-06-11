/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DaoServer;
import view.TelaPrincipal;

/**
 *
 * @author William
 */
public class TelaPrincipalFacade {

    DaoServer daoServer;
    TelaPrincipal telaPrincipal;

    public TelaPrincipalFacade() {
        daoServer = new DaoServer();
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.setVisible(true);
    }

    public void pegaNovaTemperaturaAction() {
        Double retorno = daoServer.retornaTemperatura();
        telaPrincipal.getButtonClick().setText(decimalFormat(retorno) + "ºC em Palhoça/SC");
    }

    public static String decimalFormat(Double numero) {
        java.text.DecimalFormat df = new java.text.DecimalFormat();
        df.applyPattern("###,###,##0.00");
        return df.format(numero);
    }

}
