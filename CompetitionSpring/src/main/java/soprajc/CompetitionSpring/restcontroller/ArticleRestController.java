package soprajc.CompetitionSpring.restcontroller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;

import soprajc.CompetitionSpring.exception.ArticleException;
import soprajc.CompetitionSpring.model.Article;
import soprajc.CompetitionSpring.model.JsonViews;
import soprajc.CompetitionSpring.services.ArticleService;

@RestController
@RequestMapping("/api/article")
@CrossOrigin(origins = "*")
public class ArticleRestController {
	
	@Autowired
	ArticleService articleService;
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Article create(@Valid @RequestBody Article article, BindingResult br){
		article.setDate(LocalDate.now());;
		return save(article, br);
	}
	
	private Article save(Article article, BindingResult br) {
		if (br.hasErrors()) {
			throw new ArticleException();
		}
		return articleService.save(article);
	}

	@PostMapping("/{id}")
	private void uploadFile(@PathVariable Integer id, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		if(file.getContentType().contains("image")) {
		String URL = articleService.uploadFile(file);
		articleService.getById(id).setImage(URL);
		articleService.save(articleService.getById(id));
		//return URL;
		}
		else {System.out.println("Mauvais format"); }
	}
		
	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Article> getAll() {
		return articleService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Article getById(@PathVariable Integer id) {
		return articleService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		articleService.delete(id);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Article update(@PathVariable Integer id, @Valid @RequestBody Article article, BindingResult br) {
		Article articleEnBase = articleService.getById(id);
		article.setJournaliste(articleEnBase.getJournaliste());
		article.setId(id);
		article.setDate(LocalDate.now());
		return save(article, br);
	}
		
	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Article partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Article article = articleService.getById(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Article.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, article, v);
		});
		article.setDate(LocalDate.now());
		return articleService.save(article);
	}
}
