package com.example.MSresenasYcalificaciones.controller;

import com.example.MSresenasYcalificaciones.dto.ResenaModel;
import com.example.MSresenasYcalificaciones.model.Resena;
import com.example.MSresenasYcalificaciones.service.ResenaService;
import com.example.MSresenasYcalificaciones.assembler.ResenaModelAssembler;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/resenas")
public class ResenaControllerV2 {

    private final ResenaService service;
    private final ResenaModelAssembler assembler;

    public ResenaControllerV2(ResenaService service, ResenaModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Operation(summary = "Obtiene todas las reseñas")
    @GetMapping
    public ResponseEntity<CollectionModel<ResenaModel>> obtenerTodos() {
        List<Resena> resenas = service.listarResenas();
        List<ResenaModel> modelos = resenas.stream().map(assembler::toModel).toList();
        return ResponseEntity.ok(CollectionModel.of(modelos,
                linkTo(methodOn(ResenaControllerV2.class).obtenerTodos()).withSelfRel()));
    }

    @Operation(summary = "Obtiene una reseña por ID")
    @GetMapping("/{idResena}")
    public ResponseEntity<ResenaModel> obtenerPorId(@PathVariable int idResena) {
        return service.obtenerResenaPorId(idResena)
                .map(resena -> ResponseEntity.ok(assembler.toModel(resena)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crea una nueva reseña")
    @PostMapping
    public ResponseEntity<ResenaModel> crearResena(@RequestBody Resena resena) {
        Resena nueva = service.guardResena(resena);
        return ResponseEntity.ok(assembler.toModel(nueva));
    }

    @Operation(summary = "Actualiza una reseña existente")
    @PutMapping("/{idResena}")
    public ResponseEntity<ResenaModel> actualizarResena(@PathVariable int idResena, @RequestBody Resena resena) {
        return service.obtenerResenaPorId(idResena)
                .map(resenaExistente -> {
                    resenaExistente.setComentario(resena.getComentario());
                    resenaExistente.setCalificacion(resena.getCalificacion());
                    resenaExistente.setFechaResena(resena.getFechaResena());
                    Resena actualizado = service.guardResena(resenaExistente);
                    return ResponseEntity.ok(assembler.toModel(actualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Elimina una reseña por ID")
    @DeleteMapping("/{idResena}")
    public ResponseEntity<Void> eliminarResena(@PathVariable int idResena) {
        if (service.obtenerResenaPorId(idResena).isPresent()) {
            service.eliminarResena(idResena);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}