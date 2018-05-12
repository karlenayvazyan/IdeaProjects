package am.ak.journal.springbootjournal.repository;

import am.ak.journal.springbootjournal.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
