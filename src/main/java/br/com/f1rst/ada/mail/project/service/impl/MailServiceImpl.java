package br.com.f1rst.ada.mail.project.service.impl;

import br.com.f1rst.ada.mail.project.model.EMail;
import br.com.f1rst.ada.mail.project.model.MailMap;
import br.com.f1rst.ada.mail.project.service.MailService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class MailServiceImpl implements MailService {

    private MailMap mailMap = new MailMap();

    @Override
    public int contarRemetentes() {
        return 0;
    }

    @Override
    public void salvar(String remetente, EMail email) {

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
        return mailMap.values().stream().map(emailLists -> emailLists
                .removeIf(email -> email.isSameSenderAndReceivedBefore(email, remetente, dataHora)))
                .anyMatch(result -> true) ? 1 : 0;
    }

    @Override
    public List<String> listarRemetentesDePais(String pais) {
        return null;
    }
}
