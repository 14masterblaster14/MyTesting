package com.example.a10fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.Fragment_Container, new LoginFragment());
        transaction.commit();

/*
        android.app.FragmentManager manager = getFragmentManager();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        transaction.add(R.id.Fragment_Container,loginFragment);
        transaction.commit();
*/
        findViewById(R.id.Txt_New_User).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                RegistrationFragment registrationFragment = new RegistrationFragment();
                transaction.replace(R.id.Fragment_Container, registrationFragment);
                transaction.commit();

            }
        });


    }

}

