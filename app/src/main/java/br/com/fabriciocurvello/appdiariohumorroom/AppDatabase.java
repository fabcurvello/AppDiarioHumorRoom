package br.com.fabriciocurvello.appdiariohumorroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {RegistroDeHumor.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RegistroDeHumorDao registroDeHumorDao();
}
