package br.com.fabriciocurvello.appdiariohumorroom;

import androidx.room.Entity;

import java.util.Date;

@Entity(tableName = "registros_humor")
public class RegistroDeHumor {

    private int id;
    private Date data;
    private int humor;
    private String motivo;

    // construtor (sem id)
    public RegistroDeHumor(Date data, int humor, String motivo) {
        this.data = data;
        this.humor = humor;
        this.motivo = motivo;
    }

    // getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHumor() {
        return humor;
    }

    public void setHumor(int humor) {
        this.humor = humor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
