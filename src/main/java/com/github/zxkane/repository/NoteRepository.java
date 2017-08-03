package com.github.zxkane.repository;

import com.github.zxkane.domain.Note;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by kane on 2017/7/28.
 */
public interface NoteRepository extends ReactiveMongoRepository<Note, String> {

    Mono<Note> findByRequestid(String requestid);
}
