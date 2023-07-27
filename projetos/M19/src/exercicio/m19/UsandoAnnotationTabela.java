package exercicio.m19;


public class UsandoAnnotationTabela {
    @Tabela(nome = "Talbe name")
    public static class MinhaEntidade {
    }

    public static void main(String[] args) {
        Class<MinhaEntidade> classe = MinhaEntidade.class;
        lerAnotacaoTabela(classe);
    }

    public static void lerAnotacaoTabela(Class<?> classe) {
        if (classe.isAnnotationPresent(Tabela.class)) {
            Tabela tabelaAnnotation = classe.getAnnotation(Tabela.class);
            String nomeTabela = tabelaAnnotation.nome();
            System.out.println("Nome da tabela: " + nomeTabela);
        } else {
            System.out.println("A anotação @Tabela não foi encontrada!!");
        }
    }
}