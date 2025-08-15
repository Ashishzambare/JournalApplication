package com.example.JournalApp.service;

import com.example.JournalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import com.example.JournalApp.entity.JournalEntry;
import com.example.JournalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {


    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the entry.", e);
        }
    }



    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }


    public Optional<JournalEntry> getJournalEntryById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public void deleteByUserName(String userName) {
        User user = userService.findByUserName(userName);
        if (user != null && user.getJournalEntries() != null) {
            user.getJournalEntries().clear();
            userService.saveUser(user); // save the updated user without entries
        }
    }

    @Transactional
    public boolean deleteJournalById(ObjectId id, String userName) {
        try {
            User user = userService.findByUserName(userName);
            boolean removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));

            if (removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }

            return removed;
        } catch (Exception e) {
            log.error("Error while deleting journal entry", e);
            throw new RuntimeException("An error occurred while deleting the entry.", e);
        }
    }
}