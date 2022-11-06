package com.js.movies.controller;

import com.js.movies.excepcion.ElementoNuloExcepcion;
import com.js.movies.modelo.Pelicula;
import com.js.movies.salida.Respuesta;
import com.js.movies.servicio.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaController {

    @Autowired
    private PeliculaServicio peliculaServicio;

    @PostMapping("/pelicula")
    public @ResponseBody Respuesta savePelicula(@RequestBody Pelicula pelicula){
        Respuesta respuesta = new Respuesta();
        try{
            boolean estado = this.peliculaServicio.savePelicula(pelicula);
            respuesta.setCodigo(0);
            respuesta.setMensaje("Ok");
            respuesta.setRespuesta(estado);
        }catch (ElementoNuloExcepcion exc){
            respuesta.setCodigo(1);
            respuesta.setMensaje("Error: " + exc.toString());

        }catch (RuntimeException exc){
            respuesta.setCodigo(2);
            respuesta.setMensaje("Error: " + exc.toString());

        }
        return respuesta;
    }

    @GetMapping("/pelicula")
    public @ResponseBody Respuesta getPelicula(){
        Respuesta respuesta = new Respuesta();
        try{
            List<Pelicula> peliculas = this.peliculaServicio.getPeliculaCatalogo("vistas");
            respuesta.setCodigo(0);
            respuesta.setMensaje("Ok");
            respuesta.setRespuesta(peliculas);
        }catch (RuntimeException exc){
            respuesta.setCodigo(2);
            respuesta.setMensaje("Error: " + exc.toString());
        }
        return respuesta;
    }


}