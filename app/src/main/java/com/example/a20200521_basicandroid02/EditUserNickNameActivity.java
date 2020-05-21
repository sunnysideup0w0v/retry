package com.example.a20200521_basicandroid02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a20200521_basicandroid02.databinding.ActivityMainBinding;

public class EditUserNickNameActivity extends BaseActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_user_nick_name);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        binding.editNickNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent();
                String nick = binding.userNickNameTxt.getText().toString();
                myIntent.putExtra("editNickName",nick);
                setResult(RESULT_OK,myIntent);
                finish();
            }
        });
    }

    @Override
    public void setValues() {

    }
}
