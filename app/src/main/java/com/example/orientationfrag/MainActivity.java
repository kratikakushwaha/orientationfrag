package com.example.orientationfrag;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.Set {
    Fragment1 fragment1;
    Fragment2 fragment2;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragment2 = (Fragment2) fragmentManager.findFragmentByTag("Tag2");
        fragment1 = (Fragment1) fragmentManager.findFragmentByTag("Tag1");

        if (fragment1 == null) {
            fragment1 = new Fragment1();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frag1, fragment1, "Tag1");
            fragmentTransaction.commit();
        }
        if (fragment2 == null) {
            fragment2 = new Fragment2();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frag2, fragment2, "Tag2");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void send(String str) {
        fragment2.bridge(str);
    }

}
