package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Obtener todas las personas
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    // Guardar una nueva persona
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    // Buscar una persona por ID
    public Persona findById(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + id));
    }

    // Actualizar una persona existente
    public Persona update(Long id, Persona personaActualizada) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(personaActualizada.getNombre());
                    persona.setApellido(personaActualizada.getApellido());
                    persona.setEdad(personaActualizada.getEdad());
                    return personaRepository.save(persona);
                })
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + id));
    }

    // Eliminar una persona
    public void delete(Long id) {
        if (!personaRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Persona no encontrada con ID: " + id);
        }
        personaRepository.deleteById(id);
    }
}
