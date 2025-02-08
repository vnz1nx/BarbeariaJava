package view;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.CLiente;
import model.ModeloTabela;

import javax.swing.JScrollPane;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField InputCadastro;
	private JTable table;
	private ArrayList<CLiente>clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                    if (gd.isFullScreenSupported()) {
                        gd.setFullScreenWindow(frame);
                    } else {
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame.setVisible(true);
                    }
                    frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		clientes = new ArrayList<CLiente>();
		clientes.add(new CLiente("1", "Marcos", "Marcos@gmail.com", "(62)993697069", "Não Informado"));
		clientes.add(new CLiente("2", "Sthefany", "Lady@hotmail.com", "(62)991750822", "Não Informado"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1441, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Cadastrar = new JButton("Cadastrar");
		Cadastrar.setBounds(81, 58, 147, 33);
		contentPane.add(Cadastrar);
		
		InputCadastro = new JTextField();
		InputCadastro.setBounds(253, 58, 790, 33);
		contentPane.add(InputCadastro);
		InputCadastro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 123, 1013, 445);
		contentPane.add(scrollPane);
		
		ModeloTabela modeloDeTabela = new ModeloTabela(clientes);
		
		table = new JTable();
		table.setModel(modeloDeTabela);
		scrollPane.setViewportView(table);
		
		setSize(1406, 694);
        setTitle("Cadastro");
	}
}
