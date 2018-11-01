package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Noticia;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button botaoRegistrarNoticia = findViewById(R.id.menu_registrar_noticia);
        botaoRegistrarNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaFormularioNoticia = new Intent(MenuActivity.this, FormularioNoticiaActivity.class);
                MenuActivity.this.startActivity(irParaFormularioNoticia);
            }
        });

        Button botaoMostrarNoticia = findViewById(R.id.menu_ver_ultima_noticia);
        botaoMostrarNoticia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verNovaNoticia = new Intent(MenuActivity.this, NoticiaActivity.class);
                MenuActivity.this.startActivity(verNovaNoticia);
            }
        });

        Button botaoRegistrarImovel = findViewById(R.id.menu_registrar_imovel);
        botaoRegistrarImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaFormularioImovel = new Intent(MenuActivity.this, FormularioImovelActivity.class);
                MenuActivity.this.startActivity(irParaFormularioImovel);
            }
        });

        Button botaoMostrarListaImovel = findViewById(R.id.menu_ver_imoveis);
        botaoMostrarListaImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verListaImoveis = new Intent(MenuActivity.this, ListaImovelActivity.class);
                MenuActivity.this.startActivity(verListaImoveis);
            }
        });
    }
}
