package com.example.calhacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * An activity representing a list of Users. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link DoctorDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class DoctorListActivity extends AppCompatActivity {

    private static final String TAG = DoctorListActivity.class.getName();

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        View recyclerView = findViewById(R.id.doctor_list);
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, DoctorsDB.DOCTORS, mTwoPane));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final DoctorListActivity mParentActivity;
        private final List<Doctor> mValues;
        private final boolean mTwoPane;

        SimpleItemRecyclerViewAdapter(DoctorListActivity parent,
                                      List<Doctor> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.doctor_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).getDocName());
            holder.mContentView.setText(mValues.get(position).getSpecialty());
            holder.itemView.setTag(mValues.get(position).getDocName());//get id
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = view.findViewById(R.id.doctorNameId);
                mContentView = view.findViewById(R.id.doctorSpecialtyId);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                String id = (String) view.getTag();
                Context context = view.getContext();
                Intent intent = new Intent(context, DoctorDetailActivity.class);
                intent.putExtra(DoctorDetailFragment.ARG_ITEM_ID, id);
                context.startActivity(intent);
            }
        }


    }
}
