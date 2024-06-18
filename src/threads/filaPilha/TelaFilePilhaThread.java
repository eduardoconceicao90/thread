package threads.filaPilha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFilePilhaThread extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout()); /* Painel de componentes */

    private JLabel descricaoNome = new JLabel("Nome");
    private JTextField nome = new JTextField();

    private JLabel descricaoEmail = new JLabel("Email");
    private JTextField email = new JTextField();

    private JButton jButton = new JButton("Add lista");
    private JButton jButton2 = new JButton("Stop");

    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

    public TelaFilePilhaThread() { /* Executa o que tiver dentro no momento da abertura ou execução */
        setTitle("Minha tela com thread");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);

        //---------------------------------------

        GridBagConstraints gridBagConstraints = new GridBagConstraints(); /* Controlador de posicionamento de componentes */
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5,10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        descricaoNome.setPreferredSize(new Dimension(200,25));
        jPanel.add(descricaoNome, gridBagConstraints);

        nome.setPreferredSize(new Dimension(200,25));
        gridBagConstraints.gridy++;
        jPanel.add(nome, gridBagConstraints);

        //---------------------------------------

        descricaoEmail.setPreferredSize(new Dimension(200,25));
        gridBagConstraints.gridy++;
        jPanel.add(descricaoEmail, gridBagConstraints);

        email.setPreferredSize(new Dimension(200,25));
        gridBagConstraints.gridy++;
        jPanel.add(email, gridBagConstraints);

        //---------------------------------------

        gridBagConstraints.gridwidth = 1;

        jButton.setPreferredSize(new Dimension(92,25));
        gridBagConstraints.gridy++;
        jPanel.add(jButton, gridBagConstraints);

        jButton2.setPreferredSize(new Dimension(92,25));
        gridBagConstraints.gridx++;
        jPanel.add(jButton2, gridBagConstraints);

        //---------------------------------------

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { /* Executa o clique no botão */

                if (fila == null){
                    fila = new ImplementacaoFilaThread();
                    fila.start();
                }

                for (int qtd = 0; qtd < 100; qtd++){
                    ObjetoFilaThread objetoFilaThread = new ObjetoFilaThread();
                    objetoFilaThread.setNome(nome.getText());
                    objetoFilaThread.setEmail(email.getText());

                    fila.add(objetoFilaThread);
                }
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { /* Executa o clique no botão */
                fila.stop();
                fila = null;
            }
        });

        fila.start();
        add(jPanel, BorderLayout.WEST);

        /* Sempre será o último comando */
        setVisible(true); /* Torna a tela visível para o usuário */
    }
}
