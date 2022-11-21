package gui.mainview;

import command.CommandManager;
import controller.ActionManager;
import enums.notifikacija.MyNotification;
import enums.tipKomponenti.TipSadrzaja;
import error.ErrorFactory;
import error.MyError;
import gui.treeGui.treeModel.MyTreeModel;
import gui.treeGui.treeView.MyTree;
import myComponents.view.ProjekatView;
import observer.IObserver;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements IObserver {
    private static MainFrame instance;

    private ActionManager actionManager;
    private CommandManager commandManager;

    private JPanel contentPanel;

    private JPanel editModePanel;
    private JPanel slideShowPanel;
    private JPanel cardViewPanel;
    private MainMenuBar menuBar;
    private MainToolBar toolBar;

    private Color color;
    private int strokeDebljina;
    private boolean dashed;
    private TipSadrzaja tipSadrzaja;

    private ProjekatView projekatView;

    private CardLayout cardLayout;

    private MyTree myTree;
    private MyTreeModel myTreeModel;

    private MainFrame() {

    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }


    //Ovde ubacujes contentPanel, MenuBar, ToolBar
    private void initialize() {
        initMyTree();
        standard();

        ErrorFactory.getInstance().addObserver(this);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        editModePanel = new JPanel();
        editModePanel.setBackground(Color.WHITE);
        editModePanel.setLayout(new BorderLayout());
        add(contentPanel);

        actionManager = new ActionManager();
        commandManager = new CommandManager();

        MainMenuBar myMenuBar = new MainMenuBar();
        setJMenuBar(myMenuBar);

        MainToolBar myToolBar = new MainToolBar();
        editModePanel.add(myToolBar, BorderLayout.NORTH);

        editModePanel.add(makeMeASplitPane(), BorderLayout.CENTER);

        contentPanel.add(editModePanel, BorderLayout.CENTER);

        makeMeASlideShowPane();
    }

    private void standard() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width/2 +150 , screenSize.height/2+150);
        setTitle("RuDok - 2021");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setVisible(true);
    }

    private void initMyTree() {
        myTree = new MyTree();
        myTreeModel = new MyTreeModel();
        myTree.setModel(myTreeModel);
    }

    private void makeMeASlideShowPane() {
        slideShowPanel = new JPanel();
        cardLayout = new CardLayout();

        slideShowPanel.setLayout(new BorderLayout());

        JButton prevBtn = new JButton(actionManager.getPrevBtnAction());
        JButton nextBtn = new JButton(actionManager.getNextBtnAction());
        JButton closeBtn = new JButton(actionManager.getEditModeAction());

        cardViewPanel = new JPanel(cardLayout);

        slideShowPanel.add(prevBtn, BorderLayout.WEST);
        slideShowPanel.add(nextBtn, BorderLayout.EAST);
        slideShowPanel.add(closeBtn, BorderLayout.NORTH);
        slideShowPanel.add(cardViewPanel, BorderLayout.CENTER);
    }

    //splitPane levo/desno
    private JSplitPane makeMeASplitPane() {
        Dimension minimumSize = new Dimension(200, 100);

        JScrollPane leftScrollPane = new JScrollPane(myTree, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        leftScrollPane.setMinimumSize(minimumSize);

        projekatView = new ProjekatView();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, projekatView);
        splitPane.setOneTouchExpandable(true);
        splitPane.setSize(minimumSize);

        return splitPane;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public JPanel getEditModePanel() {
        return editModePanel;
    }

    public void setEditModePanel(JPanel editModePanel) {
        this.editModePanel = editModePanel;
    }

    public MyTree getMyTree() {
        return myTree;
    }

    public void setMyTree(MyTree myTree) {
        this.myTree = myTree;
    }

    public MyTreeModel getMyTreeModel() {
        return myTreeModel;
    }

    public void setMyTreeModel(MyTreeModel myTreeModel) {
        this.myTreeModel = myTreeModel;
    }

    public ProjekatView getProjekatView() {
        return projekatView;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardViewPanel(JPanel cardViewPanel) {
        this.cardViewPanel = cardViewPanel;
    }

    public JPanel getCardViewPanel() {
        return cardViewPanel;
    }

    public JPanel getSlideShowPanel() {
        return slideShowPanel;
    }

    public void setSlideShowPanel(JPanel slideShowPanel) {
        this.slideShowPanel = slideShowPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public TipSadrzaja getTipSadrzaja() {
        return tipSadrzaja;
    }

    public void setTipSadrzaja(TipSadrzaja tipSadrzaja) {
        this.tipSadrzaja = tipSadrzaja;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStrokeDebljina() {
        return strokeDebljina;
    }

    public void setStrokeDebljina(int strokeDebljina) {
        this.strokeDebljina = strokeDebljina;
    }

    public boolean isDashed() {
        return dashed;
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
    }

    @Override
    public void updateObserver(Object notification) {
        if(notification instanceof MyNotification && ((MyNotification) notification).getNotification() instanceof MyError){
            MyError error = (MyError) ((MyNotification) notification).getNotification() ;
            JOptionPane.showMessageDialog(this, error.getMessage(), error.getTitle(), error.getType());
        }
    }
}
