package moduloM23;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;



public class TestSexoM {
	
    @Test
    public void testeSexoFeminino() {
        List<Pessoa> listaPessoas = new ArrayList<>();
        listaPessoas.add(new Pessoa("Jailson", 40, "M"));
        listaPessoas.add(new Pessoa("Renata", 38, "F"));
        listaPessoas.add(new Pessoa("Tiago", 20, "M"));
        listaPessoas.add(new Pessoa("Bel", 39, "F"));

        List<Pessoa> mulheres = listaPessoas.stream()
                .filter(pessoa -> pessoa.getSexo().equals("F"))
                .collect(Collectors.toList());

        for (Pessoa mulher : mulheres) {
            assertEquals("F", mulher.getSexo());
        }
    }


}
