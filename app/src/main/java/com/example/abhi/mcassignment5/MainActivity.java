package com.example.abhi.mcassignment5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = (Button)findViewById(R.id.fetchButton);
        final Context context = this;
        if(savedInstanceState != null){
            result = savedInstanceState.getString("result", "");
            setResult();
            b.setEnabled(false);
        }else {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    HTMLContentRetreiver htmlContentRetreiver = new HTMLContentRetreiver(context);
                    htmlContentRetreiver.execute();
                    b.setEnabled(false);
                }
            });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result", result);
    }

    protected void setResult(){
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText(result);
    }
}
