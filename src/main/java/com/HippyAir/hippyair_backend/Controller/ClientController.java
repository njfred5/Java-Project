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

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{passportNumber}")
    public ResponseEntity<Client> getClient(@PathVariable String passportNumber) {
        return ResponseEntity.ok(clientService.getClientById(passportNumber));
    }

    @PutMapping("/{passportNumber}")
    public ResponseEntity<Client> updateClient(@PathVariable String passportNumber, @RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(passportNumber, client));
    }

    @DeleteMapping("/{passportNumber}")
    public ResponseEntity<Void> deleteClient(@PathVariable String passportNumber) {
        clientService.deleteClient(passportNumber);
        return ResponseEntity.noContent().build();
    }
}
