package edu.jhuapl.sd.sig.vistool.vistoolwebservice.controller;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.EmailUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class EmailController {
    @Autowired private EmailUtilities emailUtilities;

    @Transactional
    @PutMapping(value = "/email/support", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity putEmail(@RequestBody String emailBody) {
        emailUtilities.sendEmail(emailBody);
        return ResponseEntity.ok(200);
    }
}
