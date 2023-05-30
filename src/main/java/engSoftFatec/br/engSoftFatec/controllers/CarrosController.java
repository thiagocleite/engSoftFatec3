package engSoftFatec.br.engSoftFatec.controllers;

import engSoftFatec.br.engSoftFatec.models.Carro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carros")
public class CarrosController {
    private List<Carro> _carros = new ArrayList<Carro>();

    public CarrosController()
    {
        _carros.add(new Carro("Pajero","Mitsubishi",150000.00f,2020));
        _carros.add(new Carro("Corolla","Toyota",130000.00f,2021));
        _carros.add(new Carro("Onix","GM",72000.00f,2021));
        _carros.add(new Carro("Kwid","Renault",70000.00f,2022));
    }

    @GetMapping
    public String getCarros(Model model)
    {
        model.addAttribute("carros",_carros);
        return "carros";
    }
}
