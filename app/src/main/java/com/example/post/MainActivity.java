package com.example.post;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.appcompat.app.AlertDialog.Builder;
import static androidx.appcompat.app.AlertDialog.OnClickListener;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Buscar CEP");
        setContentView(R.layout.activity_main);

        final EditText campoCEP = findViewById(R.id.et_cep);
        final Button botaoBuscar = findViewById(R.id.btn_buscar);
        final LinearLayout esconderLayout = findViewById(R.id.esconder_layout);

        esconderLayout.setVisibility(View.GONE);

        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(campoCEP.getText().length() == 0) {
                  AlertDialog.Builder AlertaParaCampoVazio = new AlertDialog.Builder(MainActivity.this);
                  AlertaParaCampoVazio.setTitle("Erro!");
                  AlertaParaCampoVazio.setMessage("Insira um CEP");
                  AlertaParaCampoVazio.setIcon(R.drawable.ic_action_error);
                  AlertaParaCampoVazio.setPositiveButton("OK!", new OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                      }
                  });
                  AlertaParaCampoVazio.create().show();
                }else{

                 EnderecoService service = new RetrofitConfig().getEnderecoService();
                 Call<Endereco> call = service.getEndereco(campoCEP.getText().toString());

                esconderLayout.setVisibility(View.VISIBLE);

                call.enqueue(new Callback<Endereco>() {
                    @Override
                    public void onResponse(Call<Endereco> call, Response<Endereco> response) {
                        if (response.isSuccessful()) {

                            esconderLayout.setVisibility(View.GONE);
                            Endereco endereco = response.body();

                            String conteudo1 = "Bairro: " + endereco.getBairro() + "\nCidade: "+
                                    endereco.getCidade() + "\nLogradouro: "
                                    + endereco.getLogradouro();

                            String conteudo2 = "Area km2: "+endereco.getEstado_info().getArea_km2()+
                                    "\nCódigo ibge: "+endereco.getEstado_info().getCodigo_ibge()+
                                    "\nNome: "+endereco.getEstado_info().getNome()+"\nCEP: " +
                                    endereco.getCep();

                            String conteudo3 = "Area km2: "+endereco.getCidade_info().getArea_km2()+
                                    "\nCódigo ibge: "+endereco.getCidade_info().getCodigo_ibge()+
                                    "\nEstado: "+ endereco.getEstado();

                            ExpandableTextView expandableTextView1 = (ExpandableTextView) findViewById(R.id.expand_text_view);
                            expandableTextView1.setText(conteudo1);

                            ExpandableTextView expandableTextView2 = (ExpandableTextView) findViewById(R.id.expand_text2_view);
                            expandableTextView2.setText(conteudo2);

                            ExpandableTextView expandableTextView3 = (ExpandableTextView) findViewById(R.id.expand_text3_view);
                            expandableTextView3.setText(conteudo3);
                        }
                    }
                    @Override
                    public void onFailure(Call<Endereco> call, Throwable t) {
                      Builder alertaCEPInvalido = new Builder(MainActivity.this);
                      alertaCEPInvalido.setTitle("Erro!");
                      alertaCEPInvalido.setMessage("CEP inválido");
                      alertaCEPInvalido.setIcon(R.drawable.ic_action_error);
                      alertaCEPInvalido.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                          }
                      });
                      alertaCEPInvalido.create().show();
                      esconderLayout.setVisibility(View.GONE);
                    }
                });
            }
        }});
    }
}
