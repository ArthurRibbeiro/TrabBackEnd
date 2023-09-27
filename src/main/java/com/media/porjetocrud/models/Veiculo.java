/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.media.porjetocrud.models;

/**
 *
 * @author samue
 */
public class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    String placa;
    String cor;
    int IdProprietario;
    int IdVaga;

    public Veiculo(int id, String marca, String modelo, int ano, String placa, String cor, int IdProprietario, int IdVaga) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.cor = cor;
        this.IdProprietario = IdProprietario;
        this.IdVaga = IdVaga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdProprietario() {
        return IdProprietario;
    }

    public void setIdProprietario(int IdProprietario) {
        this.IdProprietario = IdProprietario;
    }

    public int getIdVaga() {
        return IdVaga;
    }

    public void setIdVaga(int IdVaga) {
        this.IdVaga = IdVaga;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", placa=" + placa
                + ", cor=" + cor + ", IdProprietario=" + IdProprietario + ", IdVaga=" + IdVaga + "]";
    }
    
}
