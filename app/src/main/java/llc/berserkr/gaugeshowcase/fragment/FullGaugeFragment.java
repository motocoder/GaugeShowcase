package llc.berserkr.gaugeshowcase.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ekndev.gaugelibrary.DoubleValueFormatterImpl;
import com.ekndev.gaugelibrary.FullGauge;
import com.ekndev.gaugelibrary.Range;

import java.util.List;

import llc.berserkr.gaugeshowcase.R;

public class FullGaugeFragment extends Fragment {

    double value = 50;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflated = inflater.inflate(R.layout.full_gauge_fragment, container, false);

        final FullGauge fullGauge = inflated.findViewById(R.id.full_gauge);

        fullGauge.setMaxValue(100);
        fullGauge.setMinValue(0);
        fullGauge.setValue(value);
        fullGauge.setNeedleColor(getResources().getColor(R.color.purple_700, getActivity().getTheme()));
        fullGauge.setBackgroundColor(getResources().getColor(R.color.teal_200, getActivity().getTheme()));
        fullGauge.setFormatter(new DoubleValueFormatterImpl(1));

        Range greenRange = new Range(0, 33.3, Color.parseColor("#00ff00"));
        Range yellowRange = new Range(33.3, 66.6, Color.parseColor("#ffff00"));
        Range redRange = new Range(66.6, 100,  Color.parseColor("#ff0000"));

        fullGauge.setRanges(List.of(greenRange, yellowRange, redRange));

        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                value += (Math.random() - 0.5) * 5;
                if(value < 0) {
                    value = 0;
                }
                else if(value > 100) {
                    value = 100;
                }
                fullGauge.setValue(value);

                handler.postDelayed(this, 50);
            }
        };

        handler.postDelayed(runnable,50);


        return inflated;
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

    }
}

