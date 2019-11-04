package com.sistema.endpoint;

import com.sistema.model.Cliente;
import com.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("cliente")
public class ClienteEndpoint {
//
//    private final ClienteRepository cli;
//
//    @Autowired
//    public ClienteEndpoint(@Qualifier("clienteRepository") ClienteRepository cli) {
//        this.cli = cli;
//    }
//
//    @GetMapping
//    public ResponseEntity<?> listAll(){
//        return new ResponseEntity<>(cli.findAll() , HttpStatus.OK);
//    }
//
//    @GetMapping(path="/{idCli}")//posso ler o cliente pegando pelo id
//    public ResponseEntity<?>getCliById(@PathVariable("idCli")Long idCli){
//        Cliente cliente=cli.findById(idCli).get();
//
//        if(cliente==null){
//            return new ResponseEntity<>( new Error() , HttpStatus.NOT_FOUND);
//
//        }
//        return new ResponseEntity<>(cliente,HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<?>save (@RequestBody Cliente cliente){
//        return new ResponseEntity<>(cli.save(cliente),HttpStatus.OK);
//    }
//
//    @DeleteMapping(path="{idCli}")
//    public ResponseEntity<?>delete(@PathVariable Long idCli){
//        cli.deleteById(idCli);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PutMapping
//    public ResponseEntity<?>update(@RequestBody Cliente cliente){
//        cli.save(cliente);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
