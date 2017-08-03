package com.github.zxkane.controller;

import com.github.zxkane.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kane on 2017/8/2.
 */
@RestController
@RequestMapping(value="/internal/note")
@Slf4j
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/request/{id}")
    public ResponseEntity<?> getNoteByRequestid(@PathVariable("id") String requestid) {
        logger.debug("Requesting note by request id '{}'.", requestid);
        return ResponseEntity.ok().body(noteRepository.findByRequestid(requestid).doOnSuccess(note ->
                        logger.debug("Found note '{}'.", note))
                .doOnSuccess(response -> logger.debug("Successfully found note by request id '{}'.", requestid)));
    }
}
