package io.github.atimothee.doodles;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import io.github.atimothee.doodles.provider.doodle.DoodleColumns;
import io.github.atimothee.doodles.provider.doodle.DoodleSelection;

public class DetailFragment extends Fragment implements LoaderManager.LoaderCallbacks{

    private static final int DETAIL_LOADER = 1;
    private TextView titleTextView;
    private ImageView imageView;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        titleTextView = (TextView)rootView.findViewById(R.id.textview_doodle_title);
        imageView = (ImageView)rootView.findViewById(R.id.image_doodle_full);

        return rootView;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        DoodleSelection selection = new DoodleSelection();
        selection.id(args.getLong(getString(R.string.key_id)));
        return new CursorLoader(getActivity(), DoodleColumns.CONTENT_URI, DoodleColumns.ALL_COLUMNS, selection.sel(), selection.args(), null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        Cursor cursor = (Cursor)data;
        if(cursor.moveToFirst()) {
            getActivity().setTitle(cursor.getString(cursor.getColumnIndex(DoodleColumns.TITLE)));
            titleTextView.setText(cursor.getString(cursor.getColumnIndex(DoodleColumns.TITLE)));
            Picasso.with(getActivity()).load("http:" + cursor.getString(cursor.getColumnIndex(DoodleColumns.URL))).into(imageView);
        }
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(DETAIL_LOADER, getArguments(), this);
    }
}
