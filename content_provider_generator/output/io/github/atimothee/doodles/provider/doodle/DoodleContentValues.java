package io.github.atimothee.doodles.provider.doodle;

import java.util.Date;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.github.atimothee.doodles.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code doodle} table.
 */
public class DoodleContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return DoodleColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable DoodleSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public DoodleContentValues putName(@Nullable String value) {
        mContentValues.put(DoodleColumns.NAME, value);
        return this;
    }

    public DoodleContentValues putNameNull() {
        mContentValues.putNull(DoodleColumns.NAME);
        return this;
    }

    public DoodleContentValues putTitle(@Nullable String value) {
        mContentValues.put(DoodleColumns.TITLE, value);
        return this;
    }

    public DoodleContentValues putTitleNull() {
        mContentValues.putNull(DoodleColumns.TITLE);
        return this;
    }

    public DoodleContentValues putUrl(@Nullable String value) {
        mContentValues.put(DoodleColumns.URL, value);
        return this;
    }

    public DoodleContentValues putUrlNull() {
        mContentValues.putNull(DoodleColumns.URL);
        return this;
    }

    public DoodleContentValues putHighResUrl(@Nullable String value) {
        mContentValues.put(DoodleColumns.HIGH_RES_URL, value);
        return this;
    }

    public DoodleContentValues putHighResUrlNull() {
        mContentValues.putNull(DoodleColumns.HIGH_RES_URL);
        return this;
    }

    public DoodleContentValues putRunDate(@Nullable Date value) {
        mContentValues.put(DoodleColumns.RUN_DATE, value == null ? null : value.getTime());
        return this;
    }

    public DoodleContentValues putRunDateNull() {
        mContentValues.putNull(DoodleColumns.RUN_DATE);
        return this;
    }

    public DoodleContentValues putRunDate(@Nullable Long value) {
        mContentValues.put(DoodleColumns.RUN_DATE, value);
        return this;
    }
}
