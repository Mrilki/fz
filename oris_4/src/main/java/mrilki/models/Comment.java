package mrilki.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Comment {

    private long id;
    private String text;
    private long author_id;
    private long day_id;

}
