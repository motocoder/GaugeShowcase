package llc.berserkr.guageshowcase.fragment;

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

import com.ekndev.guagelibrary.MultiGauge;
import com.ekndev.guagelibrary.Range;

import java.util.List;

import llc.berserkr.guageshowcase.R;

public class MultiGaugeFragment extends Fragment {

    double value = 50;
    double value2 = 50;
    double value3 = 50;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflated = inflater.inflate(R.layout.multi_guage_fragment, container, false);

        final MultiGauge arcGuage = inflated.findViewById(R.id.multi_gauge);

        arcGuage.setMaxValue(100);
        arcGuage.setMinValue(0);
        arcGuage.setValue(value);
        arcGuage.setNeedleColor(getResources().getColor(R.color.purple_700, getActivity().getTheme()));
        arcGuage.setBackgroundColor(getResources().getColor(R.color.teal_200, getActivity().getTheme()));
        arcGuage.setValueColor(getResources().getColor(R.color.purple_700, getActivity().getTheme()));

        Range greenRange = new Range(0, 33.3, Color.parseColor("#00ff00"));
        Range yellowRange = new Range(33.3, 66.6, Color.parseColor("#ffff00"));
        Range redRange = new Range(66.6, 100,  Color.parseColor("#ff0000"));

        arcGuage.setRanges(List.of(greenRange, yellowRange, redRange));
        arcGuage.setSeconRanges(List.of(greenRange, yellowRange, redRange));
        arcGuage.setThirdRanges(List.of(greenRange, yellowRange, redRange));
        {
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
                    arcGuage.setValue(value);

                    handler.postDelayed(this, 50);
                }
            };

            handler.postDelayed(runnable,50);
        }

        {
            final Handler handler = new Handler(Looper.getMainLooper());

            final Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    value2 += (Math.random() - 0.5);
                    arcGuage.setSecondValue(value2);

                    handler.postDelayed(this, 100);
                }
            };

            handler.postDelayed(runnable, 100);
        }

        {
            final Handler handler = new Handler(Looper.getMainLooper());

            final Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    value3 += (Math.random() - 0.5);
                    arcGuage.setThirdValue(value3);

                    handler.postDelayed(this, 100);
                }
            };

            handler.postDelayed(runnable, 100);
        }


        return inflated;
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);

    }
}

