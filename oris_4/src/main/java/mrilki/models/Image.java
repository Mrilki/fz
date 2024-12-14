package mrilki.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Image {
    private long id;
    private int name;
    private String path;
    private int type;
    private long day_id;

}
