package com.adityaeka.intenttask;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3;
    Button btn2;

    Uri webpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);

        btn2 = findViewById(R.id.buttonImplicit);

        Bundle bundle = getIntent().getExtras();
        tv1.setText(bundle.getString("nama"));
        tv2.setText(bundle.getString("alamat"));
        tv3.setText(bundle.getString("hp"));

        webpage = Uri.parse(bundle.getString("nama"));

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }else{
                    Log.d("ImplicitIntents", "Can't handle this!");
                }
            }
        });


    }
}
