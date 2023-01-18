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
        return 0;
    }

    @Override
    public void salvar(String remetente, EMail email) {
        if (mailMap.containsKey(remetente)) {
            mailMap.get(remetente).add(email);
        } else {
            List<EMail> emails = new ArrayList<>();
            emails.add(email);
            mailMap.put(remetente, emails);
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
}
