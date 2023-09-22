package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.TelefoneDesligadoException;
import interfaces.AparelhoTelefonico;
import interfaces.NavegadorDeInternet;
import interfaces.ReprodutorMusical;

public class Iphone implements AparelhoTelefonico, NavegadorDeInternet, ReprodutorMusical {

    private boolean statusLigado;
    private List<PaginaWeb> abas = new ArrayList<PaginaWeb>();
    private List<String> musicas = new ArrayList<>();
    private String musicaSelecionada = "";


    public void ligarDesligarTelefone() {
        if (!statusLigado) {
            statusLigado = true;
            System.out.println("Telefone ligando...");
        } else {
            statusLigado = false;
            System.out.println("Telefone desligando...");
        }
    }

    public void adicionarMusica(String musica) throws TelefoneDesligadoException {
        verificarStatusLigado();
        musicas.add(musica);
        System.out.println("Música " + musica + " adicionada com sucesso.");
    }

    public void selecionarMusica(int index) throws TelefoneDesligadoException {
        verificarStatusLigado();
        try {
            musicaSelecionada = musicas.get(index);
            System.out.println("Música " + musicaSelecionada + " selecionada.");
        } catch (Exception e) {
            System.err.println("música não encontrada");
        }

    }

    public void tocarMusica() throws TelefoneDesligadoException {
        verificarStatusLigado();
        if (!musicaSelecionada.isEmpty()) {
            System.out.println("Tocando: " + musicaSelecionada + " agora.");
        } else {
            System.err.println("Você deve selecionar uma música antes");
        }
    }

    public void iniciarCorreioDeVoz() throws TelefoneDesligadoException {
        verificarStatusLigado();
        System.out.println("Iniciando correio de voz...");
    }

    public void adicionarNovaAba(String enderecoWeb) throws TelefoneDesligadoException {
        verificarStatusLigado();
        PaginaWeb novaPagina = new PaginaWeb();
        novaPagina.setPaginaWeb(enderecoWeb);
        this.abas.add(novaPagina);
        System.out.println("Nova página " + novaPagina.getPaginaWeb() + " adicionada com sucesso.");
    }

    public void atualizarPagina(int index) throws TelefoneDesligadoException {
        verificarStatusLigado();
        try {
            PaginaWeb pagina = abas.get(index);
            System.out.println("Página " + pagina.getPaginaWeb() + " Atualizada com sucesso.");
        } catch (Exception e) {
            System.out.println("Aba não encontrada...");
        }
    }

    public void exibirPagina(int index) throws TelefoneDesligadoException {
        verificarStatusLigado();
        PaginaWeb pagina = abas.get(index);
        System.out.println("Página " + pagina.getPaginaWeb() + " sendo exibida");
    }

    private void verificarStatusLigado() throws TelefoneDesligadoException {
        if (!statusLigado)
            throw new TelefoneDesligadoException("Telefone desligado");
    }

}
