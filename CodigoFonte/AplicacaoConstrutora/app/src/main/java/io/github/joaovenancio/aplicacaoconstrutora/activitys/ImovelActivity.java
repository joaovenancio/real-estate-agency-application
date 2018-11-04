package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.activitys.ajudantes.AjudanteMostrarImovel;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;
import com.google.android.gms.maps.SupportMapFragment;

public class ImovelActivity extends YouTubeBaseActivity {

    AjudanteMostrarImovel ajudante;
    Imovel imovel;
    MapsActivity mapsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imovel);

        this.ajudante = new AjudanteMostrarImovel(this);

        //Recuperar o imovel:
        Intent intent = getIntent();
        this.imovel = (Imovel) intent.getSerializableExtra("imovel");

        //Mostrar os dados na view:
        this.ajudante.definirConteudo(imovel);

        //Maps:
        //mapsActivity = new MapsActivity();
        //mapsActivity.onCreate(savedInstanceState);
        Button botaoMaps = findViewById(R.id.imovel_botao_maps);
        botaoMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irParaMaps = new Intent(ImovelActivity.this, MapsActivity.class);
                //Adicionar o imovel na intent:
                irParaMaps.putExtra("imovel", ImovelActivity.this.imovel);
                ImovelActivity.this.startActivity(irParaMaps);
            }
        });

        //Configurar o botao de voltar:
        Button botaoVoltar = findViewById(R.id.imovel_botao_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
