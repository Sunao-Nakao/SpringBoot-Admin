package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contacts;
import com.example.demo.repository.ContactsRepository;



/** コンタクトサービスクラス **/
@Service
public class ContactService {
	
	/** ContactsRepositoryを使用してContactServiceのインスタンスを作成する。
     * @param contactsRepository Contactsエンティティのリポジトリ
     */
	@Autowired
	private ContactsRepository contactsRepository;
	
	public ContactService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }
	
	/** 指定されたIDを持つContactsエンティティを取得する。
     * @param id 取得したいContactsエンティティのID
     * @return 指定されたIDを持つContactsエンティティのOptional
     */
	public Optional<Contacts> selectById(Long Id){
		return contactsRepository.findById(Id);
		}
	
	public List<Contacts> findAll() {
        return contactsRepository.findAll();
    }

    //ポイント①
    public void insert(Contacts contact) {
    	contactsRepository.save(contact);
    }

    //ポイント②
    public void update(Contacts contact) {
    	contactsRepository.save(contact);
    }

    //ポイント③
    public void delete(Long id) {
    	contactsRepository.deleteById(id);
    }

}
