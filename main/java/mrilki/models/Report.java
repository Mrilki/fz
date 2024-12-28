package mrilki.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@AllArgsConstructor
@Getter
@Setter
@Builder
public class Report {
    private long id;
    private String text;
    private String reason;
    private long date_id;
    private long day_id;

}
