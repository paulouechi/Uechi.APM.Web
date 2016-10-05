/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paulo.uechi
 */
public class tratar {

        private static String strRetorno;
        private static int intRetorno;
        private static short shoRetorno;
        private static long lngRetorno;
        private static Boolean BooRetorno;
        private static Date datRetorno;
        private static float fltRetorno;
        private static byte bytRetorno;
        private static double dobRetorno;
        
        public static double ToDoubleDBNull(String strColuna)
        {
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    dobRetorno = Double.parseDouble(strColuna);
                }
            } catch (Exception e) {
                dobRetorno = 0;
            }
            return dobRetorno;
        }
        
        public static String ToStringDBNull(String strColuna)
        {
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    strRetorno = strColuna.toString();
                }
            } catch (Exception e) {
                strRetorno = "";
            }
            return strRetorno;
        }
        
        public static int ToIntDBNull(String strColuna)
        {
            intRetorno = 0;
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    intRetorno = Integer.parseInt(strColuna);
                }
            } catch (Exception e) {
                intRetorno = 0;
            }
            return intRetorno;
        }
        
        public static short ToShortDBNull(String strColuna)
        {
            shoRetorno = 0;
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    shoRetorno = Short.valueOf(strColuna);
                }
            } catch (Exception e) {
                shoRetorno = 0;
            }
            return shoRetorno;
        }
        
        public static long ToLongDBNull(String strColuna)
        {
            lngRetorno = 0;
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    lngRetorno = Long.valueOf(strColuna);
                }
            } catch (Exception e) {
                lngRetorno = 0;
            }
            return lngRetorno;
        }
    
        public static Boolean ToBooleanDBNull(String strColuna)
        {
            BooRetorno = false;
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty()) {
                    if (strColuna == "1" || strColuna == "0"){
                        if (strColuna == "1"){ 
                            BooRetorno = true;
                        } else {
                            BooRetorno = false;
                        }
                    } else {
                        BooRetorno = Boolean.parseBoolean(strColuna);
                    }
                }
            } catch (Exception e) {
                BooRetorno = false;
            }
            return BooRetorno;
        }
        
        public static Date ToDateDBNull(String strColuna) throws ParseException
        {
            SimpleDateFormat objFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try
            {
                if (strColuna.length() == 10){
                    strColuna = strColuna + " 00:00:00";
                }
                if (strColuna.indexOf("/") != -1){
                    strColuna = strColuna.replace("/", "-");
                }
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    datRetorno = objFmt.parse(strColuna);
                }
            } catch (Exception e) {
                datRetorno = objFmt.parse(tempo.pegaDataHoraExt24H());
            }
            return datRetorno;
        }
        
        public static Date TodateDBNull(String strColuna) throws ParseException
        {
            SimpleDateFormat objFmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            try
            {
                if (strColuna.length() == 10){
                    strColuna = strColuna + " 00:00:00";
                }
                if (strColuna.length() == 0){
                    datRetorno = objFmt.parse(tempo.pegaDataHoraBrz24H());
                } else{
                    datRetorno = objFmt.parse(strColuna);
                    if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                    {
                        datRetorno = objFmt.parse(strColuna);
                    }
                }
            } catch (Exception e) {
                datRetorno = objFmt.parse(tempo.pegaDataHoraExt24H());
            }
            return datRetorno;
        }
        
        public static float ToFloatDBNull(String strColuna)
        {
            fltRetorno = 0;
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    fltRetorno = Float.parseFloat(strColuna);
                }
            } catch (Exception e) {
                fltRetorno = 0;
            }
            return fltRetorno;
        }
        
        public static byte ToByteDBNull(String strColuna)
        {
            bytRetorno = 0;
            try
            {
                if (strColuna != null || strColuna != "" || !strColuna.isEmpty())
                {
                    bytRetorno = Byte.valueOf(strColuna);
                }
            } catch (Exception e) {
                bytRetorno = 0;
            }
            return bytRetorno;
        }
        
    
}
