package io.github.atimothee.doodles;

/**
 * Created by CrowdStar on 3/2/2015.
 */
public interface DoodleRequestListener {

    public void onSuccess(String JsonString);

    public void onFailed();

}
