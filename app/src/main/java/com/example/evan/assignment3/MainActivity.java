package com.example.evan.assignment3;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.animalSelectedInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is an object that keeps track of whether we have a fragment or not.
        //if it shows up null then the if statement below runs.
        ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.placeHolder);

        //added this if statement so it doesn't keep creating new fragments on each rotation
        if (savedFragment == null) {

            //creates new ListFragment object called fragment
            ListFragment fragment = new ListFragment();

            //create FragmentManager object by using getFragmentManager method
            FragmentManager fragmentManager = getSupportFragmentManager();

            //creates FragmentTransaction object by using the fragmentManager above's method beginTransaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            //have to add the placeHolder and the fragment to the fragmentTransaction
            fragmentTransaction.add(R.id.placeHolder, fragment);

            //finally the fragmentTransaction needs to run the commit method to commit it.
            fragmentTransaction.commit();
        }
    }

    //onAnimalSelected implementation method. stuff happens when you press an animal from the list
    //this method takes the index of the animal pressed as an argument.
    @Override
    public void onAnimalSelected(int index) {
        //a toast is created with the index from the ImageList.
        Toast.makeText(MainActivity.this, ImageList.names[index], Toast.LENGTH_SHORT).show();

        //when the animal is selected we need to show a ViewImageFragment.
        //This is basically the same as above except it creates the ViewImageFragment
        ViewImageFragment fragment = new ViewImageFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //this time the fragmentTransaction replaces the fragment instead of adding it
        fragmentTransaction.replace(R.id.placeHolder, fragment);

        //add the fragment to the backstack so that we can go back to the previous thing in the BackStack
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
