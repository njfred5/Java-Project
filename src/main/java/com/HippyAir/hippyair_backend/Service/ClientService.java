package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.model.Client;
import com.HippyAir.hippyair_backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // FIXED: clearer name
    public Client getClientByPassport(String passportNumber) {
        return clientRepository.findById(passportNumber)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client updateClient(String passportNumber, Client clientDetails) {
        Client client = getClientByPassport(passportNumber);
        client.setNumPassport(clientDetails.getNumPassport());
        client.setUser(clientDetails.getUser());
        return clientRepository.save(client);
    }

    public void deleteClient(String passportNumber) {
        clientRepository.deleteById(passportNumber);
    }
}

