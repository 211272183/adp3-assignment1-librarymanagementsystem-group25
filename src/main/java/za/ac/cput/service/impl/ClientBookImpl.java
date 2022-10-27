package za.ac.cput.service.impl;
/*
    Breyton Ernstzen
    Capstone Project
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.domain.ClientBook;
import za.ac.cput.repository.ClientBookIRepository;
import za.ac.cput.repository.ClientIRepository;
import za.ac.cput.service.ClientBookIService;
import za.ac.cput.service.IService;

import java.util.Collections;
import java.util.List;

@Service
public class ClientBookImpl implements ClientBookIService {

    private final ClientBookIRepository clientBookIRepository;
    private final ClientIRepository clientIRepository;

    @Autowired
    public ClientBookImpl(ClientBookIRepository clientBookIRepository,ClientIRepository clientIRepository){
        this.clientBookIRepository = clientBookIRepository;
        this.clientIRepository = clientIRepository;
    }

    @Override
    public ClientBook create(ClientBook clientBook) {
        return this.clientBookIRepository.save(clientBook);
    }

    @Override
    public ClientBook read(String clientId) {
        return this.clientBookIRepository.findById(clientId).orElse(null);
    }

    @Override
    public ClientBook update(ClientBook updateClientBook) {
        return this.clientBookIRepository.save(updateClientBook);
    }

    @Override
    public void delete(String clientId) {
        this.clientBookIRepository.deleteById(clientId);

    }

    @Override
    public List<ClientBook> getAll() {
        return this.clientBookIRepository.findAll().stream().toList();
    }

    //might be wrong
    @Override
    public List<ClientBook> findClientBookByClient(Client client) {
       return this.clientBookIRepository.findClientBookByClients(client);

    }

    @Override
    public List<ClientBook> findClientBooksByClientId(String clientId) {
        Client client = this.clientIRepository.findById(clientId).orElse(null);
        return this.clientBookIRepository.findClientBooksByClients(client);

    }

}
