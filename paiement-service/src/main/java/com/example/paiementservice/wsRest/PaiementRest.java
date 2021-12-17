package com.example.paiementservice.wsRest;

import com.example.paiementservice.entity.Paiement;
import com.example.paiementservice.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paiement")
public class PaiementRest {

    @Autowired
    private PaiementService paiementService;

    @PostMapping("/payer")
    public Paiement payer(@RequestBody Paiement paiement) {
        return paiementService.payer(paiement);
    }

    @GetMapping("/")
    public Paiement findById(@PathVariable Long id) {
        return paiementService.findById(id).orElse(null);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable Long id) {
        return paiementService.existsById(id);
    }

    @GetMapping("/all")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/all/commande/{ref}")
    public List<Paiement> findByCommande(@PathVariable String ref) {
        return paiementService.findByCommande(ref);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paiementService.delete(id);
    }

}

