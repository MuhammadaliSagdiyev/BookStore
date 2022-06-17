package nt.java.Controller;

import lombok.RequiredArgsConstructor;
import nt.java.DAO.Author;
import nt.java.Repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping("/authors")
    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }
}
