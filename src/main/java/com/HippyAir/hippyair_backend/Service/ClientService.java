package com.HippyAir.hippyair_backend.Service;

import com.HippyAir.hippyair_backend.Model.Client;
import com.HippyAir.hippyair_backend.Model.User;
import com.HippyAir.hippyair_backend.DTO.ClientDTO;
import com.HippyAir.hippyair_backend.Repository.ClientRepository;
import com.HippyAir.hippyair_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new client linked to an existing user
    public Client createClient(ClientDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Client client = new Client();
        client.setPassportNumber(dto.getPassportNumber());
        client.setUser(user);

        return clientRepository.save(client);
    }

    // Get all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Get client by ID
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    // Update client info
    public Client updateClient(Long id, ClientDTO dto) {
        Client client = getClientById(id);
        client.setPassportNumber(dto.getPassportNumber());

        // Optional: update linked user if needed
        if (dto.getUserId() != null && !dto.getUserId().equals(client.getUser().getIdUser())) {
            User newUser = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("New user not found"));
            client.setUser(newUser);
        }

        return clientRepository.save(client);
    }

    // Delete client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
