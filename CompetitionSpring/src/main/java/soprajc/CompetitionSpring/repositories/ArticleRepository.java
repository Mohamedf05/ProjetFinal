package soprajc.CompetitionSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import soprajc.CompetitionSpring.model.Article;
import soprajc.CompetitionSpring.model.Journaliste;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
