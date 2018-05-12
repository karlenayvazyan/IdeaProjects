package am.ak.manning.SpringBootReadingList;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karlen on 9/7/17.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
