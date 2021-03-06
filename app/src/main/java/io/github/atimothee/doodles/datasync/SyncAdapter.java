package io.github.atimothee.doodles.datasync;

/**
 * Created by Timo on 3/3/15.
 */

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.github.atimothee.doodles.R;
import io.github.atimothee.doodles.provider.DoodlesProvider;
import io.github.atimothee.doodles.provider.doodle.DoodleColumns;
import io.github.atimothee.doodles.provider.doodle.DoodleContentValues;
import io.github.atimothee.doodles.provider.doodle.DoodleModel;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Handle the transfer of data between a server and an
 * app, using the Android sync adapter framework.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {
    private static final String LOG_TAG = SyncAdapter.class.getSimpleName();
    // Global variables
    // Define a variable to contain a content resolver instance
    ContentResolver mContentResolver;

    /**
     * Set up the sync adapter
     */
    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        /*
         * If your app uses a content resolver, get an instance of it
         * from the incoming Context
         */
        mContentResolver = context.getContentResolver();
    }

    /**
     * Set up the sync adapter. This form of the
     * constructor maintains compatibility with Android 3.0
     * and later platform versions
     */
    public SyncAdapter(
            Context context,
            boolean autoInitialize,
            boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        /*
         * If your app uses a content resolver, get an instance of it
         * from the incoming Context
         */
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider, SyncResult syncResult) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://google.com")
                .build();

        DoodleService doodleService = restAdapter.create(DoodleService.class);
        List<Doodle> doodles = doodleService.listDoodles(extras.getInt(getContext().getString(R.string.key_year)), extras.getInt(getContext().getString(R.string.key_month)));
        List<ContentValues> contentValuesList = new ArrayList<>();
        ContentValues contentValues;
        for(Doodle d: doodles){
            contentValues = new ContentValues();
            contentValues.put(DoodleColumns.NAME, d.getName());
            contentValues.put(DoodleColumns.TITLE, d.getTitle());
            contentValues.put(DoodleColumns.URL, d.getUrl());
            contentValues.put(DoodleColumns.HIGH_RES_URL, d.getHiresUrl());
            contentValues.put(DoodleColumns.RUN_DATE, new Date(d.getRunDateArray().get(0),d.getRunDateArray().get(1),d.getRunDateArray().get(2)).getTime());
            contentValuesList.add(contentValues);
        }
        mContentResolver.bulkInsert(DoodleColumns.CONTENT_URI, contentValuesList.toArray(new ContentValues[contentValuesList.size()]));
        Log.d(LOG_TAG, "Retrofit fetched!");
    }
}
