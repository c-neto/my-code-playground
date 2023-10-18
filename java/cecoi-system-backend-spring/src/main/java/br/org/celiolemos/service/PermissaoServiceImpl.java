package br.org.celiolemos.service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.org.celiolemos.api.service.PermissaoService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Permissao;
import br.org.celiolemos.model.Usuario;
import br.org.celiolemos.repository.PermissaoRepository;
import br.org.celiolemos.repository.UsuarioRepository;

@Service
@Qualifier("usuarioService")
public class PermissaoServiceImpl implements PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Usuario adicionarPermissaoEmUsuario(Integer usuarioId, Set<Permissao> permissoes) {

		Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
		if (optionalUsuario.isPresent()) {

			Usuario usuario = optionalUsuario.get();
			permissoes.forEach(permissao -> {
				Optional<Permissao> permissaoEncontrada = permissaoRepository.findByNome(permissao.getNome());
				if (permissaoEncontrada.isPresent()) {
					permissao.setId(permissaoEncontrada.get().getId());
				} else {
					throw new NullPointerException(
							"Permissão não está cadastrada no sistema, entre em contato com o administrador!");
				}
				usuario.addPermissao(permissao);
			});
			return usuarioRepository.findById(usuarioId).get();
		}
		throw new NaoEncontrado(
				"Usuario não encontrado. Para cadastrar um Permissao é preciso adicionar um usuário primeiro");

	}

	@Override
	public Permissao encontrarPorId(Integer permissaoId) {

		Optional<Permissao> optionalPermissao = permissaoRepository.findById(permissaoId);
		if (optionalPermissao.isPresent()) {
			Permissao Permissao = optionalPermissao.get();
			return Permissao;
		}
		throw new NaoEncontrado("Permissão não foi encontrada");
	}

	@Override
	public Iterable<Permissao> encontrarTudo() {
		return permissaoRepository.findAll();
	}

	@Override
	public Permissao atualizarPermissao(Integer permissaoId, Permissao permissao) {
		Optional<Permissao> optionalPermissao = permissaoRepository.findById(permissaoId);
		if (optionalPermissao.isPresent()) {
			Permissao permissaoAntiga = optionalPermissao.get();
			permissao.setId(permissaoAntiga.getId());
			Permissao updateStatus = permissaoRepository.save(permissao);

			if (Objects.nonNull(updateStatus)) {
				return updateStatus;
			}
			throw new FalhaNaAtualizacao("Permissão não foi atualizado, tente novamente mais tarde");
		}
		throw new NaoEncontrado("Permissao não foi encontrado. A atualização não foi realizada");

	}

	@Override
	public void removerPermissao(Integer permissaoId) {

		if (permissaoRepository.existsById(permissaoId)) {

			permissaoRepository.deleteById(permissaoId);

			if (permissaoRepository.existsById(permissaoId)) {
				throw new FalhaNaRemocao("Permissao não foi removido, tente novamente mais tarde");
			}
			return;
		} else {
			throw new NaoEncontrado("Permissão não existe");
		}

	}

	@Override
	public Permissao adicionarPermissao(Permissao permissao) {
		if (permissaoRepository.existsByNome(permissao.getNome()))
			throw new ElementoJaCadastrado("Permissão já está cadastrada");
		permissao.setAuthority("ROLE_" + permissao.getAuthority());
		return permissaoRepository.save(permissao);
	}

	@Override
	public Usuario removerPermissaoDeUsuario(Integer usuarioId, Set<Permissao> permissoes) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			permissoes.forEach(permissao -> {
				Optional<Permissao> permissaoEncontrada = permissaoRepository.findByNome(permissao.getNome());
				if (permissaoEncontrada.isPresent()) {
					permissao.setId(permissaoEncontrada.get().getId());
				} else {
					throw new NullPointerException(
							"Permissão não está cadastrada no sistema, não foi possivel remover a permissao "
									+ permissao.getNome());
				}
				usuario.removerPermissao(permissao);
			});
			return usuarioRepository.save(usuario);
		}
		throw new NaoEncontrado(
				"Usuario não encontrado. Para remover as permissões de um usuário é preciso adicioná-lo primeiro");
	}
}