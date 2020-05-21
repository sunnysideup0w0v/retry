package com.example.a20200521_basicandroid02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a20200521_basicandroid02.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    final int REQ_FOR_PHONE_NUM = 1002;
    final int REQ_FOR_NICKNAME = 1001;
    final int REQ_FOR_EMAIL = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dialPhoneNum = binding.userPhoneTxt.getText().toString();
                //안드로이드의 경우 전화걸기 등에서 uri 정보를 요구함
                Uri myUri = Uri.parse(String.format("tel: %s",dialPhoneNum));
                Intent myIntent = new Intent(Intent.ACTION_DIAL,myUri);
                startActivity(myIntent);
            }
        });

        binding.editPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext,EditUserPhoneActivity.class);
                startActivity(myIntent);
            }
        });
//        View.OnClickListener ocl = View.OnClickListener(){
//            Intent myIntent = new Intent(mContext,EditUserNickNameActivity.class);
//            startActivity(myIntent);
//        }
//        binding.editNickNameBtn.setOnClickListener(ocl);
        binding.editNickNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext,EditUserNickNameActivity.class);
                startActivity(myIntent);
            }
        });
        binding.editEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext,EditUserEmailActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_FOR_NICKNAME){
            if(resultCode == RESULT_OK){
                String nick = getIntent().getStringExtra("editNickName");
                binding.userNickNameTxt.setText(nick);
            }
        }
        else if(requestCode == REQ_FOR_PHONE_NUM){
            if(resultCode == RESULT_OK){
                if(data != null) {
                    String phoneNum = getIntent().getStringExtra("phone");
                    binding.userPhoneTxt.setText(phoneNum);
                }
            } else {
                Toast.makeText(mContext, "전화번호 변경을 취소했습니다.", Toast.LENGTH_SHORT).show();
            }
        } else if(requestCode == REQ_FOR_EMAIL){
            if(resultCode == RESULT_OK){
                if(data != null){
                    String Email = getIntent().getStringExtra("edtUserEmail");
                    binding.userEmailTxt.setText(Email);
                }
            }
        }
    }
}
