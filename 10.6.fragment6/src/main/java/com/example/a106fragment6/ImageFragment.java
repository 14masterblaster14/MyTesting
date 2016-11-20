package com.example.a106fragment6;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {

    public static final String KEY_MY_IMAGE = "myImage";

    public static ImageFragment getInstance(int image) {

        ImageFragment fragment = new ImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MY_IMAGE, image);
        fragment.setArguments(bundle);
        return fragment;

    }

    /*  --- Deafult Value ---

    public ImageFragment() {
        // Required empty public constructor
    }

    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_image, container, false);

        View rootView = inflater.inflate(R.layout.fragment_image, container, false);
        showTweety(rootView);
        return rootView;
    }


    public void showTweety(View rootView) {

        Bundle bundle = getArguments();

        if (bundle != null)

            ((ImageView) rootView.findViewById(R.id.imageView))
                    .setImageResource(bundle.getInt(KEY_MY_IMAGE));

    }
}