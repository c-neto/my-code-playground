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

import br.org.celiolemos.api.service.TelefoneService;
import br.org.celiolemos.excecoes.ElementoJaCadastrado;
import br.org.celiolemos.excecoes.FalhaNaAtualizacao;
import br.org.celiolemos.excecoes.FalhaNaRemocao;
import br.org.celiolemos.excecoes.FalhaNoCadastro;
import br.org.celiolemos.excecoes.NaoEncontrado;
import br.org.celiolemos.model.Responsavel;
import br.org.celiolemos.model.Telefone;
import br.org.celiolemos.repository.ResponsavelRepository;
import br.org.celiolemos.repository.TelefoneRepository;

@Service
@Qualifier("responsavelService")
public class TelefoneResponsavelServiceImpl implements TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired
	private ResponsavelRepository responsavelRepository;

	private Log logger = LogFactory.getLog(TelefoneResponsavelServiceImpl.class);

	@Override
	@Transactional
	public Iterable<Telefone> adicionarTelefone(Integer responsavelId, Set<Telefone> telefones) {

		Optional<Responsavel> optionalResponsavel = responsavelRepository.findById(responsavelId);
		if (optionalResponsavel.isPresent()) {
			Responsavel responsavel = optionalResponsavel.get();
			telefones.forEach(t -> {
				if (telefoneRepository.existsByNumero(t.getNumero())) {
					throw new ElementoJaCadastrado("Telefone já cadastrado!");
				}
				t.setResponsavel(responsavel);
			});
			try {
				return telefoneRepository.saveAll(telefones);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new FalhaNoCadastro(e.getCause().getLocalizedMessage());
			}
		}
		throw new NaoEncontrado(
				"Responsavel não encontrado. Para cadastrar um telefone é preciso adicionar um responsavel primeiro");
	}

	@Override
	public Telefone encontrarPorId(Integer responsavelId, Integer telefoneId) {

		if (responsavelRepository.existsById(responsavelId)) {
			Optional<Telefone> optionalTelefone = telefoneRepository.findById(telefoneId);
			if (optionalTelefone.isPresent()) {
				Telefone telefone = optionalTelefone.get();
				return telefone;
			}
			throw new NaoEncontrado("Telefone não foi encontrado");
		}
		throw new NaoEncontrado(
				"Responsavel não encontrado. Para cadastrar um telefone é preciso adicionar um responsavel primeiro");

	}

	@Override
	public List<Telefone> encontrarTudo(Integer responsavelId) {
		return telefoneRepository.findAllByResponsavelId(responsavelId);
	}

	@Override
	@Transactional
	public Telefone atualizarTelefone(Integer responsavelId, Integer telefoneId, Telefone telefone) {

		Optional<Responsavel> responsavel = responsavelRepository.findById(responsavelId);
		if (responsavel.isPresent()) {
			Optional<Telefone> optionalTelefone = telefoneRepository.findById(telefoneId);
			if (optionalTelefone.isPresent()) {
				Telefone telefoneAntigo = optionalTelefone.get();
				telefone.setId(telefoneAntigo.getId());
				telefone.setResponsavel(responsavel.get());
				Telefone updateStatus = telefoneRepository.save(telefone);

				if (Objects.nonNull(updateStatus)) {
					return updateStatus;
				}
				throw new FalhaNaAtualizacao("Telefone não foi atualizado, tente novamente mais tarde");
			}
			throw new NaoEncontrado("Telefone não foi encontrado. A atualização não foi realizada");
		}
		throw new NaoEncontrado("Responsavel não encontrado. Para atualizar um telefone o responsavel precisa existir");

	}

	@Override
	public void removeTelefone(Integer responsavelId, Integer idTelefone) {

		if (responsavelRepository.existsById(responsavelId)) {
			if (telefoneRepository.existsById(idTelefone)) {

				telefoneRepository.deleteById(idTelefone);

				if (telefoneRepository.existsById(idTelefone)) {
					throw new FalhaNaRemocao("Telefone não foi removido, tente novamente mais tarde");
				}
			}
			return;
		}
		throw new NaoEncontrado("Responsavel não encontrado. Para atualizar um telefone o responsavel precisa existir");
	}
}