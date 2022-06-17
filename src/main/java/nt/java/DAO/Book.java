package nt.java.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_uz")
    private String name_uz;

    @Column(name = "name_ru")
    private String name_ru;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "publisher_date")
    private Date publisher_date;

    @Column(name = "page_count")
    private Integer page_count;

    @Column(name = "author_id")
    private Integer author_id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher_id")
    private Integer publisher_id;


}
