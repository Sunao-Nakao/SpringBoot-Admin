package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.constant.UrlConst;
import com.example.demo.entity.Contacts;
import com.example.demo.repository.ContactsRepository;

/** コンタクト画面Controller **/
@Controller
public class ContactController {
	
	@Autowired
	private ContactsRepository contactsRepository;
	
	@GetMapping(UrlConst.CONTACTS)
	public String viewContacts(Model model) {
		List<Contacts> contactsList = contactsRepository.findAll();
		model.addAttribute("contactsList", contactsList);
		return "contacts";
	}
	
	@GetMapping(UrlConst.CONTACT_DETAIL)
	public String viewContactDetail(@PathVariable("id") String id, Model model) {
		Contacts contact = contactsRepository.findById(id).orElse(null);
		model.addAttribute("contact", contact);
		return "contactDetail";
	}
	
	@GetMapping(UrlConst.CONTACT_EDIT)
	public String editContact(@PathVariable("id") String id, Model model) {
		Contacts contact = contactsRepository.findById(id).orElse(null);
		model.addAttribute("contact", contact);
		return "editcontact";
	}
}