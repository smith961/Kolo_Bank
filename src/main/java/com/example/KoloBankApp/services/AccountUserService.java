package com.example.KoloBankApp.services;

import com.example.KoloBankApp.model.AccountUser;
import com.example.KoloBankApp.repository.AccountUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class AccountUserService {
    @Autowired
    private AccountUserRepository accountUserRepository;

    public ResponseEntity<List<AccountUser>> getAllUsers(){
        return new ResponseEntity<>(accountUserRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Optional<AccountUser>> getById(int id){
    return new ResponseEntity<>(accountUserRepository.findById(id), HttpStatus.OK);}

    public ResponseEntity<AccountUser> getByUsername(String username){
        return new ResponseEntity<>(accountUserRepository.findByUsername(username), HttpStatus.OK);
    }

    public ResponseEntity<AccountUser> createNewAccountUser(AccountUser user){
        return new ResponseEntity<>(accountUserRepository.save(user), HttpStatus.CREATED);
    }
@Transactional
    public ResponseEntity<AccountUser> updateUserDetails(int id, AccountUser user){
      AccountUser accountUser = accountUserRepository.findById(id).get();
      accountUser.setFirstName(user.getFirstName());
      accountUser.setMiddleName(user.getMiddleName());
      accountUser.setLastName(user.getLastName());
      accountUser.setUsername(user.getUsername());
      accountUser.setPhoneNumber(user.getPhoneNumber());
      return  new ResponseEntity<>(accountUserRepository.save(accountUser),HttpStatus.ACCEPTED);
    }
    @Transactional
    public ResponseEntity<AccountUser> deleteAccountUser(int id){
        AccountUser user = accountUserRepository.findById(id).get();
        accountUserRepository.deleteById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}