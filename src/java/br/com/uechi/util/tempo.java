/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author paulo.uechi
 */
public class tempo {

    public static long pegaDataHoraLng() {
        long dataHoraAtual = 0;
        GregorianCalendar calendario = new GregorianCalendar();
        int hr = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int sec = calendario.get(Calendar.SECOND);
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        dataHoraAtual = Date.UTC(ano, mes, dia, hr, min, sec);

        return dataHoraAtual;
    }

    public static Date pegaDataHora() {
        Calendar objCal = new GregorianCalendar();
        return objCal.getTime();
    }

    public static Date pegaData() {
        Calendar objCal = new GregorianCalendar();
        objCal.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        objCal.set(Calendar.MINUTE, 0);
        objCal.set(Calendar.SECOND, 0);
        return objCal.getTime();
    }

    public static String pegaDataStr() {
        String dataAtual = null;
        String dias = null;
        String meses = null;

        GregorianCalendar calendario = new GregorianCalendar();
        int hr = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int sec = calendario.get(Calendar.SECOND);
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        if (dia > 0 & dia < 10) {
            dias = "0" + Integer.toString(dia);
        } else {
            dias = String.valueOf(dia);
        }

        if (mes > 0 & mes < 10) {
            meses = "0" + Integer.toString(mes);
        } else {
            meses = String.valueOf(mes);
        }

        dataAtual = ano + "-" + meses + "-" + dias;

        return dataAtual;
    }

    public static String pegaContaData(int intDias, Date dttPar) {
        String dataHoraAtual = null;
        String meses = null;
        String dias = null;

        // Calendar calendar = Calendar.getInstance(); // this would default to now
        // calendar.add(Calendar.DAY_OF_MONTH, -5).        
        GregorianCalendar calendario = new GregorianCalendar();
        calendario.setTime(dttPar);
        calendario.add(Calendar.DAY_OF_MONTH, intDias);
        int hr = 23;
        int min = 59;
        int sec = 59;
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        //ano -= 2000;
        if (mes > 0 & mes < 10) {
            meses = "0" + Integer.toString(mes);
        } else {
            meses = String.valueOf(mes);
        }

        if (dia > 0 & dia < 10) {
            dias = "0" + Integer.toString(dia);
        } else {
            dias = String.valueOf(dia);
        }

        dataHoraAtual = ano + "/" + meses + "/" + dias;
        return dataHoraAtual;
    }

    public static String pegaSubData(int intDiasMenos) {
        String dataHoraAtual = null;
        String meses = null;
        String dias = null;

        // Calendar calendar = Calendar.getInstance(); // this would default to now
        // calendar.add(Calendar.DAY_OF_MONTH, -5).        
        
        GregorianCalendar calendario = new GregorianCalendar();
        calendario.add(Calendar.DAY_OF_MONTH, intDiasMenos);
        int hr = 23;
        int min = 59;
        int sec = 59;
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        //ano -= 2000;
        if (mes > 0 & mes < 10) {
            meses = "0" + Integer.toString(mes);
        } else {
            meses = String.valueOf(mes);
        }

        if (dia > 0 & dia < 10) {
            dias = "0" + Integer.toString(dia);
        } else {
            dias = String.valueOf(dia);
        }

        dataHoraAtual = ano + "/" + meses + "/" + dias;
        return dataHoraAtual;
    }

    public static String pegaDataHora12H() {
        String dataHoraAtual = null;
        String indicador24h = null;
        String minutos = null;
        String segundos = null;

        GregorianCalendar calendario = new GregorianCalendar();
        int hr = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int sec = calendario.get(Calendar.SECOND);
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        if (hr > 12) {
            indicador24h = "PM";
        } else {
            indicador24h = "AM";
        }

        if (hr == 0) {
            hr = 12;
        } else if (hr > 12) {
            hr -= 12;
        }

        if (min == 0) {
            minutos = "00";
        } else if (min > 0 & min < 10) {
            minutos = "0" + Integer.toString(min);
        } else {
            minutos = Integer.toString(min);
        }

        if (sec == 0) {
            segundos = "00";
        } else if (min > 0 & sec < 10) {
            segundos = "0" + Integer.toString(sec);
        } else {
            segundos = Integer.toString(sec);
        }

        ano -= 2000;
        dataHoraAtual = mes + "/" + dia + "/" + ano + " " + hr + ":" + minutos + ":" + segundos + " " + indicador24h;

        return dataHoraAtual;
    }

    public static String pegaDataHoraExt24H() {
        String dataHoraAtual = null;
        String horas = null;
        String minutos = null;
        String segundos = null;
        String meses = null;
        String dias = null;

        GregorianCalendar calendario = new GregorianCalendar();
        int hr = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int sec = calendario.get(Calendar.SECOND);
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        if (hr == 0) {
            horas = "00";
        } else if (hr > 0 & hr < 10) {
            horas = "0" + Integer.toString(hr);
        } else {
            horas = Integer.toString(hr);
        }

        if (min == 0) {
            minutos = "00";
        } else if (min > 0 & min < 10) {
            minutos = "0" + Integer.toString(min);
        } else {
            minutos = Integer.toString(min);
        }

        if (sec == 0) {
            segundos = "00";
        } else if (sec > 0 & sec < 10) {
            segundos = "0" + Integer.toString(sec);
        } else {
            segundos = Integer.toString(sec);
        }

        if (mes > 0 & mes < 10) {
            meses = "0" + Integer.toString(mes);
        } else {
            meses = String.valueOf(mes);
        }

        if (dia > 0 & dia < 10) {
            dias = "0" + Integer.toString(dia);
        } else {
            dias = String.valueOf(dia);
        }

        dataHoraAtual = ano + "-" + meses + "-" + dias + " " + horas + ":" + minutos + ":" + segundos;

        return dataHoraAtual;
    }

    public static String pegaDataHoraBrz24H() {
        String dataHoraAtual = null;
        String horas = null;
        String minutos = null;
        String segundos = null;
        String meses = null;
        String dias = null;

        GregorianCalendar calendario = new GregorianCalendar();
        int hr = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int sec = calendario.get(Calendar.SECOND);
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        if (hr == 0) {
            horas = "00";
        } else if (hr > 0 & hr < 10) {
            horas = "0" + Integer.toString(hr);
        } else {
            horas = Integer.toString(hr);
        }

        if (min == 0) {
            minutos = "00";
        } else if (min > 0 & min < 10) {
            minutos = "0" + Integer.toString(min);
        } else {
            minutos = Integer.toString(min);
        }

        if (sec == 0) {
            segundos = "00";
        } else if (sec > 0 & sec < 10) {
            segundos = "0" + Integer.toString(sec);
        } else {
            segundos = Integer.toString(sec);
        }

        if (mes > 0 & mes < 10) {
            meses = "0" + Integer.toString(mes);
        } else {
            meses = String.valueOf(mes);
        }

        if (dia > 0 & dia < 10) {
            dias = "0" + Integer.toString(dia);
        } else {
            dias = String.valueOf(dia);
        }

        dataHoraAtual = dias + "/" + meses + "/" + ano + " " + horas + ":" + minutos + ":" + segundos;

        return dataHoraAtual;
    }

    public static String pegaDataHora24H() {
        String dataHoraAtual = null;
        String horas = null;
        String minutos = null;
        String segundos = null;
        String meses = null;
        String dias = null;

        GregorianCalendar calendario = new GregorianCalendar();
        int hr = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int sec = calendario.get(Calendar.SECOND);
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        if (hr == 0) {
            horas = "00";
        } else if (hr > 0 & hr < 10) {
            horas = "0" + Integer.toString(hr);
        } else {
            horas = Integer.toString(hr);
        }

        if (min == 0) {
            minutos = "00";
        } else if (min > 0 & min < 10) {
            minutos = "0" + Integer.toString(min);
        } else {
            minutos = Integer.toString(min);
        }

        if (sec == 0) {
            segundos = "00";
        } else if (sec > 0 & sec < 10) {
            segundos = "0" + Integer.toString(sec);
        } else {
            segundos = Integer.toString(sec);
        }

        //ano -= 2000;
        if (mes > 0 & mes < 10) {
            meses = "0" + Integer.toString(mes);
        } else {
            meses = String.valueOf(mes);
        }

        if (dia > 0 & dia < 10) {
            dias = "0" + Integer.toString(dia);
        } else {
            dias = String.valueOf(dia);
        }

        //dataHoraAtual = meses + "/" + dias + "/" + ano + " " + horas + ":" + minutos + ":" + segundos; 
        dataHoraAtual = ano + "/" + meses + "/" + dias + " " + horas + ":" + minutos + ":" + segundos;
        return dataHoraAtual;
    }
    
    public static String geraDataExpiracaoDocumentos(String dataExpiracao) {

        int quantidadeTempo = 0;
        String tipoTempo = null;
        if (dataExpiracao.length() == 2) {
            quantidadeTempo = Integer.parseInt(dataExpiracao.substring(0, 1));
            tipoTempo = dataExpiracao.substring(1, 2);
        } else {
            quantidadeTempo = Integer.parseInt(dataExpiracao.substring(0, dataExpiracao.length() - 1));
            tipoTempo = dataExpiracao.substring(dataExpiracao.length() - 1, dataExpiracao.length());
        }
        Date d = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

        if (tipoTempo.equals("D")) {
            c.setTime(d);
            c.add(Calendar.DAY_OF_MONTH, quantidadeTempo);
        }
        if (tipoTempo.equals("M")) {
            c.setTime(d);
            c.add(Calendar.MONTH, quantidadeTempo);
        }
        if (tipoTempo.equals("A")) {
            c.setTime(d);
            c.add(Calendar.YEAR, quantidadeTempo);
        }
        return df.format(c.getTime());
    }

    public static String retornaDatas(int intOptFmt, Date datObject) {
        String strRet;
        try
        {
            String strFmt;
            if (intOptFmt == 1){
                strFmt = "yyyy-MM-dd HH:mm:ss";
            } else if (intOptFmt == 2 ){
                strFmt = "yyyy/MM/dd HH:mm:ss";
            } else if (intOptFmt == 3 ){
                strFmt = "yyyy/MM/dd HH:mm:ss";
            } else if (intOptFmt == 4 ){
                strFmt = "yyyy/MM/dd";
            } else if (intOptFmt == 5 ){
                strFmt = "yyyy/MM/dd";
            } else if (intOptFmt == 6){
                strFmt = "dd-MM-yyyy HH:mm:ss";
            } else if (intOptFmt == 7){
                strFmt = "dd/MM/yyyy HH:mm:ss";
            } else if (intOptFmt == 8){
                strFmt = "dd/MM/yyyy HH:mm:ss";
            } else if (intOptFmt == 9){
                strFmt = "dd/MM/yyyy";
            } else if (intOptFmt == 10){
                strFmt = "dd/MM/yyyy";
            } else if (intOptFmt == 11){
                strFmt = "ddMMyyyyHHmmss";
            } else {
                strFmt = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat objFmt;
            strRet = (new SimpleDateFormat(strFmt).format(datObject));
        } catch (Exception e) {
            strRet = null;
        }
        return strRet;
    }
    
    public static String retornaTempo(long lngValor){
        String strRet = "";
        try {
        strRet = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(lngValor),
            TimeUnit.MILLISECONDS.toMinutes(lngValor) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(lngValor)),
            TimeUnit.MILLISECONDS.toSeconds(lngValor) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(lngValor)));
        } catch (Exception e) {
            strRet = "";
        }
        return strRet;
    }
    
    public static String retornaFormataData(int intOpt, Date datObject) {
        String strRet = "";
        try
        {
            Calendar objCal = Calendar.getInstance();
            objCal.setTime(datObject);
            int intMes = objCal.get(Calendar.MONTH);
            int intAno = objCal.get(Calendar.YEAR);
            if (intOpt == 1){
                // strRet = objCal.get(Calendar.DAY_OF_WEEK);
                strRet = convertRetorno(2, objCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US)) + " " + String.valueOf(objCal.get(Calendar.DAY_OF_WEEK)) + " de " +  convertRetorno(5, String.valueOf(intMes)) + " de " + String.valueOf(intAno);
            } else {
                strRet = "";
            }
        } catch (Exception e) {
            strRet = null;
        }
        return strRet;
    }
    
    public static String convertRetorno(int intOpt, String strValor){
        String strRet = "";
        try {
            if (intOpt == 1){
                // Dia semana abreviada
                if (strValor.toUpperCase().equals("SUN")){
                    strRet = "Dom";
                } else if (strValor.toUpperCase().equals("MON")){
                    strRet = "Seg";
                } else if (strValor.toUpperCase().equals("TUE")){
                    strRet = "Ter";
                } else if (strValor.toUpperCase().equals("WED")){
                    strRet = "Qua";
                } else if (strValor.toUpperCase().equals("THU")){
                    strRet = "Qui";
                } else if (strValor.toUpperCase().equals("FRI")){
                    strRet = "Sex";
                } else if (strValor.toUpperCase().equals("SAT")){
                    strRet = "Sab";
                }
            } else if (intOpt == 2){
                // Dia semana completa
                if (strValor.toUpperCase().equals("SUN")){
                    strRet = "Domingo";
                } else if (strValor.toUpperCase().equals("MON")){
                    strRet = "Segunda";
                } else if (strValor.toUpperCase().equals("TUE")){
                    strRet = "Terça";
                } else if (strValor.toUpperCase().equals("WED")){
                    strRet = "Quarta";
                } else if (strValor.toUpperCase().equals("THU")){
                    strRet = "Quinta";
                } else if (strValor.toUpperCase().equals("FRI")){
                    strRet = "Sexta";
                } else if (strValor.toUpperCase().equals("SAT")){
                    strRet = "Sábado";
                }
            } else if (intOpt == 3){
                // Meses abreviado
                if (strValor.toUpperCase().equals("JAN")){
                    strRet = "Jan";
                } else if (strValor.toUpperCase().equals("FEB")){
                    strRet = "Fev";
                } else if (strValor.toUpperCase().equals("MAR")){
                    strRet = "Mar";
                } else if (strValor.toUpperCase().equals("APR")){
                    strRet = "Abr";
                } else if (strValor.toUpperCase().equals("MAY")){
                    strRet = "Mai";
                } else if (strValor.toUpperCase().equals("JUN")){
                    strRet = "Jun";
                } else if (strValor.toUpperCase().equals("JUL")){
                    strRet = "Jul";
                } else if (strValor.toUpperCase().equals("AUG")){
                    strRet = "Ago";
                } else if (strValor.toUpperCase().equals("SEP")){
                    strRet = "Set";
                } else if (strValor.toUpperCase().equals("OCT")){
                    strRet = "Out";
                } else if (strValor.toUpperCase().equals("NOV")){
                    strRet = "Nov";
                } else if (strValor.toUpperCase().equals("DEC")){
                    strRet = "Dez";
                }
            } else if (intOpt == 4){
                // Meses completo
                if (strValor.toUpperCase().equals("JAN")){
                    strRet = "Janeiro";
                } else if (strValor.toUpperCase().equals("FEB")){
                    strRet = "Fevereiro";
                } else if (strValor.toUpperCase().equals("MAR")){
                    strRet = "Março";
                } else if (strValor.toUpperCase().equals("APR")){
                    strRet = "Abril";
                } else if (strValor.toUpperCase().equals("MAY")){
                    strRet = "Maio";
                } else if (strValor.toUpperCase().equals("JUN")){
                    strRet = "Junho";
                } else if (strValor.toUpperCase().equals("JUL")){
                    strRet = "Julho";
                } else if (strValor.toUpperCase().equals("AUG")){
                    strRet = "Agosto";
                } else if (strValor.toUpperCase().equals("SEP")){
                    strRet = "Setembro";
                } else if (strValor.toUpperCase().equals("OCT")){
                    strRet = "Outubro";
                } else if (strValor.toUpperCase().equals("NOV")){
                    strRet = "Novembro";
                } else if (strValor.toUpperCase().equals("DEC")){
                    strRet = "Dezembro";
                }
            } else if (intOpt == 5){
                // Meses completo
                if (strValor.toUpperCase().equals("1")){
                    strRet = "Janeiro";
                } else if (strValor.toUpperCase().equals("2")){
                    strRet = "Fevereiro";
                } else if (strValor.toUpperCase().equals("3")){
                    strRet = "Março";
                } else if (strValor.toUpperCase().equals("4")){
                    strRet = "Abril";
                } else if (strValor.toUpperCase().equals("5")){
                    strRet = "Maio";
                } else if (strValor.toUpperCase().equals("6")){
                    strRet = "Junho";
                } else if (strValor.toUpperCase().equals("7")){
                    strRet = "Julho";
                } else if (strValor.toUpperCase().equals("8")){
                    strRet = "Agosto";
                } else if (strValor.toUpperCase().equals("9")){
                    strRet = "Setembro";
                } else if (strValor.toUpperCase().equals("10")){
                    strRet = "Outubro";
                } else if (strValor.toUpperCase().equals("11")){
                    strRet = "Novembro";
                } else if (strValor.toUpperCase().equals("12")){
                    strRet = "Dezembro";
                }
            }
        } catch (Exception e) {
            strRet = null;
        }
        return strRet;
    }
    
    public static String convertData(int intOpt, String strValor){
        String strReturn = null;
        String strFormat;
        Date objDtt;
        Calendar objCal = new GregorianCalendar();
        try {
            objDtt = tratar.TodateDBNull(strValor);
        } catch (Exception e) {
            objCal.set(Calendar.HOUR_OF_DAY, 0);
            objCal.set(Calendar.MINUTE, 0);
            objCal.set(Calendar.SECOND, 0);
            objDtt = objCal.getTime();
        }
        try {
            if (intOpt == 1){
                strFormat = "yyyy-MM-dd HH:mm:ss";
            } else if (intOpt == 2 ){
                strFormat = "yyyy/MM/dd HH:mm:ss";
            } else if (intOpt == 3 ){
                strFormat = "yyyy/MM/dd HH:mm:ss";
            } else if (intOpt == 4 ){
                strFormat = "yyyy/MM/dd";
            } else if (intOpt == 5 ){
                strFormat = "yyyy/MM/dd";
            } else if (intOpt == 6){
                strFormat = "dd-MM-yyyy HH:mm:ss";
            } else if (intOpt == 7){
                strFormat = "dd/MM/yyyy HH:mm:ss";
            } else if (intOpt == 8){
                strFormat = "dd/MM/yyyy HH:mm:ss";
            } else if (intOpt == 9){
                strFormat = "dd/MM/yyyy";
            } else if (intOpt == 10){
                strFormat = "dd/MM/yyyy";
            } else if (intOpt == 11){
                strFormat = "HH:mm:ss dd/MM/yyyy";
            } else {
                strFormat = "yyyy-MM-dd HH:mm:ss";
            }
            SimpleDateFormat objFmt;
            strReturn = (new SimpleDateFormat(strFormat).format(objDtt));
        } catch (Exception e) {
            strReturn = null;
        }
        return strReturn;
    }
    
}
