package com.nex3z.flowlayout.flowlayout.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.TextView;

import com.nex3z.flowlayout.FlowLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillAutoSpacingLayout();
    }

    private void fillAutoSpacingLayout() {
        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flow);
        String[] dummyTexts = getResources().getStringArray(R.array.lorem_ipsum);

        for (String text : dummyTexts) {
            TextView textView = buildLabel(text);
            flowLayout.addView(textView);
        }
    }

    private TextView buildLabel(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setPadding((int)dpToPx(16), (int)dpToPx(8), (int)dpToPx(16), (int)dpToPx(8));
        textView.setBackgroundResource(R.drawable.label_bg);

        return textView;
    }

    private float dpToPx(float dp){
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
