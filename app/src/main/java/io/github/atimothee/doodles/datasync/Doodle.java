package io.github.atimothee.doodles.datasync;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Doodle {

    @Expose
    private String name;
    @Expose
    private String title;
    @Expose
    private String url;
    @SerializedName("run_date_array")
    @Expose
    private List<Integer> runDateArray = new ArrayList<Integer>();
    @SerializedName("hires_url")
    @Expose
    private String hiresUrl;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The runDateArray
     */
    public List<Integer> getRunDateArray() {
        return runDateArray;
    }

    /**
     *
     * @param runDateArray
     * The run_date_array
     */
    public void setRunDateArray(List<Integer> runDateArray) {
        this.runDateArray = runDateArray;
    }

    /**
     *
     * @return
     * The hiresUrl
     */
    public String getHiresUrl() {
        return hiresUrl;
    }

    /**
     *
     * @param hiresUrl
     * The hires_url
     */
    public void setHiresUrl(String hiresUrl) {
        this.hiresUrl = hiresUrl;
    }

}