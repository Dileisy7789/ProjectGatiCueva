package com.example.proyectogaticueva.domain;

import java.time.LocalDate;

public class RegistroMedicoAnimal
{
    private int id;
    private String nombreVacuna;
    private int dosisVacuna;
    private String sintoma;
    private String enfermedad;
    private String motivoConsulta;
    private LocalDate fechaConsulta;
    private LocalDate fechaCita;
    private LocalDate fechaRegistro;
    private double precioConsulta;
    private boolean estadoPago;
    private Veterinario veterinario;
    private Animal animal;

    public RegistroMedicoAnimal() {}
    public RegistroMedicoAnimal(int id, String nombreVacuna, int dosisVacuna, String sintoma,
                                String enfermedad, String motivoConsulta, LocalDate fechaConsulta, LocalDate fechaCita,
                                double precioConsulta, Veterinario veterinario, Animal animal) {
        this.setId(id);
        this.setNombreVacuna(nombreVacuna);
        this.setDosisVacuna(dosisVacuna);
        this.setSintoma(sintoma);
        this.setEnfermedad(enfermedad);
        this.setMotivoConsulta(motivoConsulta);
        this.setFechaConsulta(fechaConsulta);
        this.setFechaCita(fechaCita);
        this.setPrecioConsulta(precioConsulta);
        this.setVeterinario(veterinario);
        this.setAnimal(animal);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setDosisVacuna(int dosisVacuna) {
        this.dosisVacuna = dosisVacuna;
    }

    public int getDosisVacuna() {
        return dosisVacuna;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setPrecioConsulta(double precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    public double getPrecioConsulta() {
        return precioConsulta;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public boolean getEstadoPago() {
        return estadoPago;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
