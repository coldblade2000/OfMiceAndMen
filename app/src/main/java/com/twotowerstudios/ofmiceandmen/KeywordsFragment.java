package com.twotowerstudios.ofmiceandmen;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Diego Granada on 22/02/2016.
 */
public class KeywordsFragment extends ListFragment {
    // Store instance variables
    private String title;
    private int page;

    String [] values;
    int internalCharacter;
    static ArrayAdapter<String> adapter;

    // newInstance constructor for creating fragment with arguments
    public static KeywordsFragment newInstance(int page, String title) {
        KeywordsFragment fragmentFirst = new KeywordsFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        internalCharacter = MainActivity.publicCharacter;

    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.keywords_fragment, container, false);
        internalCharacter = MainActivity.publicCharacter;
        if (internalCharacter == 0){
            values = new String[] { "Strong", "Dim-witted", "Naive" };
        } else if (internalCharacter == 1) {
            values = new String[] { "Wise", "Rational", "Calculating" };
        } else if (internalCharacter == 2) {
            values = new String[] { "Arrogant", "Aggressive", "Offbeat" };
        } else if (internalCharacter == 3) {
            values = new String[] { "Lonely", "Beautiful", "Regretful" };
        } else if (internalCharacter == 4) {
            values = new String[] { "Old", "Stressed", "Loyal" };
        }
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return view;
    }

}
