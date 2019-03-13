package com.yassine.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.SERVICE.ICommandeService;
import com.yassine.SERVICE.ILigneCommandeService;
import com.yassine.SERVICE.IProduitService;
import com.yassine.entities.Commande;
import com.yassine.entities.Demo;
import com.yassine.entities.LigneCommande;


@RestController
public class TestController {
	@Autowired
	ICommandeService commande;
	@Autowired
	ILigneCommandeService lignecommande;
	@Autowired
	IProduitService produit;
	
	@RequestMapping(value="/getdata",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getdata(){
		Demo demo =new Demo();
		demo.setId("1");
		demo.setNom("Yassine");
		
		
		return new ResponseEntity<Object>(demo,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="/postdata",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Object> postdata(@RequestBody Demo demo){
	
	System.out.println("demo.id"+demo.getId());
	System.out.println("dem.nom"+demo.getNom());
	return new ResponseEntity<Object>("Success",HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getcommande",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getcommande(){
		List<Commande> commandes = commande.selectAll();
		for (Commande commande : commandes) {
			commande.setLignesCommande1(lignecommande.getByIdCommande(commande.getIdCommande()));
		}
	
		
		
		
		return new ResponseEntity<Object>(commandes,HttpStatus.OK);
		
		
	}

	@RequestMapping(value="/getlignescommande/{idCommande}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getlignecommande(@org.springframework.web.bind.annotation.PathVariable Long idCommande){
		List<LigneCommande> lignesCommandes=lignecommande.getByIdCommande(idCommande);
		
		
		return new ResponseEntity<Object>(lignesCommandes,HttpStatus.OK);
		
		
	}

}
