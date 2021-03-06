package com.flatstack.android.utils.network;

import android.content.Context;
import android.util.Log;

import com.flatstack.android.utils.ui.SimpleDialog;

import rx.functions.Action1;

/**
 * Created by Ilya Eremin on 12.08.2016.
 */
public class ErrorUtils {

    private static final String TAG = "Errors";

    public static Action1<Throwable> onError() {
        return ErrorUtils::logError;
    }

    public static void logError(Throwable throwable) {
        Log.d(TAG, "oh shit error occured", throwable);
    }

    public static void handle(Context context, Throwable error) {
        if (error instanceof RetrofitException) {
            SimpleDialog.show(context, (RetrofitException) error);
        } else {
            ErrorUtils.logError(error);
        }
    }

    public static Action1<Throwable> handle(Context context) {
        return error -> ErrorUtils.handle(context, error);
    }
}
