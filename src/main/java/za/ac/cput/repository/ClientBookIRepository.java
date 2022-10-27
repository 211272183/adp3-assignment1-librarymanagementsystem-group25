package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;

import java.util.List;

@Repository
public interface ClientBookIRepository extends JpaRepository<ClientBook, String> {
    List<ClientBook> findClientBookByClients(Client client);
    List<ClientBook> findClientBooksByClients(Client client);

}
