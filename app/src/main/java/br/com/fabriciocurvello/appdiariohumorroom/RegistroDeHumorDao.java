package br.com.fabriciocurvello.appdiariohumorroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RegistroDeHumorDao {

    @Insert
    void inserirRegistro(RegistroDeHumor registro);

    @Query("SELECT * FROM registros_humor ORDER BY data DESC")
    List<RegistroDeHumor> listaRegistros();
}
