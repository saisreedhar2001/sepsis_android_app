package com.dodo.sepsis;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frag1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frag1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static frag1 newInstance(String param1, String param2) {
        frag1 fragment = new frag1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_frag1, container, false);

        // Inflate the layout for this fragment



        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view2);

        // declaring variable for youtubeplayer view


        // below line is to place your youtube player in a full screen mode (i.e landscape mode)
        youTubePlayerView.enterFullScreen();
        youTubePlayerView.toggleFullScreen();

        // here we are adding observer to our youtubeplayerview.
        getLifecycle().addObserver(youTubePlayerView);

        // below method will provides us the youtube player
        // ui controller such as to play and pause a video
        // to forward a video
        // and many more features.
        //youTubePlayerView.getPlayerUiController();

        // below line is to enter full screen mode.
        youTubePlayerView.enterFullScreen();
        youTubePlayerView.toggleFullScreen();

        // adding listener for our youtube player view.
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo("6NdLnHbLZMU", 0);


            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer,
                                      @NonNull PlayerConstants.PlayerState state) {
                // this method is called if video has ended,
                super.onStateChange(youTubePlayer, state);
            }
        });



        return view;
    }
}