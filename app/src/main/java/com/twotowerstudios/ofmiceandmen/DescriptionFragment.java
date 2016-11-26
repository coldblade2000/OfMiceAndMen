package com.twotowerstudios.ofmiceandmen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Diego Granada on 22/02/2016.
 */
public class DescriptionFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    static ExpandableListAdapter listAdapter;
    static ExpandableListView elvDescription;
    static List<String> listDataHeader;
    static HashMap<String, List<String>> listDataChild;
    private int internalCharacter;
    // newInstance constructor for creating fragment with arguments
    public static DescriptionFragment newInstance(int page, String title) {
        DescriptionFragment fragmentFirst = new DescriptionFragment();
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
        prepareExpandableListData(0);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.description_fragment, container, false);
        /**TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);*/
        elvDescription = (ExpandableListView) view.findViewById(R.id.elvDescription);
        // preparing list data

        //prepareExpandableListData(0);

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);
        internalCharacter = MainActivity.publicCharacter;

        prepareExpandableListData(internalCharacter);

        // setting list adapter

        elvDescription.setAdapter(listAdapter);


        return view;
    }
    public static void prepareExpandableListData(int character) {
        //if(character.equals("Lennie")){
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Physical");
        listDataHeader.add("Mental");
        listDataHeader.add("Relationships");
        List<String> physical;
        List<String> mental;
        List<String> relationships;

        if (character == 0) {
            // Adding child data
            physical = new ArrayList<String>();
            physical.add("Lennie is a very tall man. He is described as being very strong and powerful. In some ways, he is like a bull, big and strong.");


            mental = new ArrayList<String>();
            mental.add("Lennie is extremely dim-witted, and has an almost non-existent short-term memory, and a bad long term memory." +
                    " He is very easy to manipulate. However he also has very little self-control, and may grow violent" +
                    " because of minor disturbances to his environment. He's friendly and naive most of the time.");

            relationships = new ArrayList<String>();
            relationships.add("Lennie is practically dependent on George, and can't live without him, because Lennie lacks the wisdom" +
                    " and intelligence to know what is best for him. He also got along with Crooks, by looking past" +
                    " his black skin. Otherwise, he wasn't really close to any others. George advised him to stay away from" +
                    " Curley and his wife, in order to avoid any trouble.");
            listDataChild.put(listDataHeader.get(0), physical); // Header, Child data
            listDataChild.put(listDataHeader.get(1), mental);
            listDataChild.put(listDataHeader.get(2), relationships);
        } else if (character == 1) {
            // Adding child data
            physical = new ArrayList<String>();
            physical.add("George is described as being very thin and small. However in no way is he weak. He has strong arms and is a very hard worker. He can definitely pull his own weight when working on the ranch");


            mental = new ArrayList<String>();
            mental.add("George is extremely smart. He always calculates every outcome, and always has a plan for everything. Aside from being pretty intelligent, especially when compared to other characters," +
                    " he is extremely wise and always has a solution. He stands out as a voice of reason. Because of this, he manages to esentially think for Lennie, so Lennie won't have to do so." +
                    " George tells Lennie what to do all of the time, because they both know Lennie's ideas always get them into trouble. ");

            relationships = new ArrayList<String>();
            relationships.add("Part of his wiseness also means that he developed an instinctual distrust for everyone. He tends to not share personal details, and is not receptive to other people's" +
                    " manipulations. George and Lennie are inseparable, with George always sticking with Lennie, even with all of the bad things he does. George also got along with both Candy and Crooks." +
                    " He was able to relate to the wisdom of Candy, the ranch's oldest worker. George was also able to look past Crooks' skin color.");
            listDataChild.put(listDataHeader.get(0), physical); // Header, Child data
            listDataChild.put(listDataHeader.get(1), mental);
            listDataChild.put(listDataHeader.get(2), relationships);
        }else if (character == 2) {
            // Adding child data
            physical = new ArrayList<String>();
            physical.add("Curley is a smaller-than-average boxer. However he uses this defect to his advantage in order to boost his ego and reputation (also known as a Napoleon complex). He always" +
                    " carries one glove on one hand, filled with vaseline.");


            mental = new ArrayList<String>();
            mental.add("Curley is a boxer, and he REALLY likes getting into battles with peoples. It is for this reason that George warns Lennie to steer clear from Curley. Since Curley is a pretty solid fighter," +
                    " but is smaller than average, and he also has a pretty big ego, he always picks fights with people bigger than him. If he fights with someone bigger and loses the fight, he could" +
                    " argue that the other person won simply because of their size. However if he wins, he gets to keep all the glory of beating a person bigger than him.");

            relationships = new ArrayList<String>();
            relationships.add("Curley is married to his wife (obviously) and he has a pretty soft side for her, as evidenced by his glove. However his wife is pretty distant from him, and she tells" +
                    " the other men in the ranch that she SETTLED for Curley. This also meant that Curley was pretty protective of her, as he was afraid of any of the other men trying to 'lead her astray'." +
                    " He doesn't really get along with any of the men in the ranch.");
            listDataChild.put(listDataHeader.get(0), physical); // Header, Child data
            listDataChild.put(listDataHeader.get(1), mental);
            listDataChild.put(listDataHeader.get(2), relationships);
        }else if (character == 3) {
            // Adding child data
            physical = new ArrayList<String>();
            physical.add("Curley's wife is a small, thin woman who is very beautiful and has a very nice body. She uses makeup and styles her hair all the time. She has curly hair.");


            mental = new ArrayList<String>();
            mental.add("Curley's wife is not very smart, but she isn't dumb either. Since she is the only woman in the ranch, and she is already married to Curley (who she starts to dislike), she " +
                    "feels pretty lonely all the time. Not to mention all of the men in the ranch avoid her in order to avoid conflicts with Curley. For this reason, she is always extra" +
                    " flirty when she is in the ranch, because she is trying to get one of the men to disregard Curley and run away with her, or maybe she just needs someone to talk to. It is hard " +
                    "to understand her intentions sometimes.");

            relationships = new ArrayList<String>();
            relationships.add("Curley's wife is always flirting with all the men in the ranch, even though she is already married to Curley. Because of his strength and appearance, she became " +
                    "attracted to Lennie, who had been told to stay away from her. It was during one of her flirtations with Lennie that Curley's wife was (semi-)accidentally killed by Lennie. " +
                    "She was avoided by all of the other men as well.");
            listDataChild.put(listDataHeader.get(0), physical); // Header, Child data
            listDataChild.put(listDataHeader.get(1), mental);
            listDataChild.put(listDataHeader.get(2), relationships);
        }else if (character == 4) {
            physical = new ArrayList<String>();
            physical.add("Candy is very old. He has grey hair and very visible wrinkles. He is missing one hand and most of the times he has a solemn or miserable expression on his face.");


            mental = new ArrayList<String>();
            mental.add("Candy is very wise, something he earned over the years. He was very close to his dog, who he raised since it was a puppy, up until it got put down by Carlson. " +
                    "He is very scared of the realization that he has spent more than half his life working in ranches, and as he becomes older, and no longer capable of working, he will" +
                    " not be able to get another job, because he is only skilled at physical work. He is also haunted by the failure of not being strong enough to put his own dog down, but " +
                    "having to delegate the action to Carlson.");

            relationships = new ArrayList<String>();
            relationships.add("Candy quickly became friends with George and Lennie, especially George, who he considers a mental equal. He despises both Curley and his wife, believing them to" +
                    " be unpredictable and very despicable. He was very close to his own dog, for obvious reasons, and he was left disturbed after it was put down.");
            listDataChild.put(listDataHeader.get(0), physical); // Header, Child data
            listDataChild.put(listDataHeader.get(1), mental);
            listDataChild.put(listDataHeader.get(2), relationships);
        }


        //}

    }
}