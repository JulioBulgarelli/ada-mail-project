package br.com.f1rst.ada.mail.project;

import br.com.f1rst.ada.mail.project.model.EMail;
import br.com.f1rst.ada.mail.project.service.MailService;
import br.com.f1rst.ada.mail.project.service.impl.MailServiceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class Application {

    private static final Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

        // preparar dados para testes
        MailService mailService = new MailServiceImpl();
        mailService.salvar("Teste", new EMail("", LocalDateTime.now().minus(1, ChronoUnit.DAYS), LocalDateTime.now(), "Assunto #1", "Corpo #1"));

        testA(mailService);
        log.info("Requisito a) passou com sucesso");

        testB(mailService);
        log.info("Requisito b) passou com sucesso");

        testC(mailService);
        log.info("Requisito c) passou com sucesso");

        testD(mailService);
        log.info("Requisito d) passou com sucesso");

        testE(mailService);
        log.info("Requisito e) passou com sucesso");

        testF(mailService);
        log.info("Requisito f) passou com sucesso");

        testG(mailService);
        log.info("Requisito g) passou com sucesso");

        testH(mailService);
        log.info("Requisito h) passou com sucesso");

        testJ(mailService);
        log.info("Requisito j) passou com sucesso");
    }

    private static void testA(MailService mailService) {

        test(mailService.contarRemetentes() > 0, "Falhou no requisito a)");
    }

    private static void testB(MailService mailService) {

        test(mailService.contarRemetentes() == 1, "Falhou no requisito b)");
    }

    private static void testC(MailService mailService) {

        int nenhumRemetente = mailService.contarRecebidosDe("TesteErrado");
        test(nenhumRemetente == 0, "Falhou no requisito c)");

        int umRemetente = mailService.contarRecebidosDe("Teste");
        test(umRemetente == 1, "Falhou no requisito c)");
    }

    private static void testD(MailService mailService) {

        List<String> teste1QuestaoD = mailService.listarEnderecosComPalavrasNoAssunto("Assunto", "1");
        test(teste1QuestaoD.size() == 1, "Falhou no requisito d)");

        List<String> teste2QuestaoD = mailService.listarEnderecosComPalavrasNoAssunto("Corpo", "1");
        test(teste2QuestaoD.isEmpty(), "Falhou no requisito d)");
    }

    private static void testE(MailService mailService) {

        Set<EMail> teste1QuestaoE = mailService.obterEmailsComPalavrasNoAssunto("Assunto", "1");
        test(teste1QuestaoE.size() == 1, "Falhou no requisito e)");

        Set<EMail> teste2QuestaoE = mailService.obterEmailsComPalavrasNoAssunto("Corpo", "1");
        test(teste2QuestaoE.isEmpty(), "Falhou no requisito e)");
    }

    private static void testF(MailService mailService) {

        int nenhumremovido = mailService.removerEmailsAntesDe(LocalDateTime.now().minus(2, ChronoUnit.DAYS));
        test(nenhumremovido == 0, "Falhou no requisito f)");

        int umRemovido = mailService.removerEmailsAntesDe(LocalDateTime.now());
        test(umRemovido == 1, "Falhou no requisito f)");

        // retornar o registro
        mailService.salvar("Teste", new EMail("", LocalDateTime.now().minus(1, ChronoUnit.DAYS), LocalDateTime.now(), "Assunto #1", "Corpo #1"));
    }

    private static void testG(MailService mailService) {

        List<String> nenhumEnvio = mailService.listarRemetentesComEnviosHoje();
        test(nenhumEnvio.isEmpty(), "Falhou no requisito g)");

        mailService.salvar("Teste", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "Assunto #2", "Corpo #2"));

        List<String> umEnvio = mailService.listarRemetentesComEnviosHoje();
        test(!umEnvio.isEmpty(), "Falhou no requisito g)");
    }

    private static void testH(MailService mailService) {

        int nenhumremovido = mailService.removerEmailsDeContendoPalavras("Teste", "Corpo", "sem");
        test(nenhumremovido == 0, "Falhou no requisito h)");

        int umRemovido = mailService.removerEmailsDeContendoPalavras("Teste", "Corpo", "1");
        test(umRemovido == 1, "Falhou no requisito h)");
    }

    private static void testJ(MailService mailService){

        mailService.salvar("teste@1.com.br", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));
        mailService.salvar("teste@2.com.br", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));

        mailService.salvar("teste@3.com.uk", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));

        mailService.salvar("teste@4.com.ca", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));
        mailService.salvar("teste@5.com.ca", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));
        mailService.salvar("teste@6.com.ca", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));

        mailService.salvar("teste@7.com.fr", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));
        mailService.salvar("teste@8.com.fr", new EMail("", LocalDateTime.now(), LocalDateTime.now(), "AssuntoTesteJ", "Mensagem email"));

        List<String> listaRemetentes;

        listaRemetentes = mailService.listarRemetentesDePais(".com.br");
        test(listaRemetentes.size() == 2, "Falhou no requisito j)");

        listaRemetentes = mailService.listarRemetentesDePais(".com.uk");
        test(listaRemetentes.size() == 1, "Falhou no requisito j)");

        listaRemetentes = mailService.listarRemetentesDePais(".com.ca");
        test(listaRemetentes.size() == 3, "Falhou no requisito j)");

        listaRemetentes = mailService.listarRemetentesDePais(".com.fr");
        test(listaRemetentes.size() == 2, "Falhou no requisito j)");
    }

    private static void test(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException(message);
        }
    }
}
