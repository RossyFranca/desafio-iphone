import models.Iphone;

public class App {
    public static void main(String[] args) throws Exception {
        Iphone aparelho = new Iphone();
        aparelho.ligarDesligarTelefone();

        aparelho.atualizarPagina(0);
        aparelho.adicionarMusica("Sweet Home Alabama - Lynyrd Skynyrd");
        aparelho.selecionarMusica(0);
        aparelho.tocarMusica();
        aparelho.adicionarNovaAba("google.com");
        aparelho.exibirPagina(0);
        aparelho.atualizarPagina(0);
        aparelho.iniciarCorreioDeVoz();
    
    }
}
