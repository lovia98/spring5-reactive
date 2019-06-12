package org.rpis5.chapters.chapter_07.wrapped_sync;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository
   extends CrudRepository<Book, Integer> {

   Iterable<Book> findByIdBetween(int lower, int upper);

   @Query("SELECT b FROM Book b WHERE " +
      "LENGTH(b.title) = (SELECT MIN(LENGTH(b2.title)) FROM Book b2)")
   Iterable<Book> findShortestTitle();
}



