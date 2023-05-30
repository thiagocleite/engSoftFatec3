package engSoftFatec.br.engSoftFatec.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import engSoftFatec.br.engSoftFatec.models.Carro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarrosApiController {
    private List<Carro> _carros = new ArrayList<Carro>();

    public CarrosApiController()
    {
        _carros.add(new Carro("Pajero","Mitsubishi",150000.00f,2020));
        _carros.add(new Carro("Corolla","Toyota",130000.00f,2021));
        _carros.add(new Carro("Onix","GM",72000.00f,2021));
        _carros.add(new Carro("Kwid","Renault",70000.00f,2022));
    }

    @GetMapping
    public List<Carro> getCarros(){
        return _carros;
    }

    @GetMapping(path = "/{Nome}")
    public Carro getCarroPorNome(@PathVariable("Nome")String Nome)
    {
        return _carros.stream().filter(x-> Nome.equals(x.Nome)).findAny().orElse(null);
    }

    @PostMapping
    public ResponseEntity<Void> adicionarCarro(@RequestBody Carro carro) {
        _carros.add(carro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> excluirCarro(@PathVariable String nome) {
        _carros.removeIf(c -> c.Nome.equals(nome));

        return ResponseEntity.noContent().build();
    }
}
