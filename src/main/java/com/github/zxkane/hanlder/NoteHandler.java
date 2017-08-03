package com.github.zxkane.hanlder;

import com.github.zxkane.domain.Note;
import com.github.zxkane.repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class NoteHandler {

    @Autowired
    NoteRepository noteRepository;

    public Mono<ServerResponse> getNoteByRequestid(ServerRequest request) {
        final String requestid = request.pathVariable("id");
        logger.debug("Requesting note by request id '{}'.", requestid);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(noteRepository.findByRequestid(requestid).doOnSuccess((note) ->
                    logger.debug("Found note '{}'.", note)), Note.class)
                .doOnSuccess((response) -> logger.debug("Successfully found note by request id '{}'.", requestid));
    }

}
