package com.example.a106fragment6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {

    public static BottomFragment getInstance() {

        BottomFragment fragment = new BottomFragment();
        return fragment;
    }

    /*
        public BottomFragment() {
            // Required empty public constructor
        }

    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_bottom, container, false);

        View rootView = inflater.inflate(R.layout.fragment_bottom, container, false);
        activateButtons(rootView);
        return rootView;
    }

    private void activateButtons(View rootView) {

        rootView.findViewById(R.id.Teaser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(R.drawable.teaser);
            }
        });

        rootView.findViewById(R.id.Fight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImage(R.drawable.fight);
            }
        });
    }

    private void changeImage(int image) {
        ((MainActivity) getActivity())
                .runFragmentTransaction(R.id.FrameContainer, ImageFragment.getInstance(image));
    }
}
