package com.pffair.data.repository.datasource.remote;


import com.pffair.data.repository.datasource.BookDataSource;
import com.pffair.data.repository.datasource.entity.Book;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by pangff on 16/11/29.
 * Description BookRemoteDataSource
 */
@Singleton
public class BookRemoteDataSource implements BookDataSource {

    @Override
    public void getBooks(final LoadBookCallback callback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Book> list = new ArrayList<>();
                for(int i=0;i<30;i++){
                    Book book = new Book();
                    book.setName("Book-remote:"+i);
                    list.add(book);
                }
                callback.onBooksLoaded(list);
            }
        }, 1000);
    }

    @Override
    public void refreshBooks() {

    }
}
