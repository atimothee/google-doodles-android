package io.github.atimothee.doodles.provider.doodle;

import java.util.Date;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import io.github.atimothee.doodles.provider.base.AbstractSelection;

/**
 * Selection for the {@code doodle} table.
 */
public class DoodleSelection extends AbstractSelection<DoodleSelection> {
    @Override
    protected Uri baseUri() {
        return DoodleColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @param sortOrder How to order the rows, formatted as an SQL ORDER BY clause (excluding the ORDER BY itself). Passing null will use the default sort
     *            order, which may be unordered.
     * @return A {@code DoodleCursor} object, which is positioned before the first entry, or null.
     */
    public DoodleCursor query(ContentResolver contentResolver, String[] projection, String sortOrder) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), sortOrder);
        if (cursor == null) return null;
        return new DoodleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null)}.
     */
    public DoodleCursor query(ContentResolver contentResolver, String[] projection) {
        return query(contentResolver, projection, null);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, projection, null, null)}.
     */
    public DoodleCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null, null);
    }


    public DoodleSelection id(long... value) {
        addEquals("doodle." + DoodleColumns._ID, toObjectArray(value));
        return this;
    }

    public DoodleSelection name(String... value) {
        addEquals(DoodleColumns.NAME, value);
        return this;
    }

    public DoodleSelection nameNot(String... value) {
        addNotEquals(DoodleColumns.NAME, value);
        return this;
    }

    public DoodleSelection nameLike(String... value) {
        addLike(DoodleColumns.NAME, value);
        return this;
    }

    public DoodleSelection nameContains(String... value) {
        addContains(DoodleColumns.NAME, value);
        return this;
    }

    public DoodleSelection nameStartsWith(String... value) {
        addStartsWith(DoodleColumns.NAME, value);
        return this;
    }

    public DoodleSelection nameEndsWith(String... value) {
        addEndsWith(DoodleColumns.NAME, value);
        return this;
    }

    public DoodleSelection title(String... value) {
        addEquals(DoodleColumns.TITLE, value);
        return this;
    }

    public DoodleSelection titleNot(String... value) {
        addNotEquals(DoodleColumns.TITLE, value);
        return this;
    }

    public DoodleSelection titleLike(String... value) {
        addLike(DoodleColumns.TITLE, value);
        return this;
    }

    public DoodleSelection titleContains(String... value) {
        addContains(DoodleColumns.TITLE, value);
        return this;
    }

    public DoodleSelection titleStartsWith(String... value) {
        addStartsWith(DoodleColumns.TITLE, value);
        return this;
    }

    public DoodleSelection titleEndsWith(String... value) {
        addEndsWith(DoodleColumns.TITLE, value);
        return this;
    }

    public DoodleSelection url(String... value) {
        addEquals(DoodleColumns.URL, value);
        return this;
    }

    public DoodleSelection urlNot(String... value) {
        addNotEquals(DoodleColumns.URL, value);
        return this;
    }

    public DoodleSelection urlLike(String... value) {
        addLike(DoodleColumns.URL, value);
        return this;
    }

    public DoodleSelection urlContains(String... value) {
        addContains(DoodleColumns.URL, value);
        return this;
    }

    public DoodleSelection urlStartsWith(String... value) {
        addStartsWith(DoodleColumns.URL, value);
        return this;
    }

    public DoodleSelection urlEndsWith(String... value) {
        addEndsWith(DoodleColumns.URL, value);
        return this;
    }

    public DoodleSelection highResUrl(String... value) {
        addEquals(DoodleColumns.HIGH_RES_URL, value);
        return this;
    }

    public DoodleSelection highResUrlNot(String... value) {
        addNotEquals(DoodleColumns.HIGH_RES_URL, value);
        return this;
    }

    public DoodleSelection highResUrlLike(String... value) {
        addLike(DoodleColumns.HIGH_RES_URL, value);
        return this;
    }

    public DoodleSelection highResUrlContains(String... value) {
        addContains(DoodleColumns.HIGH_RES_URL, value);
        return this;
    }

    public DoodleSelection highResUrlStartsWith(String... value) {
        addStartsWith(DoodleColumns.HIGH_RES_URL, value);
        return this;
    }

    public DoodleSelection highResUrlEndsWith(String... value) {
        addEndsWith(DoodleColumns.HIGH_RES_URL, value);
        return this;
    }

    public DoodleSelection runDate(Date... value) {
        addEquals(DoodleColumns.RUN_DATE, value);
        return this;
    }

    public DoodleSelection runDateNot(Date... value) {
        addNotEquals(DoodleColumns.RUN_DATE, value);
        return this;
    }

    public DoodleSelection runDate(Long... value) {
        addEquals(DoodleColumns.RUN_DATE, value);
        return this;
    }

    public DoodleSelection runDateAfter(Date value) {
        addGreaterThan(DoodleColumns.RUN_DATE, value);
        return this;
    }

    public DoodleSelection runDateAfterEq(Date value) {
        addGreaterThanOrEquals(DoodleColumns.RUN_DATE, value);
        return this;
    }

    public DoodleSelection runDateBefore(Date value) {
        addLessThan(DoodleColumns.RUN_DATE, value);
        return this;
    }

    public DoodleSelection runDateBeforeEq(Date value) {
        addLessThanOrEquals(DoodleColumns.RUN_DATE, value);
        return this;
    }
}
