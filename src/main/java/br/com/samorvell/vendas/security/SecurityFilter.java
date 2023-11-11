package br.com.samorvell.vendas.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        /*segredo do sucesso, requisições que não precisam de autenticação, não levam em conta o item do cabeçalho
        *
        * Rqueisções que precisam de autenticação, vão precisar de uma informação de autorização do cabeçalho
        *   -se o token for válido, eu monto um cabeçalho de autoriazação e encaminho a requisição.
        * */

        System.out.println("Requisição passou pelo filtro----");
        /*A mágica acontece aqui então?
        * SIM*/
        if (request.getHeader("Authorization") != null){
            UsernamePasswordAuthenticationToken auth = JwtTokenUtil.decodeToken(request);
            if (auth != null)
            SecurityContextHolder.getContext().setAuthentication(auth);
            else{
                System.out.println("Erro de token");
                //ErroDTO erro = new ErroDTO(401,"Token Inválido");
                //response.setStatus(erro.getStatus());
                response.setContentType("application/json");
                //ObjectMapper mapper = new ObjectMapper();
                //response.getWriter().print(mapper.writeValueAsString(erro));
                response.getWriter().flush();
                return;

            }

        }
        filterChain.doFilter(request, response);
    }
}
