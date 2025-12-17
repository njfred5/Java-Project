package com.HippyAir.hippyair_backend.Controller;

import com.HippyAir.hippyair_backend.model.Client;
import com.HippyAir.hippyair_backend.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Create client
    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    // Get all clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    // Get client by passport number
    @GetMapping("/{passportNumber}")
    public ResponseEntity<Client> getClient(@PathVariable String passportNumber) {
        return ResponseEntity.ok(clientService.getClientByPassport(passportNumber));
    }

    // Update client
    @PutMapping("/{passportNumber}")
    public ResponseEntity<Client> updateClient(@PathVariable String passportNumber,
                                               @RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(passportNumber, client));
    }

    // Delete client
    @DeleteMapping("/{passportNumber}")
    public ResponseEntity<Void> deleteClient(@PathVariable String passportNumber) {
        clientService.deleteClient(passportNumber);
        return ResponseEntity.noContent().build();
    }
}
