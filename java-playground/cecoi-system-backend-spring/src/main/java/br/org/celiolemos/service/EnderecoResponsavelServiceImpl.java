package br.org.celiolemos.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.org.celiolemos.api.service.EnderecoService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.FalhaNoCadastro;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Endereco;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.repository.EnderecoRepository;
import br.org.celiolemos.repository.ResponsavelRepository;

@Service
@Qualifier("responsavelService")
public class EnderecoResponsavelServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ResponsavelRepository responsavelRepository;

	private Log logger = LogFactory.getLog(EnderecoResponsavelServiceImpl.class);

	@Override
	@Transactional
	public Iterable<Endereco> adicionarEndereco(Integer responsavelId, Set<Endereco> enderecos) {

		Optional<Responsavel> optionalResponsavel = responsavelRepository.findById(responsavelId);
		if (optionalResponsavel.isPresent()) {

			Responsavel responsavel = optionalResponsavel.get();
			enderecos.forEach(endereco -> {
				if (enderecoRepository.existsByCepAndNumero(endereco.getCep(), endereco.getNumero())) {
					throw new ElementoJaCadastrado("Endereço ja esta cadastrado");
				}
				endereco.setResponsavel(responsavel);
			});
			try {
				return enderecoRepository.saveAll(enderecos);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new FalhaNoCadastro(e.getCause().getLocalizedMessage());
			}

		}
		throw new NaoEncontrado(
				"Responsavel não encontrado. Para cadastrar um endereco é preciso adicionar um responsavel primeiro");

	}

	@Override
	public Endereco encontrarPorId(Integer responsavelId, Integer enderecoId) {

		if (responsavelRepository.existsById(responsavelId)) {
			Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
			if (optionalEndereco.isPresent()) {
				Endereco endereco = optionalEndereco.get();
				return endereco;
			}
			throw new NaoEncontrado("Endereço não foi encontrado");
		}
		throw new NaoEncontrado(
				"Responsavel não encontrado. Para cadastrar um endereco é preciso adicionar um responsavel primeiro");

	}

	@Override
	public List<Endereco> encontrarTudo(Integer responsavelId) {
		return enderecoRepository.findAllByResponsavelId(responsavelId);
	}

	@Override
	@Transactional
	public Endereco atualizarEndereco(Integer responsavelId, Integer enderecoId, Endereco endereco) {
		Optional<Responsavel> responsavel = responsavelRepository.findById(responsavelId);
		if (responsavel.isPresent()) {
			Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoId);
			if (optionalEndereco.isPresent()) {
				Endereco enderecoAntigo = optionalEndereco.get();
				endereco.setId(enderecoAntigo.getId());
				endereco.setResponsavel(responsavel.get());
				Endereco updateStatus = enderecoRepository.save(endereco);

				if (Objects.nonNull(updateStatus)) {
					return updateStatus;
				}
				throw new FalhaNaAtualizacao("Endereco não foi atualizado, tente novamente mais tarde");
			}
			throw new NaoEncontrado("Endereco não foi encontrado. A atualização não foi realizada");
		}
		throw new NaoEncontrado("Responsavel não encontrado. Para atualizar um endereco o responsavel precisa existir");

	}

	@Override
	@Transactional
	public void removeEndereco(Integer responsavelId, Integer enderecoId) {

		if (responsavelRepository.existsById(responsavelId)) {
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
			throw new NaoEncontrado(
					"Responsavel não encontrado. Para remover um endereco o responsavel precisa existir");
		}
	}

}