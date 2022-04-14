package soprajc.CompetitionSpring.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import soprajc.CompetitionSpring.exception.ArticleException;
import soprajc.CompetitionSpring.model.Article;
import soprajc.CompetitionSpring.repositories.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private Validator validator;
	
	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		String absolutePath = "C:\\Users\\ajc\\Desktop\\Projet Groupe2\\ProjetFinal\\CompetitionAngular\\src\\assets\\images\\"+file.getOriginalFilename();
		file.transferTo(new File(absolutePath));
		String image = "assets/images/"+file.getOriginalFilename();
		return image;
	}
	
	public List<Article> getAll() {
		return articleRepository.findAll();
	}
	
	public Article getById(Integer id) {
		return articleRepository.findById(id).orElseThrow(ArticleException::new);
	}
	
	public Article save(Article article) {
		Set<ConstraintViolation<Article>> constraints = validator.validate(article);
		if (!constraints.isEmpty()) {
			throw new ArticleException("erreur de validation");
		}
		
		if (article.getId()!=null) {
			Article articleEnBase = getById(article.getId());
			article.setVersion(articleEnBase.getVersion());
		}
		return articleRepository.save(article);
	}
	
	public void delete(Article article) {
		delete(article.getId());
	}
	
	public void delete(Integer id) {
		articleRepository.deleteById(id);
	}
}
