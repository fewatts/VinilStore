package com.generation.vinylstore.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.vinylstore.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start(){
        usuarioRepository.deleteAll();
        usuarioRepository.save(new Usuario(0L, "Fernando Alves", "fer@email.com", "654345687687", "sdfsglkdfjlsd"));

        usuarioRepository.save(new Usuario(0L, "Alis", "alis@email.com", "7654456878768", "jhgfetyjgf"));

        usuarioRepository.save(new Usuario(0L, "TigerHead", "head@email.com", "76543234768787", "jnbfertyjnb"));

        usuarioRepository.save(new Usuario(0L, "SpinnenKopf", "kopf@email.com", "765434878768", "uhfdtyjnbvf"));
    }
    @Test
    @DisplayName("Retorna 1 usuário")
    public void deveRetornarUmUsuario(){
        Optional<Usuario> usuario = usuarioRepository.findByUsuario("fer@email.com");

        assertTrue(usuario.get().getUsuario().equals("fer@email.com"));
    }
    @Test
    @DisplayName("Retorna 3 usuários")
    public void deveRetornarTresUsuarios(){
        List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("a");

        assertEquals(3, listaDeUsuarios.size());
        assertTrue(listaDeUsuarios.get(0).getNome().equals("Fernando Alves"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Alis"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("TigerHead"));
    }
    @AfterAll
    public void end(){
        usuarioRepository.deleteAll();
    }
    
}
