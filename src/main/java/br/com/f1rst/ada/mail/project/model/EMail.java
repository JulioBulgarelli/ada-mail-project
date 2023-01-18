package br.com.f1rst.ada.mail.project.model;

import java.time.LocalDateTime;

public class EMail implements Comparable<EMail> {

    private String remetente;
    private LocalDateTime dataEnvio;
    private LocalDateTime dataRecebimento;
    private String assunto;
    private String corpo;

    public EMail() {
    }

    public EMail(String remetente, LocalDateTime dataEnvio, LocalDateTime dataRecebimento, String assunto, String corpo) {
        this.remetente = remetente;
        this.dataEnvio = dataEnvio;
        this.dataRecebimento = dataRecebimento;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalDateTime getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDateTime dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    @Override
    public int compareTo(EMail o) {
        return o.getRemetente().compareTo(this.remetente);
    }
}
