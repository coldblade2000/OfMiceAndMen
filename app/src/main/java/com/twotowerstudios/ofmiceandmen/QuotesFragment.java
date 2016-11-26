package com.twotowerstudios.ofmiceandmen;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;



/**
 * Created by Diego Granada on 22/02/2016.
 */
public class QuotesFragment extends ListFragment {
    // Store instance variables
    private String title;
    private int page;

    String [] quotesValues;
    private int internalCharacter;
    static ArrayAdapter<String> quotesAdapter;

    // newInstance constructor for creating fragment with arguments
    public static QuotesFragment newInstance(int page, String title) {
        QuotesFragment fragmentFirst = new QuotesFragment();
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
        View view = inflater.inflate(R.layout.quotes_fragment, container, false);
        internalCharacter = MainActivity.publicCharacter;
        if (internalCharacter == 0){
            quotesValues = new String[] { "George is gonna give me hell",
                    "I can still tend the rabbits, George?",
                    "I done a real bad thing. I shouldn't of did that. George'll be mad. An hide in the brush till he come. He's gonna be mad. In the brush till he come. That's what he said" };
        } else if (internalCharacter == 1) {
            quotesValues = new String[] { "And you ain't gonna do bad things like you done in Weed neither.",
                    "Don't let him pull you in. But, if the son of a bitch sock you, let him have it.",
                    "Guys like us got no family. They make a little stake then they blow it in. They ain't got nobody in the world that gives a hoot in hell about them." };
        } else if (internalCharacter == 2) {
            quotesValues = new String[] { "You the new guys the old man was waitin’ for?",
                     };
        } else if (internalCharacter == 3) {
            quotesValues = new String[] { "I tell you I ain't used to livin' like this. I coulda made somethin' of myself. Maybe I will yet. I lived right in Salinas, Come there when I was a kid. " +
                    "Well, a show come through, an' I met one of the actors. He says I could go with that show. " +
                    "But my ol' lady wouldn' let me. She says because I was on'y fifteen. But the guy says I coulda. If I'd went, I wouldn't be livin' like this, you bet.",
                    "Well, you keep your place then, Nigger. I could get you strung up on a tree so easy it ain't even funny.",
                    "They left all the weak ones here" };
        } else if (internalCharacter == 4) {
            quotesValues = new String[] { "Well-hell! I had him so long. Had him since he was a pup. I herded sheep with him. You wouldn't think it to look at him now, but he was the best damn sheep dog I ever seen.",
                    "You seem what they done to my dog tonight? They says he wasn't no good to himself nor nobody else. When they can me here I wisht somebody'd shoot me. But they won't do nothing like that. I won't have no place to go, and I can't get no more jobs.",
                    "Well, Curley's pretty handy. Never did seem right to me. S'pose Curley jumps a big guy an' licks him. Ever'body says what a game guy Curley is. And s'pose he does the same thing and gets licked. Then ever'body says the big guy oughtta pick on somebody his own size, and maybe they gang up on the big guy. Never did seem right to me. Seem like Curley ain't givin' nobody a chance." };
        }
        quotesAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, quotesValues);
        setListAdapter(quotesAdapter);
        return view;
    }

}
