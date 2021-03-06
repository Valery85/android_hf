package com.rik.android.workout;


import android.app.FragmentTransaction;
import android.os.Bundle;
//import android.support.v4.app.Fragment;           this is wrong library imported by default
import android.app.Fragment;                    // right library
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    // fix data losing when device rotate
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        }
        // Fix situation when device rotate and stopwatch get 0 in time area
        // to prevent execution of transaction which create fragment again
        // savedInstanceState checks
        else {
// getChildFragment() method used because it inside another fragment
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        ft.replace(R.id.stopwatch_container, stopwatchFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        }

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // get root object for fragment View
        View view = getView();
        if (view != null) {
            // get chosen workout object
            Workout chosenWorkout = Workout.workout[(int) workoutId];

            // set data in fragment views
            TextView nameOfWorkout = (TextView) view.findViewById(R.id.name_of_workout);
            nameOfWorkout.setText(chosenWorkout.getName());
            TextView descriptionOfWorkout = (TextView) view.findViewById(R.id.description_of_workout);
            descriptionOfWorkout.setText(chosenWorkout.getDescription());
        }
    }

    // fix data losing when device rotate
    @Override
    public void onSaveInstanceState(Bundle savedIntanceState) {
        savedIntanceState.putLong("workoutId", workoutId);
    }

    // method to transfer id in fragment from MainActivity
    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}
