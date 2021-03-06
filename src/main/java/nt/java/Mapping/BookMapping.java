package uz.yt.springdata.mapping;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.context.annotation.Lazy;
import uz.yt.springdata.dao.Author;
import uz.yt.springdata.dao.Book;
import uz.yt.springdata.dto.AuthorDTO;
import uz.yt.springdata.dto.BookDTO;
import uz.yt.springdata.dto.PublisherDTO;
import uz.yt.springdata.helper.DateHelper;
import uz.yt.springdata.helper.NumberHelper;
import uz.yt.springdata.helper.StringHelper;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapping {

    public static BookDTO toDto(Book book, int tier){
        if (tier > 1) return null;

        BookDTO bookDTO = new BookDTO(book.getId(),
                book.getNameUz(),
                book.getCost(),
                book.getGenre(),
                DateHelper.toString(book.getPublishedDate()),
                book.getPageCount());

        bookDTO.setPublisherDTO(PublisherMapping.toDto(book.getPublisher(), tier+1));
        bookDTO.setAuthor(AuthorMapping.toDto(book.getAuthorId(), tier+1));

        return bookDTO;
    }

    public static Book toEntity(BookDTO bookDTO){
        return  new Book(bookDTO.getId(),
                    bookDTO.getName(),
                    bookDTO.getCost(),
                DateHelper.toDate(bookDTO.getPublishedDate()),
                bookDTO.getPageCount(),
                bookDTO.getGenre());
    }

    public static void setEntity(Book book, BookDTO bookDTO){
        if (StringHelper.isValid(bookDTO.getName())) book.setNameUz(bookDTO.getName());
        if (StringHelper.isValid(bookDTO.getGenre())) book.setGenre(bookDTO.getGenre());
        if (NumberHelper.isValid(bookDTO.getCost())) book.setCost(bookDTO.getCost());
        if (NumberHelper.isValid(bookDTO.getPageCount())) book.setPageCount(bookDTO.getPageCount());
        if (DateHelper.isValid(bookDTO.getPublishedDate())) book.setPublishedDate(DateHelper.toDate(bookDTO.getPublishedDate()));
    }
}
