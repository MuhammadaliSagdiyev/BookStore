package nt.java.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Integer id;
    private String last_name;
    private String first_name;
    private Date birth_date;
}
