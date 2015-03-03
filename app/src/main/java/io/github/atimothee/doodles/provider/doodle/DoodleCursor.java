package io.github.atimothee.doodles.provider.doodle;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.github.atimothee.doodles.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code doodle} table.
 */
public class DoodleCursor extends AbstractCursor implements DoodleModel {
    public DoodleCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(DoodleColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(DoodleColumns.NAME);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTitle() {
        String res = getStringOrNull(DoodleColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code url} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getUrl() {
        String res = getStringOrNull(DoodleColumns.URL);
        return res;
    }

    /**
     * Get the {@code high_res_url} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHighResUrl() {
        String res = getStringOrNull(DoodleColumns.HIGH_RES_URL);
        return res;
    }

    /**
     * Get the {@code run_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getRunDate() {
        Date res = getDateOrNull(DoodleColumns.RUN_DATE);
        return res;
    }
}
