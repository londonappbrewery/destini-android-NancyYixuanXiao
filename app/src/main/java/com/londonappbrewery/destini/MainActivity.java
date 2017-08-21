package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int mStoryIndex;
    final int[] mStoryBank = {
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };
    final int[] mButtonTopText = {
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };
    final int[] mButtonBottomText = {
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState == null) {
            mStoryIndex = 0;
        } else {
            mStoryIndex = savedInstanceState.getInt("storyIndex");
        }
        mStoryTextView.setText(mStoryBank[mStoryIndex]);
        if (mStoryIndex > 2) {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else {
            mButtonTop.setText(mButtonTopText[mStoryIndex]);
            mButtonBottom.setText(mButtonBottomText[mStoryIndex]);
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 0 || mStoryIndex == 1) {
                    mStoryIndex = 2;
                    mButtonTop.setText(mButtonTopText[2]);
                    mButtonBottom.setText(mButtonBottomText[2]);
                } else {
                    mStoryIndex = 5;
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                }
                mStoryTextView.setText(mStoryBank[mStoryIndex]);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 0) {
                    mStoryIndex = 1;
                    mButtonTop.setText(mButtonTopText[1]);
                    mButtonBottom.setText(mButtonBottomText[1]);
                } else {
                    if (mStoryIndex == 1) {
                        mStoryIndex = 3;
                    } else {
                        mStoryIndex = 4;
                    }
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                }
                mStoryTextView.setText(mStoryBank[mStoryIndex]);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outstate) {
        outstate.putInt("storyIndex", mStoryIndex);
    }
}
