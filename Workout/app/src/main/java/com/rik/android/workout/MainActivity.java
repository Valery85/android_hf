package com.rik.android.workout;

import android.app.FragmentTransaction;
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
        WorkoutDetailFragment detailsFragment = new WorkoutDetailFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        detailsFragment.setWorkoutId(id);
        fragmentTransaction.replace(R.id.fragment_container, detailsFragment);

        //to have possibility return to previously formed (tapped in list) fragment
        fragmentTransaction.addToBackStack(null);
        // for animation of transition between fragment changes
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();

    }
}
