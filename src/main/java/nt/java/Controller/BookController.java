package nt.java.Controller;

import lombok.RequiredArgsConstructor;
import nt.java.DAO.Book;
import nt.java.DTO.BookDTO;
import nt.java.DTO.ResponseDTO;
import nt.java.Mapping.BookMapping;
import nt.java.Repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("/books")
    public List<BookDTO> getAll(){
        return bookRepository.findAll().stream()
                                    .map(e -> BookMapping.toDto(e))
                                    .collect(Collectors.toList());
    }

    @PostMapping("/addBook")
    public ResponseDTO<BookDTO> addBook(@RequestBody BookDTO bookDTO){
        bookRepository.save(BookMapping.toEntity(bookDTO));
        return new ResponseDTO<>(true, 0, "OK", bookDTO);
    }
}
