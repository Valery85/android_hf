package com.rik.android.workout;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
//import android.support.v4.app.ListFragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Class to show data (names of workout) from Workout.java in form of list
 */
public class WorkoutListFragment extends ListFragment {

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    // to connect activity and fragment using interface
    interface WorkoutListListener{
        void itemClicked(long id);
    }

    private  WorkoutListListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (WorkoutListListener)activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null){
            listener.itemClicked(id);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String namesOfWorkout [] = new String[Workout.workout.length];

        for (int  i = 0; i < Workout.workout.length; i++){
            namesOfWorkout[i] = Workout.workout[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, namesOfWorkout);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
