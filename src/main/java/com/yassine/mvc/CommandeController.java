package com.yassine.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yassine.SERVICE.ICommandeService;
import com.yassine.SERVICE.ILigneCommandeService;
import com.yassine.entities.Commande;
import com.yassine.entities.LigneCommande;

@Controller
@RequestMapping(value="/commande",method=RequestMethod.GET)
public class CommandeController {
	
	@Autowired
	ICommandeService commande;
	@Autowired
	ILigneCommandeService lignecommande;
	
	@RequestMapping(value="/")
	public String index(Model model, Locale local) {
		List<Commande> commandes = commande.selectAll();
		List<LigneCommande> ligne = new ArrayList<LigneCommande>();
		for (Commande commande : commandes) {
			
			commande.setLignesCommande1(ligne);
			commande.setLignesCommande1(lignecommande.getByIdCommande(commande.getIdCommande()));
				
		}
		
		model.addAttribute("commandes", commandes);
		
		return"commande/commande";
	}

}
