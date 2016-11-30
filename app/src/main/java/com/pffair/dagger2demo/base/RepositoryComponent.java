package com.pffair.dagger2demo.base;


import com.pffair.data.repository.BookRepository;
import com.pffair.data.repository.module.BookRepositoryModule;
import com.pffair.data.repository.UserRepository;
import com.pffair.data.repository.module.UserRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pangff on 16/11/29.
 * Description RepositoryComponent
 */
@Singleton
@Component(modules = {BookRepositoryModule.class, UserRepositoryModule.class, ApplicationModule.class})
public interface RepositoryComponent {

    UserRepository getUserRepository();

    BookRepository getBookRepository();
}
