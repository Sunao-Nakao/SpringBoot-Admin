package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Contacts;
import com.example.demo.repository.ContactsRepository;
import com.example.demo.service.ContactService;

import jakarta.transaction.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
	
	/** ContactsRepositoryを使用してContactServiceのインスタンスを作成する。
     * @param contactsRepository Contactsエンティティのリポジトリ
     */
	private final ContactsRepository contactsRepository;
	
	
	public ContactServiceImpl(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
	}
	
	@Override
	public Optional<Contacts> selectById(Long Id){
		return contactsRepository.findById(Id);
		}
	
	@Override
	public List<Contacts> findAll() {
        return contactsRepository.findAll();
    }

	@Override
    public void insert(Contacts contact) {
    	contactsRepository.save(contact);
    }

	@Override
    public void update(Contacts contact) {
    	contactsRepository.save(contact);
    }

	@Override
    @Transactional
    public void delete(Long id) {
    	contactsRepository.deleteById(id);
    }


}
