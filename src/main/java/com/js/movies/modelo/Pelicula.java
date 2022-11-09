package com.js.movies.modelo;

import javax.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @Column(name = "ID_PELICULA", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_GENERO")
    private Genero idGenero;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DURACION", nullable = false)
    private Float duracion;

    @Lob
    @Column(name = "SINOPSIS", nullable = false)
    private String sinopsis;

    @Column(name = "IDIOMA", nullable = false, length = 20)
    private String idioma;

    @Column(name = "ESTADO", nullable = false)
    private Short estado;

    @Column(name = "RAITING", precision = 2)
    private Float raiting;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getDuracion() {
        return duracion;
    }

    public void setDuracion(Float duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public Float getRaiting() {
        return raiting;
    }

    public void setRaiting(Float raiting) {
        this.raiting = raiting;
    }

}