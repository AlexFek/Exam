package com.example.exam4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mListLayout;

    private ImageView mProfileImage;
    private TextView mNameText;
    private TextView mDescText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListLayout = (RelativeLayout) findViewById(R.id.ListLayout);
        mProfileImage = (ImageView) findViewById(R.id.profileImage);
        mNameText = (TextView) findViewById(R.id.profileName);
        mDescText = (TextView) findViewById(R.id.profileDescription);

        mListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharedIntent = new Intent(MainActivity.this, SharedActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(mProfileImage, "imageTransition");
                pairs[1] = new Pair<View, String>(mNameText, "nameTransition");
                pairs[2] = new Pair<View, String>(mDescText, "descriptionTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(sharedIntent, options.toBundle());

            }
        });
    }
}