package com.klinker.android.twitter.data;

import com.klinker.android.twitter.data.sq_lite.InteractionsDataSource;

public class StaticStateUtils {
    public static void resetStaticState() {
        InteractionsDataSource.dataSource = null;
    }
}
