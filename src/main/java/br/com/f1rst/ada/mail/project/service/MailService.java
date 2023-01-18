package br.com.f1rst.ada.mail.project.service;

import br.com.f1rst.ada.mail.project.model.EMail;
import br.com.f1rst.ada.mail.project.model.MailMap;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface MailService {

    /* a) Determinar o total de endereços a partir dos quais se recebeu mail; */
	int contarRemetentes();
    	
    /* b) Guardar um novo mail recebido; */
	void salvar(String remetente, EMail email);
	

    /* c) Determinar quantos mails têm por origem um dado endereço; */
    int contarRecebidosDe(String remetente);

    /* d) Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro; */
    List<String> listarEnderecosComPalavrasNoAssunto(String... argumentos);

    /* e) O mesmo que a questão anterior, mas criando um conjunto contendo os mails; */
    Set<EMail> obterEmailsComPalavrasNoAssunto(String... argumentos);

    /* f) Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro; */
    int removerEmailsAntesDe(LocalDateTime dataHora);

    /* g) Criar uma lista dos endereços que hoje enviaram mails; */
    List<String> listarRemetentesComEnviosHoje();

    /* h) Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam); */
    int removerEmailsDeContendoPalavras(String remetente, String... assunto);

    /* i) Eliminar todos os mails de um dado endereço anteriores a uma data dada; */
    int removerEmailsDeAntesDe(String remetente, LocalDateTime dataHora);

    /* j) Criar uma listagem com todos os endereços de e-mail oriundos um país dado como parâmetro; */
    List<String> listarRemetentesDePais(String pais); // Pais deve ser inferido do TLD .com.br, .com, .co.uk, etc...

	

	

	
}
