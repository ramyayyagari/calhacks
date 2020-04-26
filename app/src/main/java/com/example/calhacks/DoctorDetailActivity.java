package com.example.calhacks;



import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;



/**
 * An activity representing a single User detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link DoctorListActivity}.
 */
public class DoctorDetailActivity extends AppCompatActivity {
    private String TAG = DoctorDetailActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "ENTERED DOCTORDETAILACTIVITY ONCREATE ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(DoctorDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(DoctorDetailFragment.ARG_ITEM_ID));
            DoctorDetailFragment fragment = new DoctorDetailFragment();
            fragment.setArguments(arguments);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.doctor_detail_container, fragment).commit();
        }
    }

}
