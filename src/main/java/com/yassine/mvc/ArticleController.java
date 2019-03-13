package com.yassine.mvc;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Locale;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yassine.SERVICE.IArticleService;
import com.yassine.entities.Article;
import com.yassine.export.ArticleExport;
import com.yassine.export.FileExporter;


@Controller
@RequestMapping(value="/article", method = RequestMethod.GET)
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	private FileExporter exporter = new ArticleExport();
	
	
	
	@Autowired
	private IArticleService articlee;
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String list(Model model,Locale locale) {
		List<Article> articles=articlee.selectAll();
		model.addAttribute("articles", articles);
		logger.info("Welcome home! The client locale is {}.", locale);
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
	public String save(Model model , @ModelAttribute("user") @Valid Article article, BindingResult result) {
		if (result.hasErrors()) {
	         return "redirect:/article/nouveau";
	      }
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
	@RequestMapping(value ="/export")
	public String export(HttpServletResponse response) throws IOException {
		
		exporter.exportDataToExcel(response, null, null);
		return null;
	}
}
