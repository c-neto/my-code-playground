package br.org.celiolemos.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.org.celiolemos.api.service.EnderecoService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Endereco;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.repository.EnderecoRepository;
import br.org.celiolemos.repository.UsuarioRepository;

@Service
@Qualifier("usuarioService")
public class EnderecoUsuarioServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Iterable<Endereco> adicionarEndereco(Integer usuarioId, Set<Endereco> enderecos) {

		Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
		if (optionalUsuario.isPresent()) {

			Usuario usuario = optionalUsuario.get();
			enderecos.forEach(endereco -> {
				if (enderecoRepository.existsByCepAndNumero(endereco.getCep(), endereco.getNumero())) {
					throw new ElementoJaCadastrado("Endereço ja esta cadastrado");
				}
				endereco.setUsuario(usuario);
			});
			return enderecoRepository.saveAll(enderecos);
		}
		throw new NaoEncontrado(
				"Usuario não encontrado. Para cadastrar um endereco é preciso adicionar um usuário primeiro");

	}

	@Override
	public Endereco encontrarPorId(Integer usuarioId, Integer enderecoId) {

		if (usuarioRepository.existsById(usuarioId)) {
			Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
			if (optionalEndereco.isPresent()) {
				Endereco endereco = optionalEndereco.get();
				return endereco;
			}
			throw new NaoEncontrado("Endereço não foi encontrado");
		}
		throw new NaoEncontrado(
				"Usuario não encontrado. Para cadastrar um endereco é preciso adicionar um usuário primeiro");

	}

	@Override
	public List<Endereco> encontrarTudo(Integer usuarioId) {
		return enderecoRepository.findAllByUsuarioId(usuarioId);
	}

	@Override
	@Transactional
	public Endereco atualizarEndereco(Integer usuarioId, Integer enderecoId, Endereco endereco) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		if (usuario.isPresent()) {
			Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
			if (optionalEndereco.isPresent()) {
				Endereco enderecoAntigo = optionalEndereco.get();
				endereco.setId(enderecoAntigo.getId());
				endereco.setUsuario(usuario.get());
				Endereco updateStatus = enderecoRepository.save(endereco);

				if (Objects.nonNull(updateStatus)) {
					return updateStatus;
				}
				throw new FalhaNaAtualizacao("Endereco não foi atualizado, tente novamente mais tarde");
			}
			throw new NaoEncontrado("Endereco não foi encontrado. A atualização não foi realizada");
		}
		throw new NaoEncontrado("Usuario não encontrado. Para atualizar um endereco o usuário precisa existir");

	}

	@Override
	@Transactional
	public void removeEndereco(Integer usuarioId, Integer enderecoId) {

		if (usuarioRepository.existsById(usuarioId)) {
			if (enderecoRepository.existsById(enderecoId)) {

				enderecoRepository.deleteById(enderecoId);
				
				if (enderecoRepository.existsById(enderecoId)) {
					throw new FalhaNaRemocao("Endereco não foi removido, tente novamente mais tarde");
				}
				return;
			} else {
				throw new NaoEncontrado("Endereco não existe");
			}
		} else {
			throw new NaoEncontrado("Usuario não encontrado. Para remover um endereco o usuário precisa existir");
		}
	}

}