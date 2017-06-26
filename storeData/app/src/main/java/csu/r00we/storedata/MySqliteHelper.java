package csu.r00we.storedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by r00we on 24/06/2017.
 *
 */

public class MySqliteHelper extends SQLiteOpenHelper {

    private static final String NAME = "db.sql";
    private static final int VERSION = 1;

    private static final String TABLE_NAME = "USER";
    static final String COLUMN_NAME = "NAME";
    static final String COLUMN_SURNAME = "SURNAME";

    public MySqliteHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME +
                "("+ BaseColumns._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SURNAME + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void save(String name, String surName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_SURNAME, surName);
        getWritableDatabase().insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAll(){
        return getReadableDatabase().query(TABLE_NAME, null, null, null, null, null, null);
    }
}
