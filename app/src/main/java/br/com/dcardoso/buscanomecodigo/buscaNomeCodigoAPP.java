package br.com.dcardoso.buscanomecodigo;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.Executors;

public class buscaNomeCodigoAPP extends Application {

    private static DataBaseApplication database;
    private static buscaNomeCodigoAPP instance;
    private static AppCompatActivity sharedActivityToViewModel;


    @Override
    public void onCreate() {
        super.onCreate();
        database =
                Room.databaseBuilder(this,
                        DataBaseApplication.class,
                        "busca_nome_codigo")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .addCallback(new RoomDatabase.Callback() {
                            @Override
                            public void onCreate(@NonNull final SupportSQLiteDatabase db) {
                                super.onCreate(db);
                            }
                        })
                        .build();

        instance = this;
    }

    public static DataBaseApplication obterInstanciaDB()
    {
        return database;
    }
}
