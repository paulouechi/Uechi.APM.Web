/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uechi.util;

import java.util.Date;

/**
 *
 * @author paulo.uechi
 */
public class arquivo {

    public String Nome;
    public String Atributo;
    public String Diretorio;
    public String Caminho;
    public long Tamamho;
    public Date Criacao;
    public Date Acesso;
    public Date Gravacao;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getAtributo() {
        return Atributo;
    }

    public void setAtributo(String Atributo) {
        this.Atributo = Atributo;
    }

    public String getDiretorio() {
        return Diretorio;
    }

    public void setDiretorio(String Diretorio) {
        this.Diretorio = Diretorio;
    }

    public String getCaminho() {
        return Caminho;
    }

    public void setCaminho(String Caminho) {
        this.Caminho = Caminho;
    }

    public long getTamamho() {
        return Tamamho;
    }

    public void setTamamho(long Tamamho) {
        this.Tamamho = Tamamho;
    }

    public Date getCriacao() {
        return Criacao;
    }

    public void setCriacao(Date Criacao) {
        this.Criacao = Criacao;
    }

    public Date getAcesso() {
        return Acesso;
    }

    public void setAcesso(Date Acesso) {
        this.Acesso = Acesso;
    }

    public Date getGravacao() {
        return Gravacao;
    }

    public void setGravacao(Date Gravacao) {
        this.Gravacao = Gravacao;
    }

    
}
