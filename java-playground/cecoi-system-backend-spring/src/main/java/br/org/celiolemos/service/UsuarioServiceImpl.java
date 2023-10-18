package br.org.celiolemos.service;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.celiolemos.api.service.EnderecoService;
import br.org.celiolemos.api.service.TelefoneService;
import br.org.celiolemos.api.service.UsuarioService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.repository.EnderecoRepository;
import br.org.celiolemos.repository.PermissaoRepository;
import br.org.celiolemos.repository.TelefoneRepository;
import br.org.celiolemos.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	@Qualifier("usuarioService")
	private TelefoneService telefoneService;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired
	@Qualifier("usuarioService")
	private EnderecoService enderecoService;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	@Transactional
	public Usuario adicionarUsuario(Usuario usuario, String permissao) {

		Objects.requireNonNull(usuario.getTelefones());
		Objects.requireNonNull(usuario.getEnderecos(), "O campo endereco é obrigatorio");
		if (repository.existsByCpf(usuario.getCpf())) {
			throw new ElementoJaCadastrado("Cpf já está cadastrado");
		} else if (repository.existsByLogin(usuario.getLogin())) {
			throw new ElementoJaCadastrado("Login já está cadastrado");
		}
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		if (Objects.nonNull(permissao))
			permissaoRepository.findByNome(permissao).ifPresent(p -> {
				usuario.setPermissoes(Arrays.asList(p));
			});

		Usuario usuarioCriado = repository.save(usuario);
		telefoneService.adicionarTelefone(usuarioCriado.getId(), usuario.getTelefones());
		enderecoService.adicionarEndereco(usuarioCriado.getId(), usuario.getEnderecos());
		return usuarioCriado;
	}

	@Override
	public Usuario encontrarPorId(Integer id) {

		Optional<Usuario> optionalUsuario = repository.findById(id);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			return usuario;
		}

		throw new NaoEncontrado("Usuario não encontrado");
	}

	@Override
	public Iterable<Usuario> encontrarTudo() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Usuario atualizarUsuario(Integer id, Usuario usuario) {

		Optional<Usuario> optionalUsuario = repository.findById(id);
		if (optionalUsuario.isPresent()) {

			Usuario usuarioAntigo = optionalUsuario.get();
			usuario.setId(usuarioAntigo.getId());
			usuario.setSenha(encoder.encode(usuario.getSenha()));

			Usuario updateStatus = repository.save(usuario);

			if (Objects.nonNull(updateStatus)) {
				usuario.getTelefones().forEach(telefone -> telefone.setUsuario(usuario));
				telefoneRepository.saveAll(usuario.getTelefones());
				usuario.getEnderecos().forEach(endereco -> endereco.setUsuario(usuario));
				enderecoRepository.saveAll(usuario.getEnderecos());
				return updateStatus;
			}
			throw new FalhaNaAtualizacao("Usuario não foi atualizado, algum erro ocorreu");
		}
		throw new NaoEncontrado("Usuario não encontrado");

	}

	@Override
	@Transactional
	public void removeUsuario(Integer id) {

		Boolean usuarioExiste = repository.existsById(id);
		if (usuarioExiste) {
			repository.deleteById(id);

			if (repository.existsById(id)) {
				throw new FalhaNaRemocao("Usuario não foi removid, algum erro ocorreu");
			}
		} else
			throw new NaoEncontrado("Usuario não encontrado");
	}

}
