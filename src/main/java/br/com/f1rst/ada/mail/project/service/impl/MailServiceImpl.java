package br.com.f1rst.ada.mail.project.service.impl;

import br.com.f1rst.ada.mail.project.model.EMail;
import br.com.f1rst.ada.mail.project.model.MailMap;
import br.com.f1rst.ada.mail.project.service.MailService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;



public class MailServiceImpl implements MailService {
	private MailMap mailMap = new MailMap();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removerEmailsAntesDe(LocalDateTime dataHora) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listarRemetentesComEnviosHoje() {
		/*Jeff*/
		List<String> remetentes = new ArrayList<>()/
		Date today = new Date();
		for (String remetente : this.keySet())(
			for EMail email : this.get(remetentes)){
			if (email.getSentDate().equals(today.toString().subString(0,10))){
				remetentes.add(remetentes);
			}
		}
	}

	@Override
	public void removerEmailsDeContendoPalavras(String remetente, List<String> assunto) {
	/*Jeff*/
	if (!this.containsKey(remetente)) {
			return;
		}
		List<EMail> emails = this.get(remetente);
		emails.removeIf(email -> {
			for (String palavra : assunto) {
				if (email.getSubject().contains(palavra)) {
					return true;
				}
			}
			return false;
		});
		this.put(remetente, emails);
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


/*   @Override
    public int contarRemetentes() {
    	
    }

	@Override
    public void salvar() {
		if (!mailMap.containsKey(address)) {
            List<EMail> emailList = new ArrayList<>();
            emailList.add(email);
            mailMap.put(address, emailList);
        } else {
            mailMap.get(address).add(email);
        }
    }

    @Override
    public int contarRecebidosDe(String remetente) {
        return 0;
    }

    @Override
    public List<String> listarEnderecosComPalavrasNoAssunto(String... argumentos) {
        return null;
    }

    @Override
    public Set<EMail> obterEmailsComPalavrasNoAssunto(String... argumentos) {
        return null;
    }

    @Override
    public int removerEmailsAntesDe(LocalDateTime dataHora) {
        return 0;
    }

    @Override
    public List<String> listarRemetentesComEnviosHoje() {
        return null;
    }

    @Override
    public int removerEmailsDeContendoPalavras(String remetente, String... argumentos) {
        return 0;
    }

    @Override
    public int removerEmailsDeAntesDe(String remetente, LocalDateTime dataHora) {
        return 0;
    }

    @Override
    public List<String> listarRemetentesDePais(String pais) {
        return null;
    }

	@Override
	public int contarRemetentes() {
		// TODO Auto-generated method stub
		return 0;
	}
	*/
}
