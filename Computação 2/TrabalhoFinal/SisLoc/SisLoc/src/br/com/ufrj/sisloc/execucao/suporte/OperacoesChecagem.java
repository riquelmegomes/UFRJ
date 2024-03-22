package br.com.ufrj.sisloc.execucao.suporte;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OperacoesChecagem {

    /* Método responsável por verificar se uma 'string' é um número do tipo int */
    public boolean ehInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }

    /* Método responsável por verificar se uma 'string' é um número do tipo long */
    public boolean ehLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }

    /* Método responsável por verificar se uma 'string' é um número do tipo float */
    public boolean ehFloat(String s) {
        try {
            Float.parseFloat(s);
            return false;
        }
        catch (NumberFormatException ex) {
            return true;
        }
    }

    /* Método responsável por verificar se uma 'string' esta em um formato de data */
    public boolean ehDate(String s) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.parse(s);
            return false;
        }
        catch (NumberFormatException | ParseException ex) {
            return true;
        }
    }

}
