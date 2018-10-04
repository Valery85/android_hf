package com.rik.android.workout;


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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_workout_detail, container, false);
//        return view;
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

    // method to transfer id in fragment from MainActivity
    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}
