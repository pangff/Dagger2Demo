package com.pffair.data.repository;


import com.pffair.data.repository.annotation.Local;
import com.pffair.data.repository.annotation.Remote;
import com.pffair.data.repository.datasource.BookDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by pangff on 16/11/29.
 * Description UserRepository
 */
@Singleton
public class BookRepository implements BookDataSource{

    boolean mCacheIsDirty = false;

    @Remote
    BookDataSource bookRemoteDataSource;

    @Local
    private BookDataSource bookLocalDataSource;

    @Inject
    public BookRepository(@Remote BookDataSource bookRemoteDataSource,
            @Local BookDataSource bookLocalDataSource){
        this.bookRemoteDataSource = bookRemoteDataSource;
        this.bookLocalDataSource = bookLocalDataSource;
    }

    @Override
    public void getBooks(LoadBookCallback callback) {
        if(!mCacheIsDirty){
            bookLocalDataSource.getBooks(callback);
        }else{
            bookRemoteDataSource.getBooks(callback);
        }
    }

    @Override
    public void refreshBooks() {
        mCacheIsDirty = true;
    }
}
