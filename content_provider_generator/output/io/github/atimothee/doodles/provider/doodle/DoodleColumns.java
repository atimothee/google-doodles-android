package io.github.atimothee.doodles.provider.doodle;

import android.net.Uri;
import android.provider.BaseColumns;

import io.github.atimothee.doodles.provider.DoodlesProvider;
import io.github.atimothee.doodles.provider.doodle.DoodleColumns;

/**
 * A Google Doodle (Image that appears on Google home page)
 */
public class DoodleColumns implements BaseColumns {
    public static final String TABLE_NAME = "doodle";
    public static final Uri CONTENT_URI = Uri.parse(DoodlesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String TITLE = "title";

    public static final String URL = "url";

    public static final String HIGH_RES_URL = "high_res_url";

    public static final String RUN_DATE = "run_date";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            TITLE,
            URL,
            HIGH_RES_URL,
            RUN_DATE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c == NAME || c.contains("." + NAME)) return true;
            if (c == TITLE || c.contains("." + TITLE)) return true;
            if (c == URL || c.contains("." + URL)) return true;
            if (c == HIGH_RES_URL || c.contains("." + HIGH_RES_URL)) return true;
            if (c == RUN_DATE || c.contains("." + RUN_DATE)) return true;
        }
        return false;
    }

}
