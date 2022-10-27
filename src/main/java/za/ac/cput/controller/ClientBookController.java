package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;
import za.ac.cput.service.ClientBookIService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("librarymanagementsystem/clientBook/")
@Slf4j
public class ClientBookController {
    private final ClientBookIService clientBookIService;
    //ClientBookIdd clientBookIdd;


    @Autowired
    public ClientBookController(ClientBookIService clientBookIService) {
        this.clientBookIService = clientBookIService;
    }

    @PostMapping("save_clientbook")
    public ResponseEntity<ClientBook> create(@Valid @RequestBody ClientBook clientBook){
        log.info("Save request: {}",clientBook);

        try{
//            clientBookIdd.clientId = clientBook.getClient().getClientId();
//            clientBookIdd.bookId = clientBook.getBook().getBookId();

            ClientBook save_clientBook = this.clientBookIService.create(clientBook);
            return ResponseEntity.ok(save_clientBook);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @GetMapping("read_clientBook/{clientBookId}")
    public ResponseEntity<ClientBook> read(@PathVariable String clientBookId){
        log.info("Read request: {}", clientBookId);

        try{
            ClientBook read_ClientBook = this.clientBookIService.read(clientBookId);
            return ResponseEntity.ok(read_ClientBook);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage());
        }
    }

    @PostMapping("update_clientbook")
    public ResponseEntity<ClientBook> update(@Valid @RequestBody ClientBook clientBook){
        log.info("Update request: {}",clientBook);

        try{
            ClientBook update_ClientBook = this.clientBookIService.update(clientBook);
            return ResponseEntity.ok(update_ClientBook);

        }catch(IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @DeleteMapping("delete_clientbook/{clientBookId}")
    public ResponseEntity<ClientBook> delete(@PathVariable String clientBookId){
        log.info("Delete request: {}", clientBookId);

        this.clientBookIService.delete(clientBookId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAll_clientbooks")
    public ResponseEntity<List<ClientBook>> getAll(){
        List<ClientBook> clientBooks = this.clientBookIService.getAll();
        return ResponseEntity.ok(clientBooks);
    }

    @GetMapping("findClientBookByClient/{client}")
    public ResponseEntity<List<ClientBook>> findClientBookByClient(@PathVariable Client client){
        log.info("Find Request: {}",client);

        List<ClientBook> findClientBook = this.clientBookIService.findClientBookByClient(client);
        return ResponseEntity.ok(findClientBook);
        }

    @GetMapping("clientBooksByClientId/{clientId}")
    public ResponseEntity<List<ClientBook>> findClientBooksByClientId(@PathVariable String clientId){
        log.info("Find Request: {}",clientId);

        List<ClientBook> findClientBook = this.clientBookIService.findClientBooksByClientId(clientId);
        return ResponseEntity.ok(findClientBook);
    }

}
