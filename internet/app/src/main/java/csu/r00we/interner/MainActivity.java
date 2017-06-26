package csu.r00we.interner;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void go(View view) {
        losdOkHttp(editText.getText().toString());
    }

    private void loadHttpUrlConnection(String url){
        HttpUrlConnectionTask task = new HttpUrlConnectionTask(){
            @Override
            protected void onPostExecute(String s) {
                textView.setText(s);
            }
        };
        task.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, url);
    }

    private void losdOkHttp(String url){
        OkHttpTask okHttpTask = new OkHttpTask(){
            @Override
            protected void onPostExecute(String s) {
                textView.setText(s);
            }

        };
        okHttpTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, url);

    }
}
