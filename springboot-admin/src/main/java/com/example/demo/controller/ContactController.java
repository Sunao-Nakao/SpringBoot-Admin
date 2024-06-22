package com.example.demo.controller;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.constant.UrlConst;
import com.example.demo.entity.Contacts;
import com.example.demo.form.ContactForm;
import com.example.demo.repository.ContactsRepository;
import com.example.demo.service.ContactService;

/** コンタクト画面Controller **/
@Controller
public class ContactController {
	
	@Autowired
	private ContactsRepository contactsRepository;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
    private Mapper mapper; 
	
	
	/** コンタクト一覧画面を表示 **
	 * @param model モデル
	 * @return コンタクト一覧のテンプレート名
	 */
	@GetMapping(UrlConst.CONTACTS)
	public String viewContacts(Model model) {
		List<Contacts> contactsList = contactsRepository.findAll();
		model.addAttribute("contacts", contactsList);
		return "contacts";
	}
	
	/** 指定されたIDのコンタクト詳細画面 **
	 * @param id コンタクトID
	 * @param model モデル
	 * @return コンタクト詳細のテンプレート名
	 */
	@GetMapping(UrlConst.CONTACT_DETAIL)
	public String viewContactDetail(@PathVariable("id") Long id, Model model) {
		Contacts contact = contactsRepository.findById(id).orElse(null);
		model.addAttribute("contact", contact);
		return "contactdetail";
	}
	
	/** 指定されたIDのコンタクト編集画面 **
	 * @param id コンタクトID
	 * @param model モデル
	 * @return コンタクト編集のテンプレート名
	 */
	@GetMapping(UrlConst.CONTACT_EDIT)
	public String contactedit(@PathVariable("id") Long id, Model model) {
		Contacts contact = contactsRepository.findById(id).orElse(null);
		model.addAttribute("contact", contact);
		return "contactedit";
	}
	
	/** コンタクト情報を更新 **
	 * @param id コンタクトID
	 * @param contactForm 更新するコンタクト情報のフォーム
	 * @return コンタクト一覧画面へのリダイレクト
	 */
	 @PostMapping(UrlConst.CONTACT_DETAIL)
	 public String updateContact(@PathVariable Long id, @ModelAttribute ContactForm contactForm, RedirectAttributes redirectAttributes) {
		    contactService.selectById(id)
		            .ifPresent(contacts -> {
		                mapper.map(contactForm, contacts);
		                contactsRepository.save(contacts);
		                redirectAttributes.addAttribute("id", id);
		            });
		    return "redirect:/admin/contacts/{id}";
		}
	 
	 /** コンタクト情報を削除 **
	     * @param id コンタクトID
	     * @return コンタクト一覧画面へのリダイレクト
	     */
	    @PostMapping("/admin/contacts/{id}/delete/")
	    public String delete(@PathVariable("id") Long id) {
	        contactService.delete(id);
	        return "redirect:/admin/contacts";
	    }
	
	
	
}