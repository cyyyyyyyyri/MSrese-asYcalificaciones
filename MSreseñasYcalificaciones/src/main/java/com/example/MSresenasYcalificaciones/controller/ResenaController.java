package com.example.MSresenasYcalificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.MSresenasYcalificaciones.model.Resena;
import com.example.MSresenasYcalificaciones.service.ResenaService;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/resenas")
public class ResenaController {
    @Autowired
    private ResenaService resenaService;

    @PostMapping
    public ResponseEntity<Resena> crearResena(@RequestBody Resena resena) {
        return ResponseEntity.ok(resenaService.guardResena(resena));
        
    }

    @GetMapping("/{idResena}")
    public ResponseEntity<Resena> obtenerResenaPorId(@PathVariable int idResena) {
        return resenaService.obtenerResenaPorId(idResena)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
               
    }
    
    @GetMapping
    public List<Resena> listarResenas() {
        return resenaService.listarResenas();
    }

    @GetMapping("/producto/{idProducto}")
    public List<Resena> obtenerResenasPorProducto(@PathVariable int idProducto) {
        return resenaService.obtenerResenasPorProducto(idProducto);
    }
    
    @PutMapping("/{idResena}")
    public ResponseEntity<Resena> actualizarResena(@PathVariable int idResena, @RequestBody Resena datoResena) {
        return ResponseEntity.ok(resenaService.actualizarResena(idResena, datoResena));
    }

    @DeleteMapping("/{idResena}")
    public ResponseEntity<Void> eliminarResena(@PathVariable int idResena) {
        resenaService.eliminarResena((idResena));
        return ResponseEntity.noContent().build();

    }
   
    

    

}
