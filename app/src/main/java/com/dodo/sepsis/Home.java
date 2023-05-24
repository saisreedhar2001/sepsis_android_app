package com.dodo.sepsis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Home extends AppCompatActivity
    {
        ImageView dev;
        String url1 = "https://images.hindustantimes.com/img/2023/01/25/1600x900/FmAWrPMaEAIm803_1674631249014_1674631278743_1674631278743.png";
        String url2 = "https://static1.squarespace.com/static/58a7025b8419c215b30b2df3/58a7088fe6f2e182266fce36/5e2075ea3d9b3759839729af/1579262457415/Sepsis+48.9+million+cases+11+million+deaths+169.jpg?format=1500w";
        String url3 = "https://www.thelancet.com/cms/attachment/b2591d8b-7114-4bc1-a3bd-c79dbe2c0183/gr1.jpg";
        String url4 = "https://d2jx2rerrg6sh3.cloudfront.net/image-handler/picture/2018/12/By_Designua.jpg";
        String url5 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlwnttWALcEh63qv-GbN8jFAxzY7pC7w_G_cvBjarlxw_YLpBa2mmJoXsrtBpXidV2uJg&usqp=CAU";
        ExtendedFloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fab = findViewById(R.id.add_fab);
        dev = findViewById(R.id.dev);
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,Dev.class);
                startActivity(i);
            }
        });

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.imageSlider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url4));
        sliderDataArrayList.add(new SliderData(url3));
        sliderDataArrayList.add(new SliderData(url5));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();


        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view2);

        youTubePlayerView.enterFullScreen();
        youTubePlayerView.toggleFullScreen();

        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.enterFullScreen();
        youTubePlayerView.toggleFullScreen();

        // adding listener for our youtube player view.
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.cueVideo("6NdLnHbLZMU", 0);


            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer,
                                      @NonNull PlayerConstants.PlayerState state) {
                // this method is called if video has ended,
                super.onStateChange(youTubePlayer, state);
            }
        });







        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this,browser.class);
                startActivity(i);
            }
        });


    }

}
