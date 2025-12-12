package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.Client;
import com.HippyAir.hippyair_backend.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Create client
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Get all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Get client by passport number
    public Client getClientById(String passportNumber) {
        return clientRepository.findById(passportNumber)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    // Update client
    public Client updateClient(String passportNumber, Client clientDetails) {
        Client client = getClientById(passportNumber);
        client.setUser(clientDetails.getUser());
        return clientRepository.save(client);
    }

    // Delete client
    public void deleteClient(String passportNumber) {
        clientRepository.deleteById(passportNumber);
    }
}
