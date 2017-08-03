package com.github.zxkane.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kane on 2017/7/27.
 */
@Document(collection = "note")
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    String id;
    String url;
    @Indexed(unique = true, background = true)
    private String requestid;
    private DateTime incomingTime;
}
