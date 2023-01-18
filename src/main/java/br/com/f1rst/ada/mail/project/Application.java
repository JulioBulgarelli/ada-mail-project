package br.com.f1rst.ada.mail.project;

import br.com.f1rst.ada.mail.project.model.EMail;
import br.com.f1rst.ada.mail.project.service.MailService;
import br.com.f1rst.ada.mail.project.service.impl.MailServiceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.logging.Logger;

public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

        testE();
        log.info("Requisito e) passou com sucesso");

        testF();
        log.info("Requisito f) passou com sucesso");
    }

    private static void testE() {

        // preparar dados para teste
        MailService mailService = new MailServiceImpl();
        mailService.salvar("Teste", new EMail("", LocalDateTime.now().minus(1, ChronoUnit.DAYS), LocalDateTime.now(), "Assunto #1", "Corpo #1"));

        Set<EMail> teste1QuestaoE = mailService.obterEmailsComPalavrasNoAssunto("Assunto", "1");
        test(teste1QuestaoE.size() == 1, "Falhou no requisito e)");

        Set<EMail> teste2QuestaoE = mailService.obterEmailsComPalavrasNoAssunto("Corpo", "1");
        test(teste2QuestaoE.isEmpty(), "Falhou no requisito e)");
    }

    private static void testF() {

        // preparar dados para teste
        MailService mailService = new MailServiceImpl();
        mailService.salvar("Teste", new EMail("", LocalDateTime.now().minus(1, ChronoUnit.DAYS), LocalDateTime.now(), "Assunto #1", "Corpo #1"));

        int nenhumremovido = mailService.removerEmailsAntesDe(LocalDateTime.now().minus(2, ChronoUnit.DAYS));
        test(nenhumremovido == 0, "Falhou no requisito f)");

        int umRemovido = mailService.removerEmailsAntesDe(LocalDateTime.now());
        test(umRemovido == 1, "Falhou no requisito f)");
    }

    private static void test(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException(message);
        }
    }
}
