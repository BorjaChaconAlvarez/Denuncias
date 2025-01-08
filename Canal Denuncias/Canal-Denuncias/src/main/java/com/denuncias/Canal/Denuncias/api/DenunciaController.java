package com.denuncias.Canal.Denuncias.api;


import com.denuncias.Canal.Denuncias.clases.Denuncia;
import com.denuncias.Canal.Denuncias.repositories.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// Controlador Rest para gestionar las denuncias
@RestController  // Indican que esta clase es un controlador Rest
@RequestMapping("/api/denuncias") // Define la ruta base para los endpoints

public class DenunciaController {

    @Autowired //INYECCIÓN DEL REPOSITORIO PARA ACCEDER A LA BASE DE DATOS
    private DenunciaRepository denunciaRepository;

//ENDPOINT PARA ENVIAR UNA DENUNCIA POST

   // @PostMapping
   // public Denuncia enviarDenuncia(@RequestBody Denuncia denuncia) {
    //    return denunciaRepository.save(denuncia); //Guarda la denuncia y la devuelve
    //}

    @PostMapping
    public ResponseEntity<?> enviarDenuncia (@RequestBody Denuncia denuncia) {
        Denuncia guardada = denunciaRepository.save(denuncia);
        return ResponseEntity.ok(Map.of("mensaje",  "Denuncia creada con éxito", "id", guardada.getId()));
    }

    //endpoint para listar todas las denuncias (GET)

    @PutMapping("/{id}/revisada")
    public Denuncia marcarComoRevisada(@PathVariable Long id) {
        Denuncia denuncia = denunciaRepository.findById(id).orElseThrow(); // Busca la denuncia por ID
        denuncia.setRevisada(true);  // Marca la denuncia como revisada
        return denunciaRepository.save(denuncia); // Guarda los cambios
    }

    // Endpoint para eliminar una denuncia (DELETE)
    @DeleteMapping("/{id}")
    public void eliminarDenuncia(@PathVariable Long id) {
        denunciaRepository.deleteById(id);
    }


}
