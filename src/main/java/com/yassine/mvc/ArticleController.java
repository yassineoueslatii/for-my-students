package com.yassine.mvc;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yassine.SERVICE.IArticleService;
import com.yassine.entities.Article;


@Controller
@RequestMapping(value="/article", method = RequestMethod.GET)
public class ArticleController {
	@Autowired
	private IArticleService articlee;
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String list(Model model) {
		List<Article> articles=articlee.selectAll();
		model.addAttribute("articles", articles);
		return "article/article";
	}
	@RequestMapping(value="/nouveau",method = RequestMethod.GET)
	String form(Model model) {
		Article article =new Article();
		article.setNomArticle("Test");
		model.addAttribute("article", article);
		return "article/ajout";
	}
	@RequestMapping(value="/nouveau/",method=RequestMethod.POST)
	public String save(Model model , Article article) {
		if (article!=null) {
			if(article.getIdArticle()==null) {
				articlee.save(article);
			}
			else {
			articlee.update(article);
			}
		}
		return "redirect:/article/";
	}
		
	@RequestMapping(value ="/modifier/{idArticle}")
	public String modifier(Model model,@PathVariable long idArticle) {
		Article article=articlee.getById(idArticle);
		model.addAttribute("article", article);
		return"article/ajout";
	}
	@RequestMapping(value ="/supprimer/{idArticle}")
	public String modifier(@PathVariable long idArticle) {
	if(articlee.getById(idArticle)!=null) {
		articlee.remove(idArticle);
		
	}
	return "redirect:/article/";}
}
