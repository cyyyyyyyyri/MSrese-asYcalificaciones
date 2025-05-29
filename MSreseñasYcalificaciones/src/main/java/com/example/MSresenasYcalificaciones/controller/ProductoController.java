package com.example.MSresenasYcalificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MSresenasYcalificaciones.model.Producto;
import com.example.MSresenasYcalificaciones.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }   

    @GetMapping("/{idProducto}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable int idProducto) {
        return productoService.obtenerProductoPorId(idProducto)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    }
   
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();

    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int idProducto, @RequestBody Producto daProducto) {
        return ResponseEntity.ok(productoService.actualizarProducto(idProducto, daProducto));
    }
    
    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int idProducto){
    productoService.eliminarProducto(idProducto);
    return ResponseEntity.noContent().build();
    }
    
    
       
    
    


}
