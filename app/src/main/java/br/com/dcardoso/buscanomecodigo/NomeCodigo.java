package br.com.dcardoso.buscanomecodigo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class NomeCodigo {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String codigo;
    private String nome;

    @Ignore
    private String idString;

    @Ignore
    public NomeCodigo() {
    }

    public NomeCodigo(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdString() {
        return String.valueOf(id);
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }
}
