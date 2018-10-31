package io.github.joaovenancio.aplicacaoconstrutora.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import io.github.joaovenancio.aplicacaoconstrutora.modelos.Noticia;

public class NoticiaDAO extends SQLiteOpenHelper {

    //Construtor:
    public NoticiaDAO(Context context) {
        super(context, "Imobiliaria", null, 1);
    }

    //Metodos:
    //Tabela com texto TEXT e data TEXT.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE noticias (id INTEGER PRIMARY KEY, texto TEXT NOT NULL, data TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS noticias";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Noticia noticia) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("texto", noticia.getTexto());
        dados.put("data", noticia.getData());

        db.insert("noticias",null, dados);
    }

    public List<Noticia> buscaNoticias() {
        String sql = "SELECT * FROM noticias;";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(sql, null); //Retornar um cursor para a tupla do BD

        List<Noticia> noticias = new ArrayList<Noticia>();

        while (c.moveToNext()) { //A primeira linha e null - se eu nao tiver resultados, ele retornar false
            Noticia noticia = new Noticia();
            noticia.setId(c.getLong(c.getColumnIndex("id")));
            noticia.setTexto(c.getString(c.getColumnIndex("texto")));
            noticia.setData(c.getString(c.getColumnIndex("data")));

            noticias.add(noticia);
        }

        c.close();//Terminei de usar o resultado, pode retirar da memoria a tabela

        return noticias;
    }
}
