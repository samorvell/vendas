package br.com.samorvell.vendas.controller;

import br.com.samorvell.vendas.model.Usuario;
import br.com.samorvell.vendas.security.JwtToken;
import br.com.samorvell.vendas.security.JwtTokenUtil;
import br.com.samorvell.vendas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<JwtToken> fazerLogin(@RequestBody Usuario dadosLogin){

        //System.out.println("e-mail: " + dadosLogin.getEmail());
        System.out.println("user name: " + dadosLogin.getUsername());
        System.out.println("senha: " + dadosLogin.getSenha());
        Usuario user = usuarioService.recuperarUsuario(dadosLogin);

        System.out.println("usuario do banco: " + user);

        if(user != null){
            if(user.getSenha().equals(dadosLogin.getSenha())){
                //aqui preciso criar o token para usuario
                JwtToken jwtToken = new JwtToken();

                jwtToken.setToken(JwtTokenUtil.genarateToken(user));
                return ResponseEntity.ok(jwtToken);
            }
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.notFound().build();

    }

}
