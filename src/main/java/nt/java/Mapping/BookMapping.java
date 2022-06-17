package nt.java.Mapping;

import nt.java.DAO.Book;
import nt.java.DTO.BookDTO;

public class BookMapping {

    public static BookDTO toDto(Book book){
        return new BookDTO(book.getId(),
                book.getName_uz(),
                book.getName_ru(),
                book.getCost(),
                book.getPublisher_date(),
                book.getPage_count(),
                book.getAuthor_id(),
                book.getGenre(),
                book.getPublisher_id());
    }


    public static Book toEntity(BookDTO bookDTO){
        return new Book(bookDTO.getId(),
                bookDTO.getName_uz(),
                bookDTO.getName_ru(),
                bookDTO.getCost(), bookDTO.getPublisher_date(),
                bookDTO.getPage_count(),
                bookDTO.getAuthor_id(),
                bookDTO.getGenre(),
                bookDTO.getPublisher_id());
    }
}
