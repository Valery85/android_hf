package com.rik.android.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//             create fragment object to transfer data there
//        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.details_fragment);
//             for now argument hardcoded for test purpose
//        fragment.setWorkoutId(1);
    }

    // define logic which will be used when user tap on list in WorkoutListFragment
    @Override
    public void itemClicked(long id) {

    }
}
