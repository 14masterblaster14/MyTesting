package com.example.a105fragment5;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {


    public OtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_other, container, false);
        View rootView = inflater.inflate(R.layout.fragment_other, container, false);

        rootView.findViewById(R.id.btnMy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(R.mipmap.ic_launcher);
            }
        });

        rootView.findViewById(R.id.btnTweety).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(R.drawable.tweety);
            }
        });
        return rootView;
    }

    private void loadFragment(int image) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.replace(R.id.frameContainer,AllFragment.getInstance(image));
        transaction.commit();

    }
}
