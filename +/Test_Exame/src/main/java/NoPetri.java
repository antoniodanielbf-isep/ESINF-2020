public interface NoPetri {

    // verdadeiro se é nó transição, falso se é de posição
    public boolean isTransicao();

    // verdadeiro se o nó de posição tem pelo menos um token

    public boolean temToken();

    // remove um token de um nó de posição
    public void removeToken();

    // adiciona um token a um nó de posição
    public void adicionaToken();
}
