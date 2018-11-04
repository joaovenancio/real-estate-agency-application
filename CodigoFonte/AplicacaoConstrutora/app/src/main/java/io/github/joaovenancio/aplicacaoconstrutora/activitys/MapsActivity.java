package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Imovel imovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obter o SupportMapFragment:
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //Avisar quando ele estiver pronto para uso

        //Recuperar o imovel:
        Intent intent = this.getIntent();
        this.imovel = (Imovel) intent.getSerializableExtra("imovel");
    }

    /**
     * É chamado para confiugrar o maps.
     *
     * @param googleMap - Instancia para manipular o maps da view.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Adicionar um marcador e movimentar a camera:
        LatLng localizacao = new LatLng(this.imovel.getLatitude(), this.imovel.getLongitude());
        mMap.addMarker(new MarkerOptions().position(localizacao).title(this.imovel.getTituloMaps()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(localizacao));
    }
}
