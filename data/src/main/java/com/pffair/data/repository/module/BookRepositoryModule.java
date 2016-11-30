package com.pffair.data.repository.module;


import com.pffair.data.repository.annotation.Local;
import com.pffair.data.repository.annotation.Remote;
import com.pffair.data.repository.datasource.BookDataSource;
import com.pffair.data.repository.datasource.local.BookLocalDataSource;
import com.pffair.data.repository.datasource.remote.BookRemoteDataSource;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pangff on 16/11/29.
 * Description BookRepositoryModule
 */

@Module
public class BookRepositoryModule {

    @Singleton
    @Provides
    @Local
    BookDataSource provideBookLocalDataSource(Context context) {
        return new BookLocalDataSource(context);
    }

    @Singleton
    @Provides
    @Remote
    BookDataSource provideBookRemoteDataSource() {
        return new BookRemoteDataSource();
    }
}
