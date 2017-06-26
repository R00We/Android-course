package csu.r00we.storedata;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;

/**
 * Created by r00we on 24/06/2017.
 */

public class MyCursorLoader extends CursorLoader {

    MySqliteHelper sqliteHelper;

    public MyCursorLoader(Context context, MySqliteHelper sqliteHelper) {
        super(context);
        this.sqliteHelper = sqliteHelper;
    }

    @Override
    public Cursor loadInBackground() {
        return sqliteHelper.getAll();
    }
}
