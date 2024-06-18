package threads.filaPilha;

import java.util.Objects;

public class ObjetoFilaThread {

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjetoFilaThread)) return false;

        ObjetoFilaThread that = (ObjetoFilaThread) o;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getNome());
        result = 31 * result + Objects.hashCode(getEmail());
        return result;
    }
}
