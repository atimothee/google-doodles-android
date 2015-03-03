package io.github.atimothee.doodles.provider.doodle;

import io.github.atimothee.doodles.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * A Google Doodle (Image that appears on Google home page)
 */
public interface DoodleModel extends BaseModel {

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code url} value.
     * Can be {@code null}.
     */
    @Nullable
    String getUrl();

    /**
     * Get the {@code high_res_url} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHighResUrl();

    /**
     * Get the {@code run_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getRunDate();
}
