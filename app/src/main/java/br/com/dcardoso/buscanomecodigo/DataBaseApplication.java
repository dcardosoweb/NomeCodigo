package br.com.dcardoso.buscanomecodigo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {NomeCodigo.class},version = 1, exportSchema = false)
public abstract class DataBaseApplication extends RoomDatabase {

    public abstract INomeCodigoRepository nomeCodigoRepository();
}
