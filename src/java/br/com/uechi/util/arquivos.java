/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author paulo.uechi
 */
public class arquivos {

    public static String strReturnMessage;

    // Lista Arquivos
    public static ArrayList listarArquivos(String strDiretorio) throws IOException {
        ArrayList arrLstArquivos = new ArrayList();
        try {
            File objDir = new File(strDiretorio);
            File objFilLst[] = objDir.listFiles();
            for (int i = 0; i < objFilLst.length; i++) {
                File arquivos = objFilLst[i];
                arrLstArquivos.add(arquivos.getName());
            }
        } catch (Exception e) {
            strReturnMessage = e.getMessage();
            arrLstArquivos = null;
        }
        return arrLstArquivos;
    }

    // Lista Arquivos Extensao
    public static ArrayList listarArquivosEspecificos(String strDiretorio, String strArquivoExtensao) throws IOException {
        ArrayList listaArquivos = new ArrayList();
        strReturnMessage = "";
        try {
            File diretorio = new File(strDiretorio);
            File fList[] = diretorio.listFiles();
            for (int i = 0; i < fList.length; i++) {
                File arquivos = fList[i];
                if (arquivos.getName().toLowerCase().endsWith(strArquivoExtensao)) {
                    listaArquivos.add(arquivos.getName());
                }
            }
        } catch (Exception e) {
            strReturnMessage = e.getMessage();
        }
        return listaArquivos;
    }

    // Lista Arquivos Tipados
    public static ArrayList<arquivo> listarArquivosTipado(String strDiretorio) {
        ArrayList<arquivo> arqLst = null;
        strReturnMessage = "";
        try {
            Path objPath = Paths.get(strDiretorio);
            if (Files.isDirectory(objPath, LinkOption.NOFOLLOW_LINKS)) {
                arqLst = new ArrayList<arquivo>();
                File filDiretorio = new File(strDiretorio);
                File filLst[] = filDiretorio.listFiles();

                for (int intCnt = 0; intCnt < filLst.length; intCnt++) {
                    arquivo objArq = new arquivo();
                    File arqFil = filLst[intCnt];
                    BasicFileAttributes objAtr = Files.readAttributes(arqFil.toPath(), BasicFileAttributes.class);
                    FileTime objFtm = objAtr.creationTime();
                    Date dttMod = new Date(arqFil.lastModified());
                    objArq.Nome = arqFil.getName();
                    objArq.Criacao = tratar.ToDateDBNull(objFtm.toString());
                    objArq.Gravacao = dttMod;
                    objArq.Acesso = dttMod;
                    objArq.Diretorio = arqFil.getAbsolutePath();
                    objArq.Caminho = arqFil.getAbsoluteFile().toString();
                    objArq.Tamamho = arqFil.length();
                    objArq.Atributo = "";
                    if (arqFil.isHidden()) {
                        objArq.Atributo += "S";
                    }
                    if (arqFil.canExecute()) {
                        objArq.Atributo += "A";
                    }
                    if (arqFil.canRead()) {
                        objArq.Atributo += "R";
                    }
                    if (arqFil.canWrite()) {
                        objArq.Atributo += "W";
                    }
                    arqLst.add(objArq);
                }
            } else {
                strReturnMessage = "Diretório inexistente.";
            }
        } catch (Exception e) {
            arqLst = null;
            strReturnMessage = e.getMessage();
        }
        return arqLst;
    }

    // Lista Diretorios Tipados
    public static ArrayList<diretorio> listarDiretoriosTipado(String strDiretorio) {
        ArrayList<diretorio> arqLst = null;
        strReturnMessage = "";
        try {
            Path objPath = Paths.get(strDiretorio);
            if (Files.isDirectory(objPath, LinkOption.NOFOLLOW_LINKS)) {
                arqLst = new ArrayList<diretorio>();
                File filDiretorio = new File(strDiretorio);
                File filLst[] = filDiretorio.listFiles();

                for (int intCnt = 0; intCnt < filLst.length; intCnt++) {
                    diretorio objArq = new diretorio();
                    File arqFil = filLst[intCnt];
                    objArq.Nome = arqFil.getName();
                    arqLst.add(objArq);
                }
            } else {
                strReturnMessage = "Diretório inexistente.";
            }
        } catch (Exception e) {
            arqLst = null;
            strReturnMessage = e.getMessage();
        }
        return arqLst;
    }

    // Copia Arquivo
    public static Boolean copiarArquivo(String strArquivoOrigem, String strArquivoDestino) throws IOException {
        Boolean booRet = true;
        strReturnMessage = "";
        FileChannel objSrc = null;
        FileChannel objDst = null;
        try {
            File objFilOrg = new File(strArquivoOrigem);
            File objFilDst = new File(strArquivoDestino);

            if (!objFilDst.exists()) {
                objFilDst.createNewFile();
            }
            objSrc = new FileInputStream(objFilOrg).getChannel();
            objDst = new FileOutputStream(objFilDst).getChannel();
            objDst.transferFrom(objSrc, 0, objSrc.size());
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        } finally {
            if (objSrc != null) {
                objSrc.close();
            }
            if (objDst != null) {
                objDst.close();
            }
        }
        return booRet;
    }

    // Apaga Arquivo
    public static Boolean apagarArquivo(String strArquivo) {
        Boolean booRet = true;
        strReturnMessage = "";
        try {
            File objFile = new File(strArquivo);
            if (objFile.isFile()) {
                objFile.delete();
            }
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        }
        return booRet;
    }

    // Apaga Arquivos
    public static Boolean apagarArquivos(File inFile) {
        Boolean booRet = true;
        strReturnMessage = "";
        try {
            //LOG.info("Deletando arquivos do diretorio: " + inFile.getName());
            if (inFile.isFile()) {
                inFile.delete();
            } else {
                File files[] = inFile.listFiles();
                for (int i = 0; i < files.length; i++) {
                    apagarArquivos(files[i]);
                }
            }
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        }
        return booRet;
    }

    // Verifica Arquivo
    public static Boolean verificaArquivo(String strArquivo) {
        Boolean booRet = false;
        strReturnMessage = "";
        try {
            File objFile = new File(strArquivo);
            if (objFile.isFile()) {
                booRet = true;
            }
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        }
        return booRet;
    }

    // Apagar Diretorio
    public static boolean apagarDiretorio(String strDiretorio) throws IOException {
        Boolean booRet = true;
        strReturnMessage = "";
        try {
            File file = new File(strDiretorio);
            file.delete();
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        }
        return booRet;
    }

    // Apagar Diretorio com Arquivos
    public static boolean apagarDiretorioArquivos(String strDiretorio) throws IOException {
        Boolean booRet = true;
        strReturnMessage = "";
        try {
            File objFilDir = new File(strDiretorio);
            if (objFilDir.isDirectory()) {
                File[] objFils = objFilDir.listFiles();
                for (File objFile : objFils) {
                    objFile.delete();
                }
            }
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        }
        return booRet;
    }

    // Criar Arquivo
    public static Boolean criarArquivo(String strNomeDestinoArquivo, String strConteudo) {
        Boolean booRet = true;
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(new File(strNomeDestinoArquivo)));
            br.write(strConteudo);
            br.close();
        } catch (Exception e) {
            strReturnMessage = e.getMessage();
            booRet = false;
        }
        return booRet;
    }

    // Ler Arquivo
    public static String lerArquivo(String strOrigemArquivo) {
        String strRet = "";
        try {

            BufferedReader objBffRed = new BufferedReader(new FileReader(strOrigemArquivo));
            StringBuilder objStrBld = new StringBuilder();
            String strLine = objBffRed.readLine();

            while (strLine != null) {
                objStrBld.append(strLine);
                objStrBld.append("\n");
                strLine = objBffRed.readLine();
            }
            strRet = objStrBld.toString();
        } catch (Exception e) {
            strReturnMessage = e.getMessage();
            strRet = null;
        }
        return strRet;
    }

    // Extensao de Arquivo
    public static String extensaoArquivo(String strArquivoNome) {
        try {
            StringTokenizer st = new StringTokenizer(strArquivoNome, ".");
            if (st.hasMoreElements()) {
                return st.nextElement().toString();
            }
        } catch (Exception e) {
            strReturnMessage = e.getMessage();
        }
        return strArquivoNome;
    }

    // Pesquisa Arquivo
    public Boolean pesquisarArquivo(String strDiretorio, String strArquivo) throws IOException {
        boolean booRet = false;
        strReturnMessage = "";
        try {
            File diretorioEOF = new File(strDiretorio);
            File fListEOF[] = diretorioEOF.listFiles();
            for (int i = 0; i < fListEOF.length; i++) {
                String Listado = fListEOF[i].getName().toUpperCase().toString();
                String Comparado = strArquivo.toUpperCase().toString();
                if (Listado.equals(Comparado)) {
                    booRet = true;
                    break;
                }
            }
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        }
        return booRet;
    }

    // Criar Diretorio
    public static Boolean criarDiretorio(String strDiretorio) {
        Boolean booRet = true;
        strReturnMessage = "";
        try {
            File objDir = new File(strDiretorio);
            if (!objDir.mkdir()) {
                booRet = false;
            }
        } catch (Exception e) {
            booRet = false;
            strReturnMessage = e.getMessage();
        }
        return booRet;

    }

    // Retorno pasta raiz
    public static String diretorioRaiz(String strArquivo) {
        String strReturn;
        try {
            strReturn = System.getProperty("user.dir") + "\\src\\" + strArquivo;
            if (!arquivos.verificaArquivo(strReturn)) {
                strReturn = System.getProperty("user.dir") + "\\" + strArquivo;
                if (!arquivos.verificaArquivo(strReturn)) {
                    strReturn = System.getProperty("user.dir") + "/" + strArquivo;
                    if (!arquivos.verificaArquivo(strReturn)) {
                        strReturn = System.getProperty("user.dir") + "/src/" + strArquivo;
                        if (!arquivos.verificaArquivo(strReturn)) {
                            strReturn = System.getProperty("user.dir") + "/src/br/com/uechi/config/" + strArquivo;
                            if (!arquivos.verificaArquivo(strReturn)) {
                                strReturn = strArquivo;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            strReturn = null;
        }
        return strReturn;
    }

}
