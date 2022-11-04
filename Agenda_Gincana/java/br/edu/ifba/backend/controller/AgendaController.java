package br.edu.ifba.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.backend.model.AgendaModel;
import br.edu.ifba.backend.repository.AgendaRepository;

@RestController
@RequestMapping
public class AgendaController {

	private AgendaRepository repository;
	
	@GetMapping("/listall")
	public List<AgendaModel> listall() {
		var agendas = repository.findAll();
		return agendas;
	}
	@GetMapping("/{id}")
    public AgendaModel findById(@PathVariable("id") Long id) {
		Optional<AgendaModel> obj = repository.findById(id);
		if ( obj.isPresent() )
			return obj.get();
        return null;
    }

	@PostMapping("/")
	@ResponseStatus( HttpStatus.CREATED )
	public boolean insert(@RequestBody AgendaModel model){
		System.out.println("server - insert: " + model);
		try {
			repository.save(model);
			System.out.println("server - insert: TRUE");
			return true;
		}
		catch (Exception e) {
			System.out.println("server - insert: FALSE");
			e.printStackTrace();
			return false;
		}
		@DeleteMapping("/{id}")
		@ResponseStatus( HttpStatus.ACCEPTED )
		public boolean delete(@PathVariable("id") Long id) {
			System.out.println("delete");
			try {
				repository.deleteById(id);
				return true;
			}
			catch (Exception e) {
				return false;
			}
		}
		
		
		@PutMapping("/{id}")
		@ResponseStatus( HttpStatus.CREATED )
		public ResponseEntity<AgendaModel> update(@PathVariable("id") Long id, @RequestBody AgendaModel agendaModel) {
			var p = repository.findById(id);
	        if (p.isPresent()) {
	            var agenda = p.get();
	            if ( agendaModel.getData_agenda() != null )
	            	agenda.setData_agenda(agendaModel.getData_agenda());
	            if ( agendaModel.getData_agenda() != null )
	            	agenda.setData_agenda(agendaModel.getData_agenda());
	            if ( agendaModel.getProvaModel() != null )
	            	agenda.setProvaModel(agendaModel.getProvaModel());
	            if ( agendaModel.getEventoModel() != null )
	            	agenda.setEventoModel(agendaModel.getEventoModel());
	            repository.save(agenda);
	            return ResponseEntity.ok(agenda);
	        } else {
	        	return ResponseEntity.notFound().build();
	        }
		}
}


