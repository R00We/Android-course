package csu.r00we.storedata;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import static csu.r00we.storedata.MySqliteHelper.COLUMN_NAME;
import static csu.r00we.storedata.MySqliteHelper.COLUMN_SURNAME;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    EditText name;
    EditText surName;
    ListView listView;
    MySqliteHelper sqliteHelper;
    SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        surName = (EditText)findViewById(R.id.surname);
        sqliteHelper = new MySqliteHelper(this);
        listView = (ListView)findViewById(R.id.listView);

        getLoaderManager().initLoader(0, null, this);

    }

    public void saveClick(View view) {
        sqliteHelper.save(name.getText().toString(), surName.getText().toString());
        getLoaderManager().restartLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MyCursorLoader(MainActivity.this, sqliteHelper);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this,
                android.R.layout.simple_list_item_2,
                data,
                new String[]{COLUMN_NAME, COLUMN_SURNAME},
                new int[]{android.R.id.text1, android.R.id.text2}, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        listView.setAdapter(simpleCursorAdapter);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        simpleCursorAdapter.swapCursor(null);
    }
}
