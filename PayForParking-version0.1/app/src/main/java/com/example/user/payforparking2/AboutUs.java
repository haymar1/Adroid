package com.example.user.payforparking2;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.TextView;


public class AboutUs extends AppCompatActivity {
    ImageView img;
    TextView txt,txt1,txt2,txt3,txt4,txt5,txt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_about_us);
        img=(ImageView)findViewById(R.id.imgHo);
        txt=(TextView)findViewById(R.id.txt);
        //txt1=(TextView)findViewById(R.id.txt1);
        //txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        txt4=(TextView)findViewById(R.id.txt4);
        txt5=(TextView)findViewById(R.id.txt5);
        txt6=(TextView)findViewById(R.id.txt);


    }
}
