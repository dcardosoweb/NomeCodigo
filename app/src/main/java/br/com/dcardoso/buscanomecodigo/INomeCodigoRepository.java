package br.com.dcardoso.buscanomecodigo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface INomeCodigoRepository {

    @Query("SELECT * FROM nomecodigo WHERE codigo LIKE :filtro || '%'")
    List<NomeCodigo> listar(String filtro);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Save(NomeCodigo nomeCodigo);
}
