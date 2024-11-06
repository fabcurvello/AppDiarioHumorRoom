package br.com.fabriciocurvello.appdiariohumorroom;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.Objects;

@Entity(tableName = "registros_humor")
public class RegistroDeHumor {

    @PrimaryKey(autoGenerate = true)
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

    // Sobrescrita dos métodos equals e hashCode (sem modificações, apenas gerado automaticamente)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroDeHumor that = (RegistroDeHumor) o;
        return id == that.id &&
                humor == that.humor &&
                Objects.equals(data, that.data) &&
                Objects.equals(motivo, that.motivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, humor, motivo);
    }
}
