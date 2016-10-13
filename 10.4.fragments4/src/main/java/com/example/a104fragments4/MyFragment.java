package com.example.a104fragments4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* return inflater.inflate(R.layout.fragment_my, container, false); */
        final View rootView = inflater.inflate(R.layout.fragment_my, container, false);

    /*    animate(R.anim.rotate,rootView.findViewById(R.id.textHeader));

        rootView.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity hostActivity = (MainActivity)
                        getActivity();
                hostActivity.runFragmentTxn(R.id.frameContainer,
                        new LoginFragment());
            }
        });

        rootView.findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity hostActivity = (MainActivity)
                        getActivity();
                hostActivity.runFragmentTxn(R.id.frameContainer,
                        new LoginFragment());
            }
        });
    */
        return rootView;
    }

    private void animate(int id, View view) {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), id);
        animation.setRepeatCount(Animation.INFINITE);
        view.startAnimation(animation);
    }

}
