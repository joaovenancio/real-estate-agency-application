package io.github.joaovenancio.aplicacaoconstrutora.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class ImovelDAO extends SQLiteOpenHelper {
    public ImovelDAO(Context context) {
        super(context, "Imobiliaria", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlImoveis = "CREATE TABLE imoveis (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, numeroDeQuartos INTEGER," +
                " area REAL, endereco TEXT NOT NULL, cep TEXT NOT NULL," +
                "dataDeEntrega TEXT NOT NULL, valor REAL, prazoFinanciamento INTEGER, urlPlanta TEXT, " +
                "urlVideoYoutube TEXT, latitude REAL, longitude REAL, tituloMaps TEXT);";
        String sqlNoticias = "CREATE TABLE noticias (id INTEGER PRIMARY KEY, texto TEXT NOT NULL, data TEXT NOT NULL);";

        db.execSQL(sqlImoveis);
        db.execSQL(sqlNoticias);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS imoveis;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Imovel imovel) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", imovel.getNome());
        dados.put("area", imovel.getArea());
        dados.put("numeroDeQuartos", imovel.getNumeroDeQuartos());
        dados.put("endereco", imovel.getEndereco());
        dados.put("cep", imovel.getCep());
        dados.put("dataDeEntrega", imovel.getDataDeEntrega());
        dados.put("valor", imovel.getValor());
        dados.put("prazoFinanciamento",imovel.getPrazoFinanciamento());
        dados.put("urlPlanta", imovel.getUrlPlanta());
        dados.put("urlVideoYoutube", imovel.getUrlVideoYoutube());
        dados.put("latitude", imovel.getLatitude());
        dados.put("longitude", imovel.getLongitude());
        dados.put("tituloMaps", imovel.getTituloMaps());

        db.insert("imoveis",null, dados);
    }

    public List<Imovel> recuperarImoveis() {

        String sql = "SELECT * FROM imoveis;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(sql, null); //Retornar um cursor para a tupla do BD

        List<Imovel> imoveis = new ArrayList<Imovel>();

        while (c.moveToNext()) { //A primeira linha e null - se eu nao tiver resultados, ele retornar false

            Imovel imovel = new Imovel();
            imovel.setId(c.getLong(c.getColumnIndex("id")));
            imovel.setNome(c.getString(c.getColumnIndex("nome")));
            imovel.setArea(c.getDouble(c.getColumnIndex("area")));
            imovel.setNumeroDeQuartos(c.getInt(c.getColumnIndex("numeroDeQuartos")));
            imovel.setEndereco(c.getString(c.getColumnIndex("endereco")));
            imovel.setCep(c.getString(c.getColumnIndex("cep")));
            imovel.setDataDeEntrega(c.getString(c.getColumnIndex("dataDeEntrega")));
            imovel.setValor(c.getDouble(c.getColumnIndex("valor")));
            imovel.setPrazoFinanciamento(c.getInt(c.getColumnIndex("prazoFinanciamento")));
            imovel.setUrlPlanta(c.getString(c.getColumnIndex("urlPlanta")));
            imovel.setUrlVideoYoutube(c.getString(c.getColumnIndex("urlVideoYoutube")));
            imovel.setLatitude(c.getDouble(c.getColumnIndex("latitude")));
            imovel.setLongitude(c.getDouble(c.getColumnIndex("longitude")));
            imovel.setTituloMaps(c.getString(c.getColumnIndex("tituloMaps")));

            imoveis.add(imovel);
        }

        c.close();//Terminei de usar o resultado, pode retirar da memoria a tabela

        return imoveis;
    }
}
