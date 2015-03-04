package io.github.atimothee.doodles.helpers;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;

import io.github.atimothee.doodles.R;

/**
 * Created by Timo on 3/4/15.
 */
public class AccountHelper {
    private static final String LOG_TAG = AccountHelper.class.getSimpleName();
    private Context mContext;

    public AccountHelper(Context mContext){
        this.mContext = mContext;
    }

    public Account CreateSyncAccount() {
        // Create the account type and default account
        Account newAccount = new Account(
                mContext.getString(R.string.account), mContext.getString(R.string.account_type));
        // Get an instance of the Android account manager
        AccountManager accountManager =
                (AccountManager) mContext.getSystemService(
                        mContext.ACCOUNT_SERVICE);
        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */
        if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
            Log.e(LOG_TAG, "Account exists or some other error occured!");
        }
        return newAccount;
    }
}
