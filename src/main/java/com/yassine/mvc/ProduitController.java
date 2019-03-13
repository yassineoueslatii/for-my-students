package com.yassine.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yassine.SERVICE.IProduitService;
import com.yassine.entities.Produit;

@Controller
@RequestMapping(value="/produit",method=RequestMethod.GET)
public class ProduitController {
	
	@Autowired
	IProduitService prd;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index (Model model) {
				List<Produit> produits= prd.selectAll();
				model.addAttribute("produits", produits);
				return "produit/produit";
	}
	@RequestMapping(value="/nouveau", method=RequestMethod.GET)
	public String create (Model model) {
		Produit produit = new Produit() ;
	//	produit.setNomProduit("test");
		
		model.addAttribute("produit", produit);
		return "produit/nouveau";
	}
	
	@RequestMapping(value="/nouveauu",method=RequestMethod.POST)
	public String store(Produit produit) {
		if(produit!=null) {
			
			prd.save(produit);
		}
		return "redirect:/produit/";
	}
	
	@RequestMapping(value="/modifier/{id}", method=RequestMethod.GET)
	public String create (Model model,@PathVariable long id) {
		Produit produit = prd.getById(id) ;
		//produit.setNomProduit("test");
		
		model.addAttribute("produit", produit);
		return "produit/modifier";
	}
	@RequestMapping(value="/modifierr",method=RequestMethod.POST)
	public String modifier(Produit produit) {
		if(produit!=null) {
			
			prd.update(produit);
		}
		return "redirect:/produit/";
	}
	
	@RequestMapping(value="/supprimer/{id}",method=RequestMethod.PUT)
	public String remove (@PathVariable long id) {
		prd.remove(id);
		return "redirect:/produit/";
	}

}
