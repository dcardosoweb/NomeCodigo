package br.com.dcardoso.buscanomecodigo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.util.List;

import br.com.dcardoso.buscanomecodigo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ActivityMainBinding binding;
    DataBaseApplication db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = binding.rcvListCards;
        db = buscaNomeCodigoAPP.obterInstanciaDB();
    }

    public void salvarNome(View view)
    {
        InputMethodManager inputMethodManager = (InputMethodManager)  this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);

        String nome = binding.tevNome.getText().toString().toUpperCase();

        if(nome.trim().length() >0) {
            String codigo = "";
            for (int index = 0; index < nome.length(); index++) {
                if (nome.charAt(index) == 'Ã' || nome.charAt(index) == 'Á' || nome.charAt(index) == 'Â' || nome.charAt(index) == 'A' || nome.charAt(index) == 'À' || nome.charAt(index) == 'B' || nome.charAt(index) == 'C' || nome.charAt(index) == 'Ç') {
                    codigo = codigo + "2";
                    continue;
                }

                if (nome.charAt(index) == 'D' || nome.charAt(index) == 'E' || nome.charAt(index) == 'È' || nome.charAt(index) == 'É' || nome.charAt(index) == 'Ê' || nome.charAt(index) == 'F') {
                    codigo = codigo + "3";
                    continue;
                }

                if (nome.charAt(index) == 'G' || nome.charAt(index) == 'H' || nome.charAt(index) == 'I' || nome.charAt(index) == 'Î' || nome.charAt(index) == 'Í' || nome.charAt(index) == 'Ì') {
                    codigo = codigo + "4";
                    continue;
                }

                if (nome.charAt(index) == 'J' || nome.charAt(index) == 'K' || nome.charAt(index) == 'L') {
                    codigo = codigo + "5";
                    continue;
                }

                if (nome.charAt(index) == 'M' || nome.charAt(index) == 'N' || nome.charAt(index) == 'O' || nome.charAt(index) == 'Õ' || nome.charAt(index) == 'Ô' || nome.charAt(index) == 'Ó' || nome.charAt(index) == 'Ò') {
                    codigo = codigo + "6";
                    continue;
                }

                if (nome.charAt(index) == 'P' || nome.charAt(index) == 'Q' || nome.charAt(index) == 'R' || nome.charAt(index) == 'S') {
                    codigo = codigo + "7";
                    continue;
                }

                if (nome.charAt(index) == 'T' || nome.charAt(index) == 'Ù' || nome.charAt(index) == 'Ú' || nome.charAt(index) == 'Û' || nome.charAt(index) == 'U' || nome.charAt(index) == 'V') {
                    codigo = codigo + "8";
                    continue;
                }

                if (nome.charAt(index) == 'W' || nome.charAt(index) == 'X' || nome.charAt(index) == 'Y' || nome.charAt(index) == 'Z') {
                    codigo = codigo + "9";
                    continue;
                }
            }
            binding.tevNome.setText("");
            NomeCodigo obj = new NomeCodigo();
            obj.setNome(nome);
            obj.setCodigo(codigo);
            db.nomeCodigoRepository().Save(obj);
            Toast.makeText(this, "Nome salvo com sucesso", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Nome vazio, necessário informar um nome.", Toast.LENGTH_SHORT).show();
        }


    }

    public void pesquisarNome(View view)
    {
        InputMethodManager inputMethodManager = (InputMethodManager)  this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);

        String codigo = binding.tevCodigo.getText().toString();
        List<NomeCodigo> resultado = db.nomeCodigoRepository().listar(codigo);
        NomeCodigoAdapter adapter = new NomeCodigoAdapter(resultado, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        if(resultado.size() <=0) {
            Toast.makeText(this, "Não foram encontrados resultados", Toast.LENGTH_LONG).show();
        }
    }
}
