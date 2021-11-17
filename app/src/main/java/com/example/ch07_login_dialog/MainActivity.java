package com.example.ch07_login_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

//                View view1 = new View(?);
                View view1 = View.inflate(MainActivity.this,
                                         R.layout.dialog1,
                                    null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(view1);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        EditText edt1 = view1.findViewById(R.id.dlgEdt1);
                        EditText edt2 = view1.findViewById(R.id.dlgEdt2);

                        String str1 = edt1.getText().toString();
                        String str2 = edt2.getText().toString();

                        tvName.setText(str1);
                        tvEmail.setText(str2);

                    }
                });


                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(1,2,3).show();
                        Toast toast1 = new Toast(MainActivity.this);
                        View view2 = View.inflate(MainActivity.this,
                                R.layout.toast1,null);
                        TextView tv1 = view2.findViewById(R.id.toastText1);
                        tv1.setText("취소했음!");

                        toast1.setView(view2);
                        toast1.show();


                    }
                });

                dlg.show();

            }
        });

    }
}
