package threads.tela;

import javax.swing.*;
import java.awt.*;

public class TelaTimeThread extends JDialog {

    public TelaTimeThread() { /* Executa o que tiver dentro no momento da abertura ou execução */
        setTitle("Minha tela de time com Thread");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);




        /* Sempre será o último comando */
        setVisible(true); /* Torna a tela visível para o usuário */
    }
}
