package com.example.wangyu.redevenlope;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView openBtn;
    private ImageView envelopeTop;
    private ImageView envelopeBottom;
    private ObjectAnimator moveTop;
    private ObjectAnimator moveBottom;
    private EnvelopeView mEnvelopeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envelope_view);
//        mEnvelopeView = findViewById(R.id.envelope_view);
//        mEnvelopeView.startAnimation();

        openBtn = findViewById(R.id.open);
        envelopeBottom = findViewById(R.id.envelope_bottom);
        envelopeTop = findViewById(R.id.envelope_top);

        moveTop = ObjectAnimator.ofFloat(envelopeTop, "translationY", -900);
        moveBottom = ObjectAnimator.ofFloat(envelopeBottom, "translationY", 400);
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(2000).playTogether(moveTop, moveBottom);

        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.start();
            }
        });

    }
}
