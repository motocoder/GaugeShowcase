package llc.berserkr.gaugeshowcase;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import llc.berserkr.gaugeshowcase.fragment.ArcGaugeFragment;
import llc.berserkr.gaugeshowcase.fragment.FullGaugeFragment;
import llc.berserkr.gaugeshowcase.fragment.HalfGaugeFragment;
import llc.berserkr.gaugeshowcase.fragment.MultiGaugeFragment;
import llc.berserkr.gaugeshowcase.fragment.RadialGaugeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Spinner spinner = findViewById(R.id.gauge_type_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gauges_array,
                android.R.layout.simple_spinner_item
        );
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        loadArcFragment();
                        break;
                    }
                    case 1: {
                        loadFullFragment();
                        break;
                    }
                    case 2: {
                        loadHalfFragment();
                        break;
                    }
                    case 3: {
                        loadMultiFragment();
                        break;
                    }
                    case 4 : {
                        loadRadialFragment();
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void loadArcFragment() {
        ArcGaugeFragment dynamicFragment = new ArcGaugeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.static_fragment_container, dynamicFragment);
        fragmentTransaction.addToBackStack(null); // Optional: add to back stack
        fragmentTransaction.commit();
    }

    private void loadFullFragment() {
        FullGaugeFragment dynamicFragment = new FullGaugeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.static_fragment_container, dynamicFragment);
        fragmentTransaction.addToBackStack(null); // Optional: add to back stack
        fragmentTransaction.commit();
    }

    private void loadRadialFragment() {
        RadialGaugeFragment dynamicFragment = new RadialGaugeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.static_fragment_container, dynamicFragment);
        fragmentTransaction.addToBackStack(null); // Optional: add to back stack
        fragmentTransaction.commit();
    }

    private void loadHalfFragment() {
        HalfGaugeFragment dynamicFragment = new HalfGaugeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.static_fragment_container, dynamicFragment);
        fragmentTransaction.addToBackStack(null); // Optional: add to back stack
        fragmentTransaction.commit();
    }

    private void loadMultiFragment() {
        MultiGaugeFragment dynamicFragment = new MultiGaugeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.static_fragment_container, dynamicFragment);
        fragmentTransaction.addToBackStack(null); // Optional: add to back stack
        fragmentTransaction.commit();
    }
}