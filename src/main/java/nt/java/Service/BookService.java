package nt.java.Service;

import lombok.RequiredArgsConstructor;
import nt.java.DAO.Book;
import nt.java.DTO.BookDTO;
import nt.java.DTO.ResponseDTO;
import nt.java.Mapping.BookMapping;
import nt.java.Repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public ResponseDTO<Page<BookDTO>> books(int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Book> books = bookRepository.findAll(pageRequest);

        List<BookDTO> bookDTOList = books.stream()
                .map(e -> BookMapping.toDto(e))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        Page<BookDTO> result = new PageImpl<>(bookDTOList, books.getPageable(), books.getTotalElements());

        return new ResponseDTO<>(true, 0, "OK", result);
    }
}
