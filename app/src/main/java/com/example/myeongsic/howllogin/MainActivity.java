package com.example.myeongsic.howllogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.loginButton);

        final EditText id = (EditText)findViewById(R.id.id);
        final EditText password = (EditText)findViewById(R.id.password);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.getText().toString().equals("1234")){
                    Intent intent = new Intent(view.getContext(),NextActivity.class);
                    intent.putExtra("id",id.getText().toString());
                    startActivityForResult(intent,10);
                }else {

                    Toast.makeText(MainActivity.this, "비밀번호가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 10 && resultCode==20){

            TextView textView = (TextView)findViewById(R.id.logout_user_textview);
            textView.setText(data.getStringExtra("logout_user"));
        }



    }
}
