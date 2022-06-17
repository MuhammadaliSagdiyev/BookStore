package nt.java.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Integer id;
    private String name_uz;
    private String name_ru;
    private Integer cost;
    private Date publisher_date;
    private Integer page_count;
    private Integer author_id;
    private String genre;
    private Integer publisher_id;
}
