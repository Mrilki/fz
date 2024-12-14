package mrilki.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Day {

    private Long id;
    private String text;
    private Date date;
    private Long author;

}
