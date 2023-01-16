package br.com.f1rst.ada.mail.project.model;

import java.util.HashMap;
import java.util.List;

public class MailMap extends HashMap<String, List<EMail>> {

    /**
     * Chave do mapa é o endereço de envio (remetente)
     * Valor do mapa é a lista dos emails
     */

    // Cada e-mail recebido numa dada conta de e-mail é guardado contendo o endereço de quem o enviou, a data de envio, a data de recebimento, o assunto e o texto do e-mail (não se consideram anexos, etc.).
    // Crie uma classe MailMap que associe a cada endereço de envio todos os mails recebidos (classe EMail) e implemente as seguintes operações:
    // a) Determinar o total de endereços a partir dos quais se recebeu mail;
    // b) Guardar um novo mail recebido;
    // c) Determinar quantos mails têm por origem um dado endereço;
    // d) Criar uma lista com todos os endereços que enviaram mails contendo no seu assunto uma lista de palavras dada como parâmetro;
    // e) O mesmo que a questão anterior, mas criando um conjunto contendo os mails;
    // f) Eliminar todos os e-mails recebidos antes de uma data que é dada como parâmetro;
    // g) Criar uma lista dos endereços que hoje enviaram mails;
    // h) Dada uma lista de palavras, eliminar todos os mails de um dado endereço que no seu assunto contenham uma qualquer destas (anti-spam);
    // i) Eliminar todos os mails de um dado endereço anteriores a uma data dada;
    // j) Criar uma listagem com todos os endereços de e-mail oriundos um país dado como parâmetro;
}
