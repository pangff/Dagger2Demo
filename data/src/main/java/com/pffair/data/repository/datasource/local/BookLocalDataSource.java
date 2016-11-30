package com.pffair.data.repository.datasource.local;


import com.pffair.data.repository.datasource.BookDataSource;
import com.pffair.data.repository.datasource.entity.Book;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;


/**
 * Created by pangff on 16/11/29.
 * Description BookRemoteDataSource
 */
@Singleton
public class BookLocalDataSource implements BookDataSource {

    public BookLocalDataSource(Context context){

    }

    @Override
    public void getBooks(LoadBookCallback callback) {
        List<Book> list = new ArrayList<>();
        for(int i=0;i<30;i++){
            Book book = new Book();
            book.setName("Book-local:"+i);
            list.add(book);
        }
        callback.onBooksLoaded(list);
    }

    @Override
    public void refreshBooks() {

    }
}
