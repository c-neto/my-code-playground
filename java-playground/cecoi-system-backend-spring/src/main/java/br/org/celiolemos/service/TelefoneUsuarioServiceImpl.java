package br.org.celiolemos.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.org.celiolemos.api.service.TelefoneService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Telefone;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.repository.TelefoneRepository;
import br.org.celiolemos.repository.UsuarioRepository;

@Service
@Qualifier("usuarioService")
public class TelefoneUsuarioServiceImpl implements TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Iterable<Telefone> adicionarTelefone(Integer usuarioId, Set<Telefone> telefones) {

		Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			telefones.forEach(t -> {
				if (telefoneRepository.existsByNumero(t.getNumero())) {
					throw new ElementoJaCadastrado("Telefone já cadastrado!");
				}
				t.setUsuario(usuario);
			});
			return telefoneRepository.saveAll(telefones);
		}
		throw new NaoEncontrado(
				"Usuario não encontrado. Para cadastrar um telefone é preciso adicionar um usuário primeiro");
	}

	@Override
	public Telefone encontrarPorId(Integer usuarioId, Integer telefoneId) {

		if (usuarioRepository.existsById(usuarioId)) {
			Optional<Telefone> optionalTelefone = telefoneRepository.findById(telefoneId);
			if (optionalTelefone.isPresent()) {
				Telefone telefone = optionalTelefone.get();
				return telefone;
			}
			throw new NaoEncontrado("Telefone não foi encontrado");
		}
		throw new NaoEncontrado(
				"Usuario não encontrado. Para cadastrar um telefone é preciso adicionar um usuário primeiro");

	}

	@Override
	public List<Telefone> encontrarTudo(Integer usuarioId) {
		return telefoneRepository.findAllByUsuarioId(usuarioId);
	}

	@Override
	@Transactional
	public Telefone atualizarTelefone(Integer usuarioId, Integer telefoneId, Telefone telefone) {

		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		if (usuario.isPresent()) {
			Optional<Telefone> optionalTelefone = telefoneRepository.findById(telefoneId);
			if (optionalTelefone.isPresent()) {
				Telefone telefoneAntigo = optionalTelefone.get();
				telefone.setId(telefoneAntigo.getId());
				telefone.setUsuario(usuario.get());
				Telefone updateStatus = telefoneRepository.save(telefone);

				if (Objects.nonNull(updateStatus)) {
					return updateStatus;
				}
				throw new FalhaNaAtualizacao("Telefone não foi atualizado, tente novamente mais tarde");
			}
			throw new NaoEncontrado("Telefone não foi encontrado. A atualização não foi realizada");
		}
		throw new NaoEncontrado("Usuario não encontrado. Para atualizar um telefone o usuário precisa existir");

	}

	@Override
	public void removeTelefone(Integer usuarioId, Integer idTelefone) {

		if (usuarioRepository.existsById(usuarioId)) {
			if (telefoneRepository.existsById(idTelefone)) {

				telefoneRepository.deleteById(idTelefone);

				if (telefoneRepository.existsById(idTelefone)) {
					throw new FalhaNaRemocao("Telefone não foi removido, tente novamente mais tarde");
				}
			}
			return;
		}
		throw new NaoEncontrado("Usuario não encontrado. Para atualizar um telefone o usuário precisa existir");
	}
}