package com.example.a20200521_basicandroid02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a20200521_basicandroid02.databinding.ActivityEditUserEmailBinding;

import java.nio.channels.InterruptedByTimeoutException;

public class EditUserEmailActivity extends BaseActivity {
    ActivityEditUserEmailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_user_email);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edtMail = binding.edtUserMail.getText().toString();
                Intent myIntent = new Intent();
                myIntent.putExtra("edtUserMail",edtMail);
                setResult(RESULT_OK,myIntent);
                finish();
            }
        });
    }

    @Override
    public void setValues() {

    }
}
