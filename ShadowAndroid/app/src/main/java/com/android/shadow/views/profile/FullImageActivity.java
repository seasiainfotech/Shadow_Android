package com.android.shadow.views.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.shadow.R;
import com.bumptech.glide.Glide;

public class FullImageActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mUserImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        findViewById(R.id.image_view_back).setOnClickListener(this);
        mUserImageView = (ImageView) findViewById(R.id.image_view_user);
        mUserImageView.setOnClickListener(this);

        String image = getIntent().getStringExtra("user_image");
        Glide.with(this).load(image).
                error(getResources().getDrawable(R.drawable.profile_gray))
                .into(mUserImageView);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.image_view_back) {
            finish();
        }
    }
}
