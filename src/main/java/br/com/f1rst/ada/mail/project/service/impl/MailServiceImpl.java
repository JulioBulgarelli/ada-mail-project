package br.com.f1rst.ada.mail.project.service.impl;

import br.com.f1rst.ada.mail.project.model.EMail;
import br.com.f1rst.ada.mail.project.model.MailMap;
import br.com.f1rst.ada.mail.project.service.MailService;

import java.time.LocalDateTime;
import java.util.*;


public class MailServiceImpl implements MailService {

    private final MailMap mailMap = new MailMap();

    @Override
	public int contarRemetentes() {
	    return mailMap.size();
	}

	@Override
	public void salvar(String remetente, EMail email) {
		if (!mailMap.containsKey(remetente)) {
            List<EMail> emailList = new ArrayList<>();
            emailList.add(email);
            mailMap.put(remetente, emailList);
        } else {
            mailMap.get(remetente).add(email);
        }
	}

	@Override
	public int contarRecebidosDe(String remetente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listarEnderecosComPalavrasNoAssunto(String... argumentos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EMail> obterEmailsComPalavrasNoAssunto(String... argumentos) {
		Set<EMail> emails = new TreeSet<>();

		for (Map.Entry<String, List<EMail>> email : mailMap.entrySet()) {
			for (EMail e : email.getValue()) {
				boolean include = true;

				for (String s : argumentos) {
					if (!e.getAssunto().toLowerCase().contains(s.toLowerCase())) {
						include = false;
						break;
					}
				}

				if (include) {
					emails.add(e);
				}
			}
		}

		return emails;
	}

	@Override
	public int removerEmailsAntesDe(LocalDateTime dataHora) {
		List<EMail> emailsRemovidos = new ArrayList<>();

		for (Map.Entry<String, List<EMail>> email : mailMap.entrySet()) {
			for (EMail e : email.getValue()) {
				if (e.getDataRecebimento().isBefore(dataHora)) {
					emailsRemovidos.add(e);
				}
			}
		}

		return emailsRemovidos.size();
	}

	@Override
	public List<String> listarRemetentesComEnviosHoje() {
		/*Jeff*/
		List<String> remetentes = new ArrayList<>();
		LocalDateTime today = LocalDateTime.now();

		for (Map.Entry<String, List<EMail>> remetente : mailMap.entrySet()) {
			for (EMail email : remetente.getValue()) {
				if (email.getDataEnvio().isEqual(today)) {
					remetentes.add(remetente.getKey());
				}
			}
		}

		return remetentes;
	}

	@Override
	public void removerEmailsDeContendoPalavras(String remetente, String... assunto) {
		/*Jeff*/
		if (!mailMap.containsKey(remetente)) {
			return;
		}

		List<EMail> emails = mailMap.get(remetente);
		emails.removeIf(email -> {
			for (String palavra : assunto) {
				if (email.getAssunto().contains(palavra)) {
					return true;
				}
			}
			return false;
		});

		mailMap.put(remetente, emails);
	}

	@Override
	public int removerEmailsDeAntesDe(String remetente, LocalDateTime dataHora) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listarRemetentesDePais(String pais) {
		// TODO Auto-generated method stub
		return null;
	}
}
