package io.github.atimothee.doodles;

import android.content.ContentResolver;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import io.github.atimothee.doodles.helpers.AccountHelper;
import io.github.atimothee.doodles.provider.DoodlesProvider;


public class MainActivity extends ActionBarActivity implements DoodleFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DoodleFragment())
                    .commit();
        }
    }

    private void sync(int year, int month){
        // Pass the settings flags by inserting them in a bundle
        Bundle settingsBundle = new Bundle();
        settingsBundle.putBoolean(
                ContentResolver.SYNC_EXTRAS_MANUAL, true);
        settingsBundle.putBoolean(
                ContentResolver.SYNC_EXTRAS_EXPEDITED, true);
        settingsBundle.putInt(getString(R.string.key_year), year);
        settingsBundle.putInt(getString(R.string.key_month), month);
        /*
         * Request the sync for the default account, authority, and
         * manual sync settings
         */
        AccountHelper accountHelper = new AccountHelper(this);
        ContentResolver.requestSync(accountHelper.CreateSyncAccount(), DoodlesProvider.AUTHORITY, settingsBundle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String id) {

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements DoodleRequestListener {
        TextView textView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            textView = (TextView) rootView.findViewById(R.id.textView);
            // adding action to the get doodle info button
            rootView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String year = "" + Calendar.getInstance().get(Calendar.YEAR);//get the current  year from system date
                    String month = "" + Calendar.getInstance().get(Calendar.MONTH);// get current month from system date
                    new DoodleInfo(PlaceholderFragment.this, year, month).execute();// call the doodle info class to make request to the server to fetch json string from google doodle page
                }
            });
            return rootView;
        }

        @Override
        public void onSuccess(String JsonString) {
            textView.setText(JsonString);// when request to the server is successfull, it output a jsonstring.
        }

        @Override
        public void onFailed() {
            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();// display a toast in case of failure
        }
    }
}