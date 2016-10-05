/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author paulo.uechi
 */
public class propriedades {

    private String strFileProperties;

    public configuracao configuracao(int intTipo) {
        configuracao objConfiguracao = new configuracao();
        Properties objPropriedades = new Properties();
        try {
            if (intTipo == 0) {
                // For App
                strFileProperties = System.getProperty("user.dir") + "\\src\\" + constantes.strPROPERTIES_FILE;
                if (!arquivos.verificaArquivo(strFileProperties)) {
                    strFileProperties = System.getProperty("user.dir") + "\\" + constantes.strPROPERTIES_FILE;
                    if (!arquivos.verificaArquivo(strFileProperties)) {
                        strFileProperties = System.getProperty("user.dir") + "/" + constantes.strPROPERTIES_FILE;
                        if (!arquivos.verificaArquivo(strFileProperties)) {
                            strFileProperties = System.getProperty("user.dir") + "/src/" + constantes.strPROPERTIES_FILE;
                            if (!arquivos.verificaArquivo(strFileProperties)) {
                                constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - File " + strFileProperties + " not found.\r\n";
                            }
                        }
                    }
                }
                // System.out.println(strFileProperties);
                objPropriedades.load(new FileInputStream(strFileProperties));

                objConfiguracao.setBooRepetir(tratar.ToBooleanDBNull(objPropriedades.getProperty("Repetir")));
                objConfiguracao.setConexaoDBMSQL(tratar.ToStringDBNull(objPropriedades.getProperty("ConexaoDBMSQL")));
                objConfiguracao.setConexaoDBMYSQL(tratar.ToStringDBNull(objPropriedades.getProperty("ConexaoDBMYSQL")));
                objConfiguracao.setStrAplicacao(tratar.ToStringDBNull(objPropriedades.getProperty("IdeAplicacao")));
                objConfiguracao.setlngIntervalo(tratar.ToLongDBNull(objPropriedades.getProperty("Intervalo")));

                objConfiguracao.setBooAgendar(tratar.ToBooleanDBNull(objPropriedades.getProperty("Agendar")));
                objConfiguracao.setIntAgendarTipo(tratar.ToIntDBNull(objPropriedades.getProperty("Agendar_Tipo")));
                objConfiguracao.setDatAgendarInicio(tratar.ToDateDBNull(tempo.pegaData() + " " + objPropriedades.getProperty("Agendar_Inicio")));
                objConfiguracao.setDatAgendarFim(tratar.ToDateDBNull(tempo.pegaData() + " " + objPropriedades.getProperty("Agendar_Fim")));
                constantes.strPROPERTIES_IDEAPLICACAO = objConfiguracao.getStrAplicacao();
            } else if (intTipo == 1) {
                // For Web/WS
                ResourceBundle objRsc;
                try {
                    objRsc = ResourceBundle.getBundle("com.uechi.config." + constantes.strPROPERTIES_FILE.replace(".properties", ""), Locale.getDefault());
                } catch (Exception e) {
                    objRsc = ResourceBundle.getBundle("br.com.uechi.config." + constantes.strPROPERTIES_FILE.replace(".properties", ""), Locale.getDefault());
                }
                try {
                    objConfiguracao.setConexaoLog(tratar.ToStringDBNull(objRsc.getString("ConexaoLogs")));
                } catch (Exception e) {
                    objConfiguracao.setConexaoLog("");
                }
                try {
                    objConfiguracao.setConexaoDBMSQL(tratar.ToStringDBNull(objRsc.getString("ConexaoDBMSQL")));
                } catch (Exception e) {
                    objConfiguracao.setConexaoDBMSQL("");
                }
                try {
                    objConfiguracao.setConexaoDBMYSQL(tratar.ToStringDBNull(objRsc.getString("ConexaoDBMYSQL")));
                } catch (Exception e) {
                    objConfiguracao.setConexaoDBMYSQL("");
                }
                try {
                    objConfiguracao.setBooRepetir(tratar.ToBooleanDBNull(objRsc.getString("Repetir")));
                    objConfiguracao.setStrAplicacao(tratar.ToStringDBNull(objRsc.getString("IdeAplicacao")));
                    objConfiguracao.setlngIntervalo(tratar.ToLongDBNull(objRsc.getString("Intervalo")));
                    objConfiguracao.setBooAgendar(tratar.ToBooleanDBNull(objRsc.getString("Agendar")));
                    objConfiguracao.setIntAgendarTipo(tratar.ToIntDBNull(objRsc.getString("Agendar_Tipo")));
                    objConfiguracao.setDatAgendarInicio(tratar.ToDateDBNull(tempo.pegaDataStr() + " " + objRsc.getString("Agendar_Inicio")));
                    objConfiguracao.setDatAgendarFim(tratar.ToDateDBNull(tempo.pegaDataStr() + " " + objRsc.getString("Agendar_Fim")));
                } catch (Exception e) {
                    objConfiguracao.setBooRepetir(false);
                    objConfiguracao.setStrAplicacao("0");
                    objConfiguracao.setlngIntervalo(0);
                    objConfiguracao.setBooAgendar(false);
                    objConfiguracao.setIntAgendarTipo(0);
                    objConfiguracao.setDatAgendarInicio(tempo.pegaDataHora());
                    objConfiguracao.setDatAgendarFim(tempo.pegaDataHora());
                }

                constantes.strPROPERTIES_IDEAPLICACAO = objConfiguracao.getStrAplicacao();
            }
        } catch (FileNotFoundException e) {
            constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - File not found. Details: " + e.getMessage() + "\r\n";
        } catch (IOException e) {
            constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - Fail read file. Details: " + e.getMessage() + "\r\n";
        } catch (NullPointerException e) {
            constantes.strPROPERTIES_RETURNMESSAGE = "[configuracao] - Fail parameter file. Details: " + e.getMessage() + "\r\n";
        } catch (Exception e) {
            constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - Fail details: " + e.getMessage() + "\r\n";
        }
        return objConfiguracao;
    }

    public String configuracao(int intTipo, String configuracao) {
        Properties objPropriedades = new Properties();
        String strFileProperties;
        String valorConfig = "";
        try {
            if (intTipo == 0) {
                strFileProperties = System.getProperty("user.dir") + "\\src\\" + constantes.strPROPERTIES_FILE;
                if (!arquivos.verificaArquivo(strFileProperties)) {
                    strFileProperties = System.getProperty("user.dir") + "\\" + constantes.strPROPERTIES_FILE;
                    if (!arquivos.verificaArquivo(strFileProperties)) {
                        strFileProperties = System.getProperty("user.dir") + "/" + constantes.strPROPERTIES_FILE;
                        if (!arquivos.verificaArquivo(strFileProperties)) {
                            strFileProperties = System.getProperty("user.dir") + "/src/" + constantes.strPROPERTIES_FILE;
                            if (!arquivos.verificaArquivo(strFileProperties)) {
                                strFileProperties = System.getProperty("user.dir") + "/src/br/com/uechi/config/" + constantes.strPROPERTIES_FILE;
                                if (!arquivos.verificaArquivo(strFileProperties)) {
                                    constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - File " + strFileProperties + " not found.\r\n";
                                }
                            }
                        }
                    }
                }
                try {
                    objPropriedades.load(new FileInputStream(strFileProperties));
                } catch (Exception e) {
                    objPropriedades = null;
                }
                try {
                    valorConfig = tratar.ToStringDBNull(objPropriedades.getProperty(configuracao));
                } catch (Exception e) {
                }
            } else if (intTipo == 1) {
                // For Web/WS
                ResourceBundle objRsc;
                try {
                    objRsc = ResourceBundle.getBundle("com.uechi.config." + constantes.strPROPERTIES_FILE.replace(".properties", ""), Locale.getDefault());
                } catch (Exception e) {
                    objRsc = ResourceBundle.getBundle("br.com.uechi.config." + constantes.strPROPERTIES_FILE.replace(".properties", ""), Locale.getDefault());
                }
                try {
                    valorConfig = tratar.ToStringDBNull(objRsc.getString(configuracao));
                } catch (Exception e) {
                }
            }
        } catch (NullPointerException e) {
            constantes.strPROPERTIES_RETURNMESSAGE = "[configuracao] - Fail parameter file. Details: " + e.getMessage() + "\r\n";
        } catch (Exception e) {
            constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - Fail details: " + e.getMessage() + "\r\n";
        }
        return valorConfig;
    }

    public boolean Gravar(String strPathFile, String configuracao, String strValor) throws IOException {
        boolean booRet = true;
        Properties objPropriedades = new Properties();
        String strFileProperties = "";
        try {
            strFileProperties = strPathFile;
            if (!arquivos.verificaArquivo(strFileProperties)) {
                constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - File " + strFileProperties + " not found.\r\n";
                booRet = false;
            }
            try {
                if (booRet) {
                    // Gravacao
                    FileInputStream objFilInp = new FileInputStream(strFileProperties);
                    objPropriedades.load(objFilInp);
                    objFilInp.close();

                    FileOutputStream objFilOut = new FileOutputStream(strFileProperties);
                    objPropriedades.setProperty(configuracao, strValor);
                    objPropriedades.store(objFilOut, null);
                    objFilOut.close();
                }
            } catch (Exception e) {
                booRet = false;
            }
        } catch (Exception e) {
            booRet = false;
        }
        return booRet;
    }

    public String Leitura(String strPathFile, String configuracao) {
        Properties objPropriedades = new Properties();
        String strFileProperties;
        String valorConfig = "";
        try {
            strFileProperties = strPathFile;
            if (!arquivos.verificaArquivo(strFileProperties)) {
                constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - File " + strFileProperties + " not found.\r\n";
            }
            try {
                objPropriedades.load(new FileInputStream(strFileProperties));
            } catch (Exception e) {
                objPropriedades = null;
            }
            try {
                valorConfig = tratar.ToStringDBNull(objPropriedades.getProperty(configuracao));
            } catch (Exception e) {
            }
        } catch (Exception e) {
            constantes.strPROPERTIES_RETURNMESSAGE += "[configuracao] - Fail details: " + e.getMessage() + "\r\n";
        }
        return valorConfig;
    }
   
}
