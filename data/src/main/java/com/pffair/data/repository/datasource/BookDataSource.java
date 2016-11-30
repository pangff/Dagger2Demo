package com.pffair.data.repository.datasource;

import com.pffair.data.repository.datasource.entity.Book;

import java.util.List;

/**
 * Created by pangff on 16/11/29.
 * Description BookDataSource
 */

public interface BookDataSource {

     interface LoadBookCallback {

          void onBooksLoaded(List<Book> books);

          void onDataNotAvailable();
     }

     void getBooks(LoadBookCallback callback);

     void refreshBooks();
}
