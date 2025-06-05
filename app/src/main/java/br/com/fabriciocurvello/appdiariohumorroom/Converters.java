package br.com.fabriciocurvello.appdiariohumorroom;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {

    //Recebe valor númerico do tipo Long e retorna um Date
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    //Recebe valor Date e retorna valor numérico tipo Long
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

}
