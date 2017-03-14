package com.example.usuario.bdhelper;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBhelper extends  SQLiteOpenHelper {
    //Informacion de la tabla
    public static final String TABLE_MEMBER="miembros";
    public static final String MIEMBRO_ID="_id";
    public static final String MIEMBRO_NOMBRE="nombre";
    static final String DB_NAME = "DBMIEMBRO";
    static final int DB_VERSION = 1;
    //Informacion de la base de datos
    public static final String CRETAE_TABLE="create table "
            +TABLE_MEMBER + "("+MIEMBRO_ID
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +MIEMBRO_NOMBRE + " TEXT NOT NULL);";

    public DBhelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRETAE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
        onCreate(db);
    }
}
