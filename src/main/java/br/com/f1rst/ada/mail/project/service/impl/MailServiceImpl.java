package br.com.f1rst.ada.mail.project.service.impl;

import br.com.f1rst.ada.mail.project.model.EMail;
import br.com.f1rst.ada.mail.project.model.MailMap;
import br.com.f1rst.ada.mail.project.service.MailService;

import java.time.LocalDate;
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
		for (Map.Entry<String, List<EMail>> pair : mailMap.entrySet()) {
			if(pair.getKey().equals(remetente) ){
				return (pair.getValue()).size();
			}
		}
		return 0;
	}

	@Override
	public List<String> listarEnderecosComPalavrasNoAssunto(String... argumentos) {
		List<String> result = new ArrayList<>();
		for (Map.Entry<String, List<EMail>> pair : mailMap.entrySet()) {
			for(EMail email : pair.getValue()){
				boolean include = true;

				for (String s : argumentos) {
					if (!email.getAssunto().toLowerCase().contains(s.toLowerCase())) {
						include = false;
						break;
					}
				}

				if (include) {
					result.add(pair.getKey()); //Se for para retornar dos itens da lista de email, seria email.remetente;
				}
			}
		}
		return result;
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

		for (Map.Entry<String, List<EMail>> remetente : mailMap.entrySet()) {
			for (EMail e : remetente.getValue()) {
				if (e.getDataRecebimento().isBefore(dataHora)) {
					emailsRemovidos.add(e);
				}
			}

			remetente.getValue().removeAll(emailsRemovidos);
		}

		return emailsRemovidos.size();
	}

	@Override
	public List<String> listarRemetentesComEnviosHoje() {
		/*Jeff*/
		List<String> remetentes = new ArrayList<>();
		LocalDate today = LocalDate.now();

		for (Map.Entry<String, List<EMail>> remetente : mailMap.entrySet()) {
			for (EMail email : remetente.getValue()) {
				if (email.getDataEnvio().toLocalDate().isEqual(today)) {
					remetentes.add(remetente.getKey());
				}
			}
		}

		return remetentes;
	}

	@Override
	public int removerEmailsDeContendoPalavras(String remetente, String... assunto) {
		/*Jeff*/
		if (!mailMap.containsKey(remetente)) {
			return 0;
		}

		List<EMail> emailsRemovidos = new ArrayList<>();

		for (EMail email : mailMap.get(remetente)) {
			for (String palavra : assunto) {
				if (email.getAssunto().toLowerCase().contains(palavra.toLowerCase())) {
					emailsRemovidos.add(email);
				}
			}
		}

		mailMap.get(remetente).removeAll(emailsRemovidos);
		return emailsRemovidos.size();
	}

	@Override
	public int removerEmailsDeAntesDe(String remetente, LocalDateTime dataHora) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listarRemetentesDePais(String pais) {
		List<String> listaRemetentes = new ArrayList<>();
        for (Map.Entry<String, List<EMail>> emailList : mailMap.entrySet()) {
            if(emailList.getKey().endsWith(pais)){
                listaRemetentes.add(emailList.getKey());
            }
        }
		return listaRemetentes;
	}
}
