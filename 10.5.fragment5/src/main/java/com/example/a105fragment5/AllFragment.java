package com.example.a105fragment5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {

    public static final String KEY_IMAGE = "image";
    public static final String KEY_MY_DATA = "myData";

    public AllFragment() {
        // Required empty public constructor
    }

    public static AllFragment getInstance(int image, String message) {
        AllFragment fragment = new AllFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_IMAGE, image);
        bundle.putString(KEY_MY_DATA, message);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_all, container, false);

        View rootView = inflater.inflate(R.layout.fragment_all, container, false);

        ((ImageView) rootView.findViewById(R.id.imageView)).setImageResource(getArguments().getInt(KEY_IMAGE));

        setText(rootView);

        return rootView;
    }

    private void setText(View rootView) {
        Bundle bundle = getArguments();
        if (bundle != null) {

            //    TextView textView = (TextView) rootView.findViewById(R.id.All_Txt);
            //    textView.setText(bundle.getString("myData"));

            // Inline code for above 2 lines

            ((TextView) rootView.findViewById(R.id.All_Txt)).setText(bundle.getString(KEY_MY_DATA));
        }
    }
}
