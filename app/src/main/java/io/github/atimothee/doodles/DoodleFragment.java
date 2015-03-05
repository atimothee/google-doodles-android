package io.github.atimothee.doodles;

import android.app.Activity;
import android.app.LoaderManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import io.github.atimothee.doodles.dummy.DummyContent;
import io.github.atimothee.doodles.provider.doodle.DoodleColumns;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class DoodleFragment extends Fragment implements AbsListView.OnItemClickListener, android.support.v4.app.LoaderManager.LoaderCallbacks<Object> {

    private static final int DOODLE_LOADER = 1;

    private OnFragmentInteractionListener mListener;
    private AbsListView mListView;
    private SimpleCursorAdapter mAdapter;
    private Cursor mCursor;
    private final String[] COLUMNS = {DoodleColumns.TITLE, DoodleColumns.URL};
    private final int[] VIEW_IDS = {R.id.textview_doodle_title, R.id.image_doodle_thumbnail};

    public DoodleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new SimpleCursorAdapter(getActivity(), R.layout.doodle_list_item, null, COLUMNS, VIEW_IDS);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {

                if(view.getId()==R.id.image_doodle_thumbnail){
                    Picasso.with(getActivity()).load("http:"+cursor.getString(cursor.getColumnIndex(DoodleColumns.URL))).into((ImageView)view);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doodle, container, false);
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (null != mListener) {
            mCursor.moveToPosition(position);
            mListener.onFragmentInteraction(mCursor.getLong(mCursor.getColumnIndex(DoodleColumns._ID)));
        }
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {

        return new CursorLoader(getActivity(), DoodleColumns.CONTENT_URI, DoodleColumns.ALL_COLUMNS, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {
        Cursor cursor = (Cursor) data;
        mCursor = cursor;
        mAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Long id);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(DOODLE_LOADER, null, this);
    }
}
