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
    private String placa;
    private String cor;
    private int idProprietario;
    private int idVaga;

    public Veiculo(int id, String marca, String modelo, int ano, String placa, String cor, int idProprietario, int idVaga) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.cor = cor;
        this.idProprietario = idProprietario;
        this.idVaga = idVaga;
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
        return idProprietario;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    @Override
    public String toString() {
        return "id: " + id + " | marca: " + marca + " | modelo: " + modelo + " | ano: " + ano + " | placa: " + placa
                + " | cor: " + cor + " | IdProprietario: " + idProprietario + " | IdVaga: " + idVaga;
    }
    
}
