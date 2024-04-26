package com.major.DigitalDiary.Controller;

import com.major.DigitalDiary.Exception.EntryNotFoundException;
import com.major.DigitalDiary.Model.Entry;
import com.major.DigitalDiary.Model.User;
import com.major.DigitalDiary.Service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "${frontend.origin}")
@RequestMapping("/entry")
public class EntryController {
    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Entry>> getUserEntries(@PathVariable("username") String username) {
        System.out.println(username);
      List<Entry> userEntries = entryService.findAllEntriesByUsername(username);
        return new ResponseEntity<>(userEntries, HttpStatus.OK);
    }
    @GetMapping("/{username}/{date}")
    public ResponseEntity<Entry> getUserEntryByDate(@PathVariable("username") String username, @PathVariable("date") LocalDate date) {
        System.out.println(username);
        Entry userEntry= entryService.findEntryByUsernameAndDate(username,date);
        if(userEntry ==null){
            throw new EntryNotFoundException("There is no record on this day :(");
        }
        System.out.println(userEntry);
        return new ResponseEntity<>(userEntry, HttpStatus.OK);
    }

    @GetMapping("/find/{user_id}")
    public ResponseEntity<List<Entry>> getUserEntries(@PathVariable("user_id") Long userId) {
        System.out.println(userId);
      List<Entry> userEntries = entryService.findEntriesByUserId(userId);
        return new ResponseEntity<>(userEntries, HttpStatus.OK);
    }



    @GetMapping("/parent/{user_id}")
    public ResponseEntity<Entry> getParentEntry(@PathVariable("user_id") Long userId) {
        System.out.println(userId);
        Entry yesterdayEntry = entryService.findChildYesterdayEntryByUserId(userId);
        return new ResponseEntity<>(yesterdayEntry, HttpStatus.OK);
    }
    @GetMapping("/today/{username}")
    public ResponseEntity<Entry> getTodayEntry(@PathVariable("username") String username) {
        System.out.println(username);
        Entry todayEntry = entryService.findEntryByUsernameAndDate(username,LocalDate.now());
        return new ResponseEntity<>(todayEntry, HttpStatus.OK);
    }


    @GetMapping("/parent/user/{username}")
    public ResponseEntity<Entry> getParentEntry(@PathVariable("username") String username) {
        System.out.println(username);
        Entry yesterdayEntry = entryService.findChildYesterdayEntryByUsername(username);
        return new ResponseEntity<>(yesterdayEntry, HttpStatus.OK);
    }
    @PostMapping(path = "/create/{username}")
    public ResponseEntity<Void> setParent(@PathVariable String username, @RequestBody Entry entry){
        System.out.println("Entry Details");
        System.out.println(entry);

        //throw new RuntimeException("Contact Support!!");
        entryService.setEntry(entry);
        return ResponseEntity.ok().build();
    }
}
